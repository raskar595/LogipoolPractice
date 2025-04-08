package com.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.model.Employee;
import com.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl empSer;
	
	@Value("${file.path}")
	String path;	
	
	@PostMapping("/addEmp")
	public Employee addEmp(String name,String position,String city,int salary,MultipartFile file) throws IOException {
		return empSer.addEmployee(name, position, city, salary, path, file);
	}
}
