package com.toystore.ecomm.users.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toystore.ecomm.users.model.User;
import com.toystore.ecomm.users.model.Usersresponse;
import com.toystore.ecomm.users.multitenant.MultiTenantManager;
import com.toystore.ecomm.users.services.UserService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-04T22:49:45.638Z")

@RestController
public class UsersApiController implements UsersApi {

    private static final Logger log = LoggerFactory.getLogger(UsersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    UserService userService;
    
	/*
	 * private Map<String, LoggedTenantInfo> mapValue = new HashMap<>(); private
	 * Map<String, LoggedTenantInfo> userDbMap = new HashMap<>();
	 */
    private final MultiTenantManager tenantManager;

    @org.springframework.beans.factory.annotation.Autowired
    public UsersApiController(ObjectMapper objectMapper, HttpServletRequest request, MultiTenantManager tenantManager) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.tenantManager = tenantManager;
    }

    public ResponseEntity<Usersresponse> usersByUserIdDELETE(@ApiParam(value = "",required=true) @PathVariable("userId") Integer userId) {
        //String accept = request.getHeader("Accept");
        
        try {
	        userService.removeUser(userId);
	        return new ResponseEntity<Usersresponse>(objectMapper.readValue("{  \"message\" : \"The User has been deleted successfully\"}", Usersresponse.class), HttpStatus.CREATED);
	        //return new ResponseEntity<Void>(HttpStatus.CREATED);
        } catch (IOException e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<Usersresponse>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<User> usersByUserIdGET(@ApiParam(value = "",required=true) @PathVariable("userId") Integer userId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)(SecurityContextHolder.getContext().getAuthentication()).getDetails();
        		String jwtToken = details.getTokenValue();
        		
        		Claims body = Jwts.parser()
                        		  .setSigningKey("345345fsdfsf5345".getBytes())
                        		  .parseClaimsJws(jwtToken)
                        		  .getBody();
        		System.out.println("DB URL is---------------------------------------------------:" + body.get("db_url"));
        		
        		String tenantUsername = body.get("user_name").toString();
        		String tenantDBName = body.get("db_name").toString();
        		String tenantDBUrl = body.get("db_url").toString();
        		
        		if(tenantManager.tenantIsAbsent(tenantUsername)) {
        			tenantManager.addTenant(tenantUsername, tenantDBUrl, "authuser", "authuser");
        			tenantManager.setCurrentTenant(tenantUsername);
        		} else {
        			tenantManager.setCurrentTenant(tenantUsername);
        		}
        		
            	return new ResponseEntity<User>(userService.getUser(userId), HttpStatus.OK);
                //return new ResponseEntity<User>(objectMapper.readValue("{  \"firstName\" : \fetchedUser.\,  \"lastName\" : \"lastName\",  \"primaryContact\" : \"primaryContact\",  \"middleName\" : \"middleName\",  \"emailId\" : \"emailId\",  \"userId\" : \"userId\"}", User.class), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<User> usersByUserIdPUT(@ApiParam(value = "" ,required=true )  @Valid @RequestBody User body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	return new ResponseEntity<User>(userService.updateUser(body),  HttpStatus.OK);
                //return new ResponseEntity<User>(objectMapper.readValue("{  \"firstName\" : \"firstName\",  \"lastName\" : \"lastName\",  \"primaryContact\" : \"primaryContact\",  \"middleName\" : \"middleName\",  \"emailId\" : \"emailId\",  \"userId\" : \"userId\"}", User.class), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<User>> usersGET(@ApiParam(value = "Get User based on emailId") @Valid @RequestParam(value = "email", required = false) String emailId,@ApiParam(value = "Get User based on firstName") @Valid @RequestParam(value = "firstName", required = false) String firstName,@ApiParam(value = "Get User based on primaryContact") @Valid @RequestParam(value = "primaryContact", required = false) String primaryContact) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	List<User> userList = null;
            	if (emailId == null && firstName == null && primaryContact == null) {
					/*
					 * Optional<Authentication> authentication =
					 * Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication());
					 * Optional<String> dbUrlStr = authentication.map(a -> {
					 * OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)
					 * a.getDetails(); return (String) ((Map)
					 * details.getDecodedDetails()).get("db_url"); }); System.out.
					 * println("DB URL is---------------------------------------------------:" +
					 * dbUrlStr.get());
					 */
            		
            		OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)(SecurityContextHolder.getContext().getAuthentication()).getDetails();
            		String jwtToken = details.getTokenValue();
            		
            		Claims body = Jwts.parser()
                            		  .setSigningKey("345345fsdfsf5345".getBytes())
                            		  .parseClaimsJws(jwtToken)
                            		  .getBody();
            		System.out.println("DB URL is---------------------------------------------------:" + body.get("db_url"));
            		
            		String tenantUsername = body.get("user_name").toString();
            		String tenantDBName = body.get("db_name").toString();
            		String tenantDBUrl = body.get("db_url").toString();
            		
            		if(tenantManager.tenantIsAbsent(tenantUsername)) {
            			tenantManager.addTenant(tenantUsername, tenantDBUrl, "authuser", "authuser");
            			tenantManager.setCurrentTenant(tenantUsername);
            		} else {
            			tenantManager.setCurrentTenant(tenantUsername);
            		}
            		
            		//loadCurrentDatabaseInstance(body.get("user_name").toString(), tenantInfo);
            		
            		//setMetaDataAfterLogin();
            		
            		userList = userService.getAllUsers();
            	} else {
            		
            	}
            	
            	return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
                //return new ResponseEntity<List<User>>(objectMapper.readValue("[ {  \"firstName\" : \"firstName\",  \"lastName\" : \"lastName\",  \"primaryContact\" : \"primaryContact\",  \"middleName\" : \"middleName\",  \"emailId\" : \"emailId\",  \"userId\" : \"userId\"}, {  \"firstName\" : \"firstName\",  \"lastName\" : \"lastName\",  \"primaryContact\" : \"primaryContact\",  \"middleName\" : \"middleName\",  \"emailId\" : \"emailId\",  \"userId\" : \"userId\"} ]", List.class), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<User>>(HttpStatus.NOT_IMPLEMENTED);
    }
    
