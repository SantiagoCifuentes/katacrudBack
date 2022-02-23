package com.example.katacrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin (origins = "http://localhost:3001/")

public class TodoController
{
    @Autowired
    private TodoServices services;

    @GetMapping(value = "api/todos")
    public Iterable<Todo> list() {
        return services.list();
    }


    @PostMapping(value = "api/todo")
    public Todo save(@RequestBody Todo todo)
    {
        return services.save(todo);
    }


    @PutMapping(value = "api/todo")
    public Todo update(@RequestBody Todo todo)
    {
        if (todo.getId() != null){return services.save(todo);}
        throw new RuntimeException("No existe el id para actualizar");
    }


    @DeleteMapping(value = "api/todo/{id}")
    public void delete(@PathVariable("id") Long id)
    {
        services.delete(id);
    }

    @GetMapping(value = "api/{id}/todo")

    public Todo get(@PathVariable("id") Long id)
    {
        return services.get(id);
    }

}
