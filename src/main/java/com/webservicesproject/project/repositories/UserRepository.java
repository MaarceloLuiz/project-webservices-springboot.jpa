package com.webservicesproject.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservicesproject.project.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