    public ResponseEntity<Usersresponse> usersPOST(@ApiParam(value = "" ,required=true )  @Valid @RequestBody User body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
	            	OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)(SecurityContextHolder.getContext().getAuthentication()).getDetails();
	        		String jwtToken = details.getTokenValue();
	        		
			        Claims jwtbody = Jwts.parser()
			              		  .setSigningKey("345345fsdfsf5345".getBytes())
			              		  .parseClaimsJws(jwtToken)
			              		  .getBody();
					System.out.println("DB URL is---------------------------------------------------:" + jwtbody.get("db_url"));
					
					String tenantUsername = jwtbody.get("user_name").toString();
					String tenantDBName = jwtbody.get("db_name").toString();
					String tenantDBUrl = jwtbody.get("db_url").toString();
					
					if(tenantManager.tenantIsAbsent(tenantUsername)) {
						tenantManager.addTenant(tenantUsername, tenantDBUrl, "authuser", "authuser");
						tenantManager.setCurrentTenant(tenantUsername);
					} else {
						tenantManager.setCurrentTenant(tenantUsername);
					}
	            	
					userService.saveUser(body);
	            	return new ResponseEntity<Usersresponse>(objectMapper.readValue("{  \"message\" : \"The User has been created successfully\"}", Usersresponse.class), HttpStatus.CREATED);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Usersresponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Usersresponse>(HttpStatus.NOT_IMPLEMENTED);
    }
    
	/*
	 * private void loadCurrentDatabaseInstance(String userName, LoggedTenantInfo
	 * tenantInfo) { DBContextHolder.setCurrentDb(tenantInfo.getTenantDBName());
	 * mapValue.put(userName, tenantInfo); }
	 * 
	 * @Bean(name = "userTenantInfo")
	 * 
	 * @ApplicationScope public UserTenantInformation setMetaDataAfterLogin() {
	 * UserTenantInformation tenantInformation = new UserTenantInformation(); if
	 * (mapValue.size() > 0) { for (String key : mapValue.keySet()) { if (null ==
	 * userDbMap.get(key)) { //Here Assign putAll due to all time one come.
	 * userDbMap.putAll(mapValue); } else { userDbMap.put(key, mapValue.get(key)); }
	 * } mapValue = new HashMap<>(); } tenantInformation.setMap(userDbMap); return
	 * tenantInformation; }
	 */
    

}
