package com.example.todolist.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AutoreDTO {
    private Long id;
    private String nome;
    private List<LibroDTO> libri;
}

