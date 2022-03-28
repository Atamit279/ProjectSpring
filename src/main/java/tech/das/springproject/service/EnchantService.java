package tech.das.springproject.service;

import org.springframework.http.HttpStatus;
import tech.das.springproject.DTO.EnchantDTO;

import java.util.List;

public interface EnchantService {
    HttpStatus save(EnchantDTO enchantDTO);

    List<EnchantDTO> getAll();

    EnchantDTO getById(Long id);

    EnchantDTO update(EnchantDTO enchantDTO);

    HttpStatus deleteById(Long id);
}
