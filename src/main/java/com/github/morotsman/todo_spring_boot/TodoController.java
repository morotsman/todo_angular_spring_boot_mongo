package com.github.morotsman.todo_spring_boot;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class TodoController {

    @Resource
    private TodoService todoService;


    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public List<Todo> list() {
        return todoService.list();
    }

    @RequestMapping(value = "/todos", method = RequestMethod.POST)
    public Todo create(@RequestBody Todo todo) {
        return todoService.create(todo);
    }

    @RequestMapping(value = "/todos/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") String id) {
        todoService.delete(id);
    }
    
}    
