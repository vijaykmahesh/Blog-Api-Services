package com.blogging.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDetailsDTO {

	@JsonProperty("userId")
	private Long userId;

	@NotBlank(message = "userName cannot be empty")
	@Length(min = 5, max = 150)
	@JsonProperty("userName")
	private String userName;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonProperty("dateOfBirth")
	private Date dateOfBirth;

	@JsonProperty("email")
	@Email(message = "enter valid emailId")
	private String email;

	@JsonProperty("about")
	private String about;
	
	@JsonProperty("postDtos")
	private List<PostDTO> postDtos;

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

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public List<PostDTO> getPostDtos() {
		return postDtos;
	}

	public void setPostDtos(List<PostDTO> postDtos) {
		this.postDtos = postDtos;
	}
	
	

}
