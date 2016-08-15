package com.egen.restfulapp.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
// TODO: Auto-generated Javadoc

/**
 * The Class User.
 *
 * @author ajain
 */
@Entity
public class User {

	/** The id. */
	@Id
	private ObjectId id;

	/** The first name. */
	private String firstName;

	private String lastName;

	private String email;

	private Address address;

	private String dateCreated;

	private Company company;

	private String profilePic;

	public User() {

	}

	public User(ObjectId id, String firstName, String email, Address address, Company company) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.email = email;
		this.address = address;
		this.company = company;
	}

	public User(String firstName, String lastName, String email, Address address, String dateCreated, Company company,
			String profilePic) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.dateCreated = dateCreated;
		this.company = company;
		this.profilePic = profilePic;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public ObjectId getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(ObjectId id) {
		this.id = id;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName
	 *            the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName
	 *            the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address
	 *            the new address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * Gets the date created.
	 *
	 * @return the date created
	 */
	public String getDateCreated() {
		return dateCreated;
	}

	/**
	 * Sets the date created.
	 *
	 * @param dateCreated
	 *            the new date created
	 */
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * Gets the company.
	 *
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * Sets the company.
	 *
	 * @param company
	 *            the new company
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * Gets the profile pic.
	 *
	 * @return the profile pic
	 */
	public String getProfilePic() {
		return profilePic;
	}

	/**
	 * Sets the profile pic.
	 *
	 * @param profilePic
	 *            the new profile pic
	 */
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", address=" + address + ", dateCreated=" + dateCreated + ", company=" + company + ", profilePic="
				+ profilePic + "]";
	}

}
