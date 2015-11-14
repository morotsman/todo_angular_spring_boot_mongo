package com.github.morotsman.todo_spring_boot;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 */
public interface TodoRepository extends MongoRepository<Todo, String>{
    
}
