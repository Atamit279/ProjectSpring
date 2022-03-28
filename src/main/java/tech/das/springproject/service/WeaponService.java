package tech.das.springproject.service;

import lombok.Data;
import org.springframework.http.HttpStatus;
import tech.das.springproject.DTO.WeaponDTO;

import java.util.List;


public interface WeaponService {
    HttpStatus save(WeaponDTO weaponDTO);

    List<WeaponDTO> getAll();

    WeaponDTO getById(Long id);

    WeaponDTO update(WeaponDTO weaponDTO);

    HttpStatus deleteById(Long id);
}
