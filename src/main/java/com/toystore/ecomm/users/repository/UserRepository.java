package com.toystore.ecomm.users.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.toystore.ecomm.users.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	public List<User> findByEmailId(String emailId);
	public List<User> findByFirstName(String firstName);
	public List<User> findByPrimaryContact (String primaryContact);
}
