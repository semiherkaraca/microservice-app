package com.haydikodlayalim.accountservice.service;

import com.haydikodlayalim.accountservice.entity.Account;
import com.haydikodlayalim.accountservice.repo.AccountRepository;
import com.haydikodlayalim.contract.AccountDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    public AccountDto get(String id) {
        Account account = accountRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(account, AccountDto.class);
    }

    @Transactional
    public AccountDto save(AccountDto accountDto) {
        Account account = modelMapper.map(accountDto, Account.class);
        account = accountRepository.save(account);
        accountDto.setId(account.getId());
        return accountDto;
    }

    @Transactional
    public AccountDto update(String id, AccountDto accountDto) {
        Assert.isNull(id, "Id cannot be null");
        Optional<Account> optionalAccount = accountRepository.findById(id);
        Account accountToUpdate = optionalAccount.map(it -> {
            it.setDateBirth(accountDto.getDateBirth());
            it.setName(accountDto.getName());
            it.setSurname(accountDto.getSurname());
            return it;
        }).orElseThrow(IllegalArgumentException::new);
        Account save = accountRepository.save(accountToUpdate);
        return modelMapper.map(save, AccountDto.class);
    }

    @Transactional
    public void delete(String id) {
        Account account = accountRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        accountRepository.delete(account);
    }

    public Slice<AccountDto> findAll(Pageable pageable) {
        Slice<Account> accounts = accountRepository.findAll(pageable);
        return null;
    }
}
