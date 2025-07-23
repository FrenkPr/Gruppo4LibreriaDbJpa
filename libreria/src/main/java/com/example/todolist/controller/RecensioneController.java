package com.example.todolist.controller;

import com.example.todolist.model.Recensione;
import com.example.todolist.service.RecensioneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recensioni")
@RequiredArgsConstructor
public class RecensioneController
{
    private final RecensioneService recensioneService;

    @GetMapping
    public List<Recensione> getAllRecensione() {
        return recensioneService.findAll();
    }

    @GetMapping("/{id}")
    public Recensione getRecensioneById(@PathVariable Long id) {
        return recensioneService.findById(id);
    }

    @PostMapping
    public Recensione createRecensione(@RequestBody Recensione recensione) {
        return recensioneService.save(recensione);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRecensione(@PathVariable Long id) {
        recensioneService.delete(id);
        return ResponseEntity.ok("Recensione eliminata");
    }
}