package com.library.management.controllers;

import com.library.management.entitites.Publisher;
import com.library.management.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/publishers")

public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping
    public List<Publisher> findAll() {
        return publisherService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Publisher> findById(@PathVariable Long id) {
        return publisherService.findById(id);
    }

    @PostMapping
    public Publisher save(@RequestBody Publisher publisher) {
        return publisherService.save(publisher);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        publisherService.deleteById(id);
    }
}


