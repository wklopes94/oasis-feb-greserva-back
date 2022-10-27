package oasis.feb.reservasrestaurantes.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Restaurante {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "O Atributo NOME não pode ser Vazio!")
	@Size(min=2, 
	  max=64,
	  message = "O Numero de caracteres do atributo 'NOME' tem de estar entre 2 and 64!")
	@Column(name="nome", length=64, nullable = false, unique=true, updatable=true)
	private String nome;
	@Min(1)
	@Max(100)
	@Column(name="lotacao_maxima", nullable = false, unique=false, updatable=true)
	private Integer lotacaoMaxima;
	
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
	
	/* Entidades dos Relacionamentos*/
	@OneToMany(mappedBy="restaurante")
	private List<RestauranteSeating> restauranteSeatings;
	
	public Restaurante() {}

	public Restaurante(String nome, 
					   Integer lotacaoMaxima, 
					   Boolean ativo, 
					   LocalDateTime dataCriacao,
					   LocalDateTime dataUltimaActualizacao) {
		this.nome = nome;
		this.lotacaoMaxima = lotacaoMaxima;
		this.ativo = ativo;
		this.dataCriacao = dataCriacao;
		this.dataUltimaActualizacao = dataUltimaActualizacao;
	}

	public Restaurante(Long id, 
					   String nome, 
					   Integer lotacaoMaxima, 
					   Boolean ativo, 
					   LocalDateTime dataCriacao,
					   LocalDateTime dataUltimaActualizacao) {
		this.id = id;
		this.nome = nome;
		this.lotacaoMaxima = lotacaoMaxima;
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

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getLotacaoMaxima() {
		return this.lotacaoMaxima;
	}

	public void setLotacaoMaxima(Integer lotacaoMaxima) {
		this.lotacaoMaxima = lotacaoMaxima;
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

	
	
	public List<RestauranteSeating> getRestauranteSeatings() {
		return restauranteSeatings;
	}

	public void setRestauranteSeatings(List<RestauranteSeating> restauranteSeatings) {
		this.restauranteSeatings = restauranteSeatings;
	}

	@Override
	public String toString() {
		return "Restaurante [id=" + id + 
			   ", nome=" + this.nome + 
			   ", lotacaoMaxima=" + this.lotacaoMaxima + 
			   ", ativo=" + this.ativo + 
			   ", dataCriacao=" + this.dataCriacao + 
			   ", dataUltimaActualizacao=" + this.dataUltimaActualizacao + "]";
	}

}
