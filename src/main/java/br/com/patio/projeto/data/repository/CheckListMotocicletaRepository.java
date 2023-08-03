package br.com.patio.projeto.data.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.patio.projeto.data.repository.query.CheckListMotocicletaQuery;
import br.com.patio.projeto.entity.CheckListMotocicletaEntity;
import br.com.patio.projeto.entity.RetiraVeiculoEntity;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CheckListMotocicletaRepository extends JpaRepository<CheckListMotocicletaEntity, Long>{

	Optional<CheckListMotocicletaEntity> findById(Long oid);

	CheckListMotocicletaEntity save(CheckListMotocicletaEntity old);

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO `checklist_motocicleta`(`tanque`, `protecao_frontal`, `retrovisor_dir`, `retrovisor_esq`, `farol`, `banco`, `pneu_dianteiro`, " +
			"`pneu_traseiro`, `bengala`, `freio`, `carenagem_dir`, `carenagem_esq`, `suporte_placa`, `motor`, `farolete`, `seta_dir`, `seta_esq`, `escapamento`," +
			" `roda_traseira`, `roda_dianteira`, `observacao`, `solicitante`, `proprietario`, `veiculo`, `chassi`, `local`, `atravesDE`, `telefone`, `entrada`, " +
			"`renavam`, `bairro`, `guincho`, `cpf_cnpj`, `cor`, `produto`, `cidade`, `placa`, `uf`, `documento`, `bagagito`, `retrovisor_eletrico`, `retrovisor_comum`, " +
			"`farois_auxiliares`, `rodas_comum`, `rodas_de_liga`, `radio_toca_cds`, `amplificador`, `mata_cachorro`, `buzinas`, `bateria`, `alarme`, `empresa`, `motocicleta`," +
			" `combustivel`, `pneus_status`, `assinatura_vistoriador`, `assinatura_policial`) " +
			" VALUES " +
			"(:tanque,:tanque , :protecao_frontal, :retrovisor_dir , :retrovisor_esq, :farol, :banco, :pneu_dianteiro,\n" +
			" :pneu_traseiro, :bengala , :freio, :carenagem_dir, :carenagem_esq, :suporte_placa, :motor, :farolete, :seta_dir, :seta_esq, :escapamento,\n" +
			" :roda_traseira, :roda_dianteira, :observacao, :solicitante, :proprietario, :veiculo, :chassi, :local, :atravesDE, :telefone, :entrada,\n" +
			" :renavam, :bairro, :guincho, :cpf_cnpj, :cor, :produto, :cidade, :placa, :uf, :documento, :bagagito, :retrovisor_eletrico, :retrovisor_comum,\n" +
			" :farois_auxiliares, :rodas_comum, :rodas_de_liga, :radio_toca_cds, :amplificador, :mata_cachorro, :buzinas, :bateria, :alarme, :empresa, :motocicleta,\n" +
			" :combustivel, :pneus_status, :assinatura_vistoriador, :assinatura_policial) ", nativeQuery = true)
	void inseriMotocicleta(int tanque , int protecao_frontal, int retrovisor_dir , int retrovisor_esq, int farol, int banco, int pneu_dianteiro,
					   int pneu_traseiro, int bengala , int freio, int carenagem_dir, int carenagem_esq, int suporte_placa, int motor, int farolete, int seta_dir, int seta_esq, int escapamento,
					   int roda_traseira, int roda_dianteira, String observacao, String solicitante, String proprietario, String veiculo, String chassi, String local, String atravesDE, String telefone, String entrada,
					   String renavam, String bairro, String guincho, String cpf_cnpj, String cor, String produto, String cidade, String placa, String uf, String documento, String bagagito, String retrovisor_eletrico, String retrovisor_comum,
					   String farois_auxiliares, String rodas_comum, String rodas_de_liga, String radio_toca_cds, String amplificador, String mata_cachorro, String buzinas, String bateria, String alarme, String empresa, String motocicleta,
					   String combustivel, String pneus_status, byte[] assinatura_vistoriador, byte[] assinatura_policial);

	void delete(CheckListMotocicletaEntity address);

	@Query(value = CheckListMotocicletaQuery.FIND_Placa)
	List<CheckListMotocicletaEntity> findByList(@Param("placa") String placa );
	
	@Query(value = CheckListMotocicletaQuery.FIND_Placa)
	CheckListMotocicletaEntity findByPlaca(@Param("placa") String placa );

	
}