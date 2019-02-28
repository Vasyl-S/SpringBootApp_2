package com.strychak.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.strychak.domain.EmployeeDto;
import com.strychak.entity.Employee;

public interface EmployeeService {

	void saveEmployee(EmployeeDto dto);

	EmployeeDto findById(Long id);

	void delete(Long id);
	
	List<EmployeeDto> getEmployees();

	Page<Employee> findEmployeeByName(Pageable Pageable, String firstName);

	List<EmployeeDto> findAllEmployeesByPages(Pageable pageable);

}