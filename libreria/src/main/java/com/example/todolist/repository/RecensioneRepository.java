package com.example.todolist.repository;

import com.example.todolist.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecensioneRepository extends JpaRepository<Recensione, Long>
{
    //find by methods required for "JoinColumns"
    List<Recensione> findByLibroId(Long libroId);
    List<Recensione> findByUtenteId(Long utenteId);
}