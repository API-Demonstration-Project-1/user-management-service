package com.toystore.ecomm.users.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toystore.ecomm.users.model.Address;
import com.toystore.ecomm.users.model.Addressesresponse;
import com.toystore.ecomm.users.services.AddressService;

import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
	
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-04T22:49:45.638Z")

@RestController
public class AddressesApiController implements AddressesApi {

    private static final Logger log = LoggerFactory.getLogger(AddressesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    AddressService addressService;

    @org.springframework.beans.factory.annotation.Autowired
    public AddressesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Addressesresponse> addressesByAddressIdDELETE(@ApiParam(value = "", required=true) @PathVariable("addressId") Integer addressId) {
        //String accept = request.getHeader("Accept");
        
        try {
        	addressService.removeAddress(addressId);
	        return new ResponseEntity<Addressesresponse>(objectMapper.readValue("{  \"message\" : \"The Address has been deleted successfully\"}", Addressesresponse.class), HttpStatus.CREATED);
	        //return new ResponseEntity<Void>(HttpStatus.CREATED);
        } catch (IOException e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<Addressesresponse>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Address> addressesByAddressIdGET(@ApiParam(value = "", required=true) @PathVariable("addressId") Integer addressId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	return new ResponseEntity<Address>(addressService.getAddress(addressId), HttpStatus.OK);
                //return new ResponseEntity<Address>(objectMapper.readValue("{  \"country\" : \"country\",  \"addressType\" : \"addressType\",  \"district\" : \"district\",  \"state\" : \"state\",  \"line3\" : \"line3\",  \"userId\" : \"userId\",  \"line2\" : \"line2\",  \"line1\" : \"line1\",  \"addressId\" : \"addressId\"}", Address.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Address>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Address>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Address> addressesByAddressIdPUT(@ApiParam(value = "", required=true )  @Valid @RequestBody Address body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	return new ResponseEntity<Address>(addressService.updateAddress(body),  HttpStatus.OK);
            	
            	//return new ResponseEntity<Address>(objectMapper.readValue("{  \"country\" : \"country\",  \"addressType\" : \"addressType\",  \"district\" : \"district\",  \"state\" : \"state\",  \"line3\" : \"line3\",  \"userId\" : \"userId\",  \"line2\" : \"line2\",  \"line1\" : \"line1\",  \"addressId\" : \"addressId\"}", Address.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Address>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Address>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Address>> addressesGET(@ApiParam(value = "Get all Addresses for a given User") @Valid @RequestParam(value = "user", required = false) Integer user,@ApiParam(value = "Get specific type of Address (Billing or Shipping) for a given User. This works only if 'user' query parameter is also part of the URL.") @Valid @RequestParam(value = "addressType", required = false) String addressType) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	List<Address> addressList = null;
            	if (user == null && addressType == null) {
            		addressList = addressService.getAllAddresses();
            	} else {
            		addressList = addressService.getAddressByUserIdAndAddressType(user, addressType);
            	}
            	
            	return new ResponseEntity<List<Address>>(addressList, HttpStatus.OK);
            	
                //return new ResponseEntity<List<Address>>(objectMapper.readValue("[ {  \"country\" : \"country\",  \"addressType\" : \"addressType\",  \"district\" : \"district\",  \"state\" : \"state\",  \"line3\" : \"line3\",  \"userId\" : \"userId\",  \"line2\" : \"line2\",  \"line1\" : \"line1\",  \"addressId\" : \"addressId\"}, {  \"country\" : \"country\",  \"addressType\" : \"addressType\",  \"district\" : \"district\",  \"state\" : \"state\",  \"line3\" : \"line3\",  \"userId\" : \"userId\",  \"line2\" : \"line2\",  \"line1\" : \"line1\",  \"addressId\" : \"addressId\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Address>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Address>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Addressesresponse> addressesPOST(@ApiParam(value = "", required=true )  @Valid @RequestBody Address body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	addressService.saveAddress(body);
                return new ResponseEntity<Addressesresponse>(objectMapper.readValue("{  \"message\" : \"The Address has been created successfully\"}", Addressesresponse.class), HttpStatus.CREATED);
            	//return new ResponseEntity<Addressesresponse>(objectMapper.readValue("{  \"message\" : \"The Address has been created successfully\"}", Addressesresponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Addressesresponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Addressesresponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
