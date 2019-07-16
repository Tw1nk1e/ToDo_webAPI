package com.coxautodev.graphql.tools.example.repositories;

import com.coxautodev.graphql.tools.example.models.Task;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepositories extends MongoRepository<Task, ObjectId> {
    @Query("{ 'category': ?0 }")
    List<Task> findAllByCategory(String category);
}