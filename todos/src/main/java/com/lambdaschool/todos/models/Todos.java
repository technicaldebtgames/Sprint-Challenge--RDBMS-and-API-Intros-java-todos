package com.lambdaschool.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "todos")
public class Todos extends Auditable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long todoid; // id is long, not null

    @Column(nullable = false)
    private String description; // desc is str not null

    @Column(nullable = false) // prob not needed because of its type but w/e
    private boolean completed; // defaults to false in constructor, could prob set to false here tho

    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties(value = "todos",
        allowSetters = true) // not sure if needed but doesn't seem to hurt
    private User user; // one user per many todos

    public Todos()
    {
        //System.out.println("Todos empty constructor ran."); // debugging
    }

    public Todos(           // probably a few ways to do this but i initially went for what the seed data
        User user,          // file looked like it wanted, i abandoned that and used data.sql method, this
        String description) // could prob be changed but it's working so w/e, and this is probably the better
    {                       // way to do it anyway since it means you MUST have a full user to create a todoObj
        this.description = description;
        this.user = user;
        this.completed = false; // set default for this to false on all todos
        //System.out.println("Todos full constructor ran.");
        //System.out.println(this.description);
        //System.out.println(this.user);
        //System.out.println(this.completed); // debugging
    }

    public long getTodoid()
    {
        return todoid;
    }

    public void setTodoid(long todoid)
    {
        this.todoid = todoid;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public boolean isCompleted()
    {
        return completed;
    }

    public void setCompleted(boolean completed)
    {
        this.completed = completed;
    }

    public User getUser() // we only need 1 user in a todoObj
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
