package com.spring.data.methods.springdatamethods.business;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.data.methods.springdatamethods.entities.User;
import com.spring.data.methods.springdatamethods.json.MessageJson;
import com.spring.data.methods.springdatamethods.repositories.UserRepository;

@Service
public class UserBussiness {

	@Autowired
	UserRepository repository;
	
	@Transactional
	public MessageJson saveUser(User user) throws Exception{
		MessageJson message = 
				new MessageJson("User was persisted!");
		try{
			repository.save(user);
		}catch(Exception e){
			message = new MessageJson("There's an error " + e.getCause());
			throw new Exception(e.getMessage());
		}
		return message;
	}
	
	@Transactional
	public MessageJson saveUsers(List<User> users) throws Exception{
		MessageJson message = 
				new MessageJson("Users was persisted!");
		try{
			repository.save(users);
		}catch(Exception e){
			message = new MessageJson("There's an error " + e.getCause());
			throw new Exception(e.getMessage());
		}
		return message;
	}
	
	@Transactional
	public MessageJson deleteByName(String name) throws Exception{
		MessageJson message = null;
		try{
			repository.deleteByName(name);
			message = 
					new MessageJson(name + " was removed!");
		}catch(Exception e){
			message = new MessageJson("There's an error removing an object");
			throw new Exception(e.getMessage());
		}
		return message;
	}
	
	public List<User> findByName(String name){
		return repository.findByName(name);
	}
	
	public List<User> findByNameIgnoreCas(String name){
		return repository.findByNameIgnoreCase(name);
	}
	
	public List<User> findDistinctUserByName(String name){
		return repository.findDistinctUserByName(name);
	}
	
	public List<User> findByNameOrderByAgeAsc(String name){
		return repository.findByNameOrderByAgeAsc(name);
	}
	
	public List<User> findTop2ByName(String name){
		return repository.findTop2ByName(name);
	}

	public List<User> findByAgeGreaterThan(int age){
		return repository.findByAgeGreaterThan(age);
	}
	
	public List<User> findByNameOrderByLastNameAsc(String name){
		return repository.findByNameOrderByLastNameAsc(name);
	}
	
}
