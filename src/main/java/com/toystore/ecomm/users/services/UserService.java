package com.toystore.ecomm.users.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toystore.ecomm.users.model.User;
import com.toystore.ecomm.users.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getUserByEmailId(String emailId) {
		return userRepository.findByEmailId(emailId);
	}
	
	public List<User> getUserByFirstName(String firstName) {
		return userRepository.findByFirstName(firstName);
	}
	
	public List<User> getUserByPrimaryContact(String primaryContact) {
		return userRepository.findByPrimaryContact(primaryContact);
	}
	
	public void saveUser(User user) {
		user.withId((new Random()).nextInt(1000));
		userRepository.save(user);
	}
	
	public User getUser(Integer userId) {
		return userRepository.findById(userId).get();
	}
	
	public List<User> getAllUsers() {
		List<User> fetchedUserList = new ArrayList<User>();
		Iterable<User> fetchedUserIterable = userRepository.findAll();
		
		fetchedUserIterable.forEach(fetchedUserList::add);
		
		return fetchedUserList;
	}
	
	public User updateUser(User user) {
		User existingUser = userRepository.findById(user.getUserId()).get();
		
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setMiddleName(user.getMiddleName());
		existingUser.setEmailId(user.getEmailId());
		existingUser.setPrimaryContact(user.getPrimaryContact());
		
		return userRepository.save(existingUser);
	}
	
	public void removeUser(Integer userId) {
		userRepository.deleteById(userId);
	}
}
