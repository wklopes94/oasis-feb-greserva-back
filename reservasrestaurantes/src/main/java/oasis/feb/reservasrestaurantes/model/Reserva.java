package oasis.feb.reservasrestaurantes.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import oasis.feb.reservasrestaurantes.validator.NumeroCrianca;

@Entity
public class Reserva {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Positive(message="O Numero de Adultos de uma Reserva deve ser Maior que Zero")
	@Min(1)
	@Max(10)
	@Column(name="numero_adulto", nullable=false, unique=false, updatable=true)
	private Integer numeroAdulto;
	
	//@PositiveOrZero(message="O Numero de Crianças de uma Reserva deve ser Maior ou igual a Zero")
	//@Min(0)
	//@Max(5)
	@NumeroCrianca(minimo = 1, maximo = 5, message="O NUMERO CRIANCA DEVE ESTAR ENTRE 1-5")
	@Column(name="numero_crianca", nullable=false,unique=false, updatable=true, columnDefinition = "int default 0")
	private Integer numeroCrianca;
	
	@Column(name="data_reserva", nullable=false, updatable=true, unique=false)
	private LocalDate dataReserva;
	
	@NotEmpty(message = "O Atributo OBSERVAÇÕES não pode ser Vazio!")
	@Size(min=2, 
	  max=500,
	  message = "O Numero de caracteres do atributo 'OBSERVAÇÔES' tem de estar entre 2 and 500!")
	@Column(name= "observacoes", length=500, nullable=false, unique=false, updatable=true)
	private String observacoes;
	
	
	@NotEmpty(message = "O Atributo COMENTARIOS não pode ser Vazio!")
	@Size(min=2, 
	  max=500,
	  message = "O Numero de caracteres do atributo 'APELIDO' tem de estar entre 2 and 500!")
	@Column(name= "comentarios", length=500, nullable=false, unique=false, updatable=true)
	private String comentarios;
	
	
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
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estado_id", referencedColumnName = "id", nullable=false)
	private Estado estado;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cliente_id", referencedColumnName = "id", nullable=false)
    private Cliente cliente;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="utilizador_id", referencedColumnName = "id", nullable=false)
    private Utilizador utilizador;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="pagamento_id", referencedColumnName = "id", nullable=false)
    private Pagamento pagamento;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="restaurante_seating_id", referencedColumnName = "id", nullable=false)
    private RestauranteSeating restauranteSeating;
	
	@ManyToMany	
	@JoinTable(name = "reserva_has_extra", 
			   joinColumns = @JoinColumn(name = "reserva_id"), 
			   inverseJoinColumns = @JoinColumn(name = "extra_id"))
	private List<Extra> extras;
	
	public Reserva() {}
	
	public Reserva(Integer numeroAdulto, 
				   Integer numeroCrianca, 
				   LocalDate dataReserva,
				   String observacoes, 
				   String comentarios, 
				   Boolean ativo,
				   LocalDateTime dataCriacao, 
				   LocalDateTime dataUltimaActualizacao) {
		this.numeroAdulto = numeroAdulto;
		this.numeroCrianca = numeroCrianca;
		this.dataReserva = dataReserva;
		this.observacoes = observacoes;
		this.comentarios = comentarios;
		this.ativo = ativo;
		this.dataCriacao = dataCriacao;
		this.dataUltimaActualizacao = dataUltimaActualizacao;
	}

	public Reserva(Long id, 
				   Integer numeroAdulto, 
				   Integer numeroCrianca,
				   LocalDate dataReserva, 
				   String observacoes, 
				   String comentarios,
				   Boolean ativo,
				   LocalDateTime dataCriacao,
				   LocalDateTime dataUltimaActualizacao) {
		this.id = id;
		this.numeroAdulto = numeroAdulto;
		this.numeroCrianca = numeroCrianca;
		this.dataReserva = dataReserva;
		this.observacoes = observacoes;
		this.comentarios = comentarios;
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

	public Integer getNumeroAdulto() {
		return this.numeroAdulto;
	}

	public void setNumeroAdulto(Integer numeroAdulto) {
		this.numeroAdulto = numeroAdulto;
	}

	public Integer getNumeroCrianca() {
		return this.numeroCrianca;
	}

	public void setNumeroCrianca(Integer numeroCrianca) {
		this.numeroCrianca = numeroCrianca;
	}

	public LocalDate getDataReserva() {
		return this.dataReserva;
	}

	public void setDataReserva(LocalDate dataReserva) {
		this.dataReserva = dataReserva;
	}

	public String getObservacoes() {
		return this.observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
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
	
	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Utilizador getUtilizador() {
		return utilizador;
	}

	public void setUtilizador(Utilizador utilizador) {
		this.utilizador = utilizador;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public RestauranteSeating getRestauranteSeating() {
		return restauranteSeating;
	}

	public void setRestauranteSeating(RestauranteSeating restauranteSeating) {
		this.restauranteSeating = restauranteSeating;
	}

	public List<Extra> getExtras() {
		return extras;
	}

	public void setExtras(List<Extra> extras) {
		this.extras = extras;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + 
			   ", numeroAdulto=" + this.numeroAdulto + 
			   ", numeroCrianca=" + this.numeroCrianca + 
			   ", dataReserva=" + this.dataReserva + 
			   ", observacoes=" + this.observacoes + 
			   ", comentarios=" + this.comentarios + 
			   ", ativo=" + ativo +
			   ", dataCriacao=" + this.dataCriacao + 
			   ", dataUltimaActualizacao=" + this.dataUltimaActualizacao + "]";
	}

}
