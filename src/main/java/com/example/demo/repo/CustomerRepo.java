package com.example.demo.repo;

import com.example.demo.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepo extends MongoRepository<Customer, String> {

    @Query("{bookName :?0}")
    List<Customer> findAll(String name);

    @Query("{customerName :?0}")
    Optional<Customer> findByName(String name);

    @Query("{customerName :?0}")
    Optional<Customer> findByAuthor(String name);



}
