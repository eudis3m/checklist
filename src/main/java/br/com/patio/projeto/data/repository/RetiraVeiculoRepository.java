package br.com.patio.projeto.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.patio.projeto.data.repository.query.CheckListAutomovelQuery;
import br.com.patio.projeto.data.repository.query.RetiraVeiculoQuery;
import br.com.patio.projeto.entity.RetiraVeiculoEntity;



public interface RetiraVeiculoRepository extends PagingAndSortingRepository<RetiraVeiculoEntity, Long>{
	
	@Query(value = RetiraVeiculoQuery.RetiraVeiculo)
	List<RetiraVeiculoEntity> findByRetiraVeiculo(@Param("placa") String placa);
	
	@Query(value = RetiraVeiculoQuery.RetiraMotocicleta)
	List<RetiraVeiculoEntity> findByRetiraMotocicleta(@Param("placa") String placa);
	
	@Query(value = RetiraVeiculoQuery.BuscaPlaca)
	RetiraVeiculoEntity findByPlaca(@Param("placa") String placa);

}
