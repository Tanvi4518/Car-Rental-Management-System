package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.UserEntity.AddVehicle;

public interface adminCarRepo extends CrudRepository<AddVehicle,Long> {
    
}
