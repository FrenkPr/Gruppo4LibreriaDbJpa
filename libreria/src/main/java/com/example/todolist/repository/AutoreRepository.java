package com.example.todolist.repository;

import com.example.todolist.model.Autore;
import org.springframework.data.jpa.repository.JpaRepository; //JpaRepository extends CrudRepository class

public interface AutoreRepository extends JpaRepository<Autore, Long>
{
    
}