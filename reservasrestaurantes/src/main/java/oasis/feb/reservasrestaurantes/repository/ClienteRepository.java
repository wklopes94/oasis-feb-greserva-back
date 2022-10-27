package oasis.feb.reservasrestaurantes.repository;


import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import oasis.feb.reservasrestaurantes.model.Cliente;


@RepositoryRestResource(collectionResourceRel = "clientes", path = "clientes")
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	Page<Cliente> findById(Long id, Pageable pageable);
	
	Page<Cliente> findByNome(String nome, Pageable pageable);
	
	Page<Cliente> findByEmail(String email, Pageable pageable);
	
	Page<Cliente> findByApelido(String apelido, Pageable pageable);
	
	Page<Cliente> findByTelefone(String telefone, Pageable pageable);
	
	Page<Cliente> findByTipo(String tipo, Pageable pageable);
	
	Page<Cliente> findByAtivo(Boolean ativo, Pageable pageable);
	
	
    
	Page<Cliente> findByDataCriacao(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
									LocalDateTime dataCriacao, 
									Pageable pageable);
	
	Page<Cliente> findByDataUltimaActualizacao(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
												LocalDateTime dataUltimaActualizacao, 
												Pageable pageable);
	
	
}
