package com.spring.data.methods.springdatamethods.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.data.methods.springdatamethods.entities.User;

/**
 * 
 * @author sanches.java
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	List<User> findByName(String name);
	
	List<User> findByNameIgnoreCase(String name);
	
	List<User> findDistinctUserByName(String name);
	
	List<User> findByNameOrderByAgeAsc(String name);
	
	List<User> findTop2ByName(String name);
	
	Long deleteByName(String name);
	
	Long deleteById(Long id);
	
	List<User> findByAgeGreaterThan(int age);
	
	List<User> findByNameOrderByLastNameAsc(String name);
}
