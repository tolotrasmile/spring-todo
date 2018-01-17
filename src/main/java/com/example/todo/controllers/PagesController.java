package com.example.todo.controllers;

import com.example.todo.dao.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PagesController {

    @Autowired
    TodoRepository repository;

    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "Welcome";
    }

}
