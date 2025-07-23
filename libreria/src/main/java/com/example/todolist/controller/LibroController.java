package com.example.todolist.controller;

import com.example.todolist.dto.LibroDTO;
import com.example.todolist.mapper.LibroMapper;
import com.example.todolist.model.Libro;
import com.example.todolist.model.Recensione;
import com.example.todolist.model.Utente;
import com.example.todolist.model.Autore;
import com.example.todolist.service.AutoreService;
import com.example.todolist.service.LibroService;
import com.example.todolist.service.RecensioneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.todolist.repository.LibroRepository;


import java.util.List;

@RestController
@RequestMapping("/libro")
@RequiredArgsConstructor
public class LibroController {

    private final LibroService libroService;
    private final RecensioneService recensioneService;
    private final AutoreService autoreService;
  

    @GetMapping
    public ResponseEntity<List<LibroDTO>> getAll() {
        return ResponseEntity.ok(libroService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(libroService.getById(id));
    }

    @PostMapping
    public ResponseEntity<LibroDTO> create( @RequestBody LibroDTO dto) {
        return ResponseEntity.ok(libroService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibroDTO> update(@PathVariable Long id,  @RequestBody LibroDTO dto) {
        return ResponseEntity.ok(libroService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        libroService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}/libro")
    public List<Libro> getLibroByAutore(@PathVariable Long id) {
        return libroService.findByAutoreId(id);
    }
  
   
}
