package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Movie;
import com.example.demo.repository.MovieRepo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieRepo repo;

    @PostMapping("/add")
    public Movie add(@Valid @RequestBody Movie m) {
        return repo.save(m);
    }

    @GetMapping("/all")
    public List<Movie> getAll() {
        return repo.findAll();
    }
}
