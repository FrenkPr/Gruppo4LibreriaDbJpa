package com.example.todolist.repository;

import com.example.todolist.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository; //JpaRepository extends CrudRepository class

public interface UtenteRepository extends JpaRepository<Utente, Long>
{
    
}