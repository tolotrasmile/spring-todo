package com.example.todo.controllers;

import com.example.todo.dao.TodoRepository;
import com.example.todo.dao.UserRepository;
import com.example.todo.entities.TodoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TodoRepository todoRepository;

    @GetMapping("/{userId}/todos/")
    @ResponseBody
    public ArrayList<TodoEntity> getTodoByUserId(@PathVariable int userId) {
        return (ArrayList<TodoEntity>) todoRepository.findByUserId(userId);
    }
}
