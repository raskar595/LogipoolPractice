package com.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dao.EmployeeRepository;
import com.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository empRepo;

	@Override
	public Employee addEmployee(String name, String position, String city, int salary,String path, MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		
		String fname=file.getOriginalFilename();
		String fpath=path+fname;
		
		Files.copy(file.getInputStream(), Paths.get(fpath));
		
		Employee emp=new Employee();
		emp.setName(name);
		emp.setCity(city);
		emp.setPosition(position);
		emp.setSalary(salary);
		emp.setFname(fname);
		emp.setFpath(fpath);
		
		return empRepo.save(emp);
	}
}
