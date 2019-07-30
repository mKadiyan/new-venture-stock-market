package com.nv.company.controllers;

import com.nv.company.models.Company;
import com.nv.company.repositories.CompanyRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CompanyControllerTest {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    protected TestRestTemplate restTemplate;

    @Before
    public void setUp() {
        companyRepository.deleteAll();
    }

    @Test
    public void shouldCreateACompany() throws Exception {
        Company company = Company
                .builder()
                .id(10)
                .build();

        restTemplate.postForEntity("/companies", company, Company.class);

        List<Company> allCompany = companyRepository.findAll();
        assertThat(allCompany, hasSize(1));
    }

    @Test
    public void shouldFetchAllCompany() throws Exception {
        Company company = Company
                .builder()
                .name("nv-company")
                .build();
        companyRepository.save(company);
        Company[] actualCompanies = restTemplate.getForEntity("/companies", Company[].class).getBody();
        assertThat(actualCompanies, arrayWithSize(1));
        assertThat(actualCompanies, arrayContaining(company));
    }
}
