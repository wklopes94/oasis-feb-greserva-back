package oasis.feb.reservasrestaurantes.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumeroQuartoValidator implements ConstraintValidator<NumeroQuarto, Integer>{

	private int numQuarto;
	
	@Override
	public void initialize(NumeroQuarto numeroQuarto) {
		//executar tarefas necessarias para a implementacao e inicializacao
		//não é obrigatorio mas deve ser feito.
		//write post construct work		
		this.numQuarto = numeroQuarto.numeroQuarto();
		
	}
	@Override
	public boolean isValid(Integer numeroQuarto, ConstraintValidatorContext context) {
		
		//////////////////////////piso -1/////////////////////////////////////////
		if(numeroQuarto==null) {
			return false;
		}
		if(numeroQuarto>=101 && numeroQuarto<=112) {
			return true;
		}
		
		if(numeroQuarto>=114 && numeroQuarto<=141) {
			return true;
		}
		
		//////////////////////////piso 0/////////////////////////////////////////
		if(numeroQuarto>=1000 && numeroQuarto<=1012) {
			return true;
		}
		
		if(numeroQuarto>=1014 && numeroQuarto<=1033) {
			return true;
		}
		
		if(numeroQuarto>=1035 && numeroQuarto<=1057) {
			return true;
		}
		
		if(numeroQuarto>=1059 && numeroQuarto<=1112) {
			return true;
		}
		
		if(numeroQuarto>=1114 && numeroQuarto<=1115) {
			return true;
		}
		
		if(numeroQuarto==1117) {
			return true;
		}
		
		if(numeroQuarto>=1119 && numeroQuarto<=1141) {
			return true;
		}
		
		if(numeroQuarto>=1143 && numeroQuarto<=1147) {
			return true;
		}
		//////////////////////////piso 1/////////////////////////////////////////
		if(numeroQuarto>=2000 && numeroQuarto<=2012) {
			return true;
		}
		
		if(numeroQuarto>=2014 && numeroQuarto<=2039) {
			return true;
		}
		
		if(numeroQuarto>=2041 && numeroQuarto<=2063) {
			return true;
		}
		
		if(numeroQuarto>=2065 && numeroQuarto<=2090) {
			return true;
		}
		
		if(numeroQuarto>=2092 && numeroQuarto<=2111) {
			return true;
		}
		
		if(numeroQuarto>=2114 && numeroQuarto<=2134) {
			return true;
		}
		
		if(numeroQuarto>=2136 && numeroQuarto<=2163) {
			return true;
		}
		return false;
	}
	
	

}
