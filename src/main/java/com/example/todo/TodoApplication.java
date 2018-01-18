package com.example.todo;

import com.example.todo.dao.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

    private static final Logger log = LoggerFactory.getLogger(TodoApplication.class);

    @Bean
    public CommandLineRunner todo(TodoRepository repository) {
        return (args) -> log.info("");
    }

    /*
    @Bean
    public CommandLineRunner users(UserRepository repository) {
        return (args) -> {
            repository.deleteAll();
            FakerService service = new FakerService();
            repository.save(service.createFakeUsers(100));
            log.info("");
        };
    }
*/
}


