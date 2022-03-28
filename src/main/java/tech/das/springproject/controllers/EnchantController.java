package tech.das.springproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.das.springproject.DTO.EnchantDTO;
import tech.das.springproject.service.EnchantService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/service/enchant")
public class EnchantController {
    private final EnchantService enchantService;

    @PostMapping("/save")
    public HttpStatus save(@RequestBody EnchantDTO enchantDTO){
        return enchantService.save(enchantDTO);
    }

    @GetMapping("/all")
    public List<EnchantDTO> getAll(){
        return enchantService.getAll();
    }

    @GetMapping("/getById/{id}")
    public EnchantDTO getById(@PathVariable Long id){
        return enchantService.getById(id);
    }

    @PutMapping("/update")
    public EnchantDTO update(@RequestBody EnchantDTO enchantDTO){
        return enchantService.update(enchantDTO);
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteById(@PathVariable Long id) {
        return enchantService.deleteById(id);
    }
}
