package oasis.feb.reservasrestaurantes.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import oasis.feb.reservasrestaurantes.validator.NumeroCrianca;
import oasis.feb.reservasrestaurantes.validator.NumeroQuarto;

@Entity
public class Hospede {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	//@Positive(message="Numero de Quarto Invalido: Tem de ser um Numero Positivo")
	//@Min(2)
	//@Max(10)
	@NumeroQuarto
	@Column(name= "numero_quarto", nullable=false, unique=false, updatable=true)
	private Integer numeroQuarto;
	
	@NotEmpty(message = "O Atributo NACIONALIDADE não pode ser Vazio!")
	@Size(min=2, 
	  max=100,
	  message = "O Numero de caracteres do atributo 'NACIONALIDADE' tem de estar entre 2 and 100!")
	@Column(name= "nacionalidade", length=100, nullable=false, unique=false, updatable=true)
	private String nacionalidade;		
	
	/* Entidades dos Relacionamentos*/
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id", nullable=false)
	private Cliente cliente;
	
	
	public Hospede() {}

	public Hospede(Integer numeroQuarto, String nacionalidade) {
		this.numeroQuarto = numeroQuarto;
		this.nacionalidade = nacionalidade;
	}

	public Hospede(Long id, Integer numeroQuarto, String nacionalidade) {
		this.id = id;
		this.numeroQuarto = numeroQuarto;
		this.nacionalidade = nacionalidade;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}	

	public Integer getNumeroQuarto() {
		return this.numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public String getNacionalidade() {
		return this.nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Hospede [id=" + this.id + 
			   ", numeroQuarto=" + this.numeroQuarto + 
			   ", nacionalidade=" + this.nacionalidade + "]";
	}	
	
}
