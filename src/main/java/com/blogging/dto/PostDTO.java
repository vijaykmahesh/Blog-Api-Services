package com.blogging.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "postId", "title", "content", "imageName", "addedDate", "userId", "categoryId"})
public class PostDTO {

	@JsonProperty("postId")
	private Long postId;

	@NotBlank(message = "title cannot be empty")
	@Length(min = 5, max = 150)
	@JsonProperty("title")
	private String title;

	@NotBlank(message = "content cannot be empty")
	@Length(min = 5, max = 150)
	@JsonProperty("content")
	private String content;

	@NotBlank(message = "imageName cannot be empty")
	@Length(min = 5, max = 150)
	@JsonProperty("imageName")
	private String imageName;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonProperty("addedDate")
	private Date addedDate;

	@JsonProperty("userId")
	private Long userId;

	@JsonProperty("categoryId")
	private Long categoryId;

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

}
