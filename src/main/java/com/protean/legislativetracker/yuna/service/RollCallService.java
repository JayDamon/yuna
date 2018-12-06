package com.protean.legislativetracker.yuna.service;

import com.protean.legislativetracker.yuna.model.RollCall;

import java.util.List;

public interface RollCallService {

    List<RollCall> saveAllRollCalls(List<RollCall> rollCalls);

}
