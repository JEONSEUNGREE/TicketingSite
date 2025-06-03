package com.massive.ticketserver.domain.repository;

import com.massive.ticketserver.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
