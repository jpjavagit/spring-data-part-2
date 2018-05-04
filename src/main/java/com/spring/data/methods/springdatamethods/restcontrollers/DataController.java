package com.spring.data.methods.springdatamethods.restcontrollers;

import java.util.List;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.spring.data.methods.springdatamethods.business.UserBussiness;
import com.spring.data.methods.springdatamethods.entities.User;
import com.spring.data.methods.springdatamethods.json.MessageJson;

/**
 * Controller class that supports HTTP calls
 * There's some examples of methods that represents Crud 
 * operations and others useful methods 
 * 
 * @author sanches.java
 *
 */

@RestController
@RequestMapping(value="/api")
public class DataController {

	@Autowired
	UserBussiness userBusiness;
	
	/**
	 * save Method that expects an User object 
	 * @param user : User
	 * @return MessageJson
	 * @throws Exception
	 */
	@RequestMapping(value = "/save",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON)
	public MessageJson saveUser(@RequestBody User user) throws Exception{
		return userBusiness.saveUser(user);
	}
	
	/**
	 * save Method that expects a collection of Users
	 * [ { 
	 * "name": "Seth",
	 * "lastName": "Sierra",
	 * "age": "21",
	 * "city": "Los Angeles",
	 * "state": "California"
	 *  },
	 * "name": "Josh",
	 * "lastName": "Kimberly",
	 * "age": "25",
	 * "city": "Los Angeles",
	 * "state": "California"
	 *  },
	 *   ]
	 * @param users : List<User>
	 * @return MessageJson
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveUsers",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON)
	public MessageJson saveUsers(@RequestBody List<User> users) throws Exception{
		return userBusiness.saveUsers(users);
	}
	
	/**
	 * delete Method that expects a String by rest parameter - /api/deleteByName/Josh
	 * @param name : String
	 * @return MessageJson
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteByName/{name}", method = RequestMethod.DELETE, 
			produces = MediaType.APPLICATION_JSON)
	public MessageJson deleteByName(@PathVariable("name") String name) throws Exception{
		return userBusiness.deleteByName(name);
	}
	
	/**
	 * Method that get a collection of Users by name 
	 * @param name : String
	 * @return List<User>
	 */
	@RequestMapping(value = "/byName/{name}", produces = MediaType.APPLICATION_JSON,
			method = RequestMethod.GET)
	public List<User> findUserByName(@PathVariable("name") String name){
		return userBusiness.findByName(name);
	}
	
	/**
	 * Method that get a collection of Users by name ignoring uppercase/lowercase words
	 * @param name : String
	 * @return List<User>
	 */
	@RequestMapping(value = "/byNameIgnoreCase/{name}", produces = MediaType.APPLICATION_JSON,
			method = RequestMethod.GET)
	public List<User> findUserByNameIgnoreCase(@PathVariable("name") String name){
		return userBusiness.findByNameIgnoreCas(name);
	}
	
	/**
	 * Method that get a collection of Users by name with distinct mechanism
	 * @param name : String
	 * @return : List<User>
	 */
	@RequestMapping(value = "/distinctByName/{name}", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON)
	public List<User> findDistinctUserByName(@PathVariable("name") String name){
		return userBusiness.findDistinctUserByName(name);
	}
	
	/**
	 * Method that get a collection of Users ordering ascending by age property 
	 * @param name : String
	 * @return List<User>
	 */
	@RequestMapping(value = "/findByNameOrderByAgeAsc/{name}", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON)
	public List<User> findByNameOrderByAgeAsc(@PathVariable("name") String name){
		return userBusiness.findByNameOrderByAgeAsc(name);
	}
	
	/**
	 * Method that get a collection of Users ordering ascending by lastName property 
	 * @param name : String
	 * @return List<User>
	 */
	@RequestMapping(value = "/findByNameOrderByLastNameAsc/{name}", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON)
	public List<User> findByNameOrderByLastNameAsc(@PathVariable("name") String name){
		return userBusiness.findByNameOrderByLastNameAsc(name);
	}
	
	/**
	 * Method that get a collection of Users by name selecting two firsts users (limit 2)
	 * @param name : String
	 * @return List<User>
	 */
	@RequestMapping(value = "/findTop2ByName/{name}", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON)
	public List<User> findTop2ByName(@PathVariable("name") String name){
		return userBusiness.findTop2ByName(name);
	}
	

	/**
	 * Method that get a collection of Users by age greater than {age}
	 * @param age : int
	 * @return List<User>
	 */
	@RequestMapping(value = "/findByAgeGreaterThan/{age}", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON)
	public List<User> findByAgeGreaterThan(@PathVariable("age") int age){
		return userBusiness.findByAgeGreaterThan(age);
	}
	
	
	
}
