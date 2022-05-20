package com.blogging.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "categoryId", "categoryTitle", "description", "PostDtos"})
public class CategoryDetailsDTO {


	@NotBlank(message = "categoryTitle cannot be null")
	@Length(min = 5, max = 150)
	@JsonProperty("categoryTitle")
	private String categoryTitle;

	@NotBlank(message = "description cannot be null")
	@Length(min = 5, max = 150)
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("PostDtos")
	List<PostDTO> PostDtos;

	

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<PostDTO> getPostDtos() {
		return PostDtos;
	}

	public void setPostDtos(List<PostDTO> postDtos) {
		PostDtos = postDtos;
	}
	
	

}
