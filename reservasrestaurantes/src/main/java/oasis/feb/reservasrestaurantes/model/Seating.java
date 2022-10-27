package oasis.feb.reservasrestaurantes.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

@Entity
public class Seating {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="O Atributo Hora de Inicio nao pode ser Null!!!")
	@Column(name="hora_inicio", nullable = false, unique=false, updatable=true)
	private LocalTime horaInicio;
	
	@NotNull(message="O Atributo Hora de Fim nao pode ser Null!!!")
	@Column(name="hora_fim", nullable = false, unique=false, updatable=true)
	private LocalTime horaFim;
	
	@NotNull(message="O Atributo COMPLETO não pode ser NULL!!!")
	@Column(name="completo", nullable = false, unique=false, updatable=true, columnDefinition="boolean default false")
	private Boolean completo;
	
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
	@OneToMany(mappedBy="seating")
	private List<RestauranteSeating> restauranteSeatings;
	
	
	public Seating() {}

	public Seating(LocalTime horaInicio, 
				   LocalTime horaFim, 
				   Boolean ativo,
				   Boolean completo,
				   LocalDateTime dataCriacao, 
				   LocalDateTime dataUltimaActualizacao) {
		super();
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.ativo = ativo;
		this.completo = completo;
		this.dataCriacao = dataCriacao;
		this.dataUltimaActualizacao = dataUltimaActualizacao;
	}

	public Seating(Long id, 
				   LocalTime horaInicio, 
				   LocalTime horaFim, 
				   Boolean ativo,
				   Boolean completo,
				   LocalDateTime dataCriacao, 
				   LocalDateTime dataUltimaActualizacao) {
		super();
		this.id = id;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.completo = completo;
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

	public LocalTime getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFim() {
		return this.horaFim;
	}

	public void setHoraFim(LocalTime horaFim) {
		this.horaFim = horaFim;
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
	
	public Boolean getCompleto() {
		return completo;
	}

	public void setCompleto(Boolean completo) {
		this.completo = completo;
	}

	@Override
	public String toString() {
		return "Seating [id=" + id + 
			   ", horaInicio=" + horaInicio + 
			   ", horaFim=" + horaFim + 
			   ", ativo=" + ativo +
			   ", completo=" + completo +
			   ", dataCriacao=" + dataCriacao + 
			   ", dataUltimaActualizacao="	+ dataUltimaActualizacao + "]";
	}	

}
