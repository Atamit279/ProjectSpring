package tech.das.springproject.DTO;

import lombok.Data;

@Data
public class WeaponDTO {
    private Long id;
    private Long dmg;
    private String name;
    private Long lvl;
    private Long PlayerId;
}
