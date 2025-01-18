package com.syfe.jan19test3.Repository;

import com.syfe.jan19test3.Entity.userTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrensactionRepository extends JpaRepository<userTransaction, Long> {
}
