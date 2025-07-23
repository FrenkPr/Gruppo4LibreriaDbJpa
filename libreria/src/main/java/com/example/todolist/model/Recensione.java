package com.example.todolist.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "recensioni")
public class Recensione
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String testo;

    @ManyToOne
    @JoinColumn(name = "libro_id", nullable = false)
    private Libro libro;

    //"JoinColumn" "name" property: "className_attributeName"
    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;
}