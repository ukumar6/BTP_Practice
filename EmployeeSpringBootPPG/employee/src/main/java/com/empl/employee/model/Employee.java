package com.empl.employee.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@javax.persistence.Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ecode")
    private Integer eCode;
    @Column(name = "efirstname", nullable = false)
    private String efirstname;
    @Column(name = "emiddlename")
    private String emiddlename;
    @Column(name = "elastname")
    private String elastname;
    @Column(name = "edob")
    private Date edob;
    @Column(name = "egender")
    private String egender;
    @Column(name = "edoj")
    private Date edoj;

}
