package tech.das.springproject.service;

import tech.das.springproject.DTO.AccountCreateDTO;
import tech.das.springproject.DTO.AccountDTO;

import java.util.List;

public interface AccountService {
    AccountDTO save(AccountCreateDTO accountDTO) throws Exception;

    AccountDTO update(AccountDTO accountDTO);

    boolean delete(Integer accountId);

    List<AccountDTO> getAll();

    AccountDTO getById(Integer id) throws Exception;
}
