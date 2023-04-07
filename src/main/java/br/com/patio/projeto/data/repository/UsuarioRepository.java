package br.com.patio.projeto.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.patio.projeto.data.repository.query.UsuarioQuery;
import br.com.patio.projeto.entity.UsuarioEntity;

public interface UsuarioRepository extends PagingAndSortingRepository<UsuarioEntity, Long>{
	
	public UsuarioEntity findByDsLoginAndDssenha(@Param("dsLogin") String dsLogin, @Param("dssenha") String Dssenha);

	List<UsuarioEntity> findByNrcpf(@Param("nrcpf") String nrcpf);
	
	List<UsuarioEntity> findByDsLogin(@Param("dsLogin") String dsLogin);  
	
	@Query(value = UsuarioQuery.FIND_TABELA_Example)
    Page<UsuarioEntity> findByExample(@Param("nmusuario") String nmusuario,  Pageable pageRequest);

	/*@Query(value = UsuarioQuery.FIND_TABELA_Usuairo)
	public List<UsuarioTabelaDTO> findTabelaUsuario(@Param("field") String field);
     */

}