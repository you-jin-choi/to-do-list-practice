package com.solo.todolist2.controller;

import com.solo.todolist2.dto.PatchDto;
import com.solo.todolist2.dto.PostDto;
import com.solo.todolist2.entity.Todos;
import com.solo.todolist2.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity postTodo (@RequestBody PostDto postDto) {
        Todos todos = new Todos();
        todos.setTitle(postDto.getTitle());
        todos.setTodo_order(postDto.getTodo_order());
        todos.setCompleted(postDto.isCompleted());

        Todos response = todoService.createTodo(todos);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PatchMapping("{id}")
    public ResponseEntity patchTodo(@PathVariable("id") Long id,
                                    @RequestBody PatchDto patchDto) {

        patchDto.setId(id);

         Todos todo = new Todos();
         todo.setId(patchDto.getId());
         todo.setTitle(patchDto.getTitle());
         todo.setTodo_order(patchDto.getTodo_order());
         todo.setCompleted(patchDto.isCompleted());

        Todos response = todoService.updateTodo(todo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity getTodo(@PathVariable("id") Long id) {

        Todos response = todoService.getTodo(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getList() {

        List<Todos> response = todoService.getList();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteTodo(@PathVariable("id") Long id) {

        todoService.deleteTodo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity deleteList() {
        todoService.deleteList();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
