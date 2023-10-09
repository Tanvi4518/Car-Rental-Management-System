package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.CustomerRepo;
import com.example.demo.UserEntity.UserRegister;
import com.example.demo.exception.RecordNotFoundException;

@Service
public class customerService {
    @Autowired
    CustomerRepo customerRepo;

    public List<UserRegister> getAllEmployees()
	{
		System.out.println("getAllEmployees");
		List<UserRegister> result = (List<UserRegister>) customerRepo.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<UserRegister>();
		}
	}

    public UserRegister getEmployeeById(Long id) throws RecordNotFoundException 
	{
		System.out.println("getEmployeeById");
		Optional<UserRegister> employee = customerRepo.findById(id);
		
		if(employee.isPresent()) {
			return employee.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

    public UserRegister CustomerSave(UserRegister entity){
        System.out.println("createOrUpdateEmployee");
		// Create new entry 
		if(entity.getId()  == null) 
		{
			entity = customerRepo.save(entity);
			
			return entity;
		} 
		else 
		{
			// update existing entry 
			Optional<UserRegister> employee = customerRepo.findById(entity.getId());
			
			if(employee.isPresent()) 
			{
				UserRegister newEntity = employee.get();
				newEntity.setEmail(entity.getEmail());
				newEntity.setFirstName(entity.getFirstName());
				newEntity.setLastName(entity.getLastName());

				newEntity = customerRepo.save(newEntity);
				
				return newEntity;
			} else {
				entity = customerRepo.save(entity);
				
				return entity;
			}
		}
        
    }



	public void deleteEmployeeById(Long id) throws RecordNotFoundException 
	{
		System.out.println("deleteEmployeeById");
		
		Optional<UserRegister> employee = customerRepo.findById(id);
		
		if(employee.isPresent()) 
		{
			customerRepo.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}


}
