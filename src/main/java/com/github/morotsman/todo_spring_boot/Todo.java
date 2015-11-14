package com.github.morotsman.todo_spring_boot;

import org.springframework.data.annotation.Id;

/**
 *
 */
public class Todo {
    
    private boolean completed;
    private String description;
    
    @Id
    private String id;
    
    public Todo(){
    
    }

    public Todo(String id, boolean completed, String description) {
        this.completed = completed;
        this.description = description;
        this.id = id;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Todo{" + "completed=" + completed + ", description=" + description + ", id=" + id + '}';
    }
    
    
    
    
    
}
