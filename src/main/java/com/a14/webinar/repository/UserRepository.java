package com.a14.webinar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.a14.webinar.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	Optional<User> findByUsernameAndPassword(String email, String password);
	Optional<User> findByUsername(String username);

}
