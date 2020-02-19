package QueMePongo.Validaciones;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import QueMePongo.Dominio.*;

public class ValidadorSugerenciaAceptar implements Validator {


@Override
public boolean supports(Class<?> clazz) {
	return Sugerencia.class.equals(clazz); // clase del bean al que da soporte este validador

}

@Override
public void validate(Object target, Errors errors) {
 
}
}