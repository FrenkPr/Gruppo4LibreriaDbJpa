package com.example.todolist.mapper;

import com.example.todolist.dto.UtenteDTO;
import com.example.todolist.model.Utente;

public class UtenteMapper
{
    public static UtenteDTO toDTO(Utente utente)
    {
        return UtenteDTO.builder()
                .id(utente.getId())
                .username(utente.getUsername())
                .listaRecensioni(
                    utente.getRecensioni().stream()
                        .map(RecensioneMapper::toDTO)
                        .toList()
                )
                .build();
    }
}
