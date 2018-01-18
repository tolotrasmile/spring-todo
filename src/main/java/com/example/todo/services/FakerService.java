package com.example.todo.services;

import com.example.todo.entities.TodoEntity;
import com.example.todo.entities.UserEntity;
import com.github.javafaker.Faker;
import groovy.lang.Singleton;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

@Singleton
public class FakerService {

    public ArrayList<TodoEntity> createFakeTodos(int number) {

        ArrayList<TodoEntity> data = new ArrayList<>();

        Faker faker = new Faker(Locale.FRENCH);

        for (int i = 0; i < number; i++) {
            TodoEntity entity = new TodoEntity();
            entity.setContent(faker.lorem().sentence());
            entity.setCompleted(false);
            entity.setUserId(faker.number().numberBetween(1, 6));
            entity.setDate(new Date());
            data.add(entity);
        }

        return data;
    }

    public ArrayList<UserEntity> createFakeUsers(int number) {

        ArrayList<UserEntity> data = new ArrayList<>();

        Faker faker = new Faker(Locale.FRENCH);

        for (int i = 0; i < number; i++) {
            UserEntity entity = new UserEntity();
            entity.setName(faker.name().fullName());
            entity.setEmail(faker.name().username() + "@todo.com");
            data.add(entity);
        }

        return data;
    }
}
