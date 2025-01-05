package com.example.CampusQuest.repository;


import com.example.CampusQuest.entity.Users;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<Users,ObjectId> {

    Users findByUserName(String username);
    Users findByEmail(String email);
}
