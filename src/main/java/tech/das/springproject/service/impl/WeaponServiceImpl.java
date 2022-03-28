package tech.das.springproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tech.das.springproject.DTO.WeaponDTO;
import tech.das.springproject.entities.Player;
import tech.das.springproject.entities.Weapon;
import tech.das.springproject.repository.WeaponRepository;
import tech.das.springproject.service.WeaponService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WeaponServiceImpl implements WeaponService {
    private final ModelMapper modelMapper;
    private final PlayerServiceImpl playerService;
    private final WeaponRepository weaponRepository;

    @Override
    public HttpStatus save(WeaponDTO weaponDTO) {
        Weapon weapon = modelMapper.map(weaponDTO, Weapon.class);
        weapon.setPlayer(modelMapper.map(playerService.getById(weaponDTO.getPlayerId()), Player.class));
        Weapon savedWeapon = weaponRepository.save(weapon);
        return savedWeapon == null ? HttpStatus.BAD_REQUEST : HttpStatus.OK;
    }

    @Override
    public List<WeaponDTO> getAll() {
        return weaponRepository.findAll().stream()
                .map(weapon -> modelMapper.map(weapon, WeaponDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public WeaponDTO getById(Long id) {
        return weaponRepository.findById(id)
                .map(weapon -> modelMapper.map(weapon, WeaponDTO.class))
                .orElse(null);
    }

    @Override
    public WeaponDTO update(WeaponDTO weaponDTO) {
        Weapon newWeapon = modelMapper.map(weaponDTO, Weapon.class);
        Optional<Weapon> optionalWeapon = weaponRepository.findById(newWeapon.getId());
        if (optionalWeapon.isPresent()) {
            Weapon oldWeapon = optionalWeapon.get();

            newWeapon.setId(oldWeapon.getId());
            newWeapon.setPlayer(oldWeapon.getPlayer());

            weaponRepository.save(newWeapon);

            return modelMapper.map(newWeapon, WeaponDTO.class);
        }
        return null;
    }

    @Override
    public HttpStatus deleteById(Long id) {
        Optional<Weapon> oldWeaponOpt = weaponRepository.findById(id);
        if (oldWeaponOpt.isPresent()) {
            weaponRepository.deleteById(id);
            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }
}
