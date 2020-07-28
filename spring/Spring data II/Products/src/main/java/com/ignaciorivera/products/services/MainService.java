package com.ignaciorivera.products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.ignaciorivera.products.models.Category;
import com.ignaciorivera.products.models.Product;
import com.ignaciorivera.products.repositories.CategoryRepository;
import com.ignaciorivera.products.repositories.ProductRepository;



@Service
public class MainService {
	
	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;
	
	public MainService(ProductRepository productRepository,CategoryRepository categoryRepository) {
		this.productRepository=productRepository;
		this.categoryRepository=categoryRepository;
	}
	

	//Devolviendo todas las categorias
    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }


	public List<Product> allProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}


	public Product createProduct(Product product) {
		return productRepository.save(product);
		
	}
	
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
		
	}
	//Buscar producto por id
	public Product findProduct(Long id) {
        Optional<Product> optionalProduct =productRepository.findById(id);
        if(optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            return null;
        }
    }
	
	//Buscar categoria por id
		public Category findCategory(Long id) {
	        Optional<Category> optionalCategory =categoryRepository.findById(id);
	        if(optionalCategory.isPresent()) {
	            return optionalCategory.get();
	        } else {
	            return null;
	        }
	    }
		
		//Actualizar datos de categoria
		public Category updateCategory(Category category){
	    	Optional<Category> temp = categoryRepository.findById(category.getId());
	    	if(temp.isPresent()) {
	        	temp.get().setProducts(category.getProducts());
	        
	        	return categoryRepository.save(temp.get());
	        } else {
	            return null;
	        }   
	    }
		
		//Actualizar datos de categoria
				public Product updateProduct(Product product){
			    	Optional<Product> temp = productRepository.findById(product.getId());
			    	if(temp.isPresent()) {
			        	temp.get().setCategories(product.getCategories());
			        
			        	return productRepository.save(temp.get());
			        } else {
			            return null;
			        }   
			    }
}
