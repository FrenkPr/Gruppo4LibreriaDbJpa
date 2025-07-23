package com.example.todolist.mapper;

import com.example.todolist.dto.LibroDTO;
import com.example.todolist.model.Libro;

public class LibroMapper {
   public static LibroDTO toDTO(Libro libro) {
    return LibroDTO.builder()
            .id(libro.getId())
            .titolo(libro.getTitolo())
            .autore_id(libro.getAutore().getId())
            .build();
}

public static Libro toEntity(LibroDTO dto, Libro dto2) {
    return Libro.builder()
            .id(dto.getId())
            .titolo(dto.getTitolo())
            .autore(dto2.getAutore())
            .build();
}
}
