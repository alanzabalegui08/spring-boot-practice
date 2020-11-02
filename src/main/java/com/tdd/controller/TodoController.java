package com.tdd.controller;


import com.tdd.domain.Todo;
import com.tdd.erros.TodoValidationErrorBuilder;
import com.tdd.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/v1")
public class TodoController {

    private TodoRepository todoRepository;

    @Autowired
    public TodoController(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    @GetMapping("/todo")
    public ResponseEntity<Iterable<Todo>> getTodos(){
        return ResponseEntity.ok(todoRepository.findAll());
    }

    @PostMapping("/to")
    public void createUser(@RequestBody Todo todo)
    {
        Todo result = todoRepository.save(todo);
    }

    @PostMapping(path = "/todos")
    public ResponseEntity<?> createTodo(@Valid @RequestBody Todo todo, Errors errors) {

        if (errors.hasErrors()){
            return ResponseEntity.badRequest().body(TodoValidationErrorBuilder.fromBindingErros(errors));
        }

        Todo result =  todoRepository.save(todo);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId()).toUri();
        return ResponseEntity.created(location).build();
    }





}
