package com.example.todolist.mapper;

import com.example.todolist.dto.AutoreDTO;
import com.example.todolist.model.Autore;

public class AutoreMapper {

  public static AutoreDTO toDTO(Autore autore) {
    return AutoreDTO.builder()
        .id(autore.getId())
        .nome(autore.getNome())
        .libri(
            autore.getLibri()
              .stream()
              .map(LibroMapper::toDTO)
              .toList())
        .build();
  }

  public static Autore toEntity(AutoreDTO dto) {
    return Autore.builder()
        .id(dto.getId())
        .nome(dto.getNome())
        .libri(
            dto.getLibri()
                .stream()
                .map(LibroMapper::toEntity))
        .build();
  }
}
