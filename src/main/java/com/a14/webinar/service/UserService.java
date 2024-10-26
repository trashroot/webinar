package com.a14.webinar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.a14.webinar.entity.User;
import com.a14.webinar.error.ResourceNotFound;
import com.a14.webinar.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	private UserRepository userRepo;

	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}


	public List<User> getAllUsers(){
		return userRepo.findAll();
	}

	@Transactional
	public User saveUser(User user) {
		return userRepo.save(user);
	}

	public User getUserByEmail(String Username) {
		return userRepo.findByUsername(Username).orElseThrow(() -> new ResourceNotFound("User not found"));
	}

	public User getUserByEmailAndPassword(String Username, String password) {
		return userRepo.findByUsernameAndPassword(Username, password).orElseThrow(() -> new ResourceNotFound("Invalid username or password"));
	}

	public User getUserById(Integer id) {
		return userRepo.findById(id).orElseThrow(() -> new ResourceNotFound("User not found."));
	}

	@Transactional
	public void deleteUser(Integer id) {
		userRepo.findById(id).ifPresentOrElse(userRepo::delete, () -> new ResourceNotFound("User not found."));
	}
}
