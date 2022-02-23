package com.example.katacrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServices {
    @Autowired
    private TodoRepository repository;

    public Iterable<Todo> list() {
        return repository.findAll();
    }

    public Todo save(Todo todo)
    {
        return repository.save(todo);
    }

    public void delete(Long id)
    {
        repository.delete(get(id));
    }

    public Todo get(Long id)//se hace este método para poder realizar el método delete
    {
        return repository.findById(id).orElseThrow();//si el id no existe arroja una excepción
    }
}

