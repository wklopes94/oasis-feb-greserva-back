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
@Constraint(validatedBy = {NumeroCriancaValidator.class})
public @interface NumeroCrianca {

	String message() default "O Numro de crianças deve estar entre 0-10";
	int minimo() default 0;
	int maximo() default 10;
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
