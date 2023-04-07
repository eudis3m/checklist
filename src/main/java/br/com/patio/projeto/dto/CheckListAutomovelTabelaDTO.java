package br.com.patio.projeto.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class CheckListAutomovelTabelaDTO implements Serializable {
	
	private static final Long serialVersionUID =  1L;
	
	private static final DateTimeFormatter String_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	//Integer oid;
	Integer capo;
	byte[] foto;
	String empresa;
	Integer vidro_diant_dir;
	Integer bau_dir;
	Integer tanque;
	Integer roda_tras_dir;
	Integer bau_esq;
	String caminhao;
	Integer parabrisa;
	Integer retrovisor_dir;
	Integer farol_dir;
	Integer lateral_tras;
	Integer vidro_tras_esq;
	Integer porta_tras_esq;
	Integer vidro_diant_esq;
	Integer porta_diant_esq;
	Integer farol_esq;
	Integer retrovisor_esq;
	Integer seta_esq;
	Integer para_choque;
	Integer farolete_dir;
	Integer farolete_esq;
	Integer vidro_tras;
	Integer traseira;
	Integer tam_porta_malas;
	Integer vidro_tras2;
	Integer teto;
	Integer capo2;
	Integer roda_tras_esq;
	Integer roda_diant_esq;
	Integer lateral_diant_esq;
	String observacao;
	String solicitante;
	String proprietario;
	String veiculo;
	String chassi;
	String local;
	String atravesDE;
	String telefone;
	Date entrada;
	String renavam;
	String placa;
	String bairro;
	String guincho;
	String cpf_cnpj;
	String cor;
	String produto;
	String cidade;
	String uf;
	String documento;
	String bagagito;
	String retrovisor_eletrico;
	String retrovisor_comum;
	String borrachao_lateral;
	String break_light;
	String farois_auxiliares;
	String rodas_comum;
	String rodas_de_liga;
	String radio_toca_cds;
	String amplificador;
	String banco_dianteiro;
	String banco_traseiro;
	String tapetes;
	String protetor_carter;
	String extintor;
	String triangulo;
	String console_interno;
	String buzinas;
	String bateria;
	String macaco;
	String chave_de_roda;
	String calotas;
	String alarme;
	
	
	public CheckListAutomovelTabelaDTO() {
		
	}
	public CheckListAutomovelTabelaDTO( Integer oid, Integer capo, Integer parabrisa, Integer retrovisor_dir, Integer farol_dir, Integer lateral_tras, Integer farolete_esq,
	String placa,
	Integer vidro_tras_esq,
	Integer porta_tras_esq,
	Integer vidro_diant_esq,
	Integer porta_diant_esq,
	Integer farol_esq,
	Integer retrovisor_esq,
	Integer seta_esq,
	Integer para_choque,
	Integer farolete_dir,
	Integer vidro_tras,
	Integer traseira,
	Integer tam_porta_malas,
	Integer vidro_tras2,
	Integer teto,
	Integer capo2,
	Integer roda_tras_esq,
	Integer roda_diant_esq,
	Integer lateral_diant_esq,
	String observacao,
	String solicitante,
	String proprietario,
	String veiculo,
	String chassi,
	String local,
	String atravesDE,
	String telefone,
	Date entrada,
	String renavam,
	String bairro,
	String guincho,
	String cpf_cnpj,
	String cor,
	String produto,
	String cidade,
	String uf,
	String documento,
	String bagagito,
	String retrovisor_eletrico,
	String retrovisor_comum,
	String borrachao_lateral,
	String break_light,
	String farois_auxiliares,
	String rodas_comum,
	String rodas_de_liga,
	String radio_toca_cds,
	String amplificador,
	String banco_dianteiro,
	String banco_traseiro,
	String tapetes,
	String protetor_carter,
	String extintor,
	String triangulo,
	String console_interno,
	String buzinas,
	String bateria,
	String macaco,
	String chave_de_roda,
	String calotas,
	String alarme,
	byte[] foto,
	String empresa,
	Integer vidro_diant_dir,
	Integer bau_dir,
	Integer tanque,
	Integer roda_tras_dir,
	Integer bau_esq,
	String caminhao) {
		super();
		//this.oid = oid;
		this.foto = foto;
		this.empresa = empresa;
		this.vidro_diant_dir = vidro_diant_dir;
		this.bau_dir = bau_dir;
		this.tanque = tanque;
		this.roda_tras_dir = roda_tras_dir;
	    this.bau_esq = bau_esq;
		this.caminhao =caminhao;
		this.capo = capo;
		this.parabrisa = parabrisa;
		this.retrovisor_dir = retrovisor_dir;
		this.farol_dir = farol_dir;
		this.lateral_tras = lateral_tras;
		this.farolete_esq = farolete_esq ;
		this.placa = placa;
		this.vidro_tras_esq = vidro_tras_esq;
		this.porta_tras_esq =porta_tras_esq ;
		this.vidro_diant_esq = vidro_diant_esq;
		this.porta_diant_esq = porta_diant_esq;
		this.farol_esq = farol_esq;
		this.retrovisor_esq = retrovisor_esq;
		this.seta_esq = seta_esq;
		this.para_choque = para_choque;
		this.farolete_dir = farolete_dir;
		this.vidro_tras = vidro_tras;
		this.traseira = traseira ;
		this.tam_porta_malas = tam_porta_malas;
		this.vidro_tras2 = vidro_tras2;
		this.teto = teto ;
		this.capo2 = capo2;
		this.roda_tras_esq  = roda_tras_esq;
		this.roda_diant_esq = roda_diant_esq;
		this.lateral_diant_esq = lateral_diant_esq;
		this.observacao = observacao;
		this.solicitante = solicitante;
		this.proprietario = proprietario ;
		this.veiculo = veiculo;
		this.chassi = chassi;
		this.local = local;
		this.atravesDE = atravesDE;
		this.telefone = telefone;
		this.entrada = entrada;
		this.renavam = renavam;
		this.bairro = bairro;
		this.guincho = guincho;
		this.cpf_cnpj = cpf_cnpj;
		this.cor = cor;
		this.produto = produto ;
		this.cidade = cidade;
		this.uf = uf;
		this.documento = documento;
		this.bagagito = bagagito;
		this.retrovisor_eletrico = retrovisor_eletrico;
		this.retrovisor_comum = retrovisor_comum ;
		this.borrachao_lateral = borrachao_lateral;
		this.break_light = break_light;
		this.farois_auxiliares = farois_auxiliares ;
		this.rodas_comum = rodas_comum;
		this.rodas_de_liga = rodas_de_liga;
		this.radio_toca_cds = radio_toca_cds;
		this.amplificador = amplificador;
		this.banco_dianteiro = banco_dianteiro;
		this.banco_traseiro = banco_traseiro;
		this.tapetes = tapetes;
		this.protetor_carter = protetor_carter;
		this.extintor = extintor;
		this.triangulo = triangulo;
		this.console_interno = console_interno;
		this.buzinas = buzinas;
		this.bateria = bateria;
		this.macaco = macaco;
		this.chave_de_roda = chave_de_roda;
		this.calotas = calotas;
		this.alarme = alarme;
	
	}
	public String getAlarme() {
		return alarme;
	}

	public void setAlarme(String alarme) {
		this.alarme = alarme;
	}
	 public String getCalotas() {
			return calotas;
		}

		public void setCalotas(String calotas) {
			this.calotas = calotas;
		}
	 public String getChave_de_roda() {
			return chave_de_roda;
		}

		public void setChave_de_roda(String chave_de_roda) {
			this.chave_de_roda = chave_de_roda;
		}
	 public String getMacaco() {
			return macaco;
		}

		public void setMacaco(String macaco) {
			this.macaco = macaco;
		}
	 public String getBateria() {
			return bateria;
		}

		public void setBateria(String bateria) {
			this.bateria = bateria;
		}
	 public String getBuzinas() {
			return buzinas;
		}

		public void setBuzinas(String buzinas) {
			this.buzinas = buzinas;
		}
	 public String getConsole_interno() {
			return console_interno;
		}

		public void setConsole_interno(String console_interno) {
			this.console_interno = console_interno;
		}
	public String getTriangulo() {
		return triangulo;
	}

	public void setTriangulo(String triangulo) {
		this.triangulo = triangulo;
	}
	 public String getExtintor() {
			return extintor;
		}

		public void setExtintor(String extintor) {
			this.extintor = extintor;
		}
	 public String getProtetor_carter() {
			return protetor_carter;
		}

		public void setProtetor_carter(String protetor_carter) {
			this.protetor_carter = protetor_carter;
		}
	 public String getTapetes() {
			return tapetes;
		}

		public void setTapetes(String tapetes) {
			this.tapetes = tapetes;
		}
	 public String getBanco_traseiro() {
			return banco_traseiro;
		}

		public void setBanco_traseiro(String banco_traseiro) {
			this.banco_traseiro = banco_traseiro;
		}
	public String getBanco_dianteiro() {
		return banco_dianteiro;
	}

	public void setBanco_dianteiro(String banco_dianteiro) {
		this.banco_dianteiro = banco_dianteiro;
	}

	public String getAmplificador() {
		return amplificador;
	}

	public void setAmplificador(String amplificador) {
		this.amplificador = amplificador;
	}
	public String getRadio_toca_cds() {
		return radio_toca_cds;
	}

	public void setRadio_toca_cds(String radio_toca_cds) {
		this.radio_toca_cds = radio_toca_cds;
	}
	 public String getRodas_de_liga() {
			return rodas_de_liga;
		}

		public void setRodas_de_liga(String rodas_de_liga) {
			this.rodas_de_liga = rodas_de_liga;
		}
	 public String getRodas_comum() {
			return rodas_comum;
		}

		public void setRodas_comum(String rodas_comum) {
			this.rodas_comum = rodas_comum;
		}

	 public String getFarois_auxiliares() {
			return farois_auxiliares;
		}

		public void setFarois_auxiliares(String farois_auxiliares) {
			this.farois_auxiliares = farois_auxiliares;
		}

	  public String getBreak_light() {
			return break_light;
		}

		public void setBreak_light(String break_light) {
			this.break_light = break_light;
		}
		
	public String getBorrachao_lateral() {
		return borrachao_lateral;
	}

	public void setBorrachao_lateral(String borrachao_lateral) {
		this.borrachao_lateral = borrachao_lateral;
	}
	public String getRetrovisor_comum() {
			return retrovisor_comum;
		}

	public void setRetrovisor_comum(String retrovisor_comum) {
			this.retrovisor_comum = retrovisor_comum;
		}
	public String getRetrovisor_eletrico() {
			return retrovisor_eletrico;
	}

	public void setRetrovisor_eletrico(String retrovisor_eletrico) {
			this.retrovisor_eletrico = retrovisor_eletrico;
	}

	public String getBagagito() {
		return bagagito;
	}

	public void setBagagito(String bagagito) {
		this.bagagito = bagagito;
	}
	 public String getDocumento() {
			return documento;
		}

		public void setDocumento(String documento) {
			this.documento = documento;
		}
	 public String getUf() {
			return uf;
		}

		public void setUf(String uf) {
			this.uf = uf;
		}
	 public String getCidade() {
			return cidade;
		}

		public void setCidade(String cidade) {
			this.cidade = cidade;
		}
	 public String getProduto() {
			return produto;
		}

		public void setProduto(String produto) {
			this.produto = produto;
		}

	 public String getCor() {
			return cor;
		}

		public void setCor(String cor) {
			this.cor = cor;
		}
	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}
	 public String getGuincho() {
			return guincho;
		}

		public void setGuincho(String guincho) {
			this.guincho = guincho;
		}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}
	 public Date getEntrada() {
			return entrada;
		}

		public void seEntrada(Date entrada) {
			this.entrada = entrada;
		}
	 public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}
	public String getAtravesDE() {
		return atravesDE;
	}

	public void setAtravesDE(String atravesDE) {
		this.atravesDE = atravesDE;
	}
	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	
	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public String getSolicitante() {
			return solicitante;
	}

	public void setSolicitante(String solicitante) {
			this.solicitante = solicitante;
	}
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Integer getLateral_diant_esq() {
			return lateral_diant_esq;
	}

	public void setLateral_diant_esq(Integer lateral_diant_esq) {
			this.lateral_diant_esq = lateral_diant_esq;
	}
	public Integer getRoda_diant_esq() {
			return roda_diant_esq;
	}

	public void setRoda_diant_esq(Integer roda_diant_esq) {
			this.roda_diant_esq = roda_diant_esq;
	}
	public Integer getCapo2() {
		return capo2;
	}

	public void setCapo2(Integer capo2) {
		this.capo2 = capo2;
	}
    public Integer getTeto() {
			return teto;
	}

    public void setTeto(Integer teto) {
			this.teto = teto;
	}
    public Integer getVidro_tras2() {
		return vidro_tras2;
}

