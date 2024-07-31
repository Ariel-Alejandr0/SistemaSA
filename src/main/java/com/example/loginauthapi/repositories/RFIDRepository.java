package com.example.loginauthapi.repositories;

import com.example.loginauthapi.domain.user.RFID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RFIDRepository extends JpaRepository<RFID, Long> {
}
