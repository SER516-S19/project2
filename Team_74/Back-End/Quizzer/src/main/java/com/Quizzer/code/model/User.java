package com.Quizzer.code.model;

import java.io.Serializable;

import javax.crypto.SecretKey;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * This class is the model for User data.
 * 
 * @author kumar
 *
 */
@Document(collection = "UserDetails")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String role;
	private String userName;
	private SecretKey userPassword;
	private String userEmailId;

	public User() {
		
	}
	public User(String id, String firstName, String lastName, String role, String userName, SecretKey userPassword,
			String userEmailId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmailId = userEmailId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public SecretKey getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(SecretKey userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
