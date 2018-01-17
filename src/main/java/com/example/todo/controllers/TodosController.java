package com.example.todo.controllers;

import com.example.todo.dao.TodoRepository;
import com.example.todo.entities.TodoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TodosController {

    @Autowired
    TodoRepository repository;

    @GetMapping("/todos")
    @ResponseBody
    public List<TodoEntity> findAll() {
        return (List<TodoEntity>) repository.findAll();
    }

    @GetMapping("/todos/{userId}")
    @ResponseBody
    public List<TodoEntity> getTodoByUserId(@PathVariable int userId) {
        return repository.findByUserId(userId);
    }

}
