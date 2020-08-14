package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;

public interface TodosService
{
    void markComplete(long todoid); // was provided here, functionality now works

    Todos save(long userid, String description); // added for debugging, unused in project
}
