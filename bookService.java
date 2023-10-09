package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.bookRepo;
import com.example.demo.UserEntity.BookVehicle;
import com.example.demo.exception.RecordNotFoundException;

@Service
public class bookService {

    @Autowired
    bookRepo bookrepo;

    public List<BookVehicle> getAllBookings()
	{
		System.out.println("getAllCars");
		List<BookVehicle> result = (List<BookVehicle>) bookrepo.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<BookVehicle>();
		}
	}

    public BookVehicle getBookingById(Long id) throws RecordNotFoundException 
	{
		System.out.println("getCarId");
		Optional<BookVehicle> employee = bookrepo.findById(id);
		
		if(employee.isPresent()) {
			return employee.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

    public BookVehicle BookSave(BookVehicle entity){
        System.out.println("createOrUpdateCar");
		// Create new entry 
		if(entity.getId()  == null) 
		{
			entity = bookrepo.save(entity);
			
			return entity;
		} 
		else 
		{
			// update existing entry 
			Optional<BookVehicle> employee = bookrepo.findById(entity.getId());
			
			if(employee.isPresent()) 
			{
				BookVehicle newEntity = employee.get();
                newEntity.setPickupdate(entity.getPickupdate());
				newEntity.setDropdate(entity.getDropdate());
				newEntity.setLocation(entity.getLocation());
				newEntity.setDays(entity.getDays());
                

				newEntity = bookrepo.save(newEntity);
				
				return newEntity;
			} else {
				entity = bookrepo.save(entity);
				
				return entity;
			}
		}
        
    }

    public void deleteCarById(Long id) throws RecordNotFoundException 
	{
		System.out.println("deleteEmployeeById");
		
		Optional<BookVehicle> employee = bookrepo.findById(id);
		
		if(employee.isPresent()) 
		{
			bookrepo.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}
    
}
