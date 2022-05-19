package com.blogging.service;

import java.util.List;

import com.blogging.dto.CategoryDTO;

public interface CategoryService {
	
	CategoryDTO createCategory(CategoryDTO categoryDTO);
	
	CategoryDTO getCategoryById(Long categoryId);
	
	CategoryDTO updateCategory(CategoryDTO categoryDTO,Long categoryId);
	
	void deleteCategory(Long categoryId);
	
	List<CategoryDTO> getAllCategories();


}
