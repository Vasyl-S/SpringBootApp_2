package com.strychak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.strychak.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
