package com.jsp.neo_banker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jsp.neo_banker.entity.*;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
    boolean existsByMobile(Long mobile);
}
