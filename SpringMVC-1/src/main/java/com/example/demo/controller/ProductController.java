package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
	ProductService service;
	@GetMapping("/display")
	public String displayProduct(Model model) {
		Product myprd=service.getProductById(2);
		model.addAttribute("product", myprd);
		return "displayProduct";
	}
	@GetMapping("/displayList")
	public String displayProductList(Model model) {
		Iterable<Product> prdList=service.getAllProducts();
		model.addAttribute("prdlist", prdList);
		return "productListing";
	}
	@GetMapping("/user")
	public ModelAndView printUser() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("user","Admin");
		mv.setViewName("user");
		return mv;
	}
	
    @GetMapping("/products")
    public String listProducts(Model model) {
        // Retrieve and send a list of products to the view
        return "product/list";
    }

    @GetMapping("/products/add")
    public String addProductForm() {
        // Return a form to add a new product
        return "product/add";
    }

    @PostMapping("/products/add")
    public String addProduct(Product product) {
        // Save the product to the database
        return "redirect:/products";
    }
}
