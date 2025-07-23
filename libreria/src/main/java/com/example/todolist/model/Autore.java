package com.example.todolist.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity //sets the "User" class as a table
@Data //getter and setter for each attribute
@NoArgsConstructor //empty constructor
@AllArgsConstructor //constructor with all params
@Builder
@Table(name = "autori")
public class Autore
{
    @Id //sets the "id" attribute as a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment option
    private Long id;

    //username non nullable field
    @Column(nullable = false)
    private String nome;

    //on "mappedBy" parameter we must pass the name of the related class.
    //The parameter is not case sensitive
    @OneToMany(mappedBy = "autore", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore //avoids "OneToMany" "ManyToOne" loop
    private List<Libro> libri;
}