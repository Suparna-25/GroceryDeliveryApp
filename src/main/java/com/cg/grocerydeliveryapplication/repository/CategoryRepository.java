package com.cg.grocerydeliveryapplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.grocerydeliveryapplication.domain.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {

	Category findByCategoryId(Long cId);

	

}
