package com.example.todocrud.services;

import com.example.todocrud.entity.Todo;
import com.example.todocrud.entity.Users;
import com.example.todocrud.repository.ToDoRepository;
import com.example.todocrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class TodoServices {

    @Autowired

     UserServices userServices;
    @Autowired
     ToDoRepository toDoRepository;
    @Autowired

     UserRepository userRepository;

    public Todo getTodoById(Long todoId){
        //write code
    }

    public void addTodo(Long userId, Todo todo){
        // write code
    }
    public void deleteTodo(Long userId,Long todoId){
        //write code
    }

    public void toggleTodoCompleted(Long todoId){
        Todo todo = this.getTodoById(todoId);
        todo.setCompleted(!todo.getCompleted());
        toDoRepository.save(todo);
    }




}
