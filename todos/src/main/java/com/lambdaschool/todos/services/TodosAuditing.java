package com.lambdaschool.todos.services;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TodosAuditing implements AuditorAware<String>
{

    @Override
    public Optional<String> getCurrentAuditor()
    {
        String uname;
        uname = "llama";
        return Optional.of(uname);
    }
}
