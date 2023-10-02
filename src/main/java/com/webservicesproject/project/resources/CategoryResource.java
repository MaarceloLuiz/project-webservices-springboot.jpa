package com.webservicesproject.project.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservicesproject.project.entities.Category;
import com.webservicesproject.project.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired //in order to the automatic injection using 'Autowired' works, we have to set the 'CategoryService' as a 'Component' of Spring
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value ="/{id}") //'PathVariable' in order to Spring to consider it as a URL parameter
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
