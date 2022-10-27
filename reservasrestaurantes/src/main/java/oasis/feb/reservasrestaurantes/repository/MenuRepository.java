package oasis.feb.reservasrestaurantes.repository;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;

import oasis.feb.reservasrestaurantes.model.Extra;
import oasis.feb.reservasrestaurantes.model.Menu;

@RepositoryRestResource(collectionResourceRel = "menus", path = "menus")
public interface MenuRepository extends JpaRepository<Menu, Long>{

	Page<Menu> findById(Long id, Pageable pageable);
	
	Page<Menu> findByNome(String nome, Pageable pageable);
	
	Page<Menu> findByAtivo(Boolean ativo, Pageable pageable);
	
	Page<Menu> findByDataCriacao(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
									LocalDateTime dataCriacao, 
									Pageable pageable);

	Page<Menu> findByDataUltimaActualizacao(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
									LocalDateTime dataUltimaActualizacao, 
									Pageable pageable);
	
	
	Page<Menu> findByRestauranteSeatingsId(Long id, Pageable pageable);
}
