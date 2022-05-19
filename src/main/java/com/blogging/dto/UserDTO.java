package com.blogging.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "userId", "userName", "dateOfBirth", "email", "password", "about" })
public class UserDTO {

	@JsonProperty("userId")
	private Long userId;

	@JsonProperty("userName")
	@NotBlank(message = "userName cannot be empty")
	@Length(min = 5, max = 150)
	private String userName;

	@JsonProperty("dateOfBirth")
	@NotBlank
	private Date dateOfBirth;

	@JsonProperty("email")
	@Email
	private String email;

	@JsonProperty("password")
	@NotBlank(message = "password cannot be empty")
	@Length(min = 5, max = 150)
	private String password;

	@JsonProperty("about")
	private String about;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

}
