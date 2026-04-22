package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberRepo repo;

    @PostMapping("/add")
    public Member add(@Valid @RequestBody Member m) {
        return repo.save(m);
    }

    @GetMapping("/all")
    public List<Member> getAll() {
        return repo.findAll();
    }
}