package com.example.loginauthapi.service.xadrez;

import com.example.loginauthapi.domain.user.RFID;
import com.example.loginauthapi.repositories.RFIDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RFIDService {

    private final RFIDRepository repository;

    @Autowired
    public RFIDService(RFIDRepository repository) {
        this.repository = repository;
    }

    public void createRFID(RFIDDTO rfiddto) {
        RFID rfid = new RFID();
        rfid.setId_RFID(rfiddto.getId_RFID());
        rfid.setId_localizacao(rfiddto.getId_localizacao());
        rfid.setData_ativacao(rfiddto.getData_ativacao());
        rfid.setData_atualizacao(rfiddto.getData_atualizacao());
        rfid.setTag_leitura(rfiddto.getTag_leitura());

        repository.save(rfid);
    }

    public void updateRFID(RFIDDTO rfiddto) {
        RFID rfid = repository.findById(rfiddto.getId_RFID()).orElseThrow(() -> new RuntimeException("RFID não encontrado"));
        rfid.setId_RFID(rfiddto.getId_RFID());
        rfid.setId_localizacao(rfiddto.getId_localizacao());
        rfid.setData_ativacao(rfiddto.getData_ativacao());
        rfid.setData_atualizacao(rfiddto.getData_ativacao());
        rfid.setTag_leitura(rfiddto.getTag_leitura());
        repository.save(rfid);
    }

    public RFID findById(Long id) {
        Optional<RFID> result = repository.findById(id);

        RFID rfid;

        if (result.isPresent()) {
            rfid = result.get();
        } else {
            throw new RuntimeException("RFID não encontrado");
        }

        return rfid;
    }

    public List<RFID> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
