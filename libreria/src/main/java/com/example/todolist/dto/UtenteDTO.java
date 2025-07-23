package com.example.todolist.dto;

import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UtenteDTO
{
    private Long id;
    private String username;
    private List<RecensioneDTO> listaRecensioni;
}