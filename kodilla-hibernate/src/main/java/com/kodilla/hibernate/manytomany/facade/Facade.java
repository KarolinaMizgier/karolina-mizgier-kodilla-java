package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Facade {
    private final CompanyDao companyRepository;
    private final EmployeeDao employeeDao;

    @Autowired
    public Facade(CompanyDao companyRepository, EmployeeDao employeeDao) {
        this.companyRepository = companyRepository;
        this.employeeDao = employeeDao;
    }

    public List<Company> findCompaniesByName(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Company name cannot be empty");
        }
        return companyRepository.findCompaniesByNameLike("%" + name + "%");
    }

    public List<Employee> findEmploeesByName(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Employee name cannot be empty");
        }
        return employeeDao.findEmployeesByLastnameLike("%" + name + "%");
    }
}
