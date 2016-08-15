package com.egen.restfulapp;

import com.egen.restfulapp.service.UserServiceImpl;

/**
 * The Class Main is responsible to start spark server by passing port number and user service 
 *
 * @author ajain
 */
public class Main {

	/**
	 * The main method
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		UserController userController = new UserController(8080, new UserServiceImpl());

	}
}
