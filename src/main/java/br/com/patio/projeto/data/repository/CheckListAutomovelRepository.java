package br.com.patio.projeto.data.repository;

import br.com.patio.projeto.data.repository.query.CheckListAutomovelQuery;
import br.com.patio.projeto.dto.CheckListAutomovelTabelaDTO;
import br.com.patio.projeto.entity.CheckListAutomovelEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface CheckListAutomovelRepository extends JpaRepository<CheckListAutomovelEntity, Long>{

	Optional<CheckListAutomovelEntity> findById(Long oid);

	CheckListAutomovelEntity save(CheckListAutomovelEntity old);

	void delete(CheckListAutomovelEntity address);

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO `checklt_automovel`(`capo`, `parabra`, `retrovor_dir`, " +
			"`farol_dir`, `lateral_tras`, `vidro_tras_esq`, `porta_tras_esq`, `vidro_diant_esq`, " +
			"`porta_diant_esq`, `farol_esq`, `retrovor_esq`, `seta_esq`, `seta_dir`, " +
			" `para_choque`, `farolete_dir`, `farolete_esq`, `vidro_tras`, `traseira`, " +
			"`tam_porta_malas`, `vidro_tras2`, `teto`, `capo2`, `roda_tras_esq`, " +
			"`roda_diant_esq`, `lateral_diant_esq`, `observacao`, `solicitante`, " +
			"`proprietario`, `veiculo`, `chassi`, `local`, `atravesDE`, `telefone`, " +
			"`entrada`, `renavam`, `bairro`, `guincho`, `cpf_cnpj`, `cor`, `produto`, " +
			"`cidade`, `placa`, `uf`, `documento`, `bagagito`, `retrovor_eletrico`, " +
			"`retrovor_comum`, `borrachao_lateral`, `break_light`, `faro_auxiliares`," +
			" `rodas_comum`, `rodas_de_liga`, `radio_toca_cds`, `amplificador`, `banco_dianteiro`," +
			" `banco_traseiro`, `tapetes`, `protetor_carter`, `extintor`, `triangulo`, `console_interno`, " +
			"`buzinas`, `bateria`, `macaco`, `chave_de_roda`, `calotas`, `alarme`, `automovel`, " +
			" `empresa`, `vidro_diant_dir`, `bau_dir`, `tanque`, `roda_tras_dir`, " +
			"`bau_esq`, `caminhao`, `combustivel`, `pneus`, `assinatura_vtoriador`, " +
			"`assinatura_policial`) " +
			" VALUES " +
			" (:capo or null, :parabra or  null, :retrovor_dir or  null,  \n" +
			" :farol_dir or  null, :lateral_tras or  null, :vidro_tras_esq or  null, :porta_tras_esq or  null, :vidro_diant_esq or  null,\n" +
			" :porta_diant_esq or  null, :farol_esq or  null, :retrovor_esq or  null, :seta_esq, :seta_dir or  null,\n" +
			" :para_choque or  null, :farolete_dir or  null, :farolete_esq or  null, :vidro_tras or  null, :traseira or  null,\n" +
			" :tam_porta_malas or  null, :vidro_tras2 or  null, :teto or  null, :capo2 or  null, :roda_tras_esq or  null, \n" +
			" :roda_diant_esq or  null, :lateral_diant_esq or  null, :observacao or  null, :solicitante or  null,\n" +
			" :proprietario or  null, :veiculo or  null, :chassi or  null, :local or  null, :atravesDE or  null, :telefone or  null,\n" +
			" :entrada, :renavam or  null, :bairro or  null, :guincho, :cpf_cnpj or  null, :cor or  null, :produto or  null,\n" +
			" :cidade or  null, :placa, :uf or  null, :documento or  null, :bagagito or  null, :retrovor_eletrico or  null,\n" +
			" :retrovor_comum or  null, :borrachao_lateral or  null, :break_light or  null, :faro_auxiliares or  null,\n" +
			" :rodas_comum or  null, :rodas_de_liga or  null, :radio_toca_cds or  null, :amplificador or  null, :banco_dianteiro or  null,\n" +
			" :banco_traseiro or  null, :tapetes or  null, :protetor_carter or  null, :extintor or  null, :triangulo or  null, :console_interno or  null,\n" +
			" :buzinas or  null, :bateria or  null, :macaco or  null, :chave_de_roda or  null, :calotas or  null, :alarme or  null, :automovel or  null,\n" +
			" :empresa, :vidro_diant_dir or  null, :bau_dir or  null, :tanque or  null, :roda_tras_dir or  null,\n" +
			" :bau_esq or  null, :caminhao or  null, :combustivel or  null, :pneus or  null, :assinatura_vtoriador or  null,\n" +
			" :assinatura_policial or  null)" , nativeQuery = true)
	void inseriVeiculo(int capo, int parabra, int retrovor_dir,
			 int farol_dir, int lateral_tras, int vidro_tras_esq, int porta_tras_esq, int vidro_diant_esq,
			 int porta_diant_esq, int farol_esq, int retrovor_esq, int seta_esq, int seta_dir,
			 int para_choque, int farolete_dir, int farolete_esq, int vidro_tras, int traseira,
			 int tam_porta_malas, int vidro_tras2, int teto, int capo2, int roda_tras_esq,
			 int roda_diant_esq, int lateral_diant_esq, String observacao, String solicitante,
			 String proprietario, String veiculo, String chassi, String local, String atravesDE, String telefone,
			 String entrada, String renavam, String bairro, String guincho, String cpf_cnpj, String cor, String produto,
			 String cidade, String placa, String uf, String documento, String bagagito, String retrovor_eletrico,
			 String retrovor_comum, String borrachao_lateral, String break_light, String faro_auxiliares,
			 String rodas_comum, String rodas_de_liga, String radio_toca_cds, String amplificador, String banco_dianteiro,
			 String banco_traseiro, String tapetes, String protetor_carter, String extintor, String triangulo, String console_interno,
			 String buzinas, String bateria, String macaco, String chave_de_roda, String calotas, String alarme, String automovel,
			 String empresa, int vidro_diant_dir, int bau_dir, int tanque, int roda_tras_dir,
			 int bau_esq, String caminhao, String combustivel, String pneus, byte[] assinatura_vtoriador,
			 byte[] assinatura_policial);

	@Query(value = CheckListAutomovelQuery.FIND_Placa)
	List<CheckListAutomovelEntity> findByList(@Param("placa") String placa );
	
	@Query(value = " select * from checklist_automovel where placa = :placa ",nativeQuery = true)
	Object findByVeiculo(@Param("placa") String placa );

	@Query(value = CheckListAutomovelQuery.FIND_Placa)
	public CheckListAutomovelEntity findByPlaca(@Param("placa") String placa );
	
}