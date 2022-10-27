package oasis.feb.reservasrestaurantes.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;

import oasis.feb.reservasrestaurantes.model.Extra;
import oasis.feb.reservasrestaurantes.model.Restaurante;
import oasis.feb.reservasrestaurantes.model.RestauranteSeating;
import oasis.feb.reservasrestaurantes.model.Seating;

@RepositoryRestResource(collectionResourceRel = "restaurante_seating", path = "restauranteSeating")
public interface RestauranteSeatingRepository extends JpaRepository<RestauranteSeating, Long>{

	Page<RestauranteSeating> findById(Long id, Pageable pageable);
	
	Page<RestauranteSeating> findByLotacao(Integer lotacao, Pageable pageable);
	
	Page<RestauranteSeating> findByData(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) 
								LocalDate data, 
								Pageable pageable);
	
	Page<RestauranteSeating> findByAtivo(Boolean ativo, Pageable pageable);
	
	Page<RestauranteSeating> findByDataCriacao(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
									LocalDateTime dataCriacao, 
									Pageable pageable);

	Page<RestauranteSeating> findByDataUltimaActualizacao(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
									LocalDateTime dataUltimaActualizacao, 
									Pageable pageable);
	
	Page<RestauranteSeating> findByMenuId(Long id, Pageable pageable);
	
	Page<RestauranteSeating> findByReservasId(Long id, Pageable pageable);
	
	Page<RestauranteSeating> findByRestauranteId(Long id, Pageable pageable);
	
	Page<RestauranteSeating> findBySeatingId(Long id, Pageable pageable);
}
