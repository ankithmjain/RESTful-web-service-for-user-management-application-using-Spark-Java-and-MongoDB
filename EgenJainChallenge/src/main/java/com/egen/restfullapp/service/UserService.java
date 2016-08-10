package com.egen.restfullapp.service;

import java.util.List;

import com.egen.restfullapp.model.Address;
import com.egen.restfullapp.model.Company;
import com.egen.restfullapp.model.User;
/**
 * 
 * @author ajain
 * 
 */
public interface UserService {

	public String addpost(User user, Address address, Company company);

	public List<User> getAllPost();

	public User getUserByEmail(String email);

	public Integer updateUser(User user, Address address, Company company);

}
