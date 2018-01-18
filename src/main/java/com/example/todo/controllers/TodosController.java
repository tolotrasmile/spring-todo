package com.example.todo.controllers;

import com.example.todo.dao.TodoRepository;
import com.example.todo.entities.TodoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/todos")
public class TodosController {

    @Autowired
    TodoRepository repository;

    @GetMapping("/")
    @ResponseBody
    public Iterable<TodoEntity> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{userId}")
    @ResponseBody
    public TodoEntity getTodoByUserId(@PathVariable int userId) {
        ArrayList<TodoEntity> list = (ArrayList<TodoEntity>) repository.findByUserId(userId);
        return list != null && list.size() > 0 ? list.get(0) : null;
    }

}
