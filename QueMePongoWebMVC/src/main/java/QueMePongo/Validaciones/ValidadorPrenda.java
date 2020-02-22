package QueMePongo.Validaciones;

import org.springframework.validation.*;

import QueMePongo.Dominio.Prenda;
import QueMePongo.Web.Modelos.PrendaModelo;

public class ValidadorPrenda implements Validator {


@Override
public boolean supports(Class<?> clazz) {
	return PrendaModelo.class.equals(clazz); // clase del bean al que da soporte este validador

}

@Override
public void validate(Object target, Errors errors) {
	// TODO Auto-generated method stub
	//Usuario user = (Usuario) target;
	
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descripcion", "field.descripcion.required", 
			"La descripcion  es obligatoria");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mail", "field.mail.required", 
			"El email es obligatoria");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.password.required", 
			"El password es obligatorio");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "field.nombre.required", 
			"El nombre es obligatorio");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellido", "field.apellido.required", 
			"El apellido es obligatorio");
	
}

}
