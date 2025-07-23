package com.example.todolist.DTO;

import com.example.todolist.model.Autore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LibroDTO {
    private Long id;
    private String titolo;
    private Long autore_id;
}
