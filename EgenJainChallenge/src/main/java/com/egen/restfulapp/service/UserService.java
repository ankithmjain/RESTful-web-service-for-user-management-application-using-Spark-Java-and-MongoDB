package com.egen.restfulapp.service;

import java.util.List;

import com.egen.restfulapp.model.Address;
import com.egen.restfulapp.model.Company;
import com.egen.restfulapp.model.User;
/**
 * userService interface
 * @author ajain
 * 
 */
public interface UserService {

	// Creates a new user
	public String addpost(User user, Address address, Company company);

	// Returns a list of all users
	public List<User> getAllPost();

	//Returns a single user
	public User getUserByEmail(String email);

	//Updates a specific user
	public Integer updateUser(User user, Address address, Company company);

}
