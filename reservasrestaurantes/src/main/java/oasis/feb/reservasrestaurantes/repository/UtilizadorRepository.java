package oasis.feb.reservasrestaurantes.repository;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;

import oasis.feb.reservasrestaurantes.model.Restaurante;
import oasis.feb.reservasrestaurantes.model.Seating;
import oasis.feb.reservasrestaurantes.model.Utilizador;

@RepositoryRestResource(collectionResourceRel = "utilizadores", path = "utilizadores")
public interface UtilizadorRepository extends JpaRepository<Utilizador, Long>{

	Page<Utilizador> findById(Long id, Pageable pageable);
	
	Page<Utilizador> findByUserName(String userName, Pageable pageable);
	
	Page<Utilizador> findByPassword(String password, Pageable pageable);
	
	Page<Utilizador> findByEmail(String email, Pageable pageable);
	
	Page<Utilizador> findByAtivo(Boolean ativo, Pageable pageable);
	
	Page<Utilizador> findByDataCriacao(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
									LocalDateTime dataCriacao, 
									Pageable pageable);
	
	Page<Utilizador> findByDataUltimaActualizacao(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
	LocalDateTime dataUltimaActualizacao, 
	Pageable pageable);
	
	Page<Utilizador> findByReservasId(Long id, Pageable pageable);

}