public void setVidro_tras2(Integer vidro_tras2) {
		this.vidro_tras2 = vidro_tras2;
}
public Integer getTam_porta_malas() {
		return tam_porta_malas;
}

public void setTam_porta_malas(Integer tam_porta_malas) {
		this.tam_porta_malas = tam_porta_malas;
}
public Integer getTraseira() {
		return traseira;
}

public void setTraseira(Integer traseira) {
		this.traseira = traseira;
}
public Integer getVidro_tras() {
		return vidro_tras;
}

public void setVidro_tras(Integer vidro_tras) {
		this.vidro_tras = vidro_tras;
}

public Integer getFarolete_dir() {
	return farolete_dir;
}

public void setFarolete_dir(Integer farolete_dir) {
	this.farolete_dir = farolete_dir;
}

public Integer getPara_choque() {
	return para_choque;
}

public void setPara_choque(Integer para_choque) {
	this.para_choque = para_choque;
}
public Integer getSeta_esq() {
		return seta_esq;
}

public void setSeta_esq(Integer seta_esq) {
		this.seta_esq = seta_esq;
}
public Integer getRetrovisor_esq() {
	return retrovisor_esq;
}

public void setRetrovisor_esq(Integer retrovisor_esq) {
	this.retrovisor_esq = retrovisor_esq;
}
public Integer getFarol_esq() {
		return farol_esq;
}

