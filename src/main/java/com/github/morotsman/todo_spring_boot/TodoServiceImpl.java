package com.github.morotsman.todo_spring_boot;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class TodoServiceImpl implements TodoService {
    
    @Resource
    private TodoRepository repository;

    @Override
    public Todo create(Todo todo) {
        return repository.insert(todo);
    }


    @Override
    public void delete(String id) {
        repository.delete(id);
    }

    @Override
    public List<Todo> list() {
        return repository.findAll();
    }
    
    
    
}
