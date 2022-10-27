package oasis.feb.reservasrestaurantes.repository;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;

import oasis.feb.reservasrestaurantes.model.Cliente;
import oasis.feb.reservasrestaurantes.model.Estado;

@RepositoryRestResource(collectionResourceRel = "estados", path = "estados")
public interface EstadoRepository extends JpaRepository<Estado, Long>{

	Page<Estado> findById(Long id, Pageable pageable);
	
	Page<Estado> findByValor(String valor, Pageable pageable);
	
	Page<Estado> findByAtivo(Boolean ativo, Pageable pageable);
	
	Page<Estado> findByDataCriacao(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
									LocalDateTime dataCriacao, 
									Pageable pageable);

	Page<Estado> findByDataUltimaActualizacao(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
									LocalDateTime dataUltimaActualizacao, 
									Pageable pageable);
}
