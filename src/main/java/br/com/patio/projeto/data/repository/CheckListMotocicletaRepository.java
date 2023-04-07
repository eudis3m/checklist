package br.com.patio.projeto.data.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.patio.projeto.data.repository.query.CheckListMotocicletaQuery;
import br.com.patio.projeto.entity.CheckListMotocicletaEntity;
import br.com.patio.projeto.entity.RetiraVeiculoEntity;

public interface CheckListMotocicletaRepository extends PagingAndSortingRepository<CheckListMotocicletaEntity, Long>{

	Optional<CheckListMotocicletaEntity> findById(Long oid);

	CheckListMotocicletaEntity save(CheckListMotocicletaEntity old);

	void delete(CheckListMotocicletaEntity address);

	@Query(value = CheckListMotocicletaQuery.FIND_Placa)
	List<CheckListMotocicletaEntity> findByList(@Param("placa") String placa );
	
	@Query(value = CheckListMotocicletaQuery.FIND_Placa)
	CheckListMotocicletaEntity findByPlaca(@Param("placa") String placa );

	
}