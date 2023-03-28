package com.fithulk.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fithulk.main.model.Employee;

@Repository
public interface MyRepository extends JpaRepository<Employee, Integer>
{

}
