package com.egen.restfulapp;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.put;
import com.egen.restfullapp.model.Address;
import com.egen.restfullapp.model.Company;
import com.egen.restfullapp.model.User;
import com.egen.restfullapp.service.UserService;
import com.google.gson.Gson;

/**
 * The Class UserController.
 *
 * @author ajain
 */
public class UserController {

	/**
	 * Instantiates a new user controller.
	 *
	 * @param port
	 *            the port
	 * @param userService
	 *            the user service
	 */
	public UserController(Integer port, UserService userService) {
		final Gson gson = new Gson();

		port(port);

		post("/createUser", (req, res) -> {
			res.type("application/json");
			User user = gson.fromJson(req.body(), User.class);
			Address address = gson.fromJson(req.body(), Address.class);
			Company company = gson.fromJson(req.body(), Company.class);
			return userService.addpost(user, address, company);
		}, gson::toJson);

		get("/getAllUsers", (req, res) -> {

			res.type("application/json");
			return userService.getAllPost();
		}, gson::toJson);

		get("/getUserByEmail/:email", (req, res) -> {

			String email = req.params(":email");
			System.out.println("id " + email);
			User user = userService.getUserByEmail(req.params(":email"));
			res.type("application/json");
			if (user != null) {
				return user;
			} else {
				return "No post found";
			}

		}, gson::toJson);

		put("/updateUser", (req, res) -> {
			res.type("application/json");
			User user = gson.fromJson(req.body(), User.class);
			Address address = gson.fromJson(req.body(), Address.class);
			Company company = gson.fromJson(req.body(), Company.class);

			Integer statusCode = userService.updateUser(user, address, company);
			res.status(statusCode);
			if (statusCode == 200) {
				res.body("Succesfully updated user");
			} else {
				res.body("User not found.");
			}
			return statusCode + ": " + res.body();

		}, gson::toJson);

	}

}
