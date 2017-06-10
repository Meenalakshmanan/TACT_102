package com.user;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tact/stackoverflow")
public class UserRatingController {

	@Autowired
     private UserRatingService userService;
	
	
	@RequestMapping(value="/list")
	public List <User> getAllUsers(){
		return userService.retrieveAllUsers();
	}
	
	
	@RequestMapping(value = "/getrating", method=RequestMethod.GET)
	public User getUserbyId(
	  @RequestParam("id") String id) {
		return userService.retrieveUser(id);
	}
	
	/*@RequestMapping(value="/{id}" , method = RequestMethod.GET)
    public User getUser(@PathVariable String id){
      return userService.retrieveUser(id);
}*/
	
	
	
	
	}
	
	

