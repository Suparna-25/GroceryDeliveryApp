package com.cg.grocerydeliveryapplication.repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.grocerydeliveryapplication.domain.Product;

public interface ProductRepository extends CrudRepository<Product,Integer>{

	Product findByProductId(int productId);

	
	Product findByCategoryName(String categoryName);

}
