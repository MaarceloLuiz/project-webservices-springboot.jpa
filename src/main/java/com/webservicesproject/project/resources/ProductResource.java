package com.webservicesproject.project.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservicesproject.project.entities.Product;
import com.webservicesproject.project.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired //in order to the automatic injection using 'Autowired' works, we have to set the 'ProductService' as a 'Component' of Spring
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value ="/{id}") //'PathVariable' in order to Spring to consider it as a URL parameter
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
