package com.anubhavtrainings.dbboot;

import org.apache.olingo.odata2.api.ODataServiceFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

import com.anubhavtrainings.dbboot.entities.AddressODataAgent;
import com.anubhavtrainings.dbboot.entities.VendorODataAgent;

@SpringBootApplication(scanBasePackages = "com.anubhavtrainings.dbboot")
@EnableJpaRepositories(basePackages = "com.anubhavtrainings.dbboot")
@EntityScan(basePackages = "com.anubhavtrainings.dbboot")
@ServletComponentScan(basePackages = "com.anubhavtrainings.dbboot")
@EnableAsync
public class DbbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbbootApplication.class, args);
	}

	@Bean(name = "com.anubhavtrainings.dbboot.processor.MyODataServiceFactory")
	public ODataServiceFactory getServiceFactory() {
		return new com.anubhavtrainings.dbboot.processor.MyODataServiceFactory("com.anubhavtrainings.dbboot");
	}

	@Bean(name = "com.anubhavtrainings.dbboot.entities.VendorODataAgent")
	public VendorODataAgent vendorODataAgent() {
		return new VendorODataAgent();
	}

	@Bean(name = "com.anubhavtrainings.dbboot.entities.AddressODataAgent")
	public AddressODataAgent addressODataAgent() {
		return new AddressODataAgent();
	}

}
