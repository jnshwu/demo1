package com.example.demo.controllers;

import com.example.demo.model.Author;
import com.example.demo.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jinshiwu on 8/9/18.
 */
@Controller
public class AuthorController {
    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model) {
        authorRepository.save(new Author("jinshi", "Wu"));
        model.addAttribute("authors", authorRepository.findAll());
        return "authors";
    }
}
