package com.example.todolist.service;

import com.example.todolist.model.Autore;
import com.example.todolist.repository.AutoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.foreign.Linker.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AutoreService {
    private final AutoreRepository autoreRepository;

    public List<Autore> findAll() {
        return autoreRepository.findAll();
    }

    public Autore findById(Long id) {
        return autoreRepository.findById(id).orElseThrow(() -> new RuntimeException("Autore non trovato"));
    }

    public Autore save(Autore autore) {
        return autoreRepository.save(autore);
    }

    public void delete(Long id) {
        autoreRepository.deleteById(id);
    }
}