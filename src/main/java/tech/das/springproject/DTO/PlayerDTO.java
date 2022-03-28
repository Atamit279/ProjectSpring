package tech.das.springproject.DTO;

import lombok.Data;

@Data
public class PlayerDTO {
    private Long id;
    private String name;
    private Long hp;
    private Long lvl;
}
