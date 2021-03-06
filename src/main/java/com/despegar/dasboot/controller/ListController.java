package com.despegar.dasboot.controller;

import com.despegar.dasboot.model.list.ListInfo;
import com.despegar.dasboot.model.list.UserList;
import com.despegar.dasboot.model.list.Movies;
import com.despegar.dasboot.service.list.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController //@Controller + @ResponseBody
public class ListController {
    private ListService service;

    @Autowired
    public ListController(ListService service) {
        this.service = service;
    }

    @GetMapping(value = "/lists/{id}")
    public UserList getList(@PathVariable(value = "id") String id) {
        return service
                .getList(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "List not found"));
    }

    @PostMapping(value = "/lists/{listId}/movies")
    public UserList addToList(
            @RequestBody Movies movies, @PathVariable(value = "listId") String listId) {
        return service
                .addToList(listId, movies.getIds())
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "List not found"));
    }

    @DeleteMapping(value = "/lists/{listId}/movies")
    public UserList deleteFromList(
            @RequestBody Movies movies, @PathVariable(value = "listId") String listId) {
        return service
                .deleteFromList(listId, movies.getIds())
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "List not found"));
    }

    @DeleteMapping(value = "/lists/{id}")
    public void delete(@PathVariable(value = "id") String listId) throws ResponseStatusException {
        service.delete(listId);
    }

    @PostMapping(value = "/lists")
    public UserList create(@RequestBody ListInfo listInfo) {
        return service.create(listInfo);
    }
}
