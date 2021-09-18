package com.gnanayakkara.rentcloud.authorizationserver.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gnanayakkara.rentcloud.authorizationserver.model.User;

public interface UserDeatilRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String name);
	
	
}
