package com.example.todolist.model;

import jakarta.persistence.*;
import lombok.*;

@Entity //sets the "Todo" class as a table
@Data //getter and setter for each attribute
@NoArgsConstructor //empty constructor
@AllArgsConstructor //constructor with all params
@Builder
@Table(name = "libri")
public class Libro
{
    @Id //sets the "id" attribute as a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment option
    private Long id;

    @Column(nullable = false)
    private String titolo;
    @Column(nullable = false)
    private double prezzo;
    

    @ManyToOne
    @JoinColumn(name = "autore_id", nullable = false)
    private Autore autore;
}


