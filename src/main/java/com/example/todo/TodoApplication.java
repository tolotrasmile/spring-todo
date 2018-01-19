package com.example.todo;

import com.example.todo.dao.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootApplication
public class TodoApplication {


    @Autowired
    private StringRedisTemplate template;

    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

    private static final Logger log = LoggerFactory.getLogger(TodoApplication.class);

    @Bean
    public CommandLineRunner todo(TodoRepository repository) {
        return (args) -> {
            ValueOperations<String, String> ops = this.template.opsForValue();
            String key = "spring.boot.redis.test";
            if (!this.template.hasKey(key)) {
                ops.set(key, "foo");
            }
            System.out.println("Found key " + key + ", value=" + ops.get(key));
        };
    }

}


