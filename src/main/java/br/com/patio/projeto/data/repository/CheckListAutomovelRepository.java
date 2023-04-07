package br.com.patio.projeto.data.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.patio.projeto.data.repository.query.CheckListAutomovelQuery;
import br.com.patio.projeto.entity.CheckListAutomovelEntity;
import br.com.patio.projeto.entity.RetiraVeiculoEntity;

public interface CheckListAutomovelRepository extends PagingAndSortingRepository<CheckListAutomovelEntity, Long>{

	Optional<CheckListAutomovelEntity> findById(Long oid);

	CheckListAutomovelEntity save(CheckListAutomovelEntity old);

	void delete(CheckListAutomovelEntity address);

	@Query(value = CheckListAutomovelQuery.FIND_Placa)
	List<CheckListAutomovelEntity> findByList(@Param("placa") String placa );
	
	@Query(value = CheckListAutomovelQuery.FIND_Placa)
	CheckListAutomovelEntity findByPlaca(@Param("placa") String placa );

	
}