package com.secure.repository;	

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.secure.model.User;

@Component
public interface UserJpaRepository extends JpaRepository<User, Long>{

	User findByName(String name);

}
