package com.example.todolist.service;

import com.example.todolist.model.Recensione;
import com.example.todolist.repository.RecensioneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecensioneService
{
    private final RecensioneRepository recensioneRepository;

    public List<Recensione> findAll() {
        return recensioneRepository.findAll();
    }

    public List<Recensione> findByLibroId(Long libroId) {
        return recensioneRepository.findByLibroId(libroId);
    }

    public List<Recensione> findByUtenteId(Long utenteId) {
        return recensioneRepository.findByUtenteId(utenteId);
    }

    public Recensione findById(Long id) {
        return recensioneRepository.findById(id).orElseThrow(() -> new RuntimeException("Recensione non trovata"));
    }

    public Recensione save(Recensione recensione) {
        return recensioneRepository.save(recensione);
    }

    public void delete(Long id) {
        recensioneRepository.deleteById(id);
    }
}