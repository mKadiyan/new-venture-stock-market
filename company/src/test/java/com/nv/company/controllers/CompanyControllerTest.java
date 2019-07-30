package com.nv.company.controllers;

import com.nv.company.dtos.CreateCompanyDto;
import com.nv.company.models.Company;
import com.nv.company.services.CompanyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CompanyController.class)
public class CompanyControllerTest {
    @MockBean
    private CompanyService companyService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getCompanies_shouldReturnCompanies() throws Exception {
        when(companyService.getAllCompanies()).thenReturn(Collections.singletonList(Company.builder().id(10).build()));
        mockMvc.perform(get("/companies")).andExpect(status().isOk()).andReturn();

        verify(companyService).getAllCompanies();
    }

    @Test
    public void registerCompany_shouldRegisterCompanies() throws Exception {
        mockMvc.perform(post("/companies")
                .contentType("application/json")
                .content("{\"name\": \"some name\"}".getBytes())).andExpect(status().isOk()).andReturn();

        verify(companyService).registerCompany(any(CreateCompanyDto.class));
    }
}
