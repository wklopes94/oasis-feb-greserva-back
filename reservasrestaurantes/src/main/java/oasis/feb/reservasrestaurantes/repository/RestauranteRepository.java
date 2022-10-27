package oasis.feb.reservasrestaurantes.repository;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;

import oasis.feb.reservasrestaurantes.model.Restaurante;
import oasis.feb.reservasrestaurantes.model.Seating;

@RepositoryRestResource(collectionResourceRel = "restaurantes", path = "restaurantes")
public interface RestauranteRepository extends JpaRepository<Restaurante, Long>{

	Page<Restaurante> findById(Long id, Pageable pageable);

	
	Page<Restaurante> findByNome(String nome, Pageable pageable);
	
	
	Page<Restaurante> findByLotacaoMaxima(Integer lotacaoMaxima, Pageable pageable);
	
	
	Page<Restaurante> findByAtivo(Boolean ativo, Pageable pageable);
	
	Page<Restaurante> findByDataCriacao(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
									LocalDateTime dataCriacao, 
									Pageable pageable);

	Page<Restaurante> findByDataUltimaActualizacao(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
									LocalDateTime dataUltimaActualizacao, 
									Pageable pageable);
	
	Page<Restaurante> findByRestauranteSeatingsId(Long id, Pageable pageable);
}
