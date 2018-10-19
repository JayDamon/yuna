package com.protean.legislativetracker.yuna.repositories;

import com.protean.legislativetracker.yuna.model.Bill;
import org.springframework.data.repository.CrudRepository;

public interface BillRepository extends CrudRepository<Bill, Long> {
}
