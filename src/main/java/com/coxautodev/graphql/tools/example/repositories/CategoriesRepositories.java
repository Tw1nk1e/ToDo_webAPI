package com.coxautodev.graphql.tools.example.repositories;

import com.coxautodev.graphql.tools.example.models.Category;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepositories extends MongoRepository<Category, ObjectId> {
}