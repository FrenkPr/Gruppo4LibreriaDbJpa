package com.example.todolist.service;

import com.example.todolist.dto.LibroDTO;
import com.example.todolist.mapper.LibroMapper;
import com.example.todolist.model.Autore;
import com.example.todolist.model.Libro;
import com.example.todolist.repository.AutoreRepository;
import com.example.todolist.repository.LibroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LibroService
{
    private final LibroRepository libroRepository;
    private final AutoreRepository autoreRepository;

    public List<LibroDTO> getAll() {
        return libroRepository.findAll().stream()
                .map(LibroMapper::toDTO)
                .collect(Collectors.toList());
    }

    public LibroDTO getById(Long id) {
        Libro libro = libroRepository.findById(id).orElseThrow();
        return LibroMapper.toDTO(libro);
    }

<<<<<<< Updated upstream
    public Libro findById(Long id) {
        return libroRepository.findById(id).orElseThrow(() -> new RuntimeException("Libro non trovato"));
=======
    public LibroDTO create(LibroDTO libro) {

        Autore autore = autoreRepository.findById(libro.getAutore_id()).orElseThrow(() -> new RuntimeException("Autore non trovato."));

        Libro todo = LibroMapper.toEntity(libro,autore);
        Libro saved = libroRepository.save(todo);
        return LibroMapper.toDTO(saved);
>>>>>>> Stashed changes
    }

    public LibroDTO update(Long id, LibroDTO dto) {
        Libro todo = libroRepository.findById(id).orElseThrow();
        Autore autore = autoreRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Autore non trovato"));

        todo.setTitolo(dto.getTitolo());
        todo.setAutore(autore);
      
//
        Libro updated = libroRepository.save(todo);
        return LibroMapper.toDTO(updated);
    }

    public void delete(Long id) {
        libroRepository.deleteById(id);
    }
    public List<Libro> findByAutoreId(Long id)
    {
        return libroRepository.findByAutoreId(id);
    }
}