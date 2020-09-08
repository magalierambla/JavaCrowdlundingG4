package com.api.crowdlending;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;  // Les dates
import java.util.Calendar;
import java.util.HashMap;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


import com.api.crowdlending.enumapp.sexUser;
import com.api.crowdlending.functionsUtils.methodesUtils;
import com.api.crowdlending.model.adminstrateur;
import com.api.crowdlending.model.category_project;
import com.api.crowdlending.model.porte_project;
import com.api.crowdlending.model.statutProject;
import com.api.crowdlending.repository.adminstrateurRepository;
import com.api.crowdlending.repository.categoryProjectRepository;
import com.api.crowdlending.repository.porteProjectRepository;
import com.api.crowdlending.repository.statutProjectRepository;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper; // necessaire pour  send mail html 
import javax.mail.internet.MimeMessage; // necessaire pour  send mail html 
import java.io.File; // necessaire pour  send mail attaché avec des fichiers 
import org.springframework.core.io.FileSystemResource;  // necessaire pour  send mail attaché avec des fichiers
import com.api.crowdlending.mail.gmail.MyConstants;

@SpringBootApplication
@EnableJpaAuditing
public class ApiCrowdlendingApplication implements ApplicationRunner {    
	
	@Autowired
	categoryProjectRepository  _categoryProjectRepository; 
	
	@Autowired
	statutProjectRepository  _statutProjectRepository; 
	
	@Autowired
	porteProjectRepository  _porteProjectRepository; 

	
	@Autowired
	adminstrateurRepository  _adminstrateurRepository; 
	
	@Autowired
    public JavaMailSender emailSender;

