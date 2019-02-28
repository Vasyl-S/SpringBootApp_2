package com.strychak.domain;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class EmployeeDto {
	
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private DepartmentDto department;

}
