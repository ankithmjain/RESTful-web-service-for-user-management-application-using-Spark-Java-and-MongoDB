package com.egen.restfullapp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.egen.restfulapp.Main;
import com.egen.restfullapp.model.User;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import spark.Spark;
import spark.utils.IOUtils;

/**
 * The Class UserControllerTest.
 */
public class UserControllerTest {

	private static Integer port = 8080;

	/**
	 * Sets the up.
	 */
	@BeforeClass
	public static void setUp() {

		Main.main(null);
		Spark.awaitInitialization();
	}

	/**
	 * After class.
	 */
	@AfterClass
	public static void afterClass() {

		Spark.stop();

	}

	/**
	 * Creates the user.
	 */
	@Test
	public void createUser() {
		try {
			JsonObject jsonParam = new JsonObject();

			jsonParam.addProperty("firstName", "Ramesha");
			jsonParam.addProperty("email", "raj_Leffler68@gmail.com");
			jsonParam.addProperty("city", "mysore");
			String json = jsonParam.toString();
			TestResponse res = request("POST", json, "/createUser");
			assertEquals(200, res.status);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Edits the user.
	 */
	@Test
	public void editUser() {
		try {
			JsonObject jsonParam = new JsonObject();
			jsonParam.addProperty("firstName", "Suresha");
			jsonParam.addProperty("email", "raj_Leffler68@gmail.com");
			jsonParam.addProperty("lastName", "Hinosha");

			String json = jsonParam.toString();
			TestResponse res = request("PUT", json, "/updateUser");
			assertEquals(200, res.status);
			assertNotNull(res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the users all.
	 *
	 * @return the users all
	 */
	@Test
	public void getUsersAll() {
		try {
			TestResponse res = request("GET", null, "/getAllUsers");
			User[] users = res.json();
			assertEquals(200, res.status);
			assertEquals("Suresha", users[0].getFirstName());
			assertNotNull(res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Request.
	 *
	 * @param method
	 *            the method
	 * @param json
	 *            the json
	 * @param path
	 *            the path
	 * @return the test response
	 */
	private TestResponse request(String method, String json, String path) {
		try {
			URL url = new URL("http://localhost:" + port + path);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(method);
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.connect();

			if (json != null) {
				OutputStream os = connection.getOutputStream();
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
				writer.write(json.toString());
				writer.close();
				os.close();
			}

			String body = IOUtils.toString(connection.getInputStream());
			return new TestResponse(connection.getResponseCode(), body);
		} catch (IOException e) {
			e.printStackTrace();
			fail("Sending request failed: " + e.getMessage());
			return null;
		}
	}

	/**
	 * The Class TestResponse.
	 */
	private static class TestResponse {

		public final String body;
		public final int status;

		/**
		 * Instantiates a new test response.
		 *
		 * @param status
		 *            the status
		 * @param body
		 *            the body
		 */
		public TestResponse(int status, String body) {
			this.status = status;
			this.body = body;
		}

		/**
		 * Json.
		 *
		 * @return the user[]
		 */
		public User[] json() {

			return new Gson().fromJson(body, User[].class);
		}
	}

}
