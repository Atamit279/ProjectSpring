package tech.das.springproject.DTO;

import lombok.Data;

@Data
public class EnchantDTO {
    private Long id;
    private String login;
    private String password;
    private String conpassword;
    private String email;
    private Number age;
    private Long weaponId;
}
