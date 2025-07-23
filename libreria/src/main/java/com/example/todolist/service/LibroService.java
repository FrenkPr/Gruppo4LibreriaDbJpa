package com.example.todolist.service;

import com.example.todolist.model.Libro;
import com.example.todolist.repository.LibroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibroService
{
    private final LibroRepository libroRepository;

    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    public List<Libro> findByAutoreId(Long autoreId) {
        return libroRepository.findByAutoreId(autoreId);
    }

    public Libro findById(Long id) {
        return libroRepository.findById(id).orElseThrow(() -> new RuntimeException("Libro non trovato"));
    }

    public Libro save(Libro todo) {
        return libroRepository.save(todo);
    }

    public void delete(Long id) {
        libroRepository.deleteById(id);
    }
}