package oasis.feb.reservasrestaurantes.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;

import oasis.feb.reservasrestaurantes.model.Reserva;
import oasis.feb.reservasrestaurantes.model.RestauranteSeating;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{

	Page<Reserva> findById(Long id, Pageable pageable);
	
	
	Page<Reserva> findByNumeroAdulto(Integer numeroAdulto, Pageable pageable);
	
	
	Page<Reserva> findByNumeroCrianca(Integer numeroCrianca, Pageable pageable);	
	
	Page<Reserva> findByDataReserva(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) 
									LocalDate dataReserva, 
									Pageable pageable);
	
	Page<Reserva> findByUtilizadorId(Long id, Pageable pageable);
	
	
	Page<Reserva> findByRestauranteSeatingId(Long id, Pageable pageable);
	
	
	Page<Reserva> findByPagamentoId(Long id, Pageable pageable);
	
	
	Page<Reserva> findByExtrasId(Long id, Pageable pageable);
	
	
	Page<Reserva> findByEstadoId(Long id, Pageable pageable);
	
	
	Page<Reserva> findByClienteId(Long id, Pageable pageable);
	
	
	Page<Reserva> findByAtivo(Boolean ativo, Pageable pageable);
	
	Page<Reserva> findByDataCriacao(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
									LocalDateTime dataCriacao, 
									Pageable pageable);

	Page<Reserva> findByDataUltimaActualizacao(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
									LocalDateTime dataUltimaActualizacao, 
									Pageable pageable);

}