package oasis.feb.reservasrestaurantes.repository;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;

import oasis.feb.reservasrestaurantes.model.Estado;
import oasis.feb.reservasrestaurantes.model.Hospede;
import oasis.feb.reservasrestaurantes.model.Pagamento;

@RepositoryRestResource(collectionResourceRel = "pagamentos", path = "pagamentos")
public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{

	Page<Pagamento> findById(Long id, Pageable pageable);
	
	Page<Pagamento> findByTipo(String tipo, Pageable pageable);
	
	Page<Pagamento> findByAtivo(Boolean ativo, Pageable pageable);
	
	Page<Pagamento> findByDataCriacao(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
									LocalDateTime dataCriacao, 
									Pageable pageable);

	Page<Pagamento> findByDataUltimaActualizacao(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
									LocalDateTime dataUltimaActualizacao, 
									Pageable pageable);
	
	
	Page<Pagamento> findByReservasId(Long id, Pageable pageable);
}
