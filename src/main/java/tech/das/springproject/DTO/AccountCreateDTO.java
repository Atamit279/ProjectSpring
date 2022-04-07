package tech.das.springproject.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AccountCreateDTO {
    private String login;
    private String password;
    private String conpassword;
    private String email;
}
