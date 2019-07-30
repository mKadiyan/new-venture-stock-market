package com.nv.company.dtos;

import lombok.Data;

@Data
public class CreateCompanyDto {
    private int id;
    private String name;
    private String companyRegistrationNumber;
    private String registeredAddress;
    private boolean enabled;
}
