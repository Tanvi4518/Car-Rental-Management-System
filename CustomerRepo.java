package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.UserEntity.UserRegister;



@Repository
public interface CustomerRepo extends CrudRepository<UserRegister,Long>{
    Optional<UserRegister> findByMobileNumber(String mobilenumber);
}
