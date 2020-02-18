package QueMePongo.Dominio;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Comman {
	private static String  ENCRYPT_KEY="QueMePongoTPDDS";

	public static String encript(String text) throws Exception {  
	    Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "AES");
	 
	    Cipher cipher = Cipher.getInstance("AES");
	    cipher.init(Cipher.ENCRYPT_MODE, aesKey);
	 
	    byte[] encrypted = cipher.doFinal(text.getBytes());
	         
	    return Base64.getEncoder().encodeToString(encrypted);
	    }
	 
	public static String decrypt(String encrypted) throws Exception {
	    byte[] encryptedBytes=Base64.getDecoder().decode( encrypted.replace("\n", "") );
	         
	    Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "AES");
	 
	    Cipher cipher = Cipher.getInstance("AES");
	    cipher.init(Cipher.DECRYPT_MODE, aesKey);
	 
	    String decrypted = new String(cipher.doFinal(encryptedBytes));
	         
	    return decrypted;
	    }
}
