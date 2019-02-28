package com.strychak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.strychak.domain.EmployeeDto;
import com.strychak.entity.Employee;
import com.strychak.service.EmployeeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@ApiOperation(value = "this method is adding the employee")
	@PostMapping
	public ResponseEntity<Void> addEmployee(@RequestBody EmployeeDto employeeDto) {
		employeeService.saveEmployee(employeeDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@ApiOperation(value = "Getting all employees from DB")
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
		List<EmployeeDto> employeeDto = employeeService.getEmployees();
		
		return new ResponseEntity<List<EmployeeDto>>(employeeDto, HttpStatus.OK);
	}

	@ApiOperation(value = "You can find employee by name")
	@GetMapping("/search")
	public ResponseEntity<Page<Employee>> searchByName(Pageable pageable, @RequestParam("firstName") String firstName) {
		Page<Employee> searchData = employeeService.findEmployeeByName(pageable, firstName);
		return new ResponseEntity<Page<Employee>>(searchData, HttpStatus.OK);
	}

	@ApiOperation(value = "Showing all employees by page")
	@GetMapping("/pages")
	public ResponseEntity<List<EmployeeDto>> findAllByPage(@PageableDefault Pageable pageable) {
		List<EmployeeDto> responseData = employeeService.findAllEmployeesByPages(pageable);
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}

	@ApiOperation(value = "You can update employee by ID")
	@PutMapping("{employeeId}")
	public ResponseEntity<Void> updadeEmployee(@PathVariable("employeeId") Long id,
			@RequestBody EmployeeDto employeeDto) {
		EmployeeDto employee = employeeService.findById(id);
		if (employee != null) {
			employeeDto.setId(id);
			employeeService.saveEmployee(employeeDto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@ApiOperation(value = "Possibility to delete the employee by ID")
	@DeleteMapping("/{employeeId}")
	public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable("employeeId") Long id) {
		EmployeeDto employee = employeeService.findById(id);
		if (employee != null) {
			employeeService.delete(employee.getId());
			return new ResponseEntity<EmployeeDto>(HttpStatus.OK);
		}
		return new ResponseEntity<EmployeeDto>(HttpStatus.NOT_FOUND);

	}

}
