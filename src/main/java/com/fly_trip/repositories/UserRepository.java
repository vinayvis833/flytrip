package com.fly_trip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fly_trip.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
}
