package com.example.todo.dao;

import com.example.todo.entities.User;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

public interface UserRedisRepository {

    void save(User userEntity);

    Map<Object, User> findAll();

    User findAllById(Long userId);

    void update(User userEntity);

    void delete(Long userId);
}

@Repository
class UserRedisRepositoryImpl implements UserRedisRepository {

    private static final String USER_HASH = "todo.user";

    private HashOperations<String, Object, User> hashOperations;

    UserRedisRepositoryImpl(RedisTemplate<String, User> redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(User user) {
        this.hashOperations.put(USER_HASH, user.getId(), user);
    }

    @Override
    public Map<Object, User> findAll() {
        return this.hashOperations.entries(USER_HASH);
    }

    @Override
    public User findAllById(Long userId) {
        return this.hashOperations.get(USER_HASH, userId);
    }

    @Override
    public void update(User user) {
        this.save(user);
    }

    @Override
    public void delete(Long userId) {
        this.hashOperations.delete(USER_HASH, userId);
    }
}