package com.strychak.service;

import java.util.List;

import com.strychak.domain.DepartmentDto;

public interface DepartmentService {
	
	void addDepartment(DepartmentDto departmentDto);

	List<DepartmentDto> showAll();

}
