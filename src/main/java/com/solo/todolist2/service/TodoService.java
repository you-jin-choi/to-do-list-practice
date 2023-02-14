package com.solo.todolist2.service;

import com.solo.todolist2.dto.PostDto;
import com.solo.todolist2.entity.Todos;
import com.solo.todolist2.repository.TodosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodosRepository repository;

    public TodoService(TodosRepository repository) {
        this.repository = repository;
    }

    public Todos createTodo(Todos todos) {
        Todos response = repository.save(todos);
        return response;
    }
   public Todos updateTodo(Todos todos) {
        Todos findTodo = findExistTodo(todos.getId());
       Optional.ofNullable(todos.getTitle()).ifPresent(title -> findTodo.setTitle(title));
       Optional.ofNullable(todos.getTodo_order()).ifPresent(todo_order->findTodo.setTodo_order(todo_order));
       Optional.ofNullable(todos.isCompleted()).ifPresent(completed-> findTodo.setCompleted(completed));

       return repository.save(findTodo);
   }

    public Todos getTodo(Long id) {
        Todos findTodo = findExistTodo(id);
        return findTodo;
    }

    public List<Todos> getList() {
     return (List<Todos>) repository.findAll();
    }
    public void deleteTodo(Long id) {
        Todos findTodo = findExistTodo(id);
        repository.delete(findTodo);
    }
    public void deleteList() {
        repository.deleteAll();
    }
    private Todos findExistTodo(Long id) {
        Todos findTodo = repository.findById(id).get();
//        Todos findTodo = optionalTodo.orElseThrow(()-> new RuntimeException("NOT FOUND"));

        return findTodo;
    }
}