public void setFarol_esq(Integer farol_esq) {
		this.farol_esq = farol_esq;
}
public Integer getPorta_diant_esq() {
		return porta_diant_esq;
}

public void setPorta_diant_esq(Integer porta_diant_esq) {
		this.porta_diant_esq = porta_diant_esq;
}
public Integer getVidro_diant_esq() {
	return vidro_diant_esq;
}

public void setVidro_diant_esq(Integer vidro_diant_esq) {
	this.vidro_diant_esq = vidro_diant_esq;
}

public Integer getPorta_tras_esq() {
	return porta_tras_esq;
}

public void setPorta_tras_esq(Integer porta_tras_esq) {
	this.porta_tras_esq = porta_tras_esq;
}
 public Integer getVidro_tras_esq() {
		return vidro_tras_esq;
	}

	public void setVidro_tras_esq(Integer vidro_tras_esq) {
		this.vidro_tras_esq = vidro_tras_esq;
	}
/*

 public Integer getOid() {
		return oid;
	}

public void setOid(Integer oid) {
		this.oid = oid;
	}
*/
public Integer getCapo() {
			return capo;
	}

public void setCapo(Integer capo) {
			this.capo = capo;
	}
 public Integer getParabrisa() {
		return parabrisa;
	}

public void setParabrisa(Integer parabrisa) {
		this.parabrisa = parabrisa;
	}
