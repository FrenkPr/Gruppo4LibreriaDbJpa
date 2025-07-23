package com.example.todolist.controller;

import com.example.todolist.model.Libro;
import com.example.todolist.model.Recensione;
import com.example.todolist.service.LibroService;
import com.example.todolist.service.RecensioneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libro")
@RequiredArgsConstructor
public class LibroController {

    private final LibroService libroService;
    private final RecensioneService recensioneService;

    @GetMapping
    public List<Libro> getAllLibro() {
        return libroService.findAll();
    }

    @GetMapping("/{id}")
    public Libro getLibroById(@PathVariable Long id) {
        return libroService.findById(id);
    }

    @PostMapping
    public Libro createLibro(@RequestBody Libro libro) {
        return libroService.save(libro);
    }

    @PutMapping("/{id}")
    public Libro updateLibro(@PathVariable Long id, @RequestBody Libro modificato) {
        Libro esistente = libroService.findById(id);
        esistente.setTitolo(modificato.getTitolo());
        esistente.setAutore(modificato.getAutore());
        return libroService.save(esistente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLibro(@PathVariable Long id) {
        libroService.delete(id);
        return ResponseEntity.ok("Libro eliminato");
    }

    // ENDPOINT SPECIFICO: tutti i commenti legati a un ToDo
    @GetMapping("/{id}/recensioni")
    public List<Recensione> getRecensioniByLibro(@PathVariable Long id) {
        return recensioneService.findByLibroId(id);
    }
}