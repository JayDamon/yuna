package com.protean.legislativetracker.yuna.service;

import com.protean.legislativetracker.yuna.model.Committee;
import com.protean.legislativetracker.yuna.repository.CommitteeRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CommitteeServiceImpl implements CommitteeService {

    private CommitteeRepository committeeRepository;

    public CommitteeServiceImpl(CommitteeRepository committeeRepository) {
        this.committeeRepository = committeeRepository;
    }

    @Override
    public void saveAll(Set<Committee> committees) {
        committeeRepository.saveAll(committees);
    }

    @Override
    public boolean existsById(Integer id) {
        return committeeRepository.existsById(id);
    }
}
