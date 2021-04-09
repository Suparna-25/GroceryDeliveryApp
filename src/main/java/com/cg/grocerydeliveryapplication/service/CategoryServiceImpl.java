package com.cg.grocerydeliveryapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.grocerydeliveryapplication.domain.Category;
import com.cg.grocerydeliveryapplication.exception.CategoryIDException;
import com.cg.grocerydeliveryapplication.repository.CategoryRepository;


@Service
public class CategoryServiceImpl {
	
@Autowired
private CategoryRepository categoryRepo;

public Category saveOrUpdate(Category category) {
	boolean exists=categoryRepo.existsByCategoryName(category.getCategoryName());
	try {
		if(exists)
		{
			throw new CategoryIDException("Category  already exists");
		}
		return categoryRepo.save(category);
	} catch (Exception e) {
		throw new CategoryIDException("Category  already exists");
	}
   }


public Category findByCategoryByCategoryID(Long categoryId) {

	Category category = categoryRepo.findByCategoryId(categoryId);
	if (category == null) {
		throw new CategoryIDException("Category ID " + categoryId + " does not exists");
	}
	return category;
}

public Iterable<Category> findAllCategories() {
	return categoryRepo.findAll();
}

public void deleteCategoryByCategoryId(Long categoryId) {
	Category category= findByCategoryByCategoryID(categoryId);
	categoryRepo.delete(category);

}
}
