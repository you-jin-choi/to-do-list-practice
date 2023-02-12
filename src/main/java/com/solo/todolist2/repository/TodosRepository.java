package com.solo.todolist2.repository;

import com.solo.todolist2.entity.Todos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TodosRepository extends JpaRepository<Todos, Integer> {
}
