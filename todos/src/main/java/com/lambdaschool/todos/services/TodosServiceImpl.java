package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.models.User;
import com.lambdaschool.todos.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "todosService")
public class TodosServiceImpl implements TodosService
{

    @Autowired // always says field injection is not recommended - why?
    private TodosRepository todosrepos;

    @Autowired
    private UserService userService; // not needed but leaving it in cause save is still below and refs it

    @Transactional
    @Override
    public void markComplete(long todoid)
    {
        Todos todo = todosrepos.findById(todoid).orElseThrow(() -> new EntityNotFoundException("Todo " + todoid + " not found."));
        todo.setCompleted(true); // adjust the boolean, specs say mark it true not flip it
        todosrepos.save(todo);
    }

    @Transactional
    @Override
    public Todos save( // this is pointless, i am not calling a save from this service, added it for debugging
        long userid,
        String description)
    {
        System.out.println("Todos.save in TSImpl ran."); // shouldnt run, and doesnt
        User user = userService.findUserById(userid);

        Todos todo = new Todos(user, description);

        return todosrepos.save(todo);
    }
}
