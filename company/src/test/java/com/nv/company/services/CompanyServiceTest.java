package com.nv.company.services;

import com.nv.company.dtos.CreateCompanyDto;
import com.nv.company.models.Company;
import com.nv.company.repositories.CompanyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CompanyServiceTest {
    @Mock
    private CompanyRepository companyRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private CompanyService companyService;

    @Test
    public void getAllCompanies_shouldReturnAllCompanies() {
        Company company = Company.builder()
                .id(10)
                .companyRegistrationNumber("10")
                .build();

        when(companyRepository.findAll()).thenReturn(Collections.singletonList(company));

        List<Company> allCompanies = companyService.getAllCompanies();

        assertThat(allCompanies, hasSize(1));
        assertThat(allCompanies, hasItem(company));
    }

    @Test
    public void registerCompany_shouldRegisterACompany() {
        CreateCompanyDto createCompanyDto = new CreateCompanyDto();
        createCompanyDto.setCompanyRegistrationNumber("10");

        Company company = Company.builder()
                .id(10)
                .companyRegistrationNumber("10")
                .build();

        when(modelMapper.map(createCompanyDto, Company.class)).thenReturn(company);
        when(companyRepository.save(company)).thenReturn(company);

        Company registeredCompany = companyService.registerCompany(createCompanyDto);

        assertThat(registeredCompany, samePropertyValuesAs(company));
    }
}
