package QueMePongo.Validaciones;
import QueMePongo.Dominio.*;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ValidadorUsuario implements Validator {


@Override
public boolean supports(Class<?> clazz) {
	return Usuario.class.equals(clazz); // clase del bean al que da soporte este validador

}

@Override
public void validate(Object target, Errors errors) {
	// TODO Auto-generated method stub
	//Usuario user = (Usuario) target;
	
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codigoUsuario", "field.codigoUsuario.required", 
			"El codigo de Usuario es obligatoria");

}
}