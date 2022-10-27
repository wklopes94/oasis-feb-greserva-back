package oasis.feb.reservasrestaurantes.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import oasis.feb.reservasrestaurantes.model.Hospede;
import oasis.feb.reservasrestaurantes.model.Particular;

@RepositoryRestResource(collectionResourceRel = "particulares", path = "particulares")
public interface ParticularRepository extends JpaRepository<Particular, Long>{
	
	Page<Particular> findById(Long id, Pageable pageable);
	
	Page<Particular> findByClienteId(Long id, Pageable pageable);

}
