package com.webservicesproject.project.resources;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.webservicesproject.project.entities.User;
import com.webservicesproject.project.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired //in order to the automatic injection using 'Autowired' works, we have to set the 'UserService' as a 'Component' of Spring
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value ="/{id}") //'PathVariable' in order to Spring to consider it as a URL parameter
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		//creating an uri object. To get the "201 created" response on postman instead of "200 OK"
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		//this is the most appropriate way to insert a resource into the database
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	//void because it's not returning me any type of body, it is only deleting by Id
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		//'noContent' will return us an empty answer with '204 No Content' on postman
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
