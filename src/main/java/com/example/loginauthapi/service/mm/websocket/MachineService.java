package com.example.loginauthapi.service.mm.websocket;

import com.example.loginauthapi.domain.user.Machine;
import com.example.loginauthapi.repositories.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineService {

    @Autowired
    private MachineRepository machineRepository;

    public List<Machine> listAllMachines(){
        return machineRepository.findAll();
    }
}

