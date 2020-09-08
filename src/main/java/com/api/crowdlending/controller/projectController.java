package com.api.crowdlending.controller;


import java.awt.PageAttributes.MediaType;
import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.crowdlending.model.*;
import com.api.crowdlending.repository.*;
import com.api.crowdlending.enumapp.*;

import com.api.crowdlending.functionsUtils.*;

import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class projectController {
	
    @Autowired
    projectRepository  _projectRepository;
    
    @Autowired
    adressreseauxSocialRepository  _adressreseauxSocialRepository;
    
    @Autowired
    linkImagesProjectRepository  _linkImagesProjectRepository;
    
    
    @Autowired
    commentProjectRepository  _commentProjectRepository;
    
    @Autowired
    porteProjectRepository  _porteProjectRepository;
    
    @Autowired
    categoryProjectRepository  _categorieProjectRepository;
    
    
    @Autowired
    statutProjectRepository  _statutProjectRepository;
    
    
    @Autowired
    QuestionRepProjectByAdminForUserRepository   _QuestionRepProjectByAdminForUserRepository;
    
    @Autowired
    QuestionRepProjectByUserForAdminRepository   _QuestionRepProjectByUserForAdminRepository;
    
    @Autowired
    QuestionRepProjectByUserForUserRepository   _QuestionRepProjectByUserForUserRepository;
    
    @Autowired
    investisseursProjectRepository   _investisseursProjectRepository;
    
    @Autowired
    fondInvestorRepository   _fondInvestorRepository;
    
    @Autowired
    favorisProjectUserRepository   _favorisProjectUserRepository;
    
    @Autowired
    heartsProjectRepository   _heartsProjectRepository;
    
    @Autowired
    userRepository   _userRepository;
    
    
    @Autowired
    likeDislikeProjectRepository  _likeDislikeProjectRepository;
    
    @Autowired
    vueProjectRepository   _vueProjectRepository;
    
    @Autowired
    newsProjectRepository   _newsProjectRepository;
    
    
    @Autowired
    messageRepository   _messageRepository;
    
    @GetMapping("/project/all_portes")    
    public ResponseEntity<List<porte_project>> getAllPortesProject() { 
    	
    	List<porte_project> list_porte =  _porteProjectRepository.findAll();
    	
        if(list_porte.size()>0) { 
    		
    		return ResponseEntity.ok(list_porte);  // code 200
    		
    	}
    	
    	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);    // code 404
        
    }
    
    @GetMapping("/project/all_categories")    
    public ResponseEntity<List<category_project>> getAllCategoriesProject() { 
    	
    	List<category_project> categories =  _categorieProjectRepository.findAll();
    	
        if(categories.size()>0) { 
    		
    		return ResponseEntity.ok(categories);  
    		
    	}
    	
    	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);   
        
    }
    
    
    @GetMapping("/project/all_statuts")    
    public ResponseEntity<List<statutProject>> getAllStatutsProject() { 
    	
    	List<statutProject> statusProject =  _statutProjectRepository.findAll();
    	
        if(statusProject.size()>0) { 
    		
    		return ResponseEntity.ok(statusProject);  
    		
    	}
    	
    	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);   
        
    }
    
    @GetMapping("/visitor/projects")    
    public ResponseEntity<List<project>> getAllMyProjectsForVisistor() { 
    	
    	List<project> projects =  _projectRepository.findAllProjectsForVisitor();
    	
        if(projects.size()>0) {
        	
        	for(int index=0;index<projects.size();index++) {
        		
        		adminstrateur  _manager_project = new adminstrateur();
        		
        		user _user = new user();
        		
        		
        		projects.get(index).setManager_project(_manager_project);
        		
        		projects.get(index).set_user(_user);
        		
        	}
    		
    		return ResponseEntity.ok(projects);  
    		
    	}
    	
    	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);   
        
    }
    
    @PostMapping("user/projects/searchByKeyword")   
    @ResponseBody
    public ResponseEntity<List<project>> searchByKeywordProjectsForUser(@RequestBody  String tag) { 
    	
    	System.out.println("tag-search="+ tag);
    	
    	List<project> projects =  _projectRepository.findAllProjectsByLikeTag("%"+ tag +"%");
    	
    	// List<project> projects =  _projectRepository.findByNomLike("%"+ tag +"%");
    	
        if(projects.size()>0) { 
    		
    		return ResponseEntity.ok(projects);  
    		
    	}
    	
    	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);   
        
    }
    
    @PostMapping("admin/projects/searchByKeyword")   
    @ResponseBody
    public ResponseEntity<List<project>> searchByKeywordProjectsForAdmin(@RequestBody  String tag) { 
    	
    	// System.out.println("tag-search="+ tag);
    	
    	List<project> projects =  _projectRepository.findAllProjectsByLikeTag("%"+ tag +"%");
    	
    	// List<project> projects =  _projectRepository.findByNomLike("%"+ tag +"%");
    	
        if(projects.size()>0) { 
    		
    		return ResponseEntity.ok(projects);  
    		
    	}
    	
    	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);   
        
    }
    
 

    @GetMapping("/admin/projects")    
    public ResponseEntity<List<project>> getAllMyProjects() { 
    	
    	List<project> projects =  _projectRepository.findAllProjects();
    	
        if(projects.size()>0) { 
    		
    		return ResponseEntity.ok(projects);  
    		
    	}
    	
    	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);   
        
    }
    
    @PostMapping("/users/{token_user}/my_projects")  
    @ResponseBody
    public ResponseEntity<List<project>> getAllMy_projects(@PathVariable String token_user , @RequestBody user _user) { 
    	
    	// System.out.println("token-user="+ _user.getToken());
    	
    	// String tokenUser = (String)  _user.getToken();
    	
    	List<project> projects =  _projectRepository.findBy_user(_user);    	
    	
    	
    	 if(projects.size()>0) { 
    		 
    		 for(int index=0;index<projects.size();index++) {
 	    		
 	    		adminstrateur  _manager_project = new adminstrateur(); 	    		
 	    		
 	    		projects.get(index).setManager_project(_manager_project); 	  		
 	    		
 	    		
 	    	}   
    		
    		return ResponseEntity.ok(projects);  
    		
    	}
    	
    	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);   	 
    	
    	
        
    }
    
    @PostMapping("/users/{token_user}/all_projects")  
    @ResponseBody
    public ResponseEntity<List<project>> getAll_projectsByUser(@PathVariable String token_user ,@RequestBody user _user) { 
    	
    	// System.out.println("token-user="+ _user.getToken());
    	
    	String tokenUser = (String)  _user.getToken();
    	
    	List<project> projects =  _projectRepository.findAllProjectsByUser(tokenUser);   	
    	
    	
    	
    	 if(projects.size()>0) { 
    		 
    		 for(int index=0;index<projects.size();index++) {
    	    		
    	    		adminstrateur  _manager_project = new adminstrateur();
    	    		
    	    		user creatorProject = new user();    		
    	    		
    	    		creatorProject.setNom(projects.get(index).get_user().getNom());
    	    		
    	    		creatorProject.setPrenom(projects.get(index).get_user().getPrenom());
    	    		
    	    		creatorProject.setPhotoUser(projects.get(index).get_user().getPhotoUser());
    	    		
    	    		creatorProject.setPseudo_name(projects.get(index).get_user().getPseudo_name());
    	    		
    	    		projects.get(index).setManager_project(_manager_project);
    	    		
    	    		projects.get(index).set_user(creatorProject);
    	    		
    	    	}   	
    		
    		return ResponseEntity.ok(projects);  
    		
    	}
    	
    	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);    	 
    	
    	
        
    }
    
    @PostMapping("/users/{token_user}/my_contrib_projects")  
    @ResponseBody
    public ResponseEntity<List<investisseursProjectModel>> getAll_contrib_projectsByUser(@RequestBody user _user) { 
    	
    	// System.out.println("token-user="+ _user.getToken());
    	
    	String tokenUser = (String)  _user.getToken();
    	
    	List<investisseursProjectModel> listInvestisseursProjectBdd =  _investisseursProjectRepository.findAllContribProjectByToken(tokenUser);  	
    
    	
    	 if(listInvestisseursProjectBdd.size()>0) {
    		 
    		 for(int index=0;index<listInvestisseursProjectBdd.size();index++) {
   			  
   			  
   			   adminstrateur  _manager_project = new adminstrateur();
   	    	  	
   	    		user creatorProject = new user();    		
   	    		
   	    		creatorProject.setNom(listInvestisseursProjectBdd.get(index).get_project().get_user().getNom());
   	    		
   	    		creatorProject.setPrenom(listInvestisseursProjectBdd.get(index).get_project().get_user().getPrenom());
   	    		
   	    		creatorProject.setPhotoUser(listInvestisseursProjectBdd.get(index).get_project().get_user().getPhotoUser());
   	    		
   	    		creatorProject.setPseudo_name(listInvestisseursProjectBdd.get(index).get_project().get_user().getPseudo_name());
   	    		
   	    		project _project = listInvestisseursProjectBdd.get(index).get_project();
   	    		
   	    		_project.set_user(creatorProject);
   	    		
   	    		_project.setManager_project(_manager_project);	    		
   	    		
   	    		listInvestisseursProjectBdd.get(index).set_project(_project);	   			  
   			  
   			  
   		  }
    		 
    		
    		return ResponseEntity.ok(listInvestisseursProjectBdd);  
    		
    	}
    	
    	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);   	 
    	
    	
        
    }
    
    
    @GetMapping("/projects/{token}")    
    public ResponseEntity<project> getDataProject(@PathVariable String token) { 
    	
    	
      	 System.out.println("token-project*="+ token);
      	 
    	project projectBdd = _projectRepository.findProjectByToken(token);
    	
    	System.out.println("infos-project*="+ projectBdd.getNom());
		 
    	 return ResponseEntity.ok(projectBdd); 
        
    }
    


   @PostMapping(value = "users/{token_user}/projects/create") 
   @ResponseBody
   public ResponseEntity<project> createProject(@PathVariable String token_user, @RequestBody  project newProject) {
	   
	   project projectBdd = new project();
	   
	    String  newToken = methodesUtils.generateAlphanumericStringToken();    
	   
	  //  System.out.println("newProject="+ newProject.toString());  
	    
	 //   System.out.println("porte_project="+ newProject.get_porte_project());    	   
	    
    
	    
	   projectBdd.setToken(newToken);
	    
	   projectBdd.setNom(newProject.getNom());   
	    
	    projectBdd.setDescription(newProject.getDescription());
	    
	    projectBdd.setMontant_minimun(newProject.getMontant_minimun());
	    
	    projectBdd.setDate_limite_collecte(newProject.getDate_limite_collecte());
	    
	    projectBdd.setAfficheProject(newProject.getAfficheProject()); 
	    
	    validProject  _validProject = validProject.ATTENTE;
	    
	    projectBdd.setValid_project(_validProject);
	    
	    projectBdd.setContrePartieProject(newProject.getContrePartieProject());
	    
	    projectBdd.set_user(newProject.get_user()); 
	    
	    projectBdd.set_statut_project(newProject.get_statut_project());
	    
	    projectBdd.setCategoryProject(newProject.getCategoryProject());    
	
	    
	    projectBdd.set_porte_project(newProject.get_porte_project());    
	    
	   
	   // System.out.println("projectBdd="+ projectBdd.toString());  	    
	   
	   
       return ResponseEntity.ok(_projectRepository.save(projectBdd)); 
       
      //  return ResponseEntity.ok().build();
	   
	   
    }
   
   @PutMapping(value = "admin/projects/update") 
   @ResponseBody
   public ResponseEntity<project> updateProjectByAdmin(@RequestBody  project updateProject) {
	   
	   
	  Optional<project>  projectBdd = _projectRepository.findById(updateProject.getId());   	 
  	 
  	 if(projectBdd.isPresent()) { 
  		 
  		 project projectBddUpdate = projectBdd.get();
  		 
  		projectBddUpdate.set_statut_project(updateProject.get_statut_project());
  		
  		projectBddUpdate.setManager_project(updateProject.getManager_project());
  		 
  		 return new ResponseEntity<>(_projectRepository.save(projectBddUpdate), HttpStatus.OK);
  		 
  	 }else {
  		 
  		 System.out.println("non-userbdd exist"); 
  		 
  		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  	 }     
	   
	   
	   
    }
   
   
   @PutMapping(value = "users/{token_user}/my_projects/{token_project}/update") 
   @ResponseBody
   public ResponseEntity<project> updateProjectByUser(@PathVariable String token_user, @PathVariable String token_project, @RequestBody  project updateProject) {
	   
	    // System.out.println("req-update-Project-id="+ updateProject.getId());
	   
	  
	   
	   
	  Optional<project>  projectBdd = _projectRepository.findById(updateProject.getId());   	 
  	 
  	 if(projectBdd.isPresent()) { 
  		 
  		 project projectBddUpdate = projectBdd.get();
  		 
  		 String tokenUserProject = projectBddUpdate.get_user().getToken();
  		 
  		 projectBddUpdate.setNom(updateProject.getNom());	
  		 
  		//  System.out.println("token-user-path="+ token_user);
  		 
  		 // System.out.println("token-user-Project="+ tokenUserProject);
  		 
  	   	 String chaine1 = new String(token_user);
  		
  	     String chaine2 = new String(tokenUserProject);
  	    
  	      boolean isEqual = (chaine1.equals(chaine2));
  	  
       //    System.out.println("isEqual = "+ isEqual);
           
           
  		 
  		 if(isEqual) {
  			 
  			// System.out.println("token-user-Project=token-user-path");
  			
  			return new ResponseEntity<>(_projectRepository.save(updateProject), HttpStatus.OK);
  			
  		 } 	else {
  			 
  			 // System.out.println("non-userbdd exist"); 
  	  		 
  	  		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  		 }
  		 
  		
  		 
  		
  		 
  	 }else {
  		 
  		 // System.out.println("non-userbdd exist"); 
  		 
  		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  	 }     
	   
	   
	   
    }
   
  
   
   @PostMapping(value = "/users/{token_user}/projects/{token_project}/create_adress_res_social") 
   @ResponseBody
   public ResponseEntity<adressReseauxSociauxProject> createAdressReseauSocialProject(@RequestBody  adressReseauxSociauxProject linkSocial) { 

	   
	  
	   
	  //  System.out.println("newProject="+ newProject.toString());  
	    
	   //  System.out.println("porte_project="+ newProject.get_porte_project());   
	   
	   // System.out.println("projectBdd="+ projectBdd.toString());    
	   
	   _adressreseauxSocialRepository.save(linkSocial);
	   
	   adminstrateur  _manager_project = new adminstrateur();
	   
	   project _project = linkSocial.get_project();

	   _project.setManager_project(_manager_project);
	   
	   linkSocial.set_project(_project);
	    
	   
      return ResponseEntity.ok(linkSocial);   
	   
	   
    }
   
   @PostMapping(value = "/users/{token_user}/projects/{token_project}/delete_adress_social") 
   @ResponseBody
   public ResponseEntity<adressReseauxSociauxProject> deleteAdressSocialByProject(@PathVariable String token_user, @PathVariable String token_project , @RequestBody  adressReseauxSociauxProject linkSocial) {
	   
	   
	   
		  // System.out.println("token-project-favoris-project = "+_project.getToken());
		  
	   _adressreseauxSocialRepository.deleteAdressReseauxSociauxProject(linkSocial.getId());  	  
	       
	      return ResponseEntity.ok().build();       
    
	   
	   
    }
   
   @PostMapping(value = "/projects/{token_project}/list_adress_social") 
   @ResponseBody
   public ResponseEntity<List<adressReseauxSociauxProject>>  getListAdressSociaux(@PathVariable String token_project , @RequestBody  project _project) { 	
	   
	   
	  // System.out.println("token-object-Project="+ _project.getToken()); 
	  
	  
	  // System.out.println("@PathVariable="+  token_project); 
	    
	   
	  List<adressReseauxSociauxProject> listAdressSociaux =  _adressreseauxSocialRepository.findBy_project(_project);   	
   	
   	
   	 if(listAdressSociaux.size()>0) {
   		 
   		 
   		 for(int index=0;index<listAdressSociaux.size();index++) {
			   
			   
			    adminstrateur  _manager_project = new adminstrateur();
	    		
	    		user creatorProject = new user();    		
	    		
	    		creatorProject.setNom(listAdressSociaux.get(index).get_project().get_user().getNom());
	    		
	    		creatorProject.setPrenom(listAdressSociaux.get(index).get_project().get_user().getPrenom());
	    		
	    		creatorProject.setPhotoUser(listAdressSociaux.get(index).get_project().get_user().getPhotoUser());
	    		
	    		creatorProject.setPseudo_name(listAdressSociaux.get(index).get_project().get_user().getPseudo_name());
	    		
	    		project _projectBdd = listAdressSociaux.get(index).get_project();
	    		
	    		_projectBdd.set_user(creatorProject);
	    		
	    		_projectBdd.setManager_project(_manager_project);	    		
	    		
	    		listAdressSociaux.get(index).set_project(_projectBdd);				   
			   
		   }

   		 
   		 
   		
   		return ResponseEntity.ok(listAdressSociaux);  
   		
   	}
   	
   	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);       
     
	   
	   
    }
   
   @PostMapping(value = "/users/{token_user}/projects/{token_project}/create_link_image") 
   @ResponseBody
   public ResponseEntity<linkImageProject> createLinkImageProject(@PathVariable String token_user, @PathVariable String token_project, @RequestBody  linkImageProject linkImage) {      
	    
	   

	   _linkImagesProjectRepository.save(linkImage);
	   
        adminstrateur  _manager_project = new adminstrateur();
	   
	   project _project = linkImage.get_project();

	   _project.setManager_project(_manager_project);
	   
	   linkImage.set_project(_project);   
	   
	   
	   return ResponseEntity.ok(linkImage);        
    
	   
	   
    }
   
   @PostMapping(value = "/users/{token_user}/projects/{token_project}/delete_link_image") 
   @ResponseBody
   public ResponseEntity<linkImageProject> deleteLinkImageProject(@PathVariable String token_user, @PathVariable String token_project, @RequestBody  linkImageProject linkImage) {
	   
	   
	   
		  // System.out.println("token-project-favoris-project = "+_project.getToken());
		  
	   _linkImagesProjectRepository.deleteLinkImageProject(linkImage.getId());  	  
	       
	      return ResponseEntity.ok().build(); 
        
    
	   
	   
    }
   
   @PostMapping(value = "/projects/{token_project}/list_link_images") 
   @ResponseBody
   public ResponseEntity<List<linkImageProject>>  getListLinkImagesProject(@PathVariable String token_project , @RequestBody  project _project) { 	
	   
	   
	  System.out.println("token-object-Project="+ _project.getToken()); 
	  
	  
	  System.out.println("@PathVariable="+  token_project); 
	    
	   
	  List<linkImageProject> listImagesProject =  _linkImagesProjectRepository.findBy_project(_project);   	
   	
   	
   	 if(listImagesProject.size()>0) { 
   		 
   		 for(int i=0;i<listImagesProject.size();i++) {
   			 
   			 
   			project _projectBis = listImagesProject.get(i).get_project();
   			
   			user _userBis = _projectBis.get_user();
   			
   			_userBis.setToken("");
   			
   			_projectBis.setToken("");  			
   			
   			_projectBis.set_user(_userBis);
   			
   			adminstrateur  _adminBis = new adminstrateur();
   			
   			_projectBis.setManager_project(_adminBis);
   			 
   			listImagesProject.get(i).set_project(_projectBis);
   			 
   			 
   		 }
   		
   		return ResponseEntity.ok(listImagesProject);  
   		
   	}
   	
   	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);     
     
	   
	   
    }
   
   @PostMapping(value = "/projects/{token_project}/comments") 
   @ResponseBody
   public ResponseEntity<List<commentProject>>  getListComments(@PathVariable String token_project , @RequestBody  project _project) {	 
	   
	    
	   
	  List<commentProject> listComments =  _commentProjectRepository.findBy_project(_project);   	
   	
   	
   	 if(listComments.size()>0) { 
   		 
   		 for(int index=0;index<listComments.size();index++) {
			   
			   
	          adminstrateur  _manager_project = new adminstrateur();
   		
   	          user creatorProject = new user();    		
   		
   		      creatorProject.setNom(listComments.get(index).get_project().get_user().getNom());
   		
   		      creatorProject.setPrenom(listComments.get(index).get_project().get_user().getPrenom());
   		
   		      creatorProject.setPhotoUser(listComments.get(index).get_project().get_user().getPhotoUser());
   		
   		      creatorProject.setPseudo_name(listComments.get(index).get_project().get_user().getPseudo_name());
   		
   		      project _projectBdd = listComments.get(index).get_project();
   		
   		     _projectBdd.set_user(creatorProject);
   		
   		     _projectBdd.setManager_project(_manager_project);	  
   		     
   		     user userComment = new user(); 
   		     
   	   	     userComment.setNom(listComments.get(index).get_project().get_user().getNom());
      		
   		     userComment.setPrenom(listComments.get(index).get_project().get_user().getPrenom());
		
   		     userComment.setPhotoUser(listComments.get(index).get_project().get_user().getPhotoUser());
		
   		     userComment.setPseudo_name(listComments.get(index).get_project().get_user().getPseudo_name());
   		     
   		     userComment.setSex(listComments.get(index).get_project().get_user().getSex());
   		
   		     listComments.get(index).set_project(_project);				   
		   
	   }

   		
   		return ResponseEntity.ok(listComments);  
   		
    }
   	
   	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);      
    
	   
	   
    }
   
   @PostMapping(value = "users/{token_user}/projects/{token_project}/comments/create") 
   @ResponseBody
   public ResponseEntity<commentProject>  createComment(@PathVariable String token_user, @PathVariable String token_project, @RequestBody  commentProject _comment) {
	   
	   
	   project  _project = _comment.get_project();
	   
	   user _user =  _project.get_user();
	   
	   _commentProjectRepository.save(_comment);
	   
       adminstrateur  _manager_project = new adminstrateur();  	  

	   _project.setManager_project(_manager_project);   
	  
	   
	   user creatorProject = new user();    		
		
	   creatorProject.setNom(_comment.get_project().get_user().getNom());
		
	   creatorProject.setPrenom(_comment.get_project().get_user().getPrenom());
		
	   creatorProject.setPhotoUser(_comment.get_project().get_user().getPhotoUser());
		
	   creatorProject.setPseudo_name(_comment.get_project().get_user().getPseudo_name());

	   _project.set_user(creatorProject);
	   
	   _comment.set_project(_project);
	   
	   return ResponseEntity.ok(_comment);  
     
	   
	   
    }
   
   
   @PostMapping(value = "projects/{token_project}/list_questions_rep_by_admin_for_user") 
   @ResponseBody
   public ResponseEntity<List<QuestionRepProjectByAdminForUserModel>>  getListQuestionsRepByAdminForUser( @PathVariable String token_project, @RequestBody  project _project) { 	
	   
	   
	  // System.out.println("token-object-Project="+ _project.getToken()); 
	  
	  
	  // System.out.println("@PathVariable="+  token_project); 
	  
	  user  _user = _project.get_user();
	  
	  adminstrateur  _admin = _project.getManager_project();
	    
	   
	  List<QuestionRepProjectByAdminForUserModel> listQuestRep =  _QuestionRepProjectByAdminForUserRepository.findByAdminForUser(_project.getToken(),_admin.getToken(),_user.getToken());   	
   	
   	
   	 if(listQuestRep.size()>0) { 
   		 
   		 
   		 for(int index=0;index<listQuestRep.size();index++) {
   			 
			   
   			 project _projectBdd = listQuestRep.get(index).get_project();
	          
	          /**************************************************************************/
   		
   	     	  user creatorProject = new user();    		
   		
   		      creatorProject.setNom(listQuestRep.get(index).get_project().get_user().getNom());
   		
   		      creatorProject.setPrenom(listQuestRep.get(index).get_project().get_user().getPrenom());
   		
   		      creatorProject.setPhotoUser(listQuestRep.get(index).get_project().get_user().getPhotoUser());
   		
   		      creatorProject.setPseudo_name(listQuestRep.get(index).get_project().get_user().getPseudo_name());
   		
   		     
   		
   		      _projectBdd.set_user(creatorProject);
   		      
   		      /***************************************************************************/
   		 
   		      adminstrateur  _manager_project = new adminstrateur();
   		     
   		      _manager_project.setNom(listQuestRep.get(index).get_project().getManager_project().getNom());
   	   		
   		      _manager_project.setPrenom(listQuestRep.get(index).get_project().getManager_project().getPrenom());
 		
   		      _manager_project.setPhotoUser(listQuestRep.get(index).get_project().getManager_project().getPhotoUser());
 		
   		      _manager_project.setPseudo_name(listQuestRep.get(index).get_project().getManager_project().getPseudo_name());  		      
   		      
   		      
   		      _projectBdd.setManager_project(_manager_project);	  		     
   		     
   		     
   		     /****************************************************************************/
   		
   		      listQuestRep.get(index).set_project(_projectBdd);				   
		   
	     }  		 
   		 
   		
   		return ResponseEntity.ok(listQuestRep);  
   		
     }
   	
   	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);     
     
	   
	   
    }
   
   @PostMapping(value = "admin/{token_user}/projects/{token_project}/QuestRepByProjectByAdminForUser/create") 
   @ResponseBody
   public ResponseEntity<QuestionRepProjectByAdminForUserModel>  createQuestRepByProjectByAdminForUser(@PathVariable String token_user, @PathVariable String token_project , @RequestBody   QuestionRepProjectByAdminForUserModel _QuestRep) {  	   
	 
	   QuestionRepProjectByAdminForUserModel _QuestRepBdd =  _QuestionRepProjectByAdminForUserRepository.save(_QuestRep);   
	   
  /**************************************************************************************/
	   
	   messageModel _newMessage = new messageModel();
	   
	   String nomUserDest = _QuestRep.get_userProjectDest().getNom() + "." +  _QuestRep.get_userProjectDest().getPrenom();
	   
	   _newMessage.set_nomUserDest(nomUserDest);
	   
	   String nomUserExp = _QuestRep.get_userAdminExp().getNom() + "." + _QuestRep.get_userAdminExp().getPrenom();
	   
	   _newMessage.set_nomUserExp(nomUserExp);
	   
	   String photoUserDest = _QuestRep.get_userProjectDest().getPhotoUser();
	   
	   _newMessage.set_photoUserDest(photoUserDest);
	   
	   String photoUserExp = _QuestRep.get_userAdminExp().getPhotoUser();
	   
	   _newMessage.set_photoUserExp(photoUserExp);
	   
	   String tokenUserExp = _QuestRep.get_userAdminExp().getToken();
	   
	   _newMessage.set_tokenUserExp(tokenUserExp);
	   
       String tokenUserDest = _QuestRep.get_userProjectDest().getToken();
	   
	   _newMessage.set_tokenUserDest(tokenUserDest);
	   
	   String tokenProject = _QuestRep.get_project().getToken();
	   
	   _newMessage.set_tokenProject(tokenProject);
	   
	   _newMessage.setStatutDest("user");
	   
	   _newMessage.setStatutExp("manager");
	   
	   String  tokenMessage = methodesUtils.generateAlphanumericStringToken(); 
	   
	   _newMessage.setToken(tokenMessage);
	   
	   _newMessage.setBodyMessage(_QuestRep.getBodyAide());
	   
	   _newMessage.setDateCreated(_QuestRep.getDateCreated());
	   
	   _newMessage.setTimestamp(_QuestRep.getTimestamp());   
	  
	   
	   _messageRepository.save(_newMessage);
	   
	   
	   
	   /************************************************************************************/
	  
	   
	   return ResponseEntity.ok(_QuestRepBdd); 	   
	   
    }
   
   
   @PostMapping(value = "/projects/{token}/list_questions_rep_by_user_for_admin") 
   @ResponseBody
   public ResponseEntity<List<QuestionRepProjectByUserForAdminModel>>  getListQuestionsRepByUserForAdmin(@PathVariable String token , @RequestBody  project _project) { 	
	   
	   
	  System.out.println("token-object-Project="+ _project.getToken()); 
	  
	  
	  System.out.println("@PathVariable="+  token); 
	  
	  user  _user = _project.get_user();
	  
	  adminstrateur  _admin = _project.getManager_project();
	    
	   
	  List<QuestionRepProjectByUserForAdminModel> listQuestRep =  _QuestionRepProjectByUserForAdminRepository.findByUserForAdmin(_project.getToken(),_admin.getToken(),_user.getToken());   	
   	
   	
   	 if(listQuestRep.size()>0) { 
   		 
   		 for(int index=0;index<listQuestRep.size();index++) {
   			 
			   
   			 project _projectBdd = listQuestRep.get(index).get_project();
	          
	          /**************************************************************************/
   		
   	     	  user creatorProject = new user();    		
   		
   		      creatorProject.setNom(listQuestRep.get(index).get_project().get_user().getNom());
   		
   		      creatorProject.setPrenom(listQuestRep.get(index).get_project().get_user().getPrenom());
   		
   		      creatorProject.setPhotoUser(listQuestRep.get(index).get_project().get_user().getPhotoUser());
   		
   		      creatorProject.setPseudo_name(listQuestRep.get(index).get_project().get_user().getPseudo_name());
   		
   		     
   		
   		      _projectBdd.set_user(creatorProject);
   		      
   		      /***************************************************************************/
   		 
   		      adminstrateur  _manager_project = new adminstrateur();
   		     
   		      _manager_project.setNom(listQuestRep.get(index).get_project().getManager_project().getNom());
   	   		
   		      _manager_project.setPrenom(listQuestRep.get(index).get_project().getManager_project().getPrenom());
 		
   		      _manager_project.setPhotoUser(listQuestRep.get(index).get_project().getManager_project().getPhotoUser());
 		
   		      _manager_project.setPseudo_name(listQuestRep.get(index).get_project().getManager_project().getPseudo_name());  		      
   		      
   		      
   		      _projectBdd.setManager_project(_manager_project);	  		     
   		     
   		     
   		     /****************************************************************************/
   		
   		      listQuestRep.get(index).set_project(_projectBdd);	
   		      
   		      listQuestRep.get(index).set_userAdminDest(_manager_project);
   		      
   		      listQuestRep.get(index).set_userProjectExp(creatorProject);
   		      
   		      
   		      /****************************************************************************/
	     } 
   		
   		return ResponseEntity.ok(listQuestRep);  
   		
   	}
   	
   	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);       
      
	   
	   
    }
   
   @PostMapping(value = "/users/{token_user}/projects/{token_project}/QuestRepByProjectByUserForAdmin/create") 
   @ResponseBody
   public ResponseEntity<QuestionRepProjectByUserForAdminModel>  createQuestRepByProjectByUserForAdmin(@PathVariable String token_user, @PathVariable String token_project , @RequestBody   QuestionRepProjectByUserForAdminModel _QuestRep) {  	   
	 
	 
	   
	   QuestionRepProjectByUserForAdminModel _QuestRepBdd = _QuestionRepProjectByUserForAdminRepository.save(_QuestRep);
	   
	  
	   
    /**************************************************************************************/
	   
	   messageModel _newMessage = new messageModel();
	   
	   String nomUserDest = _QuestRep.get_userAdminDest().getNom() + "." +  _QuestRep.get_userAdminDest().getPrenom();
	   
	   _newMessage.set_nomUserDest(nomUserDest);
	   
	   String nomUserExp = _QuestRep.get_userProjectExp().getNom() + "." + _QuestRep.get_userProjectExp().getPrenom();
	   
	   _newMessage.set_nomUserExp(nomUserExp);
	   
	   String photoUserDest = _QuestRep.get_userAdminDest().getPhotoUser();
	   
	   _newMessage.set_photoUserDest(photoUserDest);
	   
	   String photoUserExp = _QuestRep.get_userProjectExp().getPhotoUser();
	   
	   _newMessage.set_photoUserExp(photoUserExp);
	   
	   String tokenUserExp = _QuestRep.get_userProjectExp().getToken();
	   
	   _newMessage.set_tokenUserExp(tokenUserExp);
	   
       String tokenUserDest = _QuestRep.get_userAdminDest().getToken();
	   
	   _newMessage.set_tokenUserDest(tokenUserDest);
	   
	   String tokenProject = _QuestRep.get_project().getToken();
	   
	   _newMessage.set_tokenProject(tokenProject);
	   
	   _newMessage.setStatutDest("manager");
	   
	   _newMessage.setStatutExp("user");
	   
	   String  tokenMessage = methodesUtils.generateAlphanumericStringToken(); 
	   
	   _newMessage.setToken(tokenMessage);
	   
	   _newMessage.setBodyMessage(_QuestRep.getBodyAide());
	   
	   _newMessage.setDateCreated(_QuestRep.getDateCreated());
	   
	   _newMessage.setTimestamp(_QuestRep.getTimestamp());   
	  
	   
	   _messageRepository.save(_newMessage);
	   
	   
	   
	   /************************************************************************************/
	   
        adminstrateur  _manager_project = new adminstrateur();   
	   
	   _manager_project.setNom(_QuestRep.get_project().getManager_project().getNom());
	   		
       _manager_project.setPrenom(_QuestRep.get_project().getManager_project().getPrenom());
	
	   _manager_project.setPhotoUser(_QuestRep.get_project().getManager_project().getPhotoUser());
	
	   _manager_project.setPseudo_name(_QuestRep.get_project().getManager_project().getPseudo_name());  
	   
	   _QuestRepBdd.get_project().setManager_project(_manager_project);
	   
	   _QuestRepBdd.set_userAdminDest(_manager_project);
	   
	   
	   /************************************************************************************/
	   
	   return ResponseEntity.ok(_QuestRepBdd);       
    
	   
	   
    }
   
   @PostMapping(value = "/users/{token_user}/projects/{token_project}/QuestRepByProjectByUserForUser/create") 
   @ResponseBody
   public ResponseEntity<QuestionRepProjectByUserForUserModel>  createQuestRepByProjectByUserForUser(@PathVariable String token_user, @PathVariable String token_project , @RequestBody   QuestionRepProjectByUserForUserModel _QuestRep) {  
	   
	 
	  /**************************************************************************************/
	   
	   messageModel _newMessage = new messageModel();
	   
	   String nomUserDest = _QuestRep.get_userDest().getNom() + "." + _QuestRep.get_userDest().getPrenom();
	   
	   _newMessage.set_nomUserDest(nomUserDest);
	   
	   String nomUserExp = _QuestRep.get_userExp().getNom() + "." + _QuestRep.get_userExp().getPrenom();
	   
	   _newMessage.set_nomUserExp(nomUserExp);
	   
	   String photoUserDest = _QuestRep.get_userDest().getPhotoUser();
	   
	   _newMessage.set_photoUserDest(photoUserDest);
	   
	   String photoUserExp = _QuestRep.get_userExp().getPhotoUser();
	   
	   _newMessage.set_photoUserExp(photoUserExp);
	   
	   String tokenUserExp = _QuestRep.get_userExp().getToken();
	   
	   _newMessage.set_tokenUserExp(tokenUserExp);
	   
       String tokenUserDest = _QuestRep.get_userDest().getToken();
	   
	   _newMessage.set_tokenUserDest(tokenUserDest);
	   
	   String tokenProject = _QuestRep.get_project().getToken();
	   
	   _newMessage.set_tokenProject(tokenProject);
	   
	   _newMessage.setStatutDest("user");
	   
	   _newMessage.setStatutExp("user");
	   
	   String  tokenMessage = methodesUtils.generateAlphanumericStringToken(); 
	   
	   _newMessage.setToken(tokenMessage);
	   
	   _newMessage.setBodyMessage(_QuestRep.getBodyAide());
	   
	   _newMessage.setDateCreated(_QuestRep.getDateCreated());
	   
	   _newMessage.setTimestamp(_QuestRep.getTimestamp());   
	  
	   
	   _messageRepository.save(_newMessage);
	   
	   
	   
	   /************************************************************************************/
	   
	   
	   QuestionRepProjectByUserForUserModel  _QuestRepBdd = _QuestionRepProjectByUserForUserRepository.save(_QuestRep);   
	   
       
       return ResponseEntity.ok().build();
	   
	   
    }
   
   @PostMapping(value = "/projects/{token}/list_questions_rep_by_user_for_user") 
   @ResponseBody
   public ResponseEntity<List<QuestionRepProjectByUserForUserModel>>  getListQuestionsRepByUserForUser(@PathVariable String token , @RequestBody  project _project) { 	
	   
	   
	  // System.out.println("token-object-Project="+ _project.getToken()); 
	  
	  
	  // System.out.println("@PathVariable="+  token);  
	 
	    
	   
	  List<QuestionRepProjectByUserForUserModel> listQuestRep =  _QuestionRepProjectByUserForUserRepository.findByUserForUser(_project.getToken());   	
   	
   	
   	 if(listQuestRep.size()>0) { 
   		 
   		for(int index=0;index<listQuestRep.size();index++) {
   			
   			adminstrateur  _manager_project = new adminstrateur();
   			
   			user creatorProject = new user();    		
    		
    		creatorProject.setNom(listQuestRep.get(index).get_project().get_user().getNom());
    		
    		creatorProject.setPrenom(listQuestRep.get(index).get_project().get_user().getPrenom());
    		
    		creatorProject.setPhotoUser(listQuestRep.get(index).get_project().get_user().getPhotoUser());
    		
    		creatorProject.setPseudo_name(listQuestRep.get(index).get_project().get_user().getPseudo_name());
    		
    		project _projectBdd = listQuestRep.get(index).get_project();
    		
    		_projectBdd.set_user(creatorProject);
    		
    		_projectBdd.setManager_project(_manager_project);	    		
    		
    		listQuestRep.get(index).set_project(_project);
    		
    		/*********************************************************************/
    		
    		

    		
    		/**********************************************************************/ 
   			
   			
   		}
   		
   		return ResponseEntity.ok(listQuestRep);  
   		
   	}
   	
   	 return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
       
      //  return ResponseEntity.ok().build();
	   
	   
    }
   
   @PostMapping(value = "/projects/{token}/investisseurs_project") 
   @ResponseBody
   public ResponseEntity<List<investisseursProjectModel>>  getListInvestisseursProject(@PathVariable String token , @RequestBody  project _project) { 	
	   
	   
	  // System.out.println("token-object-Project="+ _project.getToken()); 
	  
	  
	  // System.out.println("@PathVariable="+  token);  
	   
	   
	 
	    
	   
	  List<investisseursProjectModel> listInvestisseursProject =  _investisseursProjectRepository.findBy_project(_project);   	
   	
   	
   	 if(listInvestisseursProject.size()>0) {    		 
   		
   		
   		return ResponseEntity.ok(listInvestisseursProject);  
   		
   	}
   	
   	 return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
       
      //  return ResponseEntity.ok().build();
	   
	   
    }
   
   @PostMapping(value = "/projects/{_tokenProject}/investisseurs_project/check_invest_project") 
   @ResponseBody
   public ResponseEntity<Optional<investisseursProjectModel>>  check_invest_project(@PathVariable String _tokenProject , @RequestBody  user _user) { 	
	   
	   
	  System.out.println("token-object-user="+ _user.getToken()); 
	  
	  
	  System.out.println("@PathVariable="+  _tokenProject);  
	  
	  String token_project = _tokenProject; 
	  
	  String tokenUser = _user.getToken();
	 
	    
	   
	  Optional<investisseursProjectModel> InvestisseursProject =  _investisseursProjectRepository.check_invest_project(token_project,tokenUser);   	
   	
   	
   	 if(InvestisseursProject.isPresent()) { 
   		
   		return ResponseEntity.ok(InvestisseursProject);  
   		
   	}
   	
   	 return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
       
      //  return ResponseEntity.ok().build();
	   
	   
    }
   
   @PostMapping(value = "/projects/{token}/investisseurs_project/createDemandeInvest") 
   @ResponseBody
   public ResponseEntity<investisseursProjectModel>  createDemandeInvestProject(@PathVariable String token , @RequestBody   investisseursProjectModel _demandeInvestProject) {  	   
	 
	   String  newToken = methodesUtils.generateAlphanumericStringToken();    
	   
	   _demandeInvestProject.setToken(newToken);
	   
	   statutDemandeInvest  _statutDemandeInvest = statutDemandeInvest.ATTENTE;
	   
	   _demandeInvestProject.setStatutDemande(_statutDemandeInvest);
	   
	   investisseursProjectModel  _demandeInvestProjectBdd = _investisseursProjectRepository.save(_demandeInvestProject);
	   
	    adminstrateur  _manager_project = new adminstrateur();
		
		user creatorProject = new user();    		
		
		creatorProject.setNom(_demandeInvestProjectBdd.get_project().get_user().getNom());
		
		creatorProject.setPrenom(_demandeInvestProjectBdd.get_project().get_user().getPrenom());
		
		creatorProject.setPhotoUser(_demandeInvestProjectBdd.get_project().get_user().getPhotoUser());
		
		creatorProject.setPseudo_name(_demandeInvestProjectBdd.get_project().get_user().getPseudo_name());
		
		project _project = _demandeInvestProjectBdd.get_project();
		
		_project.set_user(creatorProject);
		
		_project.setManager_project(_manager_project);	    		
		
		_demandeInvestProjectBdd.set_project(_project);	
	   
	   return ResponseEntity.ok(_demandeInvestProjectBdd);       
      
	   
	   
    }
   
   @PutMapping(value = "/projects/{token}/investisseurs_project/{token_demande}/updateDemandeInvest") 
   @ResponseBody
   public ResponseEntity<investisseursProjectModel>  updateDemandeInvestProject(@PathVariable String token , @RequestBody   investisseursProjectModel _demandeInvestProject) {  
	   
	   Optional<investisseursProjectModel>  demandeInvestProjectBdd = _investisseursProjectRepository.findById(_demandeInvestProject.getId());   	 
	  	 
	  	 if(demandeInvestProjectBdd.isPresent()) { 
	  		 
	  		investisseursProjectModel demandeInvestProjectBddUpdate = demandeInvestProjectBdd.get();
	  		 
	  		demandeInvestProjectBddUpdate.setStatutDemande(_demandeInvestProject.getStatutDemande());	
	  		
	  		demandeInvestProjectBddUpdate.setDate_update(_demandeInvestProject.getDate_update());
	  		
	  		investisseursProjectModel demandeInvestProjectBddUpdateBdd = _investisseursProjectRepository.save(demandeInvestProjectBddUpdate);
	  		
	  		
	  	   adminstrateur  _manager_project = new adminstrateur();
			
			user creatorProject = new user();    		
			
			creatorProject.setNom(demandeInvestProjectBddUpdateBdd.get_project().get_user().getNom());
			
			creatorProject.setPrenom(demandeInvestProjectBddUpdateBdd.get_project().get_user().getPrenom());
			
			creatorProject.setPhotoUser(demandeInvestProjectBddUpdateBdd.get_project().get_user().getPhotoUser());
			
			creatorProject.setPseudo_name(demandeInvestProjectBddUpdateBdd.get_project().get_user().getPseudo_name());
			
			project _project = demandeInvestProjectBddUpdateBdd.get_project();
			
			_project.set_user(creatorProject);
			
			_project.setManager_project(_manager_project);	    		
			
			demandeInvestProjectBddUpdateBdd.set_project(_project);	  			  		
	  		 
	  	    return new ResponseEntity<>(demandeInvestProjectBddUpdateBdd, HttpStatus.OK);
	  		 
	  	 }else {
	  		 
	  		 System.out.println("non-demande exist"); 
	  		 
	  		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  	 }  
	   
	 
       
      // return ResponseEntity.ok().build();
	   
	   
    }
   
   @PostMapping(value = "/projects/{token}/fonds_invest_project/createFondsInvestProject") 
   @ResponseBody
   public ResponseEntity<fondInvestorModel>  createFondsInvestProject(@PathVariable String token , @RequestBody   fondInvestorModel  _newFondsInvestProject) {  	   
	 
	   String  newToken = methodesUtils.generateAlphanumericStringToken();  
	   
	   System.out.println("_newFondsInvestProject="+ _newFondsInvestProject.toString()); 
	   
	   fondInvestorModel  newFondInvestorBdd = new fondInvestorModel();
	   
	   newFondInvestorBdd.setToken(newToken);   
	   
	   newFondInvestorBdd.set_investisseurProject(_newFondsInvestProject.get_investisseurProject());
	   
	   newFondInvestorBdd.set_user(_newFondsInvestProject.get_user());	   
	   
	   newFondInvestorBdd.set_project(_newFondsInvestProject.get_project());
	   
	   newFondInvestorBdd.setAmount(_newFondsInvestProject.getAmount());
	   
	   newFondInvestorBdd.setTimestamp(_newFondsInvestProject.getTimestamp());	   
	   
	   newFondInvestorBdd.setDateCreated(_newFondsInvestProject.getDateCreated());
	   
	   /***************************** mettre a jour le capital collecte de projet ********************************************/
	   
       Optional<project>  _project = _projectRepository.findByToken(token);
	   
	   if(_project.isPresent()) {
		   
		   System.out.println("project exist"); 
		   
		  project  _projectBdd = _project.get();
		   
		  int totalFons = _projectBdd.getTotal_fonds();
		   
		  totalFons = (int) (totalFons + _newFondsInvestProject.getAmount());		
		  
		  _projectBdd.setTotal_fonds(totalFons);
		   
		   _projectRepository.save(_projectBdd); 
		   
	   }
	   
	   
	   
	   
	   
	   
	   /*************************************************************************/
	   
	   
	   return ResponseEntity.ok(_fondInvestorRepository.save(newFondInvestorBdd)); 
       
      
	   
	   
    }
   
   @PostMapping(value = "/projects/{token}/fonds_invest_project") 
   @ResponseBody
   public ResponseEntity<List<fondInvestorModel>>  getListFondInvestorProject(@PathVariable String token , @RequestBody  project _project) { 	
	   
	   
		  System.out.println("token-object-Project="+ _project.getToken()); 
		  
		  
		  System.out.println("@PathVariable="+  token);  
		 
		    
		   
		  List<fondInvestorModel> listFondInvestorProject =  _fondInvestorRepository.findBy_project(_project);   	
	   	
	   	
	   	 if(listFondInvestorProject.size()>0) { 
	   		
	   		return ResponseEntity.ok(listFondInvestorProject);  
	   		
	   	}
	   	
	   	 return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
	       
	     
		   
		   
	}
   
   @PostMapping(value = "users/{token_user}/projects/{token_project}/favoris_projects/create") 
   @ResponseBody
   public ResponseEntity<?>  createFavorisProjectByUser(@PathVariable String token_user, @PathVariable String token_project , @RequestBody   favorisProjectUserModel  _newFavorisProject) {  	   
	 
	   String  newToken = methodesUtils.generateAlphanumericStringToken();   	 
	   
	   _newFavorisProject.setToken(newToken);  
	   
	   favorisProjectUserModel  FavorisProjectBdd = _favorisProjectUserRepository.save(_newFavorisProject);
	   
	  // return ResponseEntity.ok(); 
	   
	   return ResponseEntity.ok().build();
       
     
	   
	   
    }
   
   @PostMapping(value = "users/{token_user}/projects/{token_project}/favoris_projects/delete") 
   @ResponseBody
   public ResponseEntity<?>  deleteFavorisProjectByUser(@PathVariable String token_user, @PathVariable String token_project , @RequestBody   favorisProjectUserModel  _FavorisProject) {  	   
	 
	  user _user = _FavorisProject.get_user(); 
	  
	  project _project = _FavorisProject.get_project();
	  
	  // System.out.println("token-user-favoris-project = "+_user.getToken()); 
	  
	  // System.out.println("token-project-favoris-project = "+_project.getToken());
	  
	  _favorisProjectUserRepository.deleteFavorisProject(_user.getToken(),_project.getToken());  	  
       
      return ResponseEntity.ok().build();
	    
	   
    }
   
   @PostMapping(value = "users/{token_user}/projects/{token_project}/checkFavorisProjects") 
   @ResponseBody
   public ResponseEntity<List<favorisProjectUserModel>>  checkFavorisProjectsByUser(@PathVariable String token_user, @PathVariable String token_project , @RequestBody  user _user) {   
	  
	    
	   
	   List<favorisProjectUserModel> listFavorisProjectBdd =   _favorisProjectUserRepository.findCheckFavorisProject(_user.getToken(),token_project);   	
	   
	   if(listFavorisProjectBdd.size()>0) { 
		   
		   
		   for(int index=0;index<listFavorisProjectBdd.size();index++) {
			   
			   
			    adminstrateur  _manager_project = new adminstrateur();
	    		
	    		user creatorProject = new user();    		
	    		
	    		creatorProject.setNom(listFavorisProjectBdd.get(index).get_project().get_user().getNom());
	    		
	    		creatorProject.setPrenom(listFavorisProjectBdd.get(index).get_project().get_user().getPrenom());
	    		
	    		creatorProject.setPhotoUser(listFavorisProjectBdd.get(index).get_project().get_user().getPhotoUser());
	    		
	    		creatorProject.setPseudo_name(listFavorisProjectBdd.get(index).get_project().get_user().getPseudo_name());
	    		
	    		project _project = listFavorisProjectBdd.get(index).get_project();
	    		
	    		_project.set_user(creatorProject);
	    		
	    		_project.setManager_project(_manager_project);	    		
	    		
	    		listFavorisProjectBdd.get(index).set_project(_project);				   
			   
		   }
	  		
	  		 
		   return ResponseEntity.ok(listFavorisProjectBdd);  
	  		 
	  	 }else {
	  		 
	  		 System.out.println("non-userbdd exist"); 
	  		 
	  		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  	 }        
    
	   
	   
    }
   
   @PostMapping(value = "users/{token_user}/projects/list_favoris_projects") 
   @ResponseBody
   public  ResponseEntity<List<favorisProjectUserModel>>   listFavorisProjectByUser(@PathVariable String token_user , @RequestBody   user _user) {  	 
	  
	   List<favorisProjectUserModel> listFavorisProjectBdd = _favorisProjectUserRepository.findAllFavorisProjectByUser(_user.getToken());  	  
       
	  if(listFavorisProjectBdd.size()>0) { 	   
		  
		  for(int index=0;index<listFavorisProjectBdd.size();index++) {
			  
			  
			  adminstrateur  _manager_project = new adminstrateur();
	    		
	    		user creatorProject = new user();    		
	    		
	    		creatorProject.setNom(listFavorisProjectBdd.get(index).get_user().getNom());
	    		
	    		creatorProject.setPrenom(listFavorisProjectBdd.get(index).get_user().getPrenom());
	    		
	    		creatorProject.setPhotoUser(listFavorisProjectBdd.get(index).get_user().getPhotoUser());
	    		
	    		creatorProject.setPseudo_name(listFavorisProjectBdd.get(index).get_user().getPseudo_name());
	    		
	    		project _project = listFavorisProjectBdd.get(index).get_project();
	    		
	    		_project.set_user(creatorProject);
	    		
	    		_project.setManager_project(_manager_project);	    		
	    		
	    		listFavorisProjectBdd.get(index).set_project(_project);				  
			  
			  
		  }
	  		
	  		 
		   return ResponseEntity.ok(listFavorisProjectBdd);  
	  		 
	  }else {
	  		 
	  		 System.out.println("non-userbdd exist"); 
	  		 
	  		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }  
	    
	   
    }
   
   @PostMapping(value = "users/{token_user}/projects/{token_project}/checkHeartProject") 
   @ResponseBody
   public ResponseEntity<List<heartProjectModel>>  checkHeartProjectsByUser(@PathVariable String token_user ,@PathVariable String token_project , @RequestBody  user _user) {   
	  
	    
	   
	   List<heartProjectModel> listHeartProjectBdd =   _heartsProjectRepository.findCheckHeartProject(_user.getToken(),token_project);   	
	   
	   if(listHeartProjectBdd.size()>0) { 	
		   
		   
		   for(int index=0;index<listHeartProjectBdd.size();index++) {
			   
			   
			    adminstrateur  _manager_project = new adminstrateur();
	    		
	    		user creatorProject = new user();    		
	    		
	    		creatorProject.setNom(listHeartProjectBdd.get(index).get_project().get_user().getNom());
	    		
	    		creatorProject.setPrenom(listHeartProjectBdd.get(index).get_project().get_user().getPrenom());
	    		
	    		creatorProject.setPhotoUser(listHeartProjectBdd.get(index).get_project().get_user().getPhotoUser());
	    		
	    		creatorProject.setPseudo_name(listHeartProjectBdd.get(index).get_project().get_user().getPseudo_name());
	    		
	    		project _project = listHeartProjectBdd.get(index).get_project();
	    		
	    		_project.set_user(creatorProject);
	    		
	    		_project.setManager_project(_manager_project);	    		
	    		
	    		listHeartProjectBdd.get(index).set_project(_project);				   
			   
		   }
	  		 
		   return ResponseEntity.ok(listHeartProjectBdd);  
	  		 
	  	 }else {
	  		 
	  		 // System.out.println("non-userbdd exist"); 
	  		 
	  		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  	 }  
       
      //  return ResponseEntity.ok().build();
	   
	   
    }
   
   @PostMapping(value = "user/projects/{token}/statis_Heart_project_month/{year}/{month}") 
   @ResponseBody
   public ResponseEntity<List<StatistiquesChartsHeartsProjectModel>>  statistiques_hearts_project_month(@PathVariable String token , @PathVariable int year, @PathVariable int month,  @RequestBody  user _user) {	
	   
	   
	   List<StatistiquesChartsHeartsProjectModel> listStatistiquesHeartsProject =   new ArrayList<StatistiquesChartsHeartsProjectModel>(); 	
	   
	 
	   
		/************************ DATES  ***************************************/	   
	 
	  
		
       HashMap<Integer, String> nameDay = new HashMap<Integer, String>();
       
       if(month == 1 || month == 3  || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
    	   
    	     for (int i=1; i<=31; i++) {
    	    	 
    	    	 nameDay.put(i, "Jour-"+i);     	    	 
    	    	
    	    	 
    	    	 // System.out.println("***numJour  = ***" + i +"***month  = ***" + month + "***year  = ***" + year); 
    	    	 
    	    	 
    	    	 
    	     }   	   
    	   
       }
       
       if(month == 2) {
    	   
  	     for (int i=1; i<=29; i++) {
  	    	 
  	    	 nameDay.put(i, "Jour-"+i);    	
  	    	 
  	    	 // System.out.println("***numJour  = ***" + i +"***month  = ***" + month + "***year  = ***" + year); 
  	    	 
  	    }  	     
    
      }  
  	     
  	   if(month == 4  || month == 6 || month == 9 || month == 11) {
    	   
    	     for (int i=1; i<=30; i++) {
    	    	 
    	    	 nameDay.put(i, "Jour-"+i);    	
    	    	 
    	    	 // System.out.println("***numJour  = ***" + i +"***month  = ***" + month + "***year  = ***" + year); 
    	    	 
  	     }   
  	   
       }
  	   
  	 for (int i=1; i<=nameDay.size(); i++) {
  		 
  		 
  		 System.out.println("***index = ***" + i  + "***jour = ***" + nameDay.get(i)  + "***month  = ***" + month + "***year  = ***" + year);  		
  		 
  		StatistiquesChartsHeartsProjectModel _statistiquesHeart_project = new StatistiquesChartsHeartsProjectModel();
  		
  	    //	_statistiquesHeart_project.setMonth(nameMonth.get(month) + '-'+ year);
  		
  		_statistiquesHeart_project.setYear(year);
  		
  		_statistiquesHeart_project.setDay(nameDay.get(i));
  		
  		int _nbrHeartsProject =  _heartsProjectRepository.countHeartProjectByMonthANDYearByDays(i, month, year, token);   
  		
	   _statistiquesHeart_project.setNbrHearts(_nbrHeartsProject);
		
		listStatistiquesHeartsProject.add(_statistiquesHeart_project);
		
		_statistiquesHeart_project =null; 
  		 
  		 
  	 }       

 	  
 	 return ResponseEntity.ok(listStatistiquesHeartsProject);
	   
	   
   }
   
   
   @PostMapping(value = "user/projects/{token}/statis_Vue_project_month/{year}/{month}") 
   @ResponseBody
   public ResponseEntity<List<StatistiquesChartsVueProjectModel>>  statistiques_vues_project_month(@PathVariable String token , @PathVariable int year, @PathVariable int month,  @RequestBody  user _user) {	
	   
	   
	   List<StatistiquesChartsVueProjectModel> listStatistiquesVuesProject =   new ArrayList<StatistiquesChartsVueProjectModel>(); 	
	   
	 
	   
		/************************ DATES  ***************************************/	   
	 
	  
		
       HashMap<Integer, String> nameDay = new HashMap<Integer, String>();
       
       if(month == 1 || month == 3  || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
    	   
    	     for (int i=1; i<=31; i++) {
    	    	 
    	    	 nameDay.put(i, "Jour-"+i);     	    	 
    	    	
    	    	 
    	    	 // System.out.println("***numJour  = ***" + i +"***month  = ***" + month + "***year  = ***" + year); 
    	    	 
    	    	 
    	    	 
    	     }   	   
    	   
       }
       
       if(month == 2) {
    	   
  	     for (int i=1; i<=29; i++) {
  	    	 
  	    	 nameDay.put(i, "Jour-"+i);    	
  	    	 
  	    	 // System.out.println("***numJour  = ***" + i +"***month  = ***" + month + "***year  = ***" + year); 
  	    	 
  	    }  	     
    
      }  
  	     
  	   if(month == 4  || month == 6 || month == 9 || month == 11) {
    	   
    	     for (int i=1; i<=30; i++) {
    	    	 
    	    	 nameDay.put(i, "Jour-"+i);    	
    	    	 
    	    	 // System.out.println("***numJour  = ***" + i +"***month  = ***" + month + "***year  = ***" + year); 
    	    	 
  	     }   
  	   
       }
  	   
  	 for (int i=1; i<=nameDay.size(); i++) {
  		 
  		 
  		// System.out.println("***jour = ***" + i  + "***month  = ***" + month + "***year  = ***" + year);  		
  		 
  		StatistiquesChartsVueProjectModel _statistiquesVue_project = new StatistiquesChartsVueProjectModel();
  		
  	    //	_statistiquesHeart_project.setMonth(nameMonth.get(month) + '-'+ year);
  		
  		_statistiquesVue_project.setYear(year);
  		
  		_statistiquesVue_project.setDay(nameDay.get(i));
  		
  		int _nbrVuesProject =  _vueProjectRepository.countVuesProjectByMonthANDYearByDays(i, month, year, token);   
  		
  		_statistiquesVue_project.setNbrVues(_nbrVuesProject);
		
  		listStatistiquesVuesProject.add(_statistiquesVue_project);
		
  		_statistiquesVue_project =null; 
  		 
  		 
  	 }       

 	  
 	 return ResponseEntity.ok(listStatistiquesVuesProject);
	   
	   
   }
   
   @PostMapping(value = "user/projects/{token}/statis_Like_project_month/{year}/{month}") 
   @ResponseBody
   public ResponseEntity<List<StatistiquesChartsLikeProjectModel>>  statistiques_Like_project_month(@PathVariable String token , @PathVariable int year, @PathVariable int month,  @RequestBody  user _user) {	
	   
	   
	   List<StatistiquesChartsLikeProjectModel> listStatistiquesLikesProject =   new ArrayList<StatistiquesChartsLikeProjectModel>(); 	
	   
	 
	   
		/************************ DATES  ***************************************/	   
	 
	  
		
       HashMap<Integer, String> nameDay = new HashMap<Integer, String>();
       
       if(month == 1 || month == 3  || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
    	   
    	     for (int i=1; i<=31; i++) {
    	    	 
    	    	 nameDay.put(i, "Jour-"+i);     	    	 
    	    	
    	    	 
    	    	 // System.out.println("***numJour  = ***" + i +"***month  = ***" + month + "***year  = ***" + year); 
    	    	 
    	    	 
    	    	 
    	     }   	   
    	   
       }
       
       if(month == 2) {
    	   
  	     for (int i=1; i<=29; i++) {
  	    	 
  	    	 nameDay.put(i, "Jour-"+i);    	
  	    	 
  	    	 // System.out.println("***numJour  = ***" + i +"***month  = ***" + month + "***year  = ***" + year); 
  	    	 
  	    }  	     
    
      }  
  	     
  	   if(month == 4  || month == 6 || month == 9 || month == 11) {
    	   
    	     for (int i=1; i<=30; i++) {
    	    	 
    	    	 nameDay.put(i, "Jour-"+i);    	
    	    	 
    	    	 // System.out.println("***numJour  = ***" + i +"***month  = ***" + month + "***year  = ***" + year); 
    	    	 
  	     }   
  	   
       }
  	   
  	 for (int i=1; i<=nameDay.size(); i++) {
  		 
  		 
  		// System.out.println("***jour = ***" + i  + "***month  = ***" + month + "***year  = ***" + year);  		
  		 
  		StatistiquesChartsLikeProjectModel _statistiquesLike_project = new StatistiquesChartsLikeProjectModel();
  		
  	    //	_statistiquesHeart_project.setMonth(nameMonth.get(month) + '-'+ year);
  		
  		_statistiquesLike_project.setYear(year);
  		
  		_statistiquesLike_project.setDay(nameDay.get(i));
  		
  		int _nbrLikesProject =  _likeDislikeProjectRepository.countLikeProjectByMonthANDYearByDays(i, month, year, token);   
  		
  		_statistiquesLike_project.setNbrLikes( _nbrLikesProject);
		
  		listStatistiquesLikesProject.add(_statistiquesLike_project);
		
  		_statistiquesLike_project =null; 
  		 
  		 
  	 }       

 	  
 	 return ResponseEntity.ok(listStatistiquesLikesProject);
	   
	   
   }
   
   @PostMapping(value = "user/projects/{token}/statis_Dislike_project_month/{year}/{month}") 
   @ResponseBody
   public ResponseEntity<List<StatistiquesChartsDislikeProjectModel>>  statistiques_Dislike_project_month(@PathVariable String token , @PathVariable int year, @PathVariable int month,  @RequestBody  user _user) {	
	   
	   
	   List<StatistiquesChartsDislikeProjectModel> listStatistiquesDislikesProject =   new ArrayList<StatistiquesChartsDislikeProjectModel>(); 	
	   
	 
	   
		/************************ DATES  ***************************************/	   
	 
	  
		
       HashMap<Integer, String> nameDay = new HashMap<Integer, String>();
       
       if(month == 1 || month == 3  || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
    	   
    	     for (int i=1; i<=31; i++) {
    	    	 
    	    	 nameDay.put(i, "Jour-"+i);     	    	 
    	    	
    	    	 
    	    	 // System.out.println("***numJour  = ***" + i +"***month  = ***" + month + "***year  = ***" + year); 
    	    	 
    	    	 
    	    	 
    	     }   	   
    	   
       }
       
       if(month == 2) {
    	   
  	     for (int i=1; i<=29; i++) {
  	    	 
  	    	 nameDay.put(i, "Jour-"+i);    	
  	    	 
  	    	 // System.out.println("***numJour  = ***" + i +"***month  = ***" + month + "***year  = ***" + year); 
  	    	 
  	    }  	     
    
      }  
  	     
  	   if(month == 4  || month == 6 || month == 9 || month == 11) {
    	   
    	     for (int i=1; i<=30; i++) {
    	    	 
    	    	 nameDay.put(i, "Jour-"+i);    	
    	    	 
    	    	 // System.out.println("***numJour  = ***" + i +"***month  = ***" + month + "***year  = ***" + year); 
    	    	 
  	     }   
  	   
       }
  	   
  	 for (int i=1; i<=nameDay.size(); i++) {
  		 
  		 
  		// System.out.println("***jour = ***" + i  + "***month  = ***" + month + "***year  = ***" + year);  		
  		 
  		StatistiquesChartsDislikeProjectModel _statistiquesDislike_project = new StatistiquesChartsDislikeProjectModel();
  		
  	    //	_statistiquesHeart_project.setMonth(nameMonth.get(month) + '-'+ year);
  		
  		_statistiquesDislike_project.setYear(year);
  		
  		_statistiquesDislike_project.setDay(nameDay.get(i));
  		
  		int _nbrDislikesProject =  _likeDislikeProjectRepository.countDislikeProjectByMonthANDYearByDays(i, month, year, token);   
  		
  		_statistiquesDislike_project.setNbrDislikes( _nbrDislikesProject);
		
  		listStatistiquesDislikesProject.add(_statistiquesDislike_project);
		
  		_statistiquesDislike_project =null; 
  		 
  		 
  	 }       

 	  
 	 return ResponseEntity.ok(listStatistiquesDislikesProject);
	   
	   
   }
   
   
   
   
   @PostMapping(value = "user/projects/{token}/statis_Heart_project_mensuel") 
   @ResponseBody
   public ResponseEntity<List<StatistiquesChartsHeartsProjectModel>>  statistiques_hearts_project(@PathVariable String token , @RequestBody  user _user) {	
	   
	   
	   List<StatistiquesChartsHeartsProjectModel> listStatistiquesHeartsProject =   new ArrayList<StatistiquesChartsHeartsProjectModel>(); 	
	   
		/************************ DATES  ***************************************/
		
       HashMap<Integer, String> nameMonth = new HashMap<Integer, String>();
       
       nameMonth.put(1, "Janv");
       
       nameMonth.put(2, "Fev");
       
       nameMonth.put(3, "Mars");
       
       nameMonth.put(4, "Avril");
       
       nameMonth.put(5, "Mai");
       
       nameMonth.put(6, "Juin");
       
       nameMonth.put(7, "Juil");
       
       nameMonth.put(8, "Aout");
       
       nameMonth.put(9, "Sept");
       
       nameMonth.put(10, "Oct");
       
       nameMonth.put(11, "Nov");
       
       nameMonth.put(12, "Dec");
       
	   Calendar calendrier;
 	    
 	   calendrier = Calendar.getInstance();
 		
 	   int monthCurrent = calendrier.get(Calendar.MONTH);
 	   
 	   int yearCurrent  =  calendrier.get(Calendar.YEAR); 
 	   
 	   int month;
 	   
 	   int year;
 	   
 	   String numMonth;	   

 	   
 	   int  _nbrHeartsProject;
 	   
 	  monthCurrent = monthCurrent +1 ;
 	   
 	//  System.out.println("***month = = ***" + nameMonth.get(monthCurrent)  + "***year  = ***" + yearCurrent);
 	  
 	  for (int i=0;i<12;i++) {  
 		 
 		
 		 
 		 if(monthCurrent-i<=0) {
 			 
 			 month = 12+(monthCurrent-i);
 			 
 		     year = yearCurrent-1;
 			 
 		 }else {
 			 
 			 month = monthCurrent-i;
 			 
	 		 year = yearCurrent;
 			 
 		 }
 		 
 		 if(month>=1 && month<=9) {
 			 
 			numMonth = "0"+ month;
 			 
 		 }else {
 			 
 			numMonth = Integer.toString(month);
 			 
 		 }
 		 
 		StatistiquesChartsHeartsProjectModel _statistiquesHeart_project = new StatistiquesChartsHeartsProjectModel();
 		
 		_statistiquesHeart_project.setMonth(nameMonth.get(month) + '-'+ year);
 		
 		_statistiquesHeart_project.setYear(year);
 		
 		_nbrHeartsProject =  _heartsProjectRepository.countHeartProjectByMonthANDYear(token, numMonth, year);   
 		
 		_statistiquesHeart_project.setNbrHearts(_nbrHeartsProject);
 		
 		listStatistiquesHeartsProject.add(_statistiquesHeart_project);
 		
 		_statistiquesHeart_project =null;
 		 
 		 System.out.println("month =" + nameMonth.get(month) + "/year  =" + year + "/numMth  =" + numMonth);
 		  
 	  }
 	  
 	 return ResponseEntity.ok(listStatistiquesHeartsProject);
	   
	   
   }
   
   @PostMapping(value = "user/projects/{token}/statis_Vue_project_mensuel") 
   @ResponseBody
   public ResponseEntity<List<StatistiquesChartsVueProjectModel>>  statistiques_vues_project(@PathVariable String token , @RequestBody  user _user) {	
	   
	   
	   List<StatistiquesChartsVueProjectModel> listStatistiquesVuesProject =   new ArrayList<StatistiquesChartsVueProjectModel>(); 	
	   
		/************************ DATES  ***************************************/
		
       HashMap<Integer, String> nameMonth = new HashMap<Integer, String>();
       
       nameMonth.put(1, "Janv");
       
       nameMonth.put(2, "Fev");
       
       nameMonth.put(3, "Mars");
       
       nameMonth.put(4, "Avril");
       
       nameMonth.put(5, "Mai");
       
       nameMonth.put(6, "Juin");
       
       nameMonth.put(7, "Juil");
       
       nameMonth.put(8, "Aout");
       
       nameMonth.put(9, "Sept");
       
       nameMonth.put(10, "Oct");
       
       nameMonth.put(11, "Nov");
       
       nameMonth.put(12, "Dec");
       
	   Calendar calendrier;
 	    
 	   calendrier = Calendar.getInstance();
 		
 	   int monthCurrent = calendrier.get(Calendar.MONTH);
 	   
 	   int yearCurrent  =  calendrier.get(Calendar.YEAR); 
 	   
 	   int month;
 	   
 	   int year;
 	   
 	   String numMonth;	   
 	  
 	   
 	   int  _nbrVuesProject;
 	   
 	  monthCurrent = monthCurrent +1 ;
 	   
 	//  System.out.println("***month = = ***" + nameMonth.get(monthCurrent)  + "***year  = ***" + yearCurrent);
 	  
 	  for (int i=0;i<12;i++) {  
 		 		 
 		
 		 
 		 if(monthCurrent-i<=0) {
 			 
 			 month = 12+(monthCurrent-i);
 			 
 		     year = yearCurrent-1;
 			 
 		 }else {
 			 
 			 month = monthCurrent-i;
 			 
	 		 year = yearCurrent;
 			 
 		 }
 		 
 		 if(month>=1 && month<=9) {
 			 
 			numMonth = "0"+ month;
 			 
 		 }else {
 			 
 			numMonth = Integer.toString(month);
 			 
 		 }
 		 
 		StatistiquesChartsVueProjectModel _statistiquesvue_project = new StatistiquesChartsVueProjectModel();
 		
 		_statistiquesvue_project.setMonth(nameMonth.get(month) + '-'+ year);
 		
 		_statistiquesvue_project.setYear(year);
 		
 		_nbrVuesProject =  _vueProjectRepository.countVuesProjectByMonthANDYear(token, numMonth, year);   
 		
 		_statistiquesvue_project.setNbrVues(_nbrVuesProject);
 		
 		listStatistiquesVuesProject.add(_statistiquesvue_project);
 		
 		_statistiquesvue_project =null;
 		 
 		 System.out.println("month =" + nameMonth.get(month) + "/year  =" + year + "/numMth  =" + numMonth);
 		  
 	  }
 	  
 	 return ResponseEntity.ok(listStatistiquesVuesProject);
	   
	   
   }
   
   @PostMapping(value = "user/projects/{token}/statis_Likes_project_mensuel") 
   @ResponseBody
   public ResponseEntity<List<StatistiquesChartsLikeProjectModel>>  statistiques_likes_project(@PathVariable String token , @RequestBody  user _user) {	
	   
	   
	   List<StatistiquesChartsLikeProjectModel> listStatistiquesLikesProject =   new ArrayList<StatistiquesChartsLikeProjectModel>(); 	
	   
		/************************ DATES  ***************************************/
		
       HashMap<Integer, String> nameMonth = new HashMap<Integer, String>();
       
       nameMonth.put(1, "Janv");
       
       nameMonth.put(2, "Fev");
       
       nameMonth.put(3, "Mars");
       
       nameMonth.put(4, "Avril");
       
       nameMonth.put(5, "Mai");
       
       nameMonth.put(6, "Juin");
       
       nameMonth.put(7, "Juil");
       
       nameMonth.put(8, "Aout");
       
       nameMonth.put(9, "Sept");
       
       nameMonth.put(10, "Oct");
       
       nameMonth.put(11, "Nov");
       
       nameMonth.put(12, "Dec");
       
	   Calendar calendrier;
 	    
 	   calendrier = Calendar.getInstance();
 		
 	   int monthCurrent = calendrier.get(Calendar.MONTH);
 	   
 	   int yearCurrent  =  calendrier.get(Calendar.YEAR); 
 	   
 	   int month;
 	   
 	   int year;
 	   
 	   String numMonth;	   
 	  
 	   
 	   int  _nbrLikesProject;
 	   
 	  monthCurrent = monthCurrent +1 ;
 	   
 	//  System.out.println("***month = = ***" + nameMonth.get(monthCurrent)  + "***year  = ***" + yearCurrent);
 	  
 	  for (int i=0;i<12;i++) {  
 		 		 
 		
 		 
 		 if(monthCurrent-i<=0) {
 			 
 			 month = 12+(monthCurrent-i);
 			 
 		     year = yearCurrent-1;
 			 
 		 }else {
 			 
 			 month = monthCurrent-i;
 			 
	 		 year = yearCurrent;
 			 
 		 }
 		 
 		 if(month>=1 && month<=9) {
 			 
 			numMonth = "0"+ month;
 			 
 		 }else {
 			 
 			numMonth = Integer.toString(month);
 			 
 		 }
 		 
 		StatistiquesChartsLikeProjectModel _statistiqueslike_project = new StatistiquesChartsLikeProjectModel();
 		
 		_statistiqueslike_project.setMonth(nameMonth.get(month) + '-'+ year);
 		
 		_statistiqueslike_project.setYear(year);
 		
 		_nbrLikesProject =  _likeDislikeProjectRepository.countLikesProjectByMonthANDYear(token, numMonth, year);   
 		
 		_statistiqueslike_project.setNbrLikes(_nbrLikesProject);
 		
 		listStatistiquesLikesProject.add(_statistiqueslike_project);
 		
 		_statistiqueslike_project =null;
 		 
 		 System.out.println("month =" + nameMonth.get(month) + "/year  =" + year + "/numMth  =" + numMonth);
 		  
 	  }
 	  
 	 return ResponseEntity.ok(listStatistiquesLikesProject);
	   
	   
   }
   
   @PostMapping(value = "user/projects/{token}/statis_Dislikes_project_mensuel") 
   @ResponseBody
   public ResponseEntity<List<StatistiquesChartsDislikeProjectModel>>  statistiques_dislikes_project(@PathVariable String token , @RequestBody  user _user) {	
	   
	   
	   List<StatistiquesChartsDislikeProjectModel> listStatistiquesDislikesProject =   new ArrayList<StatistiquesChartsDislikeProjectModel>(); 	
	   
		/************************ DATES  ***************************************/
		
       HashMap<Integer, String> nameMonth = new HashMap<Integer, String>();
       
       nameMonth.put(1, "Janv");
       
       nameMonth.put(2, "Fev");
       
       nameMonth.put(3, "Mars");
       
       nameMonth.put(4, "Avril");
       
       nameMonth.put(5, "Mai");
       
       nameMonth.put(6, "Juin");
       
       nameMonth.put(7, "Juil");
       
       nameMonth.put(8, "Aout");
       
       nameMonth.put(9, "Sept");
       
       nameMonth.put(10, "Oct");
       
       nameMonth.put(11, "Nov");
       
       nameMonth.put(12, "Dec");
       
	   Calendar calendrier;
 	    
 	   calendrier = Calendar.getInstance();
 		
 	   int monthCurrent = calendrier.get(Calendar.MONTH);
 	   
 	   int yearCurrent  =  calendrier.get(Calendar.YEAR); 
 	   
 	   int month;
 	   
 	   int year;
 	   
 	   String numMonth;	   
 	  
 	   
 	   int  _nbrDislikesProject;
 	   
 	  monthCurrent = monthCurrent +1 ;
 	   
 	//  System.out.println("***month = = ***" + nameMonth.get(monthCurrent)  + "***year  = ***" + yearCurrent);
 	  
 	  for (int i=0;i<12;i++) {  
 		 		 
 		
 		 
 		 if(monthCurrent-i<=0) {
 			 
 			 month = 12+(monthCurrent-i);
 			 
 		     year = yearCurrent-1;
 			 
 		 }else {
 			 
 			 month = monthCurrent-i;
 			 
	 		 year = yearCurrent;
 			 
 		 }
 		 
 		 if(month>=1 && month<=9) {
 			 
 			numMonth = "0"+ month;
 			 
 		 }else {
 			 
 			numMonth = Integer.toString(month);
 			 
 		 }
 		 
 		StatistiquesChartsDislikeProjectModel _statistiquesDislikke_project = new StatistiquesChartsDislikeProjectModel();
 		
 		_statistiquesDislikke_project.setMonth(nameMonth.get(month) + '-'+ year);
 		
 		_statistiquesDislikke_project.setYear(year);
 		
 		_nbrDislikesProject =  _likeDislikeProjectRepository.countDislikesProjectByMonthANDYear(token, numMonth, year);   
 		
 		_statistiquesDislikke_project.setNbrDislikes(_nbrDislikesProject);
 		
 		listStatistiquesDislikesProject.add(_statistiquesDislikke_project);
 		
 		_statistiquesDislikke_project =null;
 		 
 		 System.out.println("month =" + nameMonth.get(month) + "/year  =" + year + "/numMth  =" + numMonth);
 		  
 	  }
 	  
 	 return ResponseEntity.ok(listStatistiquesDislikesProject);
	   
	   
   }
 
   
   @PostMapping(value = "users/{token_user}/projects/{token_project}/hearts_project/create") 
   @ResponseBody
   public ResponseEntity<project>  createHeartProjectByUser(@PathVariable String token_user, @PathVariable String token_project , @RequestBody   heartProjectModel  _newHeartProject) {	
	   
	   
	   heartProjectModel HeartProjectBdd =  _heartsProjectRepository.save(_newHeartProject);
	   
	   
      /*****************************  mettre a jour le nombre de hearts de projet ********************************************/
	   
       Optional<project>  _project = _projectRepository.findByToken(token_project);
	   
	   if(_project.isPresent()) {
		   
		   // System.out.println("project exist"); 
		   
		  project  _projectBdd = _project.get();
		   
		  int totalHearts = _heartsProjectRepository.countHeartProject(_projectBdd.getToken());  
		  
		   
		  _projectBdd.setTotal_hearts(totalHearts);
		   
		   _projectRepository.save(_projectBdd); 
		   
		   adminstrateur  _manager_project = new adminstrateur();
		   
		   user creatorProject = new user();  
		   
		   creatorProject.setNom(_projectBdd.get_user().getNom());
   		
   	       creatorProject.setPrenom(_projectBdd.get_user().getPrenom());
   		
   		   creatorProject.setPhotoUser(_projectBdd.get_user().getPhotoUser());
   		
   		   creatorProject.setPseudo_name(_projectBdd.get_user().getPseudo_name());

   	       _projectBdd.set_user(creatorProject);   	       
   	       
   	       _projectBdd.setManager_project(_manager_project);
		   
		   return ResponseEntity.ok(_projectBdd); 
		   
	   }
	   
	   
	   /*************************************************************************/
	   
	   
	   
	 //  HeartProjectBdd.
	   
	   /*************************************************************************/
	   
	   
	   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  
       
      // return ResponseEntity.ok().build();
	   
	   
    }
   
   @PostMapping(value = "users/{token_user}/projects/{token_project}/hearts_project/delete") 
   @ResponseBody
   public ResponseEntity<?>  deleteHeartsProjectByUser(@PathVariable String token_user ,@PathVariable String token_project, @RequestBody   heartProjectModel  _HeartProject) {  	   
	 
	  user _user = _HeartProject.get_user(); 
	  
	  project _project = _HeartProject.get_project();
	  
	  System.out.println("token-user-heart-project = "+_user.getToken()); 
	  
	  System.out.println("token-project-heart-project = "+_project.getToken());
	  
	  _heartsProjectRepository.deleteHeartProject(_user.getToken(),_project.getToken());  	
	  
	  /***************************** mettre a jour le nombre de hearts de projet ********************************************/
	   
	  int totalHearts = _heartsProjectRepository.countHeartProject(_project.getToken());    
	
	   
	  _project.setTotal_hearts(totalHearts);
	   
	   _projectRepository.save(_project); 
	   
	   /*************************************************************************/
       
      return ResponseEntity.ok().build();
	    
	   
    }
   
   @PostMapping(value = "user/projects/{token}/checkLikeProject") 
   @ResponseBody
   public ResponseEntity<List<likeDislikeProjectModel>>  checkLikeProjectsByUser(@PathVariable String token , @RequestBody  user _user) {   
	  
	    
	   
	   List<likeDislikeProjectModel> listLikeProjectBdd =   _likeDislikeProjectRepository.findCheckLikeProject(_user.getToken(),token);   	
	   
	   if(listLikeProjectBdd.size()>0) { 	   
	  		
	  		 
		   return ResponseEntity.ok(listLikeProjectBdd);  
	  		 
	  	 }else {
	  		 
	  		 System.out.println("non-userbdd exist"); 
	  		 
	  		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  	 }  
       
      //  return ResponseEntity.ok().build();
	   
	   
    }
   
   @PostMapping(value = "user/projects/{token}/like_dislike_project/create") 
   @ResponseBody
   public ResponseEntity<likeDislikeProjectModel>  createLikeDislikeProjectByUser(@PathVariable String token , @RequestBody   likeDislikeProjectModel  _newLikeDislikeProject) {	
	   
	   
	   likeDislikeProjectModel  likeDislikeProjectBdd =  _likeDislikeProjectRepository.save(_newLikeDislikeProject);
	   
	   
      /*****************************  mettre a jour le nombre de hearts de projet ********************************************/
	   
       Optional<project>  _project = _projectRepository.findByToken(token);
	   
	   if(_project.isPresent()) {
		   
		   System.out.println("project exist"); 
		   
		  project  _projectBdd = _project.get();
		  
		  System.out.println("statut-like-project = "+  _newLikeDislikeProject.getStatut_like_project()); 
		   
		  /***************************** mettre a jour le nombre de like et dislike de projet ********************************************/
		   
		  int totalLike = _likeDislikeProjectRepository.countLikeProject(_projectBdd.getToken());    
		
		  int totalDisLike = _likeDislikeProjectRepository.countDisLikeProject(_projectBdd.getToken()); 
		  
		  _projectBdd.setTotal_like(totalLike);
		  
		  _projectBdd.setTotal_dislike(totalDisLike);
		   
		   _projectRepository.save(_projectBdd);  
		   
		   /*************************************************************************/
		   
	   }
	   
	   
	   /*************************************************************************/
	   
	   return ResponseEntity.ok(likeDislikeProjectBdd); 
       
      // return ResponseEntity.ok().build();
	   
	   
    }
   
   @PutMapping(value = "user/projects/{token}/like_dislike_project/update") 
   @ResponseBody
   public ResponseEntity<likeDislikeProjectModel>  updateStatutLikeProject(@PathVariable String token , @RequestBody   likeDislikeProjectModel _LikeProject) {  
	   
	   Optional<likeDislikeProjectModel>  _LikeProjectBdd =  _likeDislikeProjectRepository.findById(_LikeProject.getId());   	 
	  	 
	  	 if(_LikeProjectBdd.isPresent()) { 
	  		 
	  		likeDislikeProjectModel _LikeProjectBdddUpdate = _LikeProjectBdd.get();
	  		 
	  		_LikeProjectBdddUpdate.setStatut_like_project(_LikeProject.getStatut_like_project());	
	  		
	  		_LikeProjectBdddUpdate.setDate_update(_LikeProject.getDate_update());
	  		
	  		likeDislikeProjectModel  _LikeProjectBdddUpdateNew= _likeDislikeProjectRepository.save(_LikeProjectBdddUpdate);
	  		
	  		 /***************************** mettre a jour le nombre de like et dislike de projet ********************************************/
	  		
	  		project _project = _LikeProject.get_project();
	 	   
	  	    int totalLike = _likeDislikeProjectRepository.countLikeProject(_project.getToken());    
	  	
	  	    int totalDisLike = _likeDislikeProjectRepository.countDisLikeProject(_project.getToken()); 
	  	  
	  	    _project.setTotal_like(totalLike);
	  	  
	  	    _project.setTotal_dislike(totalDisLike);
	  	   
	  	    _projectRepository.save(_project);  
	  	   
	  	   /*************************************************************************/
	  		 
	  		 return new ResponseEntity<>(_LikeProjectBdddUpdateNew, HttpStatus.OK);
	  		 
	  	 }else {
	  		 
	  		 System.out.println("non-demande exist"); 
	  		 
	  		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  	 }  
	   
	 
       
      // return ResponseEntity.ok().build();
	   
	   
    }
   
   @PostMapping(value = "user/projects/{token}/like_dislike_project/delete") 
   @ResponseBody
   public ResponseEntity<?>  deleteLikeProjectByUser(@PathVariable String token , @RequestBody   likeDislikeProjectModel  _LikeProject) {  	   
	 
	  user _user = _LikeProject.get_user(); 
	  
	  project _project = _LikeProject.get_project();
	  
	  System.out.println("token-user-like-project = "+_user.getToken()); 
	  
	  System.out.println("token-project-like-project = "+_project.getToken());
	  
	  _likeDislikeProjectRepository.deleteLikeProject(_user.getToken(),_project.getToken());  	
	  
	  /***************************** mettre a jour le nombre de like et dislike de projet ********************************************/
	   
	  int totalLike = _likeDislikeProjectRepository.countLikeProject(_project.getToken());    
	
	  int totalDisLike = _likeDislikeProjectRepository.countDisLikeProject(_project.getToken()); 
	  
	  _project.setTotal_like(totalLike);
	  
	  _project.setTotal_dislike(totalDisLike);
	   
	   _projectRepository.save(_project);  
	   
	   /*************************************************************************/
       
      return ResponseEntity.ok().build();
	    
	   
    }
   
   @PostMapping(value = "user/projects/{token}/checkVueProject") 
   @ResponseBody
   public ResponseEntity<List<vueProjectModel>>  checkVueProjectsByUser(@PathVariable String token , @RequestBody  user _user) {   
	  
	    
	   
	   List<vueProjectModel> listVueProjectBdd =   _vueProjectRepository.findCheckVueProject(_user.getToken(),token);   	
	   
	   if(listVueProjectBdd.size()>0) { 	   
	  		
	  		 
		   return ResponseEntity.ok(listVueProjectBdd);  
	  		 
	  	 }else {
	  		 
	  		 System.out.println("non-userbdd exist"); 
	  		 
	  		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  	 }  
       
      //  return ResponseEntity.ok().build();
	   
	   
    }
   
   @PostMapping(value = "user/projects/{token}/vues_project/create") 
   @ResponseBody
   public ResponseEntity<vueProjectModel>  createVueProjectByUser(@PathVariable String token , @RequestBody   vueProjectModel  _newVueProject) {	
	   
	   LocalDateTime myDateObj = LocalDateTime.now();	   
	 
	   System.out.println("Before formatting: " + myDateObj);
	   
	   DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	   String formattedDate = myDateObj.format(myFormatObj);
	   
	   System.out.println("After formatting: " + formattedDate);
	   
	 
	   vueProjectModel  newVueProject =  new vueProjectModel();
	   
	   newVueProject.setDate_created(formattedDate);
	   
	   newVueProject.setDate_consultation(_newVueProject.getDate_consultation());
	   
	   newVueProject.set_user(_newVueProject.get_user());
	   
	   newVueProject.set_project(_newVueProject.get_project());	   
	   
	   newVueProject.setIp_adress(_newVueProject.getIp_adress());
	   
	   newVueProject.setTimestamp(_newVueProject.getTimestamp());
	   
	   vueProjectModel  newVueProjectBdd =  _vueProjectRepository.save(newVueProject);
	   
	   
	   
	   
      /*****************************  mettre a jour le nombre de vues de projet ********************************************/
	   
       Optional<project>  _project = _projectRepository.findByToken(token);
	   
	   if(_project.isPresent()) {
		   
		   System.out.println("project exist"); 
		   
		  project  _projectBdd = _project.get();	  
		  
		   
		  /***************************** mettre a jour le nombre de vues  de projet ********************************************/
		   
		  int totalVues = _vueProjectRepository.countVuesProject(_projectBdd.getToken());    
		 
		  
		  _projectBdd.setTotal_vues(totalVues);		 
		   
		   _projectRepository.save(_projectBdd);  
		   
		   /*************************************************************************/
		   
	   }
	   
	   
	   /*************************************************************************/
	   
	   return ResponseEntity.ok(newVueProjectBdd); 
       
      // return ResponseEntity.ok().build();
	   
	   
    }
   
   @PutMapping(value = "user/projects/{token}/vues_project/update") 
   @ResponseBody
   public ResponseEntity<vueProjectModel>  updateVuesProject(@PathVariable String token , @RequestBody   vueProjectModel _vueProject) {  
	   
	   Optional<vueProjectModel>  _vueProjectBdd =   _vueProjectRepository.findById(_vueProject.getId());   	 
	  	 
	  	 if(_vueProjectBdd.isPresent()) { 
	  		 
	  		vueProjectModel _vueProjectBdddUpdate = _vueProjectBdd.get();
	  		 
	  		_vueProjectBdddUpdate.setDate_update(_vueProject.getDate_update());
	  		
	  		_vueProjectBdddUpdate.setIp_adress(_vueProject.getIp_adress());
	  		
	  		vueProjectModel  _vueProjectBdddUpdateNew =  _vueProjectRepository.save(_vueProjectBdddUpdate);
	  		
	  		 /***************************** mettre a jour le nombre de like et dislike de projet ********************************************/
	  		
	  		project _project =_vueProject.get_project();
	 	   
	  	    int totalVues = _vueProjectRepository.countVuesProject(_project.getToken());   
	  	  
	  	    _project.setTotal_vues(totalVues);	  	 
	  	   
	  	    _projectRepository.save(_project);  
	  	   
	  	   /*************************************************************************/
	  		 
	  		 return new ResponseEntity<>(_vueProjectBdddUpdateNew, HttpStatus.OK);
	  		 
	  	 }else {
	  		 
	  		 System.out.println("non-demande exist"); 
	  		 
	  		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  	 }  
	   
	 
       
      // return ResponseEntity.ok().build();
	   
	   
    }
   
   @PostMapping(value = "user/projects/{token}/news/create") 
   @ResponseBody
   public ResponseEntity<newsProjectModel>  createNewsProjectByUser(@PathVariable String token , @RequestBody   newsProjectModel  _newNewsProject) {	
	   
	   LocalDateTime myDateObj = LocalDateTime.now();	   
	 
	   System.out.println("Before formatting: " + myDateObj);
	   
	   DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	   String formattedDate = myDateObj.format(myFormatObj);
	   
	   System.out.println("After formatting: " + formattedDate);
	   
	 
	   newsProjectModel  newNewsProject =  new newsProjectModel();
	   
	   newNewsProject.setDate_created(_newNewsProject.getDate_created());
	   
	   newNewsProject.setTitre(_newNewsProject.getTitre());
	   
	   newNewsProject.set_project(_newNewsProject.get_project());
	   
	   newNewsProject.setDescription(_newNewsProject.getDescription());   
	   
	   newNewsProject.setPhotos(_newNewsProject.getPhotos());
	   
	   newNewsProject.setTimestamp(_newNewsProject.getTimestamp());
	   
	   newsProjectModel  newNewsProjectBdd =  _newsProjectRepository.save(newNewsProject);  
    
	   
	   
	   /*************************************************************************/
	   
	   return ResponseEntity.ok(newNewsProjectBdd); 
       
      // return ResponseEntity.ok().build();
	   
	   
    }
   
   @PostMapping(value = "user/projects/{token}/list_news_project") 
   @ResponseBody
   public ResponseEntity<List<newsProjectModel>>  getListNewsProjectForUser(@PathVariable String token , @RequestBody  project _project) { 	
	   
	   
	  System.out.println("token-object-Project="+ _project.getToken()); 
	  
	  
	  System.out.println("@PathVariable="+  token);  
	 
	    
	   
	  List<newsProjectModel> listNewsProject =  _newsProjectRepository.findAllNewsProjectByToken(_project.getToken());   	
   	
   	
   	 if(listNewsProject.size()>0) { 
   		
   		return ResponseEntity.ok(listNewsProject);  
   		
   	}
   	
   	 return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
       
      //  return ResponseEntity.ok().build();
	   
	   
    }
   
   






}
