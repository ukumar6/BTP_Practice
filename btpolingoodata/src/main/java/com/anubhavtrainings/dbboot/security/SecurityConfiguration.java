package com.anubhavtrainings.dbboot.security;

import com.sap.cloud.security.xsuaa.XsuaaServiceConfiguration;
import com.sap.cloud.security.xsuaa.extractor.IasXsuaaExchangeBroker;
import com.sap.cloud.security.xsuaa.token.TokenAuthenticationConverter;
import com.sap.cloud.security.xsuaa.tokenflows.XsuaaTokenFlows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity(debug = true) // TODO "debug" may include sensitive information. Do not use in a production
                                 // system!
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration {

    @Autowired
    XsuaaServiceConfiguration xsuaaServiceConfiguration;

    @Autowired
    XsuaaTokenFlows xsuaaTokenFlows;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .sessionManagement(management -> management
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeRequests(requests -> requests
                        .antMatchers("/anubhav.svc/*").hasAuthority("Display")
                        .antMatchers("/webapp/*").hasAuthority("Edit")
                        .antMatchers("/vendors").authenticated()
                        .anyRequest().denyAll())
                .oauth2ResourceServer(server -> server
                        .bearerTokenResolver(new IasXsuaaExchangeBroker(xsuaaTokenFlows))
                        .jwt()
                        .jwtAuthenticationConverter(getJwtAuthenticationConverter()));
		// @formatter:on

        return http.build();
    }

    /**
     * Customizes how GrantedAuthority are derived from a Jwt
     */
    Converter<Jwt, AbstractAuthenticationToken> getJwtAuthenticationConverter() {
        TokenAuthenticationConverter converter = new TokenAuthenticationConverter(xsuaaServiceConfiguration);
        converter.setLocalScopeAsAuthorities(true);
        return converter;
    }

}
