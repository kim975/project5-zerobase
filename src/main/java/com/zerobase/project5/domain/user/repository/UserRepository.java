package com.zerobase.project5.domain.user.repository;

import com.zerobase.project5.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsrKey(String userKey);
}
