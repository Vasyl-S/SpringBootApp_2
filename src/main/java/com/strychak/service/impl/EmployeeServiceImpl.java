package com.strychak.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.strychak.domain.EmployeeDto;
import com.strychak.entity.Employee;
import com.strychak.repository.EmployeeRepository;
import com.strychak.service.EmployeeService;
import com.strychak.service.utils.ObjectMapperUtils;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ObjectMapperUtils mapperUtils;

	@Override
	public void saveEmployee(EmployeeDto dto) {
		Employee employee = mapperUtils.map(dto, Employee.class);
		employeeRepository.save(employee);
	}

	@Override
	public EmployeeDto findById(Long id) {
		Employee employee = employeeRepository.findById(id).get();
		EmployeeDto employeeDTO = mapperUtils.map(employee, EmployeeDto.class);
		return employeeDTO;
	}

	@Override
	public void delete(Long id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public List<EmployeeDto> getEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		List<EmployeeDto> employeeDtos = mapperUtils.mapAll(employees, EmployeeDto.class);
		return employeeDtos;
	}
	 
	@Override
	public Page<Employee> findEmployeeByName(Pageable pageable, String firstName) {
		return employeeRepository.findByFirstName(pageable, firstName);
	}

	@Override
	public List<EmployeeDto> findAllEmployeesByPages(Pageable pageable) {
		Page<Employee> employeePage = employeeRepository
				.findAll(PageRequest.of(
						  pageable.getPageNumber()
						, pageable.getPageSize()
						, pageable.getSort()));
		List<Employee> employee = employeePage.getContent();
		List<EmployeeDto> employeeDto = mapperUtils.mapAll(employee, EmployeeDto.class);
		return employeeDto;
	}

}
