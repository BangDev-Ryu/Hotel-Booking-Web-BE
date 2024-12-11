package com.hotelmanagement.springHotel.controller;

import com.hotelmanagement.springHotel.model.Account;
import com.hotelmanagement.springHotel.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/account")
@CrossOrigin
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<Account> getAllAccount() {
        return accountService.getAllAccount();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.saveAccount(account);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody Account account) {
        return accountService.getAccountById(id)
                .map(existingAccount -> {
                    existingAccount.setEmail(account.getEmail());
                    existingAccount.setUsername(account.getUsername());
                    existingAccount.setSdt(account.getSdt());
                    return ResponseEntity.ok(accountService.saveAccount(existingAccount));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAccount(@PathVariable Long id) {
        return accountService.getAccountById(id)
                .map(account -> {
                    accountService.deleteAccount(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Account loginRequest) {
        Account account = accountService.findByEmail(loginRequest.getEmail());
        if (account != null && account.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.ok(account);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Account registerRequest) {
        if (accountService.findByEmail(registerRequest.getEmail()) != null) {
            return ResponseEntity.badRequest().body("Email already exists");
        }
        
        registerRequest.setQuyen("USER"); // Mặc định quyền là USER
        Account savedAccount = accountService.saveAccount(registerRequest);
        return ResponseEntity.ok(savedAccount);
    }

    @PutMapping("/{id}/change-password")
    public ResponseEntity<?> changePassword(
        @PathVariable Long id,
        @RequestBody Map<String, String> passwordData
    ) {
        return accountService.getAccountById(id)
            .map(account -> {
                String currentPassword = passwordData.get("currentPassword");
                String newPassword = passwordData.get("newPassword");

                if (!account.getPassword().equals(currentPassword)) {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("Mật khẩu hiện tại không đúng");
                }

                account.setPassword(newPassword);
                Account updatedAccount = accountService.saveAccount(account);
                return ResponseEntity.ok(updatedAccount);
            })
            .orElse(ResponseEntity.notFound().build());
    }

}
