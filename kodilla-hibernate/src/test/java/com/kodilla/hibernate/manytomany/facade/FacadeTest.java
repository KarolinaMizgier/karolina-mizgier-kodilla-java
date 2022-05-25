package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FacadeTest {

    @Autowired
    private Facade facade;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testFindCompaniesByName() {
        // given
        Company company = new Company("KarolinaCompany");
        companyDao.save(company);
        // when
        List<Company> companyByName = facade.findCompaniesByName("KarolinaCo");
        // then
        assertEquals(companyByName.size(), 1);
        assertEquals(companyByName.get(0).getName(), "KarolinaCompany");
        //cleanUp
        companyDao.delete(company);
    }

    @Test
    public void findEmploeesByName() {
        //given
        Employee employee = new Employee("Karolina", "Mizgier");
        employeeDao.save(employee);
        //when
        List<Employee> employees = facade.findEmploeesByName("Miz");
        //then
        assertEquals(employees.get(0).getLastname(), "Mizgier");
        //cleanUp
        employeeDao.delete(employee);
    }
}
