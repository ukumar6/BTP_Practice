package com.anubhavtrainings.dbboot.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.olingo.odata2.api.annotation.edm.EdmEntitySet;
import org.apache.olingo.odata2.api.annotation.edm.EdmEntityType;
import org.apache.olingo.odata2.api.annotation.edm.EdmKey;
import org.apache.olingo.odata2.api.annotation.edm.EdmNavigationProperty;
import org.apache.olingo.odata2.api.annotation.edm.EdmNavigationProperty.Multiplicity;
import org.apache.olingo.odata2.api.annotation.edm.EdmProperty;
import org.apache.olingo.odata2.api.annotation.edm.EdmType;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
//@Scope("prototype")
@Entity
@Table(name = "VENDOR")
@EdmEntitySet
@EdmEntityType
public class Vendor {
    @Id
    @Column(nullable = false, name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @EdmKey
    @EdmProperty
    private String code;
    @Column(nullable = false, name = "COMPANY_NAME")
    @EdmProperty
    private String companyName;
    @Column(nullable = false, name = "CONTACT")
    @EdmProperty
    private String contactPerson;
    @Column(nullable = false, name = "FIRST_NAME")
    @EdmProperty
    private String firstName;
    @Column(nullable = false, name = "LAST_NAME")
    @EdmProperty
    private String lastName;
    @Column(nullable = false, name = "WEBSITE")
    @EdmProperty
    private String website;
    @Column(nullable = false, name = "EMAIL")
    @EdmProperty
    private String email;
    @Column(nullable = false, name = "STATUS")
    @EdmProperty
    private Integer status;
    @Column(nullable = true, name = "REG_DATE")
    @EdmProperty(type = EdmType.DATE_TIME)
    @Temporal(TemporalType.DATE)
    private Date regDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "vendor", referencedColumnName = "ID")
    @EdmNavigationProperty(toType = Address.class, toMultiplicity = Multiplicity.MANY)
    private List<Address> addresses = new ArrayList<Address>();

    // default constructor

    // public Vendor(String code, String companyName, String contactPerson, String
    // firstName, String lastName) {
    // this.code = code;
    // this.companyName = companyName;
    // this.contactPerson = contactPerson;
    // this.firstName = firstName;
    // this.lastName = lastName;
    // this.website = companyName + ".com";
    // this.email = this.firstName + "." + this.lastName + "@" + this.companyName +
    // ".com";
    // this.status = 0;
    // this.regDate = new Date();
    // }

    public String getCode() {
        return code;
    }

    public Vendor() {
    }

    public Vendor(String code, String companyName, String contactPerson, String firstName, String lastName,
            String website, String email, Integer status, Date regDate, List<Address> addresses) {
        this.code = code;
        this.companyName = companyName;
        this.contactPerson = contactPerson;
        this.firstName = firstName;
        this.lastName = lastName;
        this.website = website;
        this.email = email;
        this.status = status;
        this.regDate = regDate;
        this.addresses = addresses;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

}
