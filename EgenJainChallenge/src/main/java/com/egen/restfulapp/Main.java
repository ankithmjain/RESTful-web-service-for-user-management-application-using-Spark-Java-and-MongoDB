package com.egen.restfulapp;

import com.egen.restfullapp.service.UserServiceImpl;

/**
 * The Class Main.
 *
 * @author ajain
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		UserController userController = new UserController(8080, new UserServiceImpl());

	}
}
