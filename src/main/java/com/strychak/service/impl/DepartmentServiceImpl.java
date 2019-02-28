package com.strychak.service.impl;

import com.strychak.domain.DepartmentDto;
import com.strychak.entity.Department;
import com.strychak.repository.DepartmentRepository;
import com.strychak.service.DepartmentService;
import com.strychak.service.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl  implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private ObjectMapperUtils objectMapperUtils;

	@Override
	public void addDepartment(DepartmentDto departmentDto) {
		Department department = objectMapperUtils.map(departmentDto, Department.class);
		departmentRepository.save(department);
		
	}

	@Override
	public List<DepartmentDto> showAll() {
		List<Department> department = departmentRepository.findAll();
		List<DepartmentDto> departmentDto = objectMapperUtils.mapAll(department, DepartmentDto.class);
		return departmentDto;
	}
	


	

}
