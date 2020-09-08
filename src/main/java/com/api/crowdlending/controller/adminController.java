package com.api.crowdlending.controller;

import java.awt.PageAttributes.MediaType;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.crowdlending.model.StatistiquesChartsUsersModel;
import com.api.crowdlending.model.adminstrateur;
import com.api.crowdlending.model.adressReseauxSociauxProject;
import com.api.crowdlending.model.commissionProjectModel;
import com.api.crowdlending.model.investisseursProjectModel;
import com.api.crowdlending.model.project;
import com.api.crowdlending.model.user;
import com.api.crowdlending.repository.adminstrateurRepository;
import com.api.crowdlending.repository.commisionProjectRepository;
import com.api.crowdlending.repository.investisseursProjectRepository;
import com.api.crowdlending.repository.projectRepository;
import com.api.crowdlending.repository.userRepository;
import com.api.crowdlending.functionsUtils.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class adminController {
	
    @Autowired
    adminstrateurRepository  adminRepository;
    
    @Autowired
    userRepository userRepository;
    
    @Autowired
    projectRepository  _projectRepository;
    
    @Autowired
    investisseursProjectRepository   _investisseursProjectRepository;
    
    @Autowired
    commisionProjectRepository   _commissionProjectRepository;

    @PostMapping("/admin/users") 
    @ResponseBody
    public ResponseEntity<List<user>> getAllUsers(@Valid @RequestBody  adminstrateur infosUser) { 
    	
    	List<user> users = userRepository.findAll();
    	
    	return ResponseEntity.ok(users);    
        
    }
    
    @PostMapping(value = "/admin/users/{token}/infos") 
    @ResponseBody
    public ResponseEntity<user> getInfosCompanyOwner(@PathVariable String token , @RequestBody  adminstrateur infosUser) {  
 	   
 		 
 		  
    	 Optional<user>  userBdd = userRepository.checkExistUserByToken(token);  
    	 
    	 if(userBdd.isPresent()) { 
    		 
    		 
    		 user _user = userBdd.get();
    		 
    		 _user.setToken("");
    		 
    		 _user.setPassword("");
    		 
    		 return new ResponseEntity<>(_user, HttpStatus.OK);
    		 
    	 }else {
    		 
    		 System.out.println("non-userbdd exist"); 
    		 
    		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	 }         
     
 	   
 	   
     }
    
    @PostMapping(value = "/admin/users/{token}/my_projects") 
    @ResponseBody
    public ResponseEntity<List<project>> getMyProjectsUser(@PathVariable String token , @RequestBody  adminstrateur infosUser) {  
 	   
 		 
 		  
        System.out.println("token-user="+ token);    	
    	
    	List<project> projects =  _projectRepository.findAllProjectByToken(token); 	
    	
    	
    	 if(projects.size()>0) { 
    		
    		return ResponseEntity.ok(projects);  
    		
    	}
    	
    	 return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
     
 	   
 	   
     }
    
    
    @PostMapping(value = "/admin/users/{token}/contrib_projects") 
    @ResponseBody
    public ResponseEntity<List<project>> getContribProjectsUser(@PathVariable String token , @RequestBody  adminstrateur infosUser) {  
 	   
 		 
 		  
	    System.out.println("token-user="+ token);  	
	    
	    List<project> listContribProject = new ArrayList<project>();
    	
    	
    	List<investisseursProjectModel> listInvestisseursProjectModel =  _investisseursProjectRepository.findAllContribProjectByToken(token);  	
    
    	
    	 if(listInvestisseursProjectModel.size()>0) { 
    		 
    		 for (int i = 0; i < listInvestisseursProjectModel.size(); i++) {
    			 
    			 listContribProject.add(listInvestisseursProjectModel.get(i).get_project());
    	     }
    		
    		return ResponseEntity.ok(listContribProject);  
    		
    	}
    	
    	 return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
     
 	   
 	   
     }
    
    @PostMapping("/admin/checkUser")
    @ResponseBody
    public ResponseEntity<adminstrateur> checkUser(@Valid @RequestBody  adminstrateur infosUser) {   	 
    	
    	
 	  
 	    
 	    System.out.println("infosUser.login="+ infosUser.getLogin());     
 	    
 	    System.out.println("infosUser.password="+ infosUser.getPassword());   
 	    
 	 //   return ResponseEntity.ok().build();
 	    
 	   String passwordMd5;
 	    
 	   try {
	    	
			 passwordMd5 = methodesUtils.getMD5Hex(infosUser.getPassword());
			
			 return ResponseEntity.ok(adminRepository.getUserByEmailAndPassword(infosUser.getLogin(),passwordMd5));
			
			
		} catch (NoSuchAlgorithmException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	   
	    return null;  	        
 	   
   }
    
    @PostMapping("/admin/checkUserByToken")
    @ResponseBody
    public ResponseEntity<adminstrateur> checkUserByToken(@Valid @RequestBody  adminstrateur infosUser) {   	 
    	
    	
    	 Optional<adminstrateur>  userBdd = adminRepository.checkExistUserByToken(infosUser.getToken());   
    	 
    	 if(userBdd.isPresent()) { 
    		 
    		 adminstrateur  _user = userBdd.get();
    		 
    		 return new ResponseEntity<>(adminRepository.save(_user), HttpStatus.OK);
    		 
    	 }else {
    		 
    		 System.out.println("non-userbdd exist"); 
    		 
    		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	 }  
 	   
 	 
 	   
   }
    
    @PostMapping("/admin/checkExistMailUser")
    @ResponseBody
    public ResponseEntity<adminstrateur> checkExistMailUser(@Valid @RequestBody  adminstrateur infosUser) {   	   
 	  
 	    
 	    System.out.println("infosUser.login="+ infosUser.getLogin());  	   
       
 	   return ResponseEntity.ok(adminRepository.checkExistMailUser(infosUser.getLogin())); 
 	   
     }
    
    @PutMapping(value = "/admin/update") 
    @ResponseBody
    public ResponseEntity<adminstrateur>  updateUser(@RequestBody  adminstrateur updateUser) {	   
 	   
    	 System.out.println("infosUser.token="+ updateUser.getToken()); 
    	 
    	 Optional<adminstrateur>  userBdd = adminRepository.checkExistUserByToken(updateUser.getToken());   	 
    	 
    	 if(userBdd.isPresent()) { 
    		 
    		 adminstrateur  _user = userBdd.get();
    		 
    		 _user.setDate_naissance(updateUser.getDateNaissance());
    		 
    		 _user.setDate_update(updateUser.getDate_update());
    		 
    		 _user.setNom(updateUser.getNom());
    		 
    		 _user.setPrenom(updateUser.getPrenom());
    		 
    		 _user.setPhotoUser(updateUser.getPhotoUser());
    		 
    		 _user.setSex(updateUser.getSex());
    		 
    		 _user.setPassword(updateUser.getPassword());
    		 
    		 _user.setLogin(updateUser.getLogin());
    		 
    		 System.out.println("userbdd exist"+_user.getNom()); 
    		 
    		 return new ResponseEntity<>(adminRepository.save(_user), HttpStatus.OK);
    		 
    	 }else {
    		 
    		 System.out.println("non-userbdd exist"); 
    		 
    		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	 }  
 	 
    	
    	
     }
    
    @PostMapping(value = "admin/users/statistiques_charts") 
    @ResponseBody
    public ResponseEntity<List<StatistiquesChartsUsersModel>>  statistiques_users_charts(@RequestBody  adminstrateur infosUser) {	
 	   
 	 
 	   
 	   List<StatistiquesChartsUsersModel> listStatistiquesChartsUsers =   new ArrayList<StatistiquesChartsUsersModel>(); 	 
 	   
 	   
 	   Calendar calendrier;
 	    
 	   calendrier = Calendar.getInstance();
 		
 	   int yearCurrent = calendrier.get(Calendar.YEAR);	
 	  
 	   
 	   /****************************************************************/
 	   
 	   StatistiquesChartsUsersModel _statistiquesChartsUsers = new StatistiquesChartsUsersModel();
 	   
 	   int  _nbrUsersYearCurrent =  userRepository.countNbrUsersForYearCurrent();   	   
 	   
 	   _statistiquesChartsUsers.setNbrUsers(_nbrUsersYearCurrent);
 	   
 	   String yearCurrentString = String.valueOf(yearCurrent);
 	   
 	   _statistiquesChartsUsers.setYear(yearCurrentString);
 	   
 	   listStatistiquesChartsUsers.add(_statistiquesChartsUsers);
 		
 		
 	   
 	   /****************************************************************/
 	   
 	   StatistiquesChartsUsersModel _statistiquesChartsUsers1 = new StatistiquesChartsUsersModel();
 	   
 	   int yearLast1 = yearCurrent-1;	
 		
 	  String  yearLast1String = String.valueOf(yearLast1);
 	   
 	  int  _nbrUsersYearLast1 =  userRepository.countNbrUsersForLast1Year();   	
 	  
 	  _statistiquesChartsUsers1.setYear(yearLast1String);
 	   
 	  _statistiquesChartsUsers1.setNbrUsers(_nbrUsersYearLast1);   
 	 
 	   
 	   listStatistiquesChartsUsers.add(_statistiquesChartsUsers1);   
 	   
 	   
 	   /****************************************************************/
 	   
 	   StatistiquesChartsUsersModel _statistiquesChartsUsers2 = new StatistiquesChartsUsersModel();
 	  
 	  int yearLast2 = yearCurrent-2;	
 		
 	  String  yearLast2String = String.valueOf(yearLast2);
 	   
 	  int  _nbrUsersYearLast2 =  userRepository.countNbrUsersForLast2Year();   	   
 	   
 	  _statistiquesChartsUsers2.setYear(yearLast2String);
 	   
 	  _statistiquesChartsUsers2.setNbrUsers(_nbrUsersYearLast2);   
 	 
 	   
 	   listStatistiquesChartsUsers.add(_statistiquesChartsUsers2);
 	   
 	   
 	   /****************************************************************/
 	   
 	   StatistiquesChartsUsersModel _statistiquesChartsUsers3 = new StatistiquesChartsUsersModel();
 	  
 	   int yearLast3 = yearCurrent-3;	
 		
 	   String  yearLast3String = String.valueOf(yearLast3);
 		   
 	   int  _nbrUsersYearLast3 =  userRepository.countNbrUsersForLast3Year();   	   
 		   
 	  _statistiquesChartsUsers3.setYear(yearLast3String);
 		   
 	  _statistiquesChartsUsers3.setNbrUsers(_nbrUsersYearLast3);   
 		 
 		   
 	   listStatistiquesChartsUsers.add(_statistiquesChartsUsers3);
 	   
 	   
 	   
 	   /****************************************************************/
 	   
 	   StatistiquesChartsUsersModel _statistiquesChartsUsers4 = new StatistiquesChartsUsersModel();
 	  
 	   int yearLast4 = yearCurrent-4;	
 		
 	   String  yearLast4String = String.valueOf(yearLast4);
 		   
 	   int  _nbrUsersYearLast4 =  userRepository.countNbrUsersForLast4Year();   	   
 		   
 	  _statistiquesChartsUsers4.setYear(yearLast4String);
 		   
 	  _statistiquesChartsUsers4.setNbrUsers(_nbrUsersYearLast4);   
 		 
 		   
 	   listStatistiquesChartsUsers.add(_statistiquesChartsUsers4);
 	   
 	   
 	   
 	   /****************************************************************/  
 	   

 	
 	   
 	  // return ResponseEntity.ok().build();
 	
        
        return ResponseEntity.ok(listStatistiquesChartsUsers);
 	   
 	  
 	    
 	   
     }
    
    @PostMapping("/admin/{token_admin}/projects/{token_project}/checkCommissionProject")
    @ResponseBody
    public ResponseEntity<List<commissionProjectModel>> checkCommisionProject(@PathVariable String token_project, @PathVariable String token_admin, @Valid @RequestBody  adminstrateur infosUser) {   	 
    	
    	
    	 Optional<adminstrateur>  userBdd = adminRepository.checkExistUserByToken(infosUser.getToken());   
    	 
    	 if(userBdd.isPresent()) { 
    		 
    		 // adminstrateur  _user = userBdd.get();
    		 
    		 List<commissionProjectModel>  listCommissionProjectBdd = _commissionProjectRepository.findCheckCommissionProject(token_project);   
    		 
    		 if(listCommissionProjectBdd.size()>0) {
    			 
    			 return new ResponseEntity<>(listCommissionProjectBdd, HttpStatus.OK);
    			 
    		 }else {
    			 
    			 System.out.println("non-commission-project exist"); 
        		 
        		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);  			 
    			 
    			 
    		 }   		 
    		 
    		 
    		 
    		 
    	 }else {
    		 
    		 System.out.println("non-userbdd exist"); 
    		 
    		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	 }  
 	   
 	 
 	   
   }
    
    @PostMapping("/admin/{token_admin}/projects/{token_project}/createCommissionProject")
    @ResponseBody
    public ResponseEntity<commissionProjectModel> createCommisionProject(@PathVariable String token_admin, @PathVariable String token_project, @Valid @RequestBody  commissionProjectModel newcommissionProject) {   	 
    	
    	
    	 Optional<adminstrateur>  userBdd = adminRepository.checkExistUserByToken(token_admin);   
    	 
    	 if(userBdd.isPresent()) { 
    		 
    		 // adminstrateur  _user = userBdd.get();
    		 
    		 List<commissionProjectModel>  listCommissionProjectBdd = _commissionProjectRepository.findCheckCommissionProject(token_project);   
    		 
    		 if(listCommissionProjectBdd.size()<=0) {
    			 
    			 String  newToken = methodesUtils.generateAlphanumericStringToken();   
    			 
    			 newcommissionProject.setToken(newToken);
    			 
    			 return new ResponseEntity<>(_commissionProjectRepository.save(newcommissionProject), HttpStatus.OK);
    			 
    		 }else {
    			 
    			 System.out.println("commission-project exist"); 
        		 
        		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    			 
    		 }
    		 
    		 
    		 
    	 }else {
    		 
    		 System.out.println("non-userbdd exist"); 
    		 
    		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	 }	
 	   
 	 
 	   
   }
    


}

