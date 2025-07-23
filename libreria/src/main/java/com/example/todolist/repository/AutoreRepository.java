package com.example.todolist.repository;

import com.example.todolist.model.Autore;
import org.springframework.data.jpa.repository.JpaRepository; //JpaRepository extends CrudRepository class

public interface AutoreRepository extends JpaRepository<Autore, Long>
{
    // Tutti i metodi CRUD già pronti!
    //findById
    //findAllById
    //save  creates and updates values
    //saveAll
    //deleteById
    //delete
    //existsById
}