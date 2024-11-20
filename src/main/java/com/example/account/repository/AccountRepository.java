package com.example.account.repository;

import com.example.account.model.Account;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface AccountRepository extends JpaRepository<Account, Long> {
    public Account findByAccountNumber(Long accountNumber);

    public void deleteByAccountNumber(Long accountNumber);
}
