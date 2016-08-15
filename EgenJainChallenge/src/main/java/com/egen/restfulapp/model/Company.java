package com.egen.restfulapp.model;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
// TODO: Auto-generated Javadoc

/**
 * The Class Company.
 *
 * @author ajain
 */
@Entity
public class Company {

	@Id
	private String id;

	private String name;

	private String website;

	public Company() {
		super();
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the website.
	 *
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * Sets the website.
	 *
	 * @param website
	 *            the new website
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", website=" + website + "]";
	}
}
