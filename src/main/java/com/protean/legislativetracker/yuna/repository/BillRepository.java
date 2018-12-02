package com.protean.legislativetracker.yuna.repository;

import com.protean.legislativetracker.yuna.model.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BillRepository extends CrudRepository<Bill, Long> {

    boolean existsByBillIdAndChangeHash(Long sessionId, String sessionHash);

    Bill findByBillIdAndChangeHashNot(Long billId, String changeHash);

}
