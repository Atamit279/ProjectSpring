package tech.das.springproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tech.das.springproject.DTO.AccountCreateDTO;
import tech.das.springproject.DTO.AccountDTO;
import tech.das.springproject.entities.Account;
import tech.das.springproject.repository.AccountRepository;
import tech.das.springproject.service.AccountService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final ModelMapper modelMapper;

    private final AccountRepository repository;

    @Override
    public AccountDTO save(AccountCreateDTO accountDTO) throws Exception{
        if (!isUniqueLogin(accountDTO.getLogin())) {
            throw new Exception("This login already exists");
        }
        Account savedAccount = repository.save(modelMapper.map(accountDTO, Account.class));
        return modelMapper.map(savedAccount, AccountDTO.class);
    }

    @Override
    public AccountDTO update(AccountDTO accountDTO) {
        return null;
    }

    @Override
    public boolean delete(Integer accountId) {
        return false;
    }

    @Override
    public List<AccountDTO> getAll() {
        return null;
    }

    @Override
    public AccountDTO getById(Integer id) throws Exception {
        Optional<Account> optionalAccount = repository.findById(id);
        if (optionalAccount.isEmpty()){
            throw new Exception(String.format("Profile with id %s not found", id));
        }
        return modelMapper.map(optionalAccount.get(),AccountDTO.class);
    }
    private boolean isUniqueLogin(String login){
        return repository.findAccountByLogin(login).isEmpty();
    }
}
