package com.example.demo.model.repository;

import com.example.demo.model.entity.LocalUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocalUserRepository extends JpaRepository<LocalUser, Long> {

    Optional<LocalUser> findUserByUsername(String username);
}
