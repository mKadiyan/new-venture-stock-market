package com.nv.company.controllers;

import com.nv.company.dtos.CreateCompanyDto;
import com.nv.company.models.Company;
import com.nv.company.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class CompanyController {
    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/companies")
    private ResponseEntity<List<Company>> getCompanies() {
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @PostMapping("/companies")
    private ResponseEntity<Company> registerCompany(@RequestBody CreateCompanyDto createCompanyDto) {
        return ResponseEntity.ok(companyService.registerCompany(createCompanyDto));
    }
}
