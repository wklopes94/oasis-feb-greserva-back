package oasis.feb.reservasrestaurantes.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumeroCriancaValidator implements ConstraintValidator<NumeroCrianca, Integer>{

	private int minimo;
	private int maximo;
	
	@Override
	public void initialize(NumeroCrianca numeroCrianca) {
		//executar tarefas necessarias para a implementacao e inicializacao
		//não é obrigatorio mas deve ser feito.
		//write post construct work		
		this.minimo = numeroCrianca.minimo();
		this.maximo = numeroCrianca.maximo();
		
	}
	
	@Override
	public boolean isValid(Integer numeroCrianca, ConstraintValidatorContext context) {
		// escrever a logica da validacao aqui!
		if(numeroCrianca == null) {
			return false;
		}
		if(numeroCrianca < minimo || numeroCrianca > maximo ) {
			return false; //fail test
		}
		return true; //pass test
	}

}
