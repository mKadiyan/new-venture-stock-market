package com.nv.company.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "company")
@Table
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    @JsonProperty("name")
    private String name;

    @Column(name = "company_registration_number", nullable = false, unique = true)
    @JsonProperty("companyRegistrationNumber")
    private String companyRegistrationNumber;

    @Column(name = "registered_address")
    @JsonProperty("registeredAddress")
    private String registeredAddress;

    @Column(name = "registered_on")
    @JsonProperty("registeredOn")
    private Date registeredOn;

    @Column(name = "enabled")
    @JsonProperty("enabled")
    private boolean enabled;
}
