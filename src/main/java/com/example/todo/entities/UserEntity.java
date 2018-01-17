package com.example.todo.entities;

import java.util.ArrayList;
import java.util.List;

public class UserEntity {

    private UserEntity(String name, String email) {
        setName(name);
        setEmail(email);
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static List<UserEntity> getUsers() {

        ArrayList<UserEntity> userEntities = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            userEntities.add(new UserEntity("User" + i, "user" + i + "@mail.com"));
        }

        return userEntities;
    }

}
