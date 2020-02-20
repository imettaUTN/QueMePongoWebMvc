package QueMePongo.Validaciones;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import QueMePongo.Dominio.*;

public class ValidadorEvento implements Validator {


		@Override
		public boolean supports(Class<?> clazz) {
			return Evento.class.equals(clazz); // clase del bean al que da soporte este validador

		}

		@Override
		public void validate(Object target, Errors errors) {
			// TODO Auto-generated method stub
			//Usuario user = (Usuario) target;
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descripcion", "field.descripcion.required", 
					"La descripcion es obligatoria");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fecha", "field.fecha.required", 
					"La fecha es obligatoria");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "temperaturaMinima", "field.temperaturaMinima.required", 
					"La temperatura Minima es obligatoria");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "temperaturaMaxima", "field.temperaturaMaxima.required", 
					"La temperatura Maxima es obligatoria");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "latitud", "field.latitud.required", 
					"La latitud es obligatoria");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "longitud", "field.longitud.required", 
					"La longitud es obligatoria");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "frecuencia", "field.frecuencia.required", 
					"La frecuencia es obligatoria");		
			
		}
}
