package tech.das.springproject.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
public class WeaponDTO {
    private Long id;
    private Long dmg;
    private String name;
    private Long lvl;
    private Long playerId;
}
