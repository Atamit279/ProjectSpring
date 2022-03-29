package tech.das.springproject.service;

import org.springframework.http.HttpStatus;
import tech.das.springproject.DTO.PlayerDTO;
import tech.das.springproject.entities.Player;

import java.util.List;

public interface PlayerService {
    PlayerDTO savePlayer(PlayerDTO playerDTO);

    List<PlayerDTO> getAll();

    PlayerDTO getById(Long id);

    HttpStatus deleteById(Long id);

    PlayerDTO update(PlayerDTO playerDTO);
}

