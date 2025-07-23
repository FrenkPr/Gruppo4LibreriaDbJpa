package com.example.todolist.controller;

import com.example.todolist.model.*;
import com.example.todolist.service.*;
import com.example.todolist.mapper.*;
import com.example.todolist.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utente")
@RequiredArgsConstructor
public class UtenteController
{
    private final UtenteService utenteService;
    private final RecensioneService recensioneService;

    @GetMapping
    public List<Utente> getAllUtenti() {
        return utenteService.findAll();
    }

    @GetMapping("/{id}")
    public Utente getUtenteById(@PathVariable Long id) {
        return utenteService.findById(id);
    }

    @PostMapping
    public Utente createUtente(@RequestBody Utente utente) {
        return utenteService.save(utente);
    }

    @PostMapping("/dto")
    public ResponseEntity<UtenteDTO> createDTOUtente(@RequestBody UtenteDTO utenteDto) {
        Utente nuovoUtente = getUtenteById(utenteDto.getId());
        Utente utenteAggiunto = utenteService.save(nuovoUtente);
        
        return ResponseEntity.ok(UtenteMapper.toDTO(utenteAggiunto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUtente(@PathVariable Long id) {
        utenteService.delete(id);
        return ResponseEntity.ok("Utente eliminato");
    }

    @GetMapping("/{id}/recensione")
    public List<Recensione> getRecensioniByUtente(@PathVariable Long id) {
        return recensioneService.findByUtenteId(id);
    }
}