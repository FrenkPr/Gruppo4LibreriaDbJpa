package com.example.todolist.controller;

import com.example.todolist.model.Autore;
import com.example.todolist.service.AutoreService;
import com.example.todolist.service.LibroService;
import com.example.todolist.model.Libro;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autore")
@RequiredArgsConstructor
public class AutoreController
{
    private final AutoreService autoreService;
    private final LibroService libroService;

    @GetMapping
    public List<Autore> getAllAutori() {
        return autoreService.findAll();
    }

    @GetMapping("/{id}")
    public Autore getAutoreById(@PathVariable Long id) {
        return autoreService.findById(id);
    }

    @PostMapping
    public Autore createAutore(@RequestBody Autore autore) {
        return autoreService.save(autore);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAutore(@PathVariable Long id) {
        autoreService.delete(id);
        return ResponseEntity.ok("Autore eliminato");
    }

    
    
}