package com.syfe.FinancialManagementProject.Repository;

import com.syfe.FinancialManagementProject.Entity.userTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<userTransaction, Long> {
    List<userTransaction> findAllByUsername(String username);

    Optional<userTransaction> findByTransactionid(Integer id);
}
