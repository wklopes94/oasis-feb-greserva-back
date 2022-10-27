package oasis.feb.reservasrestaurantes.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "O Atributo NOME está Vazio!")
	@Size(min=2, 
	  max=64,
	  message = "O Numero de caracteres do atributo 'NOME' tem de estar entre 2 and 64!")
	@Column(name= "nome", length=64, nullable=false, unique=false, updatable=true)
	private String nome;
	
	@NotEmpty(message = "O Atributo APELIDO não pode ser Vazio!")
	@Size(min=2, 
	  max=64,
	  message = "O Numero de caracteres do atributo 'APELIDO' tem de estar entre 2 and 64!")
	@Column(name= "apelido", length=64, nullable=false, unique=false, updatable=true)
	private String apelido;
	
	@NotEmpty(message="O Atributo EMAIL não pode ser vazio ou nulo")
	@Email(message="O EMAIL introduzido não Corresponde a um Formato Valido!!!")
	@Column(name= "email", length=320, nullable=false, unique=true, updatable=true)
	private String email;
	
	@NotEmpty(message = "O Atributo TELEFONE não pode ser Vazio!")
	@Size(min=7, 
	  max=15,
	  message = "O Numero de caracteres do atributo 'TELEFONE' tem de estar entre 7 and 15!")
	@Column(name= "telefone", length=15, nullable=false, unique=true, updatable=true)
	private String telefone;
	
	@NotEmpty(message = "O Atributo TIPO não pode ser Vazio!")
	@Size(min=2, 
	  max=64,
	  message = "O Numero de caracteres do atributo 'TIPO' tem de estar entre 2 and 64!")
	@Column(name= "tipo", length=64, nullable=false, unique=false, updatable=true)
	private String tipo;
	
	
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
	@OneToOne(mappedBy = "cliente")
	private Hospede hospede;
	
	@OneToOne(mappedBy = "cliente")
	private Particular particular;
	
	@OneToOne(mappedBy = "cliente")
	private Grupo grupo;
	
	@OneToMany(mappedBy="cliente")
	private List<Reserva> reservas;
	
	
	public Cliente() {
		super();
	}

	public Cliente(String nome, 
				   String apelido, 
				   String email, 
				   String telefone,
				   String tipo,
				   Boolean ativo, 
				   LocalDateTime dataCriacao,
				   LocalDateTime dataUltimaActualizacao) {
		super();
		this.nome = nome;
		this.apelido = apelido;
		this.email = email;
		this.telefone = telefone;
		this.tipo = tipo;
		this.ativo = ativo;
		this.dataCriacao = dataCriacao;
		this.dataUltimaActualizacao = dataUltimaActualizacao;
	}

	public Cliente(Long id, 
				   String nome, 
				   String apelido, 
				   String email, 
				   String telefone, 
				   String tipo,
				   Boolean ativo,
				   LocalDateTime dataCriacao, 
				   LocalDateTime dataUltimaActualizacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.apelido = apelido;
		this.email = email;
		this.telefone = telefone;
		this.tipo = tipo;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	

	public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}

	public Particular getParticular() {
		return particular;
	}

	public void setParticular(Particular particular) {
		this.particular = particular;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + 
				", nome=" + nome + 
				", apelido=" + apelido + 
				", email=" + email + 
				", telefone=" + telefone + 
				", tipo=" + tipo +
				", ativo=" + ativo + 
				", dataCriacao=" + dataCriacao + 
				", dataUltimaActualizacao="	+ dataUltimaActualizacao + "]";
	}	
	
}
