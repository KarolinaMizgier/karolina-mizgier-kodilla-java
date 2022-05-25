package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.task.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {

    @Query("SELECT c FROM Company c WHERE c.name LIKE %:name%")
    List<Company> findCompaniesByNameLike(@Param("name") String name);

    @Query(nativeQuery = true)
    List<Company> retrieveCompaniesByThreeLetters(@Param("NAME") String name);

}
