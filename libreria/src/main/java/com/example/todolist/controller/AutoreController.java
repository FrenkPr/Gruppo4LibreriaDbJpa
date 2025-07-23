package com.example.todolist.controller;

import com.example.todolist.dto.AutoreDTO;
import com.example.todolist.model.Autore;
import com.example.todolist.service.AutoreService;
import com.example.todolist.service.LibroService;
import com.example.todolist.model.Libro;
import com.example.todolist.model.Utente;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autore")
@RequiredArgsConstructor
public class AutoreController {
    private final AutoreService autoreService;
    private final LibroService libroService;



    @GetMapping
    public ResponseEntity<List<AutoreDTO>> getAllAutori() {
        return ResponseEntity.ok(autoreService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutoreDTO> getAutoreById(@PathVariable Long id) {
        return ResponseEntity.ok(autoreService.findById(id));
    }

    @PostMapping
    public ResponseEntity<AutoreDTO> createAutore(@RequestBody Autore autore) {
        return ResponseEntity.ok(autoreService.create(autore));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAutore(@PathVariable Long id) {
        autoreService.delete(id);
        return ResponseEntity.ok("Autore eliminato");
    }


    @GetMapping("/{id}/libro")
    public ResponseEntity<List<Libro>> getLibroByAutore(@PathVariable Long id) {
        return ResponseEntity.ok(libroService.findByAutoreId(id));
    }
}
