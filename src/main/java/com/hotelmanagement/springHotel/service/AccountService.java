package com.hotelmanagement.springHotel.service;

import com.hotelmanagement.springHotel.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<Account> getAllAccount();
    Optional<Account> getAccountById(Long id);
    Account saveAccount(Account account);
    void deleteAccount(Long id);
    Account findByEmail(String email);
}
