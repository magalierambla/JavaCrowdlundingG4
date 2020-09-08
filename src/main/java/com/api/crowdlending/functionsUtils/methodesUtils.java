package com.api.crowdlending.functionsUtils;


//  Md5
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Generer une chaine de caractere
import java.util.Random;



// Spring MVC - Comment obtenir l’adresse IP du client
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;



public class methodesUtils {
	
	
	// Spring MVC - Comment obtenir l’adresse IP du client
	private static HttpServletRequest request;
	
	/************************** Generer une chaine de caractere *******************************************/
	
	public static  String generateAlphanumericStringToken() {
		
		 int leftLimit = 48; // numeral '0'
	     int rightLimit = 122; // letter 'z'
	     int targetStringLength = 60;
		 Random random = new Random();

	     String generatedString = random.ints(leftLimit, rightLimit + 1)
		      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
		      .limit(targetStringLength)
		      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
		      .toString();

		   return generatedString;
	}
	
	/*********************** Md5 *************************************/
	
	public static String getMD5Hex(String inputString) throws NoSuchAlgorithmException {

	    MessageDigest md = MessageDigest.getInstance("MD5");
	    
	    md.update(inputString.getBytes());

	    byte[] digest = md.digest();

	    return convertByteToHex(digest);
	}

	private static String convertByteToHex(byte[] byteData) {

	    StringBuilder sb = new StringBuilder();
	    
	    for (int i = 0; i < byteData.length; i++) {
	    	
	        sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	    }

	    return sb.toString();
	}

	
	
	/*************************************************************/
	
	@Autowired
    public void setRequest(HttpServletRequest request) {
        request = request;
    }

     public static String getClientIp() {

        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        return remoteAddr;
    }
	
	
	
	
	/*************************************************************/

}
