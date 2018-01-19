package com.example.todo.resources;

import com.example.todo.dao.TodoRepository;
import com.example.todo.dao.UserRedisRepository;
import com.example.todo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    UserRedisRepository userRedisRepository;

    @Autowired
    TodoRepository todoRepository;

    @GetMapping("/{id}/{name}")
    @ResponseBody
    public Map<Object, User> addUser(@PathVariable long id, @PathVariable String name) {
        userRedisRepository.save(new User(id, name));
        return this.findAll();
    }

    @GetMapping("/")
    @ResponseBody
    public Map<Object, User> findAll() {
        return userRedisRepository.findAll();
    }

}
