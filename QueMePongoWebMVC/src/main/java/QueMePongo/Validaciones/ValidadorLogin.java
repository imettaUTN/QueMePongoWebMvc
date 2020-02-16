package QueMePongo.Validaciones;
import QueMePongo.Dominio.*;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



public class ValidadorLogin implements Validator {


@Override
public boolean supports(Class<?> clazz) {
	return Login.class.equals(clazz); // clase del bean al que da soporte este validador

}

@Override
public void validate(Object target, Errors errors) {
	// TODO Auto-generated method stub
	//Login login = (Login) target;
	
	// la matrícula es obligatoria
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "field.email.required", 
			"El email es obligatoria");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.password.required", 
			"El password es obligatorio");

}
}
