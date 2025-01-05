package com.example.CampusQuest.repository;

import com.example.CampusQuest.entity.Doubts;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DoubtsRepository extends MongoRepository<Doubts, ObjectId> {

    List<Doubts> findByUserName(String userName);
}
