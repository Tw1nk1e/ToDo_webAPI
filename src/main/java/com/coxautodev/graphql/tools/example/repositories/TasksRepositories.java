package com.coxautodev.graphql.tools.example.repositories;

import com.coxautodev.graphql.tools.example.models.Task;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepositories extends MongoRepository<Task, ObjectId> {
}