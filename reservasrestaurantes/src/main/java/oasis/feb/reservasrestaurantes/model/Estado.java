package oasis.feb.reservasrestaurantes.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "O Atributo VALOR não pode ser Vazio!")
	@Size(min=2, 
		  max=64,
		  message = "O Numero de caracteres do atributo 'VALOR' tem de estar entre 2 and 64!")
	@Column(name="valor", length=64, nullable=false, unique=true, updatable=true)
	private String valor; //possivelmente um ENUM
	
	@NotEmpty(message = "O Atributo DESCRIÇÃO não pode ser Vazio!")
	@Size(min=2, 
		  max=500,
		  message = "O Numero de caracteres do atributo'DESCRIÇÂO' tem de estar entre 2 and 500!")
	@Column(name="descricao", length=500, nullable=false, unique=false, updatable=true)
	private String descricao;
	
	@NotNull(message="O Atributo ATIVO não pode ser NULL!!!")
	@Column(name="ativo", nullable=false, unique= false, updatable= true, columnDefinition="boolean default false")
	private Boolean ativo;
	
	@FutureOrPresent(message="A Data de Criacão tem de ser uma Data Presente ou Futuro!!") 
	@NotNull(message="A Data de Criacao nao pode ser Null")
	@Column(name="create_time", nullable=false, updatable=false, unique=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime dataCriacao;
	
	@FutureOrPresent(message="A Data de Actualizacao tem de ser uma Data Presente ou Futuro!!") 
	@NotNull(message="A Data de Actualizacao nao pode ser Null")
	@Column(name="last_update", nullable=false, updatable=true, unique=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime dataUltimaActualizacao;	


	public Estado() {}

	public Estado(String valor, 
				  String descricao, 
				  Boolean ativo, 
				  LocalDateTime dataCriacao,
				  LocalDateTime dataUltimaActualizacao) {
		this.valor = valor;
		this.descricao = descricao;
		this.ativo = ativo;
		this.dataCriacao = dataCriacao;
		this.dataUltimaActualizacao = dataUltimaActualizacao;
	}

	public Estado(Long id, 
				  String valor, 
				  String descricao, 
				  Boolean ativo, 
				  LocalDateTime dataCriacao,
				  LocalDateTime dataUltimaActualizacao) {
		this.id = id;
		this.valor = valor;
		this.descricao = descricao;
		this.ativo = ativo;
		this.dataCriacao = dataCriacao;
		this.dataUltimaActualizacao = dataUltimaActualizacao;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getAtivo() {
		return this.ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public LocalDateTime getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getDataUltimaActualizacao() {
		return this.dataUltimaActualizacao;
	}

	public void setDataUltimaActualizacao(LocalDateTime dataUltimaActualizacao) {
		this.dataUltimaActualizacao = dataUltimaActualizacao;
	}

	@Override
	public String toString() {
		return "Estado [id=" + this.id + 
			   ", valor=" + this.valor + 
			   ", descricao=" + this.descricao + 
			   ", ativo=" + this.ativo + 
			   ", dataCriacao=" + this.dataCriacao + 
			   ", dataUltimaActualizacao=" + this.dataUltimaActualizacao + "]";
	}	

}