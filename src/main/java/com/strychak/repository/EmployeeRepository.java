package com.strychak.repository;






import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.strychak.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	Page<Employee> findByFirstName(Pageable pageable,String firstName);
	


}
