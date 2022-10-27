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
public class Grupo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "O Atributo OBSERVAÇÃO não pode ser Vazio!")
	@Size(min=2, 
	  max=500,
	  message = "O Numero de caracteres do atributo 'OBSERVACAO' tem de estar entre 2 and 500!")
	@Column(name= "observacao", length=500, nullable=false, unique=false, updatable=true)
	private String observacao;
	
	@NotEmpty(message = "O Atributo DESCRIÇÃO não pode ser Vazio!")
	@Size(min=2, 
	  max=500,
	  message = "O Numero de caracteres do atributo 'DESCRIÇÂO' tem de estar entre 2 and 500!")
	@Column(name= "descricao", length=500, nullable=false, unique=false, updatable=true)
	private String descricao;
	
	@NotEmpty(message = "O Atributo INSTITUIÇÃO não pode ser Vazio!")
	@Size(min=2, 
	  max=250,
	  message = "O Numero de caracteres do atributo 'INSTITUIÇÂO' tem de estar entre 2 and 250!")
	@Column(name= "instituicao", length=250, nullable=false, unique=false, updatable=true)
	private String instituicao;
	
	/* Entidades dos Relacionamentos*/
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id", nullable=false)
	private Cliente cliente;
	
	
	public Grupo() {
		super();
	}

	public Grupo(String observacao, String descricao, String instituicao) {
		super();
		this.observacao = observacao;
		this.descricao = descricao;
		this.instituicao = instituicao;
	}

	public Grupo(Long id, String observacao, String descricao, String instituicao) {
		super();
		this.id = id;
		this.observacao = observacao;
		this.descricao = descricao;
		this.instituicao = instituicao;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}
	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Grupo [id=" + id + 
				", observacao=" + observacao + 
				", descricao=" + descricao + 
				", instituicao=" + instituicao + "]";
	}
	
}