public Integer getRetrovisor_dir() {
			return retrovisor_dir;
	}

public void setRetrovisor_dir(Integer retrovisor_dir) {
			this.retrovisor_dir = retrovisor_dir;
	}
 public Integer getFarol_dir() {
		return farol_dir;
	}

public void setFarol_dir(Integer farol_dir) {
		this.farol_dir = farol_dir;
	}
public Integer getLateral_tras() {
			return lateral_tras;
	}

public void setLateral_tras(Integer lateral_tras) {
			this.lateral_tras = lateral_tras;
	}
 public Integer getFarolete_esq() {
		return farolete_esq;
	}

	public void setFarolete_esq(Integer farolete_esq) {
		this.farolete_esq = farolete_esq;
	}
	public String getPlaca() {
			return placa;
	}

	public void setPlaca(String placa) {
			this.placa = placa;
	}
	public Integer getRoda_tras_esq() {
			return roda_tras_esq;
	}
    public void setRoda_tras_esq(Integer roda_tras_esq) {
		this.roda_tras_esq = roda_tras_esq;
	}
    public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public Integer getVidro_diant_dir() {
		return vidro_diant_dir;
	}
	public void setVidro_diant_dir(Integer vidro_diant_dir) {
		this.vidro_diant_dir = vidro_diant_dir;
	}
	public Integer getBau_dir() {
		return bau_dir;
	}
	public void setBau_dir(Integer bau_dir) {
		this.bau_dir = bau_dir;
	}
	public Integer getTanque() {
		return tanque;
	}
	public void setTanque(Integer tanque) {
		this.tanque = tanque;
	}
	public Integer getRoda_tras_dir() {
		return roda_tras_dir;
	}
	public void setRoda_tras_dir(Integer roda_tras_dir) {
		this.roda_tras_dir = roda_tras_dir;
	}
	public Integer getBau_esq() {
		return bau_esq;
	}
	public void setBau_esq(Integer bau_esq) {
		this.bau_esq = bau_esq;
	}
	public String getCaminhao() {
		return caminhao;
	}
	public void setCaminhao(String caminhao) {
		this.caminhao = caminhao;
	}
	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}

}
