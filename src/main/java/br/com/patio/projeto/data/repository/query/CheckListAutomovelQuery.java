package br.com.patio.projeto.data.repository.query;

public class CheckListAutomovelQuery {
	 public static final String FIND_Placa = 
			 " SELECT c "+
			 " FROM CheckListAutomovelEntity c "
			 //+" WHERE ( upper(c.placa) LIKE upper(:placa) ) ";
			 +" WHERE ( (c.placa) = (:placa) ) ";
      
	 public static final String FIND = 
			 " SELECT new br.com.patio.projeto.dto.CheckListAutomovelTabelaDTO(" +
	         "  c.capo, " + 
	         "	c.parabrisa, " + 
	         "	c.retrovisor_dir, " + 
	         "	c.farol_dir, " + 
	         "	c.lateral_tras, " + 
	         "	c.vidro_tras_esq, " + 
	         "	c.porta_tras_esq, " + 
	         "	c.vidro_diant_esq, " + 
	         "	c.porta_diant_esq, " + 
	         "	c.farol_esq, " + 
	         "	c.retrovisor_esq, " + 
	         "	c.seta_esq, " + 
	         "	c.para_choque, " + 
	         "	c.farolete_dir, " + 
	         "	c.farolete_esq, " + 
	         "	c.vidro_tras, " + 
	         "	c.traseira, " + 
	         "	c.tam_porta_malas, " + 
	         "	c.vidro_tras2, " + 
	         "	c.teto, " + 
	         "	c.capo2, " + 
	         "	c.roda_tras_esq, " + 
	         "	c.roda_diant_esq, " + 
	         "	c.lateral_diant_esq, " + 
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
	         "	c.borrachao_lateral, " + 
	         "	c.break_light, " + 
	         "	c.farois_auxiliares, " + 
	         "	c.roda_comuns, " + 
	         "	c.rodas_de_liga, " + 
	         "	c.radio_toca_cds, " + 
	         "	c.amplificador, " + 
	         "	c.banco_dianteiro, " + 
	         "	c.banco_traseiro, " + 
	         "	c.tapetes,  " + 
	         "	c.protetor_carter, " + 
	         "	c.extintor, " + 
	         "	c.triangulo, " + 
	         "	c.console_interno, " + 
	         "	c.buzinas, " + 
	         "	c.bateria, " + 
	         "	c.macaco, " + 
	         "	c.chave_de_roda, " + 
	         "	c.calotas, " + 
	         "	c.alarme "+
	         " c.foto " +
	     	 " c.empresa " +
	     	" c.vidro_diant_dir " +
	     	" c.bau_dir " +
	     	" c.tanque "+
	     	" c.roda_tras_dir "+
	        " c.bau_esq "+
	     	" c.caminhao"+
	         " ) "+
			 " FROM CheckListAutomovelEntity c "
			 + " WHERE ( upper(c.placa) LIKE upper(:placa) ) ";
	 

}
