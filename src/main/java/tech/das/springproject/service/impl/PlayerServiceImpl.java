package tech.das.springproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tech.das.springproject.DTO.PlayerDTO;
import tech.das.springproject.entities.Player;
import tech.das.springproject.repository.PlayerRepository;
import tech.das.springproject.service.PlayerService;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final ModelMapper modelMapper;

    @Override
    public PlayerDTO savePlayer(PlayerDTO playerDTO) {
        Player player = modelMapper.map(playerDTO, Player.class);
        Player savedPlayer = playerRepository.save(player);

        return modelMapper.map(savedPlayer, PlayerDTO.class);
    }

    @Override
    public List<PlayerDTO> getAll() {
        return playerRepository.findAll().stream()
                .map(player -> modelMapper.map(player, PlayerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PlayerDTO getById(Long id) {
        return playerRepository.findById(id)
                .map(val ->modelMapper.map(val, PlayerDTO.class))
                .orElse(null);
    }

    @Override
    public PlayerDTO update(PlayerDTO playerDTO){
        Player newPlayer = modelMapper.map(playerDTO, Player.class);
        Optional<Player> optionalPlayer = playerRepository.findById(newPlayer.getId());
        if(optionalPlayer.isPresent()){
            Player oldPlayer = optionalPlayer.get();

            newPlayer.setId(oldPlayer.getId());
            newPlayer.setLvl(oldPlayer.getLvl());
            playerRepository.save(newPlayer);

            return modelMapper.map(newPlayer, PlayerDTO.class);
        }
        return null;
    }

    @Override
    public HttpStatus deleteById(Long id){
        Optional<Player> player = playerRepository.findById(id);
        if (player.isPresent()){
            playerRepository.deleteById(id);
            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }
}
