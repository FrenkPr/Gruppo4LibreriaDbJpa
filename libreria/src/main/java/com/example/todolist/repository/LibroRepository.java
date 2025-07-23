package com.example.todolist.repository;

import com.example.todolist.model.Libro;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository; //JpaRepository extends CrudRepository class
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long>
{
    // Tutti i metodi CRUD già pronti!
    //findById
    //findAllById
    //save  creates and updates values
    //saveAll
    //deleteById
    //delete
    //existsById

    List<Libro> findByAutoreId(Long autoreId);
}