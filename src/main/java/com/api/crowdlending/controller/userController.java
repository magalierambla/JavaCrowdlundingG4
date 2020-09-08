package com.api.crowdlending.controller;


import java.awt.PageAttributes.MediaType;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.crowdlending.model.user;

import com.api.crowdlending.model.adminstrateur;

import com.api.crowdlending.repository.userRepository;

import com.api.crowdlending.model.contactModel;

import com.api.crowdlending.repository.contactVisitorRepository;

import com.api.crowdlending.functionsUtils.*;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class userController {
	
    @Autowired
    userRepository userRepository;
    
    @Autowired
    contactVisitorRepository  _contactVisitorRepository;
    
    
 
    
    @PostMapping(value = "/visitor/createMessageContact") 
    @ResponseBody
    public ResponseEntity<contactModel> createMessageContact(@RequestBody  contactModel  newMessage) {
 	   
    	System.out.println("newMessage="+ newMessage.toString());
 	   
 	    String  newToken = methodesUtils.generateAlphanumericStringToken();   	
 	   
  	
 	   newMessage.setToken(newToken);
 	    
 	   
        return ResponseEntity.ok(_contactVisitorRepository.save(newMessage));
        
       // return ResponseEntity.ok().build();
     }
    
    @PostMapping("/admin/listMessagesContact")   
    public ResponseEntity<List<contactModel>> getAllMessagesContact(@RequestBody  adminstrateur  infosAdmin) { 
    	
    	List<contactModel> messages = _contactVisitorRepository.findAll();
    	
    	return ResponseEntity.ok(messages);  
        
    }



   @PostMapping(value = "/users/create") 
   @ResponseBody
   public user createUser(@RequestBody  user newUser) throws NoSuchAlgorithmException {
	   
	   
	   
	    String  newToken = methodesUtils.generateAlphanumericStringToken();    
	
	   
	    user userBdd = new user();
	   
	    userBdd.setDateNaissance(newUser.getDateNaissance());        
	    
	    userBdd.setNom(newUser.getNom());
	    
	    userBdd.setPrenom(newUser.getPrenom());
	    
	    userBdd.setSex(newUser.getSex());
	    
	    userBdd.setPhotoUser(newUser.getPhotoUser());
	    
	    userBdd.setLogin(newUser.getLogin());
	    
	    userBdd.setPassword(methodesUtils.getMD5Hex(newUser.getPassword()));
	    
	    userBdd.setToken(newToken);  
	    
	    userBdd.setTypeCompte(newUser.getTypeCompte());
	    
	    userBdd.setPseudo_name(newUser.getPseudo_name());
	    
	    System.out.println("newUser.getNom()="+ newUser.getNom());         
	    
	    
	   
       return userRepository.save(userBdd);
    }
    
    @PostMapping("/users/checkUser")
    @ResponseBody
    public ResponseEntity<user> checkUser(@Valid @RequestBody  user infosUser) throws NoSuchAlgorithmException{   	 
    	
    	
    	
 	    
 	    System.out.println("infosUser.login="+ infosUser.getLogin());     
 	    
 	    System.out.println("infosUser.password="+ infosUser.getPassword());   
 	    
 	    String passwordMd5 = methodesUtils.getMD5Hex(infosUser.getPassword());   
 	   
        return ResponseEntity.ok(userRepository.getUserByEmailAndPassword(infosUser.getLogin(),passwordMd5));
        
 	   
     }
    
    @PostMapping("/users/checkExistMailUser")
    @ResponseBody
    public ResponseEntity<user> checkExistMailUser(@Valid @RequestBody  user infosUser) {   	   
 	  
 	    
 	    System.out.println("infosUser.login="+ infosUser.getLogin());  
 	    
 	 
 	    
 	   
        return ResponseEntity.ok(userRepository.checkExistMailUser(infosUser.getLogin()));
        
 	   
     }
    
    @PutMapping(value = "/users/update") 
    @ResponseBody
    public ResponseEntity<user>  updateUser(@RequestBody  user updateUser) throws NoSuchAlgorithmException {	   
 	   
    	 System.out.println("infosUser.token="+ updateUser.getToken()); 
    	 
    	 Optional<user>  userBdd = userRepository.checkExistUserByToken(updateUser.getToken());   	 
    	 
    	 if(userBdd.isPresent()) { 
    		 
    		 user _user = userBdd.get();
    		 
    		 _user.setDate_naissance(updateUser.getDateNaissance());
    		 
    		 _user.setDate_update(updateUser.getDate_update());
    		 
    		 _user.setNom(updateUser.getNom());
    		 
    		 _user.setPrenom(updateUser.getPrenom());
    		 
    		 _user.setPhotoUser(updateUser.getPhotoUser());
    		 
    		 _user.setSex(updateUser.getSex());
    		 
    		 _user.setPassword(methodesUtils.getMD5Hex(updateUser.getPassword()));
    		 
    		 _user.setLogin(updateUser.getLogin());
    		 
    		 _user.setPseudo_name(updateUser.getPseudo_name());
    		 
    		 System.out.println("userbdd exist"+_user.getNom()); 
    		 
    		 return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
    		 
    	 }else {
    		 
    		 System.out.println("non-userbdd exist"); 
    		 
    		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	 }  
 	 
    	
    	
     }

    
  

}
