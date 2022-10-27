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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Pagamento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "O Atributo TIPO não pode ser Vazio!")
	@Size(min=2, 
	  max=64,
	  message = "O Numero de caracteres do atributo 'TIPO' tem de estar entre 2 and 64!")
	@Column(name= "tipo", length=64, nullable=false, unique=true, updatable=true)
	private String tipo;
	
	@NotEmpty(message = "O Atributo DESCRIÇÃO não pode ser Vazio!")
	@Size(min=2, 
	  max=500,
	  message = "O Numero de caracteres do atributo 'DESCRIÇÂO' tem de estar entre 2 and 500!")
	@Column(name= "descricao", length=500, nullable=false, unique=true, updatable=true)
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

	
	/* Entidades dos Relacionamentos*/
	@OneToMany(mappedBy="utilizador")
	private List<Reserva> reservas;
	
	
	public Pagamento() {
		super();
	}

	public Pagamento(String tipo, String descricao, Boolean ativo, LocalDateTime dataCriacao,
			LocalDateTime dataUltimaActualizacao) {
		super();
		this.tipo = tipo;
		this.descricao = descricao;
		this.ativo = ativo;
		this.dataCriacao = dataCriacao;
		this.dataUltimaActualizacao = dataUltimaActualizacao;
	}

	public Pagamento(Long id, String tipo, String descricao, Boolean ativo, LocalDateTime dataCriacao,
			LocalDateTime dataUltimaActualizacao) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.descricao = descricao;
		this.ativo = ativo;
		this.dataCriacao = dataCriacao;
		this.dataUltimaActualizacao = dataUltimaActualizacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getDataUltimaActualizacao() {
		return dataUltimaActualizacao;
	}

	public void setDataUltimaActualizacao(LocalDateTime dataUltimaActualizacao) {
		this.dataUltimaActualizacao = dataUltimaActualizacao;
	}
	
	

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	@Override
	public String toString() {
		return "Pagamento [id=" + id + 
				", tipo=" + tipo + 
				", descricao=" + descricao + 
				", ativo=" + ativo + 
				", dataCriacao=" + dataCriacao + 
				", dataUltimaActualizacao=" + dataUltimaActualizacao + "]";
	}
	
	
}
