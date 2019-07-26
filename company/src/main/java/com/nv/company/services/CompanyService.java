package com.nv.company.services;

import com.nv.company.dtos.CreateCompanyDto;
import com.nv.company.models.Company;
import com.nv.company.repositories.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class CompanyService {
    private CompanyRepository companyRepository;
    private ModelMapper modelMapper;

    @Autowired
    public CompanyService(CompanyRepository companyRepository, ModelMapper modelMapper) {
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company registerCompany(CreateCompanyDto createCompanyDto) {
        Company company = modelMapper.map(createCompanyDto, Company.class);
        company.setRegisteredOn(Calendar.getInstance().getTime());
        return companyRepository.save(company);
    }
}
