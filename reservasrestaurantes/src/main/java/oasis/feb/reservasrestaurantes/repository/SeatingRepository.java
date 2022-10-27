package oasis.feb.reservasrestaurantes.repository;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;

import oasis.feb.reservasrestaurantes.model.Menu;
import oasis.feb.reservasrestaurantes.model.Seating;

@RepositoryRestResource(collectionResourceRel = "seatings", path = "seatings")
public interface SeatingRepository extends JpaRepository<Seating, Long>{

	Page<Seating> findById(Long id, Pageable pageable);
	
	Page<Seating> findByAtivo(Boolean ativo, Pageable pageable);
	
	Page<Seating> findByDataCriacao(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
									LocalDateTime dataCriacao, 
									Pageable pageable);

	Page<Seating> findByDataUltimaActualizacao(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
									LocalDateTime dataUltimaActualizacao, 
									Pageable pageable);
	
	Page<Seating> findByCompleto(Boolean completo, Pageable pageable);
	
	Page<Seating> findByHoraInicio(@DateTimeFormat(iso = DateTimeFormat.ISO.TIME) 
									LocalTime horaInicio, 
									Pageable pageable);
	
	Page<Seating> findByHoraFim(@DateTimeFormat(iso = DateTimeFormat.ISO.TIME) 
									LocalTime horaFim, 
									Pageable pageable);
	
	Page<Seating> findByRestauranteSeatingsId(Long id, Pageable pageable);
	

}
