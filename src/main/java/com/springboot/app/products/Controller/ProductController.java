/**
 * 
 */
package com.springboot.app.products.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.products.Exceptions.ResourceNotFoundException;
import com.springboot.app.products.Model.Products;
import com.springboot.app.products.Repository.ProductsRepositorty;

/**
 * @author SATYAM
 *
 */
@RestController
@RequestMapping("/app")
public class ProductController {

		@Autowired
		private ProductsRepositorty PR; 
		
		@GetMapping("/productsget")
		public List <Products> getAllProductsDetails(Products products) {
			return PR.findAll();
		}
		
		@PostMapping("addproducts")
		public Products addProducts(@RequestBody Products products) {
			return PR.save(products);
		}
		
		@GetMapping("/productsget/{id}")
		public Products getProductById(@PathVariable(value="id") Long productID) {
			return PR.findById(productID).orElseThrow(()->new ResourceNotFoundException("Products","id",productID));
		}
		
		@PutMapping("/updateproducts/{id}")
		public Products updateProducts(@PathVariable(value="id") Long productID, @RequestBody Products productsDetails) {
			Products setProducts = PR.findById(productID).orElseThrow(()->new ResourceNotFoundException("Products","id",productID));
			setProducts.setProductName(productsDetails.getProductName());
			setProducts.setProductQuality(productsDetails.getProductQuality());
			setProducts.setProductModel(productsDetails.getProductModel());
			setProducts.setProductVersion(productsDetails.getProductVersion());
			Products updatedProducts = PR.save(setProducts);
			return updatedProducts;
		}
		
		@DeleteMapping("/deleteproducts/{id}")
		public ResponseEntity<?> deleteProducts(@PathVariable(value="id") Long productID){
			Products getId = PR.findById(productID).orElseThrow(()->new ResourceNotFoundException("Products","id",productID));
			PR.delete(getId);
			return ResponseEntity.ok().build();
			}
		
		
}
