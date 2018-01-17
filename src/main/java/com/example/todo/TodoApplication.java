package com.example.todo;

import com.example.todo.dao.TodoRepository;
import com.example.todo.entities.TodoEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class TodoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

    private static final Logger log = LoggerFactory.getLogger(TodoApplication.class);

    @Bean
    public CommandLineRunner demo(TodoRepository repository) {
        return (args) -> {

            repository.deleteAll();

            TodoEntity entity = new TodoEntity();
            entity.setContent("Content");
            entity.setCompleted(false);
            entity.setUserId(1);
            entity.setContent("Content");
            entity.setDate(new Date());
            repository.save(entity);

            repository.findAll().forEach(todoEntity -> log.info(todoEntity.toString()));

            log.info("");

        };
    }
}
