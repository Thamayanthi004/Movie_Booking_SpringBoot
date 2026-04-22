package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Movie;

public interface MovieRepo extends JpaRepository<Movie,Integer>{
List<Movie> findByLanguage(String language);
List<Movie> findByGenre(String genre);
}
