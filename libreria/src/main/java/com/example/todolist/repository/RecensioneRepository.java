package com.example.todolist.repository;

import com.example.todolist.model.Recensione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecensioneRepository extends JpaRepository<Recensione, Long>
{
    List<Recensione> findByLibroId(Long libroId);
}