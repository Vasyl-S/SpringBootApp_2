package com.strychak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.strychak.domain.DepartmentDto;
import com.strychak.service.DepartmentService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@ApiOperation(value = "This method is for adding department")
	@PostMapping
	public ResponseEntity<Void> saveDepartment(@RequestBody DepartmentDto departmentDto){
		 departmentService.addDepartment(departmentDto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	@ApiOperation(value = "You can see the list of all departments")
	@GetMapping
	public ResponseEntity<List<DepartmentDto>> showAllDepartments() {
		List<DepartmentDto> department = departmentService.showAll();
		return new ResponseEntity<List<DepartmentDto>>(department, HttpStatus.OK);

	}

}
