package oasis.feb.reservasrestaurantes.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = {NumeroQuartoValidator.class})
public @interface NumeroQuarto {

	String message() default "O Numero de Quarto é Invalido!!!";
	int numeroQuarto() default 0;
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
