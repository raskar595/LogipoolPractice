package com.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.model.Employee;

public interface EmployeeService {
	
	Employee addEmployee(String name,String position,String city,int salary,String path,MultipartFile file) throws IOException;

}
