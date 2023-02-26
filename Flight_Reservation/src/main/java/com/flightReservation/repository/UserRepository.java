package com.flightReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.flightReservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmail(String email);
}