	public static void main(String[] args) {
		
		SpringApplication.run(ApiCrowdlendingApplication.class, args);
	}
	
	
	
	
	@Override
    public void run(ApplicationArguments args) throws Exception {
		
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
	 	   
	 	  monthCurrent = monthCurrent +1 ;
	 	   
	       System.out.println("***month = = ***" + nameMonth.get(monthCurrent)  + "***year  = ***" + yearCurrent);
	 	  
	 	  for (int i=0;i<12;i++) {
	 		  
	 		  int calcul_dif = monthCurrent-i;
	 		  
	 		  
	 		// System.out.println("***compt = ***" + i +"***calcul_dif  = ***" + calcul_dif );  	 		 
	 		
	 		 
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
	 		 
	 		 System.out.println("month =" + nameMonth.get(month) + "/year  =" + year + "/numMth  =" + numMonth);
	 		  
	 	  }
	 	  
	 	 
		
		/************************ get adress-ip ***************************************/
		
		// System.out.println("***ip-adress = ***" + methodesUtils.getClientIp());
		
		/************************************ Dates *********************************************/
		
		// import java.time.Instant;  
		
		Instant instant = Instant.now();
		
		long timeStampMillis = instant.toEpochMilli();
		
		System.out.println("***timeStampMillis = ***" + timeStampMillis);
		
		
		
		/**************************** Envoi mail text ************************************/
		
	/*	
	 * import org.springframework.mail.SimpleMailMessage;
       import org.springframework.mail.javamail.JavaMailSender;
	   import com.api.crowdlending.mail.gmail.MyConstants;*/
		
		// Create a Simple MailMessage.
	/*	SimpleMailMessage message = new SimpleMailMessage();
		
		message.setTo(MyConstants.FRIEND_EMAIL);
        message.setSubject("Test Simple Email");
	   // message.setText("Hello, Im testing Simple Email && adress-ip ="+ methodesUtils.getClientIp() ); 
	    // message.setText("Hello, Im testing Simple Email && adress-ip ="); 
		
        // Send Message!
       // this.emailSender.send(message);
		
		/****************************** Envoi mail HTML **********************************/
		
		/*	import org.springframework.mail.javamail.MimeMessageHelper; // necessaire pour  send mail html 
		import javax.mail.internet.MimeMessage; // necessaire pour  send mail html 
		import com.api.crowdlending.mail.gmail.MyConstants;*/
        
     /*   MimeMessage messageHtml = emailSender.createMimeMessage();
        
        boolean multipart = true;
         
        MimeMessageHelper helper = new MimeMessageHelper(messageHtml, multipart, "utf-8");
         
        String htmlMsg = "<h3>Im testing send a HTML email</h3>"
                +"<img src='http://www.apache.org/images/asf_logo_wide.gif'>";
         
        messageHtml.setContent(htmlMsg, "text/html");
         
        helper.setTo(MyConstants.FRIEND_EMAIL);
         
        helper.setSubject("Test send HTML email");*/
         
        // Send Message Html 
       // this.emailSender.send(messageHtml);
        
        
        
        /**************************** Envoyer un courrier attaché avec des fichiers ************************************/
		
		/*	 	
		import java.io.File; // necessaire pour  send mail attaché avec des fichiers 
		import org.springframework.core.io.FileSystemResource;  // necessaire pour  send mail attaché avec des fichiers
		import com.api.crowdlending.mail.gmail.MyConstants;*/
        
        
      /*  MimeMessage messageFile = emailSender.createMimeMessage();
        
        boolean multipartFile = true;
 
        MimeMessageHelper helperFile = new MimeMessageHelper(messageFile, multipartFile);
 
        helperFile.setTo(MyConstants.FRIEND_EMAIL);
        helperFile.setSubject("Test email with attachments");
         
        helperFile.setText("Hello, Im testing email with attachments!");
         
        String path1 = "C:/Users/abdel-dev/Desktop/Langage programmation/Langage-Java/Notes.txt";
        String path2 = "C:/Users/abdel-dev/Desktop/Langage programmation/Langage-Java/Notes.txt";
 
        // Attachment 1
        FileSystemResource file1 = new FileSystemResource(new File(path1));
        helperFile.addAttachment("Txt file", file1);
 
        // Attachment 2
        FileSystemResource file2 = new FileSystemResource(new File(path2));
        helperFile.addAttachment("Readme", file2);
 
        this.emailSender.send(messageFile); */
        
        
        
                     /****************************************************************************************/
		
		
		String[] listCategorie = {"Art & Photo","BD","Enfance & Educ.","Artisanat & Cuisine","Film et vidéo","Sports","Santé & Bien-être","Technologie","Autres projets"};
		
		for(int i=0; i<listCategorie.length; i++) { 
			
			category_project categorieProject = new category_project();		
			
			
			 Optional<category_project>  categorieBdd = _categoryProjectRepository.findByNom(listCategorie[i]);
			 
			 if(!categorieBdd.isPresent()) { 
				 
				 categorieProject.setNom(listCategorie[i]);
				 
				 _categoryProjectRepository.save(categorieProject);       
				 
			 }		
			
		
		} 
		
		/******************************************************************/
		
		
      String[] listStatut = {"Attente","Valide","Annule","En cours","Termine","Renouvele"};
		
		for(int i=0; i<listStatut.length; i++) { 
			
			statutProject statutProject = new statutProject();		
			
			
			 Optional<statutProject>  statutBdd = _statutProjectRepository.findByNom(listStatut[i]);
			 
			 if(!statutBdd.isPresent()) { 
				 
				 statutProject.setNom(listStatut[i]);
				 
				 _statutProjectRepository.save(statutProject);       
				 
			 }		
			
		
		} 	
		
		
		/******************************************************************/
		
	 String[] listPorteProject = {"moi-même","mon association","mon entreprise"};
			
			for(int i=0; i<listPorteProject.length; i++) { 
				
				porte_project porteProject = new porte_project();		
				
				
				 Optional<porte_project>  porteProjectBdd = _porteProjectRepository.findByNom(listPorteProject[i]);
				 
				 if(!porteProjectBdd.isPresent()) { 
					 
					 porteProject.setNom(listPorteProject[i]);
					 
					 _porteProjectRepository.save(porteProject);       
					 
				 }		
				
			
			} 			
		
		
		
			/******************************************************************/

		
		String[] listAdmin = {"admin1@yopmail.com"};
		
		for(int i=0; i<listAdmin.length; i++) { 		
				
			
			
			 Optional<adminstrateur>  adminBdd = _adminstrateurRepository.findByLogin(listAdmin[i]);
			 
			 if(!adminBdd.isPresent()) { 
				 
			   	 adminstrateur admin = new adminstrateur();	
			   	 
			   	  String passwordAdmin = "123";
				 
				  admin.setNom(listCategorie[i]);				
				  
				  admin.setPassword(methodesUtils.getMD5Hex(passwordAdmin));
				  
				  admin.setPhotoUser("https://i.imgur.com/Ne454Ai.jpg");
				  
				  sexUser _sex = sexUser.H;
				  
				  admin.setSex(_sex );
				  
				  admin.setToken("5OHS4LGd2m8aVSOk0d9AOlNs3idRcLEzFfbch2WfjcvIFi16StyT77MRgb7t");
				  
				  admin.setLogin("admin1@yopmail.com");
				  
				  admin.setTypeCompte("admin");
				  
				  admin.setNom("chachia");
				  
				  admin.setPrenom("abdelilah");	
				  
				  admin.setPseudo_name("Docfile");	
				  
				 _adminstrateurRepository.save(admin);       
				 
			 }		
			
		
		} 	
		
		
		
        System.out.println("***Generated***");
        
        /**************************************************************************/

        
        
        
        
        /*************************************************************************/
    }
}
