package com.wigo.services.config;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.wigo.services.models.Restaurant;

public interface  RestauranRepo extends MongoRepository<Restaurant, ObjectId>  {

}
