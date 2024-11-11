package com.wigo.services.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wigo.services.config.RestauranRepo;
import com.wigo.services.models.Restaurant;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestauranRepo restauranRepo;

    @PostMapping("/create")
    public ResponseEntity<String> createRestauran(@RequestBody @Valid Restaurant restaurantData) {
        Restaurant newRestaurant = restauranRepo.save(restaurantData);
        return ResponseEntity.status(201).body(newRestaurant.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable("id") String id) {
        ObjectId objId = new ObjectId(id);
        Optional<Restaurant> restaurantData = restauranRepo.findById(objId);
        if (restauranRepo.findById(objId).isPresent()) {
            return ResponseEntity.ok(restaurantData.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/random/{code}")
    public ResponseEntity<List<Restaurant>> getRandomRestaurants (@PathVariable("code") String code) {
         List<Restaurant> allRestaurants = restauranRepo.findAll();
        // Shuffle the list to randomize
        Collections.shuffle(allRestaurants);
        List<Restaurant> validRestaurants = new ArrayList<>();
        if(code != null && !code.isEmpty()) {
            validRestaurants = allRestaurants.stream().filter(restaurant -> (restaurant.isAvailable() && restaurant.getCode().equals(code))).limit(5).collect(Collectors.toList());
        }

        if(validRestaurants.isEmpty()) {
            validRestaurants = allRestaurants.stream().filter(restaurant -> (restaurant.isAvailable())).limit(5).collect(Collectors.toList());
        }
         return ResponseEntity.ok(validRestaurants);
    }
    @GetMapping("/all/{code}")
    public ResponseEntity<List<Restaurant>> getAllNearbyRestaurants (@PathVariable("code") String code) {
        List<Restaurant> allRestaurants = restauranRepo.findAll();
       // Shuffle the list to randomize
       Collections.shuffle(allRestaurants);
       List<Restaurant> validRestaurants = new ArrayList<>();
       if(code != null && !code.isEmpty()) {
           validRestaurants = allRestaurants.stream().filter(restaurant -> (restaurant.isAvailable() && restaurant.getCode().equals(code))).collect(Collectors.toList());
       }

       if(validRestaurants.isEmpty()) {
           validRestaurants = allRestaurants.stream().filter(restaurant -> (restaurant.isAvailable())).collect(Collectors.toList());
       }
        return ResponseEntity.ok(validRestaurants);
   }
}
