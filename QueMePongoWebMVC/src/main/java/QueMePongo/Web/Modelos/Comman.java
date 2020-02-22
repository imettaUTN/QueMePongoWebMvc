package QueMePongo.Web.Modelos;

import java.security.spec.KeySpec;
import java.util.*;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import QueMePongo.Dominio.*;
import QueMePongo.Dominio.Enumerados.EnumCapa;

public class Comman {
	
	private static String secretKey = "boooooooooom!!!!";
	private static String salt = "ssshhhhhhhhhhh!!!!";

	public static String encrypt(String strToEncrypt) 
	{
	    try
	    {
	        byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	        IvParameterSpec ivspec = new IvParameterSpec(iv);
	         
	        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
	        KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65536, 256);
	        SecretKey tmp = factory.generateSecret(spec);
	        SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
	         
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
	        return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
	    } 
	    catch (Exception e) 
	    {
	        System.out.println("Error while encrypting: " + e.toString());
	    }
	    return null;
	}
	 	
	public static String decrypt(String strToDecrypt) {
	    try
	    {
	        byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	        IvParameterSpec ivspec = new IvParameterSpec(iv);
	         
	        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
	        KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65536, 256);
	        SecretKey tmp = factory.generateSecret(spec);
	        SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
	         
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
	        return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
	    } 
	    catch (Exception e) {
	        System.out.println("Error while decrypting: " + e.toString());
	    }
	    return null;
	}
		
	public static List<PrendaModelo> ConvertPrendaToModelList(List<Prenda> prendas){
		List<PrendaModelo> Lprenda = new ArrayList<PrendaModelo>();
		
		for( Prenda prenda : prendas) {
			PrendaModelo Mprenda = new PrendaModelo(prenda.getDescripcion(), prenda.getColorPrimario(), prenda.getColorSecundario(), prenda.getCategoria().getDescripcion(), prenda.getCodPrenda(), prenda.getGuardarropa().getId());
			Lprenda.add(Mprenda);
		}
		return Lprenda;
	}
	
	public static List<TipoPrendaModelo> ConvertTipoPrendaToModelList(List<TipoPrenda> tipoPrenda){
		List<TipoPrendaModelo> Lprenda = new ArrayList<TipoPrendaModelo>();
		
		for( TipoPrenda prenda : tipoPrenda) {
			TipoPrendaModelo Mprenda = new TipoPrendaModelo();
			Mprenda.setCodTipoPrenda(prenda.getCodTipoPrenda());
			Mprenda.setDescripcion(prenda.getDescripcion());
			Lprenda.add(Mprenda);
		}
		return Lprenda;
	}
	
	public static List<GuardarropaModelo> ConvertTipoGuardarropaToModelList(List<Guardarropa> guardarropa){
		List<GuardarropaModelo> Lprenda = new ArrayList<GuardarropaModelo>();		
		for( Guardarropa prenda : guardarropa) {
			GuardarropaModelo Mcategoria = new GuardarropaModelo();
			Mcategoria.setCodigoGuardarropa(prenda.getId());
			Mcategoria.setDescripcion(prenda.getDescripcion());
			Lprenda.add(Mcategoria);
		}
		return Lprenda;
	}
	
	public static PrendaModelo converPrendaModel(Prenda prenda) {
		PrendaModelo Mprenda = new PrendaModelo(prenda.getDescripcion(), prenda.getColorPrimario(), prenda.getColorSecundario(), prenda.getCategoria().getDescripcion(), prenda.getCodPrenda(), prenda.getGuardarropa().getId());
       return Mprenda;
	}
	
	public static Prenda FromModelToClasPrenda(PrendaModelo pm){
		
			Prenda p = new Prenda();
			p.setColorPrimario(pm.getColorPrimario());		
			p.setColorSecundario(pm.getColorSecundario());
			p.setDescripcion(pm.getDescripcion());
			Guardarropa g = Guardarropa.buscarPorId(pm.getCodigoGuardarropa());
			p.setGuardarropa(g);
            TipoPrenda tp = TipoPrenda.buscarPorId(pm.getTipoPrenda());
            p.setTipoPrenda(tp);
            p.setNumeroDeCapa(EnumCapa.Primera);
		
		return p;
	}
}
