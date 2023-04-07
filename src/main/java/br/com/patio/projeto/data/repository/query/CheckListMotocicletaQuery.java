package br.com.patio.projeto.data.repository.query;

public class CheckListMotocicletaQuery {
	 public static final String FIND_Placa = 
			 " SELECT c "+
			 " FROM CheckListMotocicletaEntity c "
			// +" WHERE ( upper(c.placa) LIKE upper(:placa) ) ";
	         +" WHERE ( (c.placa) = (:placa) ) ";
      
	 public static final String FIND = 
			 " SELECT new br.com.patio.projeto.dto.CheckListMotocicletaTabelaDTO(" +
	         "  c.tanque, " + 
	         "	c.protecao_frontal, " + 
	         "	c.retrovisor_dir, " + 
	         "	c.retrovisor_esq, " + 
	         "	c.farol, " + 
	         "	c.banco, " + 
	         "	c.pneu_dianteiro, " + 
	         "	c.pneu_traseiro, " + 
	         "	c.bengala, " + 
	         "	c.freio, " + 
	         "	c.carenagem_dir, " + 
	         "	c.carenagem_esq, " + 
	         "	c.suporte_placa, " + 
	         "	c.motor, " + 
	         "	c.farolete, " + 
	         "	c.seta_dir, " + 
	         "	c.seta_esq, " + 
	         "	c.escapamento, " + 
	         "	c.roda_traseira, " + 
	         "	c.roda_dianteira, " + 
	         "	c.observacao, " + 
	         "	c.solicitante, " + 
	         "	c.proprietario, " + 
	         "	c.veiculo, " + 
	         "	c.chassi, " + 
	         "	c.local, " + 
	         "	c.atravesDE, " + 
	         "	c.telefone, " + 
	         "	c.entrada, " + 
	         "	c.renavam, " + 
	         "	c.placa, " + 
	         "	c.bairro, " + 
	         "	c.guincho, " + 
	         "	c.cpf_cnpj, " + 
	         "	c.cor, " + 
	         "	c.produto, " + 
	         "	c.cidade, " + 
	         "	c.uf, " + 
	         "	c.documento, " + 
	         "	c.bagagito, " + 
	         "	c.retrovisor_eletrico, " + 
	         "	c.retrovisor_comum, " + 
	         "	c.farois_auxiliares, " + 
	         "	c.roda_comuns, " + 
	         "	c.rodas_de_liga, " + 
	         "	c.radio_toca_cds, " + 
	         "	c.amplificador, " + 
	         "	c.mata_cachorro, " +  
	         "	c.buzinas, " + 
	         "	c.bateria, " + 
	         "	c.alarme "+
	         " ) "+
			 " FROM CheckListMotocicletaEntity c "
			 + " WHERE ( upper(c.placa) LIKE upper(:placa) ) ";
	 

}
