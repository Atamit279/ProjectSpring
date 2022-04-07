package tech.das.springproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.das.springproject.DTO.AccountCreateDTO;
import tech.das.springproject.DTO.AccountDTO;
import tech.das.springproject.service.AccountService;

@RestController
@RequestMapping("/api/service/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/")
    public AccountDTO save(@RequestBody AccountCreateDTO accountDTO) throws  Exception{
        return accountService.save(accountDTO);
    }

    @GetMapping("/{id}")
    public AccountDTO getById(@PathVariable Integer id) throws Exception{
        return accountService.getById(id);
    }
}
