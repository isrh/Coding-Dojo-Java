package com.ignaciorivera.products.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ignaciorivera.products.models.Category;

import com.ignaciorivera.products.models.Product;
import com.ignaciorivera.products.services.MainService;


@Controller
public class MainController {

private final MainService mainService;
    
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }
    
    @RequestMapping("/")
    public String mainMenu(Model model, @ModelAttribute("product") Product product) {
        
        return "/main/index.jsp";
    }
    
    @RequestMapping("/products/show")
    public String index(Model model, @ModelAttribute("product") Product product) {
        List<Product> products = mainService.allProducts();
        model.addAttribute("products", products);
        return "/products/show.jsp";
    }
    
    //Mostrar formulario para crear nuevo producto
    @RequestMapping("/products/new")
    public String newProduct(Model model, @ModelAttribute("product") Product product) {
        
        return "/products/new.jsp";
    }
    
  //Metodo para crear nuevo producto
    @RequestMapping(value="/products/new", method=RequestMethod.POST)
    public String createProduct(Model model, @ModelAttribute("student") Product product, BindingResult result) {
    	if (result.hasErrors()) {
            return "/students/new.jsp";
        } else {
            mainService.createProduct(product);
            return "redirect:/products/show";
        }
    }
    
  //Mostrar formulario para crear nueva categoria
    @RequestMapping("/categories/new")
    public String newCategory(Model model, @ModelAttribute("category") Category category) {
        
        return "/categories/new.jsp";
    }
    
  //Crear u
    @RequestMapping("/categories/show")
    public String showCategory(Model model, @ModelAttribute("category") Category category) {
    	List<Category> categories = mainService.allCategories();
        model.addAttribute("categories", categories);
       
        return "/categories/show.jsp";
    }
    
    @RequestMapping(value="/categories/new", method=RequestMethod.POST)
    public String createCategory(Model model, @ModelAttribute("category") Category category, BindingResult result) {
    	if (result.hasErrors()) {
            return "/categories/new.jsp";
        } else {
            mainService.createCategory(category);
            return "redirect:/categories/show";
        }
    }
    
  //Mostrar producto por id
    @RequestMapping("/products/{id}")
    public String showProduct(@PathVariable("id") Long id, Model model) {
    	
    	List<Category> allcategories = mainService.allCategories();
    	
    	List<Category> categories = new ArrayList<>();
    	
    	categories=allcategories;
    	Product product=mainService.findProduct(id);

    	List<Category> productCategories=product.getCategories();
    	
    	if(productCategories.size()==0) {
    		
    		categories=allcategories;
    	}
    	else {
    		for(int i=0;i<allcategories.size();i++) {
        		for(int j=0;j<productCategories.size();j++) {
        			
        			if(allcategories.get(i).getId()==productCategories.get(j).getId()) {
        				categories.remove(i);
        			}
        			
        		}
        		
        	}
    	}
    		
    	
    	
    	model.addAttribute("product",product);
    	model.addAttribute("productCategories",productCategories);
    	model.addAttribute("categories", categories);
        return "/products/idshow.jsp";
    }
    
    @RequestMapping(value="/products/{id}", method=RequestMethod.POST)
    public String addCategoryProduct(@PathVariable("id") Long idproduct, @RequestParam("category_id") Long idcategory,  Model model) {
    	
    	Product product = mainService.findProduct(idproduct);
    	Category category = mainService.findCategory(idcategory);
		
    	product.getCategories().add(category);

		mainService.updateProduct(product);

		return "redirect:/products/"+idproduct;
    }
    
    
  //Mostrar producto por id
    @RequestMapping("/categories/{id}")
    public String showCategory(@PathVariable("id") Long id, Model model) {
    	
    	List<Product> allproducts = mainService.allProducts();
    	
    	List<Product> products = new ArrayList<>();
    	
    	products=allproducts;
    	
    	Category category=mainService.findCategory(id);

    	List<Product> categoriesProducts=category.getProducts();
    	
    	if(categoriesProducts.size()==0) {
    		model.addAttribute("products", products);
    	}
    	
    	else {
    		
    		for(int i=0;i<allproducts.size();i++) {
        		for(int j=0;j<categoriesProducts.size();j++) {
        			
        			if(allproducts.get(i).getId()==categoriesProducts.get(j).getId()) {
        				products.remove(i);
        				model.addAttribute("products", products);
        				
        			}
        			
        		}
        		
        	}
    		
    	}
    	
    	
    	
    	
    	
    	
    	model.addAttribute("category",category);
    	
    	model.addAttribute("categoriesProducts",categoriesProducts);
    	
        return "/categories/idshow.jsp";
    }
    
    @RequestMapping(value="/categories/{id}", method=RequestMethod.POST)
    public String addProductCategory(@PathVariable("id") Long idcategory, @RequestParam("product_id") Long idproduct,  Model model) {
    	
    	
    	Category category = mainService.findCategory(idcategory);
    	Product product = mainService.findProduct(idproduct);
		
    	category.getProducts().add(product);

		mainService.updateCategory(category);

		return "redirect:/categories/"+idcategory;
    }
}
