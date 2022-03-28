package tech.das.springproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.das.springproject.DTO.WeaponDTO;
import tech.das.springproject.entities.Weapon;
import tech.das.springproject.service.WeaponService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/service/weapon")
public class WeaponController {
    private final WeaponService weaponService;

    @PostMapping("/save")
    public HttpStatus save(@RequestBody WeaponDTO weaponDTO){
        return weaponService.save(weaponDTO);
    }

    @GetMapping("/all")
    public List<WeaponDTO> getAll(){
        return weaponService.getAll();
    }

    @GetMapping("/getById/{id}")
    public WeaponDTO getById(@PathVariable Long id){
        return weaponService.getById(id);
    }

    @PutMapping("/update")
    public WeaponDTO update(@RequestBody WeaponDTO weaponDTO){
        return weaponService.update(weaponDTO);
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteById(@PathVariable Long id) {
        return weaponService.deleteById(id);
    }
}
