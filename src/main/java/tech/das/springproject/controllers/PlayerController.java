package tech.das.springproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.das.springproject.DTO.PlayerDTO;
import tech.das.springproject.service.PlayerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/service/player")
public class PlayerController {
    private final PlayerService playerService;

    @PostMapping("/save")
    public PlayerDTO savePlayer(@RequestBody PlayerDTO playerDTO){
        return playerService.savePlayer(playerDTO);
    }

    @GetMapping("/all")
    public List<PlayerDTO> getAll(){
        return playerService.getAll();
    }

    @GetMapping("/getById/{id}")
    public PlayerDTO getById(@PathVariable Long id){
        return playerService.getById(id);
    }

    @PutMapping("/update")
    public PlayerDTO update(@RequestBody PlayerDTO playerDTO){
        return playerService.update(playerDTO);
    }

    @DeleteMapping("/deleteById/{id}")
    public HttpStatus deleteById(   @PathVariable Long id){
        return playerService.deleteById(id);
    }
}
