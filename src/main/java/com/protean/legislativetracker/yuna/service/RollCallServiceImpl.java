package com.protean.legislativetracker.yuna.service;

import com.protean.legislativetracker.yuna.model.RollCall;
import com.protean.legislativetracker.yuna.repository.RollCallRepository;

import java.util.ArrayList;
import java.util.List;

public class RollCallServiceImpl implements RollCallService {

    private RollCallRepository rollCallRepository;

    public RollCallServiceImpl(RollCallRepository rollCallRepository) {
        this.rollCallRepository = rollCallRepository;
    }

    @Override
    public List<RollCall> saveAllRollCalls(List<RollCall> rollCalls) {
        List<RollCall> savedRollCalls = new ArrayList<>();
        rollCallRepository.saveAll(rollCalls).forEach(savedRollCalls::add);
        return savedRollCalls;
    }
}
