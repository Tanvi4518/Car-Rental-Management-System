package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.UserEntity.BookVehicle;

@Repository
public interface bookRepo extends CrudRepository<BookVehicle,Long>{
    
}
