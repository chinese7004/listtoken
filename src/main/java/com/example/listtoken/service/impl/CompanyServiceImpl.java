package com.example.listtoken.service.impl;

import com.example.listtoken.dao.CompanyDao;
import com.example.listtoken.entity.Company;
import com.example.listtoken.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Huoshan
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyDao companyDao;

    @Override
    public List<Company> getCompanyList(Integer pageSize, Integer pageNo) {
        Integer start = (pageNo - 1) * pageSize;
        return companyDao.getCompanyList(start, pageNo);
    }

    @Override
    public void create(Company company, Integer userId) {
        Company company1 = companyDao.getCompanyByName(company.getName());
        if (company1 != null) {
            throw new RuntimeException("Company exists.");
        }

        companyDao.createCompany(company);
        company1 = companyDao.getCompanyByName(company.getName());
        companyDao.createCompanyUserRel(company1.getId(), userId);
    }

    @Override
    public void update(Company company, Integer userId) {
        Company company1 = companyDao.getCompanyById(company.getId());
        if (company1 == null) {
            throw new RuntimeException("Company does not exist.");
        }

        company1 = companyDao.getCompanyByName(company.getName());
        if (company1 != null) {
            throw new RuntimeException("Company exists.");
        }

        companyDao.update(company);
    }

    @Override
    public void delete(Integer id) {
        Company company = companyDao.getCompanyById(id);
        if (company == null) {
            throw new RuntimeException("Company does not exist.");
        }

        companyDao.delete(id);
    }

    @Override
    public Company get(Integer id) {
        Company company = companyDao.getCompanyById(id);
        if (company == null) {
            throw new RuntimeException("Company does not exist.");
        }
        return company;
    }
}
