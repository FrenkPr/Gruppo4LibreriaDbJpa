package com.example.todolist.service;

import com.example.todolist.dto.AutoreDTO;
import com.example.todolist.mapper.AutoreMapper;
import com.example.todolist.model.Autore;
import com.example.todolist.repository.AutoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.foreign.Linker.Option;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AutoreService {
    private final AutoreRepository autoreRepository;

    public List<AutoreDTO> findAll() {
        return autoreRepository.findAll().stream().map(AutoreMapper::toDTO).toList();
    }

    public AutoreDTO findById(Long id) {
        return AutoreMapper.toDTO(autoreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autore non trovato")));
    }

    public AutoreDTO create(AutoreDTO dto) {
        return AutoreMapper.toDTO(autoreRepository.save(AutoreMapper.toEntity(dto)));
    }

    public AutoreDTO update(AutoreDTO dto) {
        Autore autore = autoreRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Autore non trovato."));

        autore.setNome(dto.getNome());
        
        return AutoreMapper.toDTO(autoreRepository.save(autore));
    }

    public void delete(Long id) {
        autoreRepository.deleteById(id);
    }
}
