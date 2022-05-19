package com.blogging.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Posts")
public class Posts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "postId", unique = true, nullable = false)
	private Long postId;
	
	@Column(name = "title", unique = true, nullable = false)
	private String title;
	
	@Column(name = "content", unique = true, nullable = false)
	private String content;
	
	@Column(name = "imageName")
	private String imageName;
	
	@Column(name = "addedDate")
	private Date addedDate;
	
	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "categoryId", referencedColumnName = "categoryId", nullable = false)
	private Category category;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Posts [postId=" + postId + ", title=" + title + ", content=" + content + ", imageName=" + imageName
				+ ", addedDate=" + addedDate + ", user=" + user + ", category=" + category + "]";
	}
	
	
	
	
	
	
	
	
	
	



}
