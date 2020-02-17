package QueMePongo.Validaciones;
import QueMePongo.Dominio.*;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ValidadorGuardarropa implements Validator {


@Override
public boolean supports(Class<?> clazz) {
	return Guardarropa.class.equals(clazz); // clase del bean al que da soporte este validador

}

@Override
public void validate(Object target, Errors errors) {
	// TODO Auto-generated method stub
	//Usuario user = (Usuario) target;
	
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descripcion", "field.descripcion.required", 
			"La descripcion es obligatoria");
	
}
}