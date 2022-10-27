package oasis.feb.reservasrestaurantes.repository;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;

import oasis.feb.reservasrestaurantes.model.Extra;
import oasis.feb.reservasrestaurantes.model.Pagamento;

@RepositoryRestResource(collectionResourceRel = "extras", path = "extras")
public interface ExtraRepository extends JpaRepository<Extra, Long>{

	Page<Extra> findById(Long id, Pageable pageable);
	
	Page<Extra> findByNome(String nome, Pageable pageable);
	
	Page<Extra> findByAtivo(Boolean ativo, Pageable pageable);
	
	Page<Extra> findByDataCriacao(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
									LocalDateTime dataCriacao, 
									Pageable pageable);

	Page<Extra> findByDataUltimaActualizacao(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
									LocalDateTime dataUltimaActualizacao, 
									Pageable pageable);
	
	
	Page<Extra> findByReservasId(Long id, Pageable pageable);
}
