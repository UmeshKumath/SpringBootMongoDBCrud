package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {


}
