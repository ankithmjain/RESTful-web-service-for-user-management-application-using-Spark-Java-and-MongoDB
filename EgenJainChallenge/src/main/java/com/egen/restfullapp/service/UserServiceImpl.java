package com.egen.restfullapp.service;

import java.util.List;

import org.eclipse.jetty.http.HttpStatus;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.egen.restfullapp.model.Address;
import com.egen.restfullapp.model.Company;
import com.egen.restfullapp.model.User;
import com.mongodb.MongoClient;

/**
 * The Class UserServiceImpl.
 *
 * @author ajain
 */
public class UserServiceImpl implements UserService {

	private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	MongoClient client = new MongoClient("localhost", 27017);

	Datastore datastore = new Morphia().createDatastore(client, "user");

	public String addpost(User user, Address address, Company company) {
		User dbuser = getUserByEmail(user.getEmail());

		if (dbuser == null) {
			datastore.save(user, address, company);
			logger.info("User Creater Successfully");
			return "Successfully Created";

		} else {

			return "User already exist";

		}

	}

	public List<User> getAllPost() {

		List<User> list = datastore.find(User.class).asList();

		if (list != null) {
			logger.info("Getting all users");
			return list;
		}
		logger.info("no users found");
		return null;
	}

	public User getUserByEmail(String email) {
		logger.info("Getting a user by email");
		User user = datastore.find(User.class, "email", email).get();
		if (user != null) {
			return user;
		} else {
			System.out.println("not able to query");
			return null;
		}
	}

	public Integer updateUser(User user, Address address, Company company) {

		User dbuser = getUserByEmail(user.getEmail());

		if (dbuser != null) {
			logger.info("Updating a user");
			user.setId(dbuser.getId());
			datastore.merge(user);
			return HttpStatus.OK_200;
		} else {
			logger.info("User not found");
			return HttpStatus.NOT_FOUND_404;
		}

	}

	
}
