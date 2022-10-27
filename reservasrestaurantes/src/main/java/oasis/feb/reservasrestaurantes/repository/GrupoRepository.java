package oasis.feb.reservasrestaurantes.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import oasis.feb.reservasrestaurantes.model.Grupo;
import oasis.feb.reservasrestaurantes.model.Particular;

@RepositoryRestResource(collectionResourceRel = "grupos", path = "grupos")
public interface GrupoRepository extends JpaRepository<Grupo, Long>{

	Page<Grupo> findById(Long id, Pageable pageable);
	
	Page<Grupo> findByInstituicao(String instituicao, Pageable pageable);
	
	Page<Grupo> findByClienteId(Long id, Pageable pageable);
}
