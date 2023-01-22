/**
 * 
 */
package com.springboot.app.products.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.app.products.Model.Products;

/**
 * @author SATYAM
 *
 */
public interface ProductsRepositorty extends JpaRepository<Products, Long> {

}
