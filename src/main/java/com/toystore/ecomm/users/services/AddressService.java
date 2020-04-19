package com.toystore.ecomm.users.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toystore.ecomm.users.model.Address;
import com.toystore.ecomm.users.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	public List<Address> getAddressByUserId(Integer userId) {
		return addressRepository.findByUserId(userId);
	}
	
	public List<Address> getAddressByUserIdAndAddressType(Integer userId, String addressType) {
		List<Address> addressList = addressRepository.findByUserId(userId);
		
		List<Address> singleAddress = new ArrayList<Address>();
		if (addressType.equalsIgnoreCase(addressList.get(0).getAddressType())) {
			singleAddress.add(addressList.get(0));
			return singleAddress;
		} else {
			singleAddress.add(addressList.get(1));
			return singleAddress;
		}
	}
	
	public void saveAddress(Address address) {
		address.withId((new Random()).nextInt(1000));
		addressRepository.save(address);
	}
	
	public Address getAddress(Integer addressId) {
		return addressRepository.findById(addressId).get();
	}
	
	public List<Address> getAllAddresses() {
		List<Address> fetchedAddressList = new ArrayList<Address>();
		Iterable<Address> fetchedAddressIterable = addressRepository.findAll();
		
		fetchedAddressIterable.forEach(fetchedAddressList::add);
		
		return fetchedAddressList;
	}
	
	public Address updateAddress(Address address) {
		Address existingAddress = addressRepository.findById(address.getAddressId()).get();
		
		existingAddress.setAddressType(address.getAddressType());;
		existingAddress.setLine1(address.getLine1());
		existingAddress.setLine2(address.getLine2());
		existingAddress.setLine3(address.getLine3());
		existingAddress.setUserId(address.getUserId());
		existingAddress.setDistrict(address.getDistrict());
		existingAddress.setState(address.getDistrict());
		existingAddress.setZipCode(address.getZipCode());
		existingAddress.setCountry(address.getCountry());
		
		return addressRepository.save(existingAddress);
	}
	
	public void removeAddress(Integer addressId) {
		addressRepository.deleteById(addressId);
	}
}
