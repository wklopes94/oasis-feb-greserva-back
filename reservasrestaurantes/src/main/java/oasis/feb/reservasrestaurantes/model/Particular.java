package oasis.feb.reservasrestaurantes.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Particular {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "O Atributo OBSERVAÇÃO não pode ser Vazio!")
	@Size(min=2, 
	  max=500,
	  message = "O Numero de caracteres do atributo 'OBSERVAÇÂO' tem de estar entre 2 and 500!")
	@Column(name= "observacao", length=500, nullable=false, unique=false, updatable=true)
	private String observacao;

	/* Entidades dos Relacionamentos*/
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id", nullable=false)
	private Cliente cliente;
	
	public Particular() {
		super();
	}

	public Particular(String observacao) {
		super();
		this.observacao = observacao;
	}

	public Particular(Long id, String observacao) {
		super();
		this.id = id;
		this.observacao = observacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

	@Override
	public String toString() {
		return "Particular [id=" + id + ", observacao=" + observacao + "]";
	}
	
		
}
