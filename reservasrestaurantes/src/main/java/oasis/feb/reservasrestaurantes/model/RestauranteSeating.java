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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class RestauranteSeating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@FutureOrPresent(message="A Data de Reserva tem de ser uma Data Presente ou Futuro!!") 
	@NotNull(message="A Data de Reserva nao pode ser Null")
	@Column(name="data", nullable=false, unique=false, updatable=true)
	private LocalDate data;
	
	@Min(1)
	@Max(100)
	@Column(name="lotacao", nullable=false, unique=false, updatable=true)
	private Integer lotacao;
	
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
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="seating_id", referencedColumnName = "id", nullable=false)
    private Seating seating;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="restaurante_id", referencedColumnName = "id", nullable=false)
    private Restaurante restaurante;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="menu_id", referencedColumnName = "id", nullable=false)
    private Menu menu;
	
	@OneToMany(mappedBy="restauranteSeating")
	private List<Reserva> reservas;
	
	public RestauranteSeating() {}
	
	public RestauranteSeating(Long id, 
							  LocalDate data, 
							  Integer lotacao,
							  Boolean ativo,
							  LocalDateTime dataCriacao,
							  LocalDateTime dataUltimaActualizacao) {
		this.id = id;
		this.data = data;
		this.lotacao = lotacao;
		this.ativo = ativo;
		this.dataCriacao = dataCriacao;
		this.dataUltimaActualizacao = dataUltimaActualizacao;
	}	


	public RestauranteSeating(LocalDate data, 
							  Integer lotacao, 
							  Boolean ativo,
							  LocalDateTime dataCriacao,
							  LocalDateTime dataUltimaActualizacao) {
		this.data = data;
		this.lotacao = lotacao;
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

	public LocalDate getData() {
		return this.data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Integer getLotacao() {
		return this.lotacao;
	}

	public void setLotacao(Integer lotacao) {
		this.lotacao = lotacao;
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
	
	

	public Seating getSeating() {
		return seating;
	}

	public void setSeating(Seating seating) {
		this.seating = seating;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	@Override
	public String toString() {
		return "RestauranteSeating [id=" + id + 
			   ", data=" + data + 
			   ", lotacao=" + lotacao + 
			   ", ativo=" + ativo + 
			   ", dataCriacao=" + dataCriacao + 
			   ", dataUltimaActualizacao=" + dataUltimaActualizacao + "]";
	}
	
	
}
