package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.UserEntity.AddVehicle;

@Repository
public interface carRepo extends CrudRepository<AddVehicle,Long>{
    
}
