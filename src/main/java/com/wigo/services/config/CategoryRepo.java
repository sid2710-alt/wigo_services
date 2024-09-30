package com.wigo.services.config;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wigo.services.models.Category;

public interface CategoryRepo extends MongoRepository<Category, String> {

}
