package com.api.crowdlending.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.crowdlending.model.User;

import com.api.crowdlending.model.messageModel;
import com.api.crowdlending.repository.messageRepository;


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
    public ResponseEntity<List<messageModel>> getAllMessagesRecus(@PathVariable String token_user , @RequestBody User _user) {

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
    public ResponseEntity<List<messageModel>> getAllMessagesEnvoyes(@PathVariable String token_user , @RequestBody User _user) {

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
