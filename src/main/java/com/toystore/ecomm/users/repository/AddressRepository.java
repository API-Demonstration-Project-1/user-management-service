package com.toystore.ecomm.users.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.toystore.ecomm.users.model.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer>{
	public List<Address> findByUserId(Integer userId);
}
