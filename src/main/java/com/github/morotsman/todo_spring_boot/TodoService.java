package com.github.morotsman.todo_spring_boot;

import java.util.List;



/**
 *
 */
public interface TodoService {
    
    public Todo create(final Todo todo);
    

    public void delete(final String id);
    
    public List<Todo> list();
    
}
