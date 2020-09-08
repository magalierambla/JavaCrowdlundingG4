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
import com.api.crowdlending.model.likeDislikeProjectModel;
import com.api.crowdlending.model.messageModel;
import com.api.crowdlending.model.project;
import com.api.crowdlending.repository.contactVisitorRepository;
import com.api.crowdlending.repository.messageRepository;
import com.api.crowdlending.functionsUtils.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class messagerieController {
	
    @Autowired
    messageRepository  _messageRepository;
    
    @PostMapping(value = "users/{token_user}/messages/create") 
    @ResponseBody
    public ResponseEntity<messageModel>  createMessageByUser(@PathVariable String token_user , @RequestBody   messageModel  _message) {	
 	   
 	   
 	  
        
       return ResponseEntity.ok().build();
 	   
 	   
     }    
   
    
    @PostMapping(value = "users/{token_user}/messages_recus/all")   
    @ResponseBody
    public ResponseEntity<List<messageModel>> getAllMessagesRecus(@PathVariable String token_user , @RequestBody user _user) { 
    	
    	 System.out.println("token-user="+ _user.getToken());
    	
    	 String tokenUser = (String)  _user.getToken();
    	
    	List<messageModel> messages=  _messageRepository.findAllMessagesRecusByTokenUser(tokenUser);    	
    	
    	
    	 if(messages.size()>0) { 
    		 
    		 for(int index=0;index<messages.size();index++) {
 	    		
 	    		  		
 	    		
 	    		
 	    	}   
    		
    		return ResponseEntity.ok(messages);  
    		
    	}
    	
    	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);   	 
    	
    	
        
    }
    
    @PostMapping(value = "users/{token_user}/messages_envoyes/all")   
    @ResponseBody
    public ResponseEntity<List<messageModel>> getAllMessagesEnvoyes(@PathVariable String token_user , @RequestBody user _user) { 
    	
    	 System.out.println("token-user="+ _user.getToken());
    	
    	 String tokenUser = (String)  _user.getToken();
    	
    	List<messageModel> messages=  _messageRepository.findAllMessagesEnvoyesByTokenUser(tokenUser);    	
    	
    	
    	 if(messages.size()>0) { 
    		 
    		 for(int index=0;index<messages.size();index++) {
 	    		
 	    		  		
 	    		
 	    		
 	    	}   
    		
    		return ResponseEntity.ok(messages);  
    		
    	}
    	
    	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);   	 
    	
    	
        
    }
    
    
   
    
    
 
    


    
  

}
