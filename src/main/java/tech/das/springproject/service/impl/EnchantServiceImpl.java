package tech.das.springproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tech.das.springproject.DTO.EnchantDTO;
import tech.das.springproject.entities.Enchant;
import tech.das.springproject.entities.Weapon;
import tech.das.springproject.repository.EnchantRepository;
import tech.das.springproject.service.EnchantService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnchantServiceImpl implements EnchantService {
    private final ModelMapper modelMapper;
    private final WeaponServiceImpl weaponService;
    private final EnchantRepository enchantRepository;

    @Override
    public HttpStatus save(EnchantDTO enchantDTO) {
        Enchant enchant = modelMapper.map(enchantDTO, Enchant.class);
        enchant.setWeapon(modelMapper.map(weaponService.getById(enchantDTO.getWeaponId()), Weapon.class));
        Enchant savedEnchant = enchantRepository.save(enchant);
        return savedEnchant==null?HttpStatus.BAD_REQUEST:HttpStatus.OK;
    }

    @Override
    public List<EnchantDTO> getAll() {
        return enchantRepository.findAll().stream()
                .map(enchant -> modelMapper.map(enchant, EnchantDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EnchantDTO getById(Long id) {
        return enchantRepository.findById(id)
                .map(enchant -> modelMapper.map(enchant, EnchantDTO.class))
                .orElse(null);
    }

    @Override
    public EnchantDTO update(EnchantDTO enchantDTO) {
        Enchant newEnchant = modelMapper.map(enchantDTO, Enchant.class);
        Optional<Enchant> optionalEnchant = enchantRepository.findById(newEnchant.getId());
        if(optionalEnchant.isPresent()){
            Enchant oldEnchant = optionalEnchant.get();

            newEnchant.setId(oldEnchant.getId());
            newEnchant.setWeapon(oldEnchant.getWeapon());

            enchantRepository.save(newEnchant);

            return modelMapper.map(newEnchant, EnchantDTO.class);
        }
        return null;
    }

    @Override
    public HttpStatus deleteById(Long id) {
        Optional<Enchant> oldEnchantOpt = enchantRepository.findById(id);
        if(oldEnchantOpt.isPresent()){
            enchantRepository.deleteById(id);
            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }
}


