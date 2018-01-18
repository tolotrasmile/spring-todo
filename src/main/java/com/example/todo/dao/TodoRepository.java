package com.example.todo.dao;

import com.example.todo.entities.TodoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TodoRepository extends CrudRepository<TodoEntity, Long> {

    @Query("SELECT todo FROM TodoEntity todo WHERE todo.id = :id")
    List<TodoEntity> findById(@Param("id") int id);

    @Query("SELECT todo FROM TodoEntity todo WHERE todo.userId = :userId")
    List<TodoEntity> findByUserId(@Param("userId") int userId);

}