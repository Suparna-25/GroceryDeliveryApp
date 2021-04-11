package com.cg.grocerydeliveryapplication.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.grocerydeliveryapplication.domain.Category;
import com.cg.grocerydeliveryapplication.exception.CategoryIDException;
import com.cg.grocerydeliveryapplication.service.CategoryServiceImpl;
import com.cg.grocerydeliveryapplication.service.MapValidationErrorService;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {
	@Autowired
	private CategoryServiceImpl categoryService;
	@Autowired
	private MapValidationErrorService mapValidateErrorService;
	
	@PostMapping("/add")
	@CrossOrigin
	public ResponseEntity<?> addCategory(@Valid @RequestBody Category category, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidateErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		Category newCategory = categoryService.saveOrUpdate(category);
		return new ResponseEntity<Category>(newCategory, HttpStatus.CREATED);
	}
	@PutMapping("/update/{categoryId}")
	public ResponseEntity<?> update(@PathVariable Long categoryId, @RequestBody Category category) throws CategoryIDException {
		Category newcategory=categoryService.findByCategoryByCategoryID(categoryId);
		if(newcategory==null || categoryId<=0) {
			throw new CategoryIDException("Updation cannot be possible for unavailable employee");
		}
		return new ResponseEntity<Category>(categoryService.saveOrUpdate(category), HttpStatus.OK);
	}

	
	@GetMapping("/show/{categoryId}")
	public ResponseEntity<?> getCategoryByCId(@PathVariable Long categoryId)
	{
		return new ResponseEntity<Category>(categoryService.findByCategoryByCategoryID(categoryId),HttpStatus.OK);
	}
	@GetMapping("/all")
	public Iterable<Category> getAllCategories(){
		return categoryService.findAllCategories();
	}
	@DeleteMapping("/delete/{categoryId}")
	public ResponseEntity<?> deleteCategory(@PathVariable Long categoryId){
		categoryService.deleteCategoryByCategoryId(categoryId);
		return new ResponseEntity<String> ("Category with Id : "+categoryId+" Deleted!",HttpStatus.OK);
	}

}
