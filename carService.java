package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.carRepo;
import com.example.demo.UserEntity.AddVehicle;
import com.example.demo.exception.RecordNotFoundException;

@Service
public class carService {

    @Autowired
    carRepo carrepo;

    public List<AddVehicle> getAllCars()
	{
		System.out.println("getAllCars");
		List<AddVehicle> result = (List<AddVehicle>) carrepo.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<AddVehicle>();
		}
	}

    public AddVehicle getCarById(Long id) throws RecordNotFoundException 
	{
		System.out.println("getCarId");
		Optional<AddVehicle> employee = carrepo.findById(id);
		
		if(employee.isPresent()) {
			return employee.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

    public AddVehicle CarSave(AddVehicle entity){
        System.out.println("createOrUpdateCar");
		// Create new entry 
		if(entity.getId()  == null) 
		{
			entity = carrepo.save(entity);
			
			return entity;
		} 
		else 
		{
			// update existing entry 
			Optional<AddVehicle> employee = carrepo.findById(entity.getId());
			
			if(employee.isPresent()) 
			{
				AddVehicle newEntity = employee.get();
                newEntity.setImage(entity.getImage());
				newEntity.setVehicleName(entity.getVehicleName());
				newEntity.setModelName(entity.getModelName());
				newEntity.setBrand(entity.getBrand());
                newEntity.setSeater(entity.getSeater());
                newEntity.setPrice(entity.getPrice());

				newEntity = carrepo.save(newEntity);
				
				return newEntity;
			} else {
				entity = carrepo.save(entity);
				
				return entity;
			}
		}
        
    }
    
}
