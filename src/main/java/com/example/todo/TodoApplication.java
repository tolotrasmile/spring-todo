package com.example.todo;

import com.example.todo.dao.TodoRepository;
import com.example.todo.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootApplication
public class TodoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

    private static final Logger log = LoggerFactory.getLogger(TodoApplication.class);

    @Bean
    public CommandLineRunner todo(TodoRepository repository, StringRedisTemplate template) {
        return (args) -> {

            ValueOperations<String, String> ops = template.opsForValue();
            String key = "spring.boot.redis.test";

            if (!template.hasKey(key)) {
                ops.set(key, "foo");
            }

            System.out.println("Found key " + key + ", value=" + ops.get(key));
        };
    }

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    RedisTemplate<String, User> userEntityRedisTemplate() {
        RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(this.jedisConnectionFactory());
        return redisTemplate;
    }

}


