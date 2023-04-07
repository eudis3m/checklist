package br.com.patio.projeto.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class CheckListMotocicletaTabelaDTO implements Serializable {
	
	private static final Long serialVersionUID =  1L;
	
	private static final DateTimeFormatter String_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	//Integer oid;
	Integer tanque;
	Integer protecao_frontal;
	Integer retrovisor_dir;
	Integer farol;
	Integer banco;
	Integer pneu_dianteiro;
	Integer pneu_traseiro;
	Integer bengala;
	Integer freio;
	Integer carenagem_dir;
	Integer carenagem_esq;
	Integer suporte_placa;
	Integer motor;
	Integer farolete;
	Integer seta_dir;
	Integer seta_esq;
	Integer escapamento;
	Integer roda_traseira;
	Integer roda_dianteira;
	String observacao;
	String solicitante;
	String proprietario;
	String veiculo;
	String chassi;
	String local;
	String atravesDE;
	String telefone;
	String entrada;
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
	String farois_auxiliares;
	String roda_comuns;
	String rodas_de_liga;
	String radio_toca_cds;
	String amplificador;
	String mata_cachorro;
	String buzinas;
	String bateria;
	String calotas;
	String alarme;
	
	
	public CheckListMotocicletaTabelaDTO() {
		
	}
	public CheckListMotocicletaTabelaDTO( Integer tanque,
			Integer protecao_frontal,
			Integer retrovisor_dir,
			Integer farol,
			Integer banco,
			Integer pneu_dianteiro,
			Integer pneu_traseiro,
			Integer bengala,
			Integer freio,
			Integer carenagem_dir,
			Integer carenagem_esq,
			Integer suporte_placa,
			Integer motor,
			Integer farolete,
			Integer seta_dir,
			Integer seta_esq,
			Integer escapamento,
			Integer roda_traseira,
			Integer roda_dianteira,
			String observacao,
			String solicitante,
			String proprietario,
			String veiculo,
			String chassi,
			String local,
			String atravesDE,
			String telefone,
			String entrada,
			String renavam,
			String placa,
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
			String farois_auxiliares,
			String roda_comuns,
			String rodas_de_liga,
			String radio_toca_cds,
			String amplificador,
			String mata_cachorro,
			String buzinas,
			String bateria,
			String calotas,
			String alarme) {
		super();
		//this.oid = oid;
		this.tanque = tanque;
		this.protecao_frontal = protecao_frontal;
		this.retrovisor_dir = retrovisor_dir;
		this.farol = farol;
		this.banco = banco;
		this.pneu_dianteiro = pneu_dianteiro ;
		this.placa = placa;
		this.pneu_traseiro = pneu_traseiro;
		this.bengala = bengala ;
		this.freio = freio;
		this.carenagem_dir = carenagem_dir;
		this.carenagem_esq = carenagem_esq;
		this.suporte_placa = suporte_placa;
		this.seta_esq = seta_esq;
		this.motor = motor;
		this.farolete = farolete;
		this.seta_dir = seta_dir;
		this.seta_esq = seta_esq ;
		this.escapamento = escapamento;
		this.roda_traseira = roda_traseira;
		this.roda_dianteira = roda_dianteira;
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
		this.farois_auxiliares = farois_auxiliares ;
		this.roda_comuns = roda_comuns;
		this.rodas_de_liga = rodas_de_liga;
		this.radio_toca_cds = radio_toca_cds;
		this.amplificador = amplificador;
		this.mata_cachorro = mata_cachorro;
		this.buzinas = buzinas;
		this.bateria = bateria;
		this.calotas = calotas;
		this.alarme = alarme;
	
	}
	
	public Integer getTanque() {
		return tanque;
	}
	public void setTanque(Integer tanque) {
		this.tanque = tanque;
	}
	public Integer getProtecao_frontal() {
		return protecao_frontal;
	}
	public void setProtecao_frontal(Integer protecao_frontal) {
		this.protecao_frontal = protecao_frontal;
	}
	public Integer getRetrovisor_dir() {
		return retrovisor_dir;
	}
	public void setRetrovisor_dir(Integer retrovisor_dir) {
		this.retrovisor_dir = retrovisor_dir;
	}
	public Integer getFarol() {
		return farol;
	}
	public void setFarol(Integer farol) {
		this.farol = farol;
	}
	public Integer getBanco() {
		return banco;
	}
	public void setBanco(Integer banco) {
		this.banco = banco;
	}
	public Integer getPneu_dianteiro() {
		return pneu_dianteiro;
	}
	public void setPneu_dianteiro(Integer pneu_dianteiro) {
		this.pneu_dianteiro = pneu_dianteiro;
	}
	public Integer getPneu_traseiro() {
		return pneu_traseiro;
	}
	public void setPneu_traseiro(Integer pneu_traseiro) {
		this.pneu_traseiro = pneu_traseiro;
	}
	public Integer getBengala() {
		return bengala;
	}
	public void setBengala(Integer bengala) {
		this.bengala = bengala;
	}
	public Integer getFreio() {
		return freio;
	}
	public void setFreio(Integer freio) {
		this.freio = freio;
	}
	public Integer getCarenagem_dir() {
		return carenagem_dir;
	}
	public void setCarenagem_dir(Integer carenagem_dir) {
		this.carenagem_dir = carenagem_dir;
	}
	public Integer getCarenagem_esq() {
		return carenagem_esq;
	}
	public void setCarenagem_esq(Integer carenagem_esq) {
		this.carenagem_esq = carenagem_esq;
	}
	public Integer getSuporte_placa() {
		return suporte_placa;
	}
	public void setSuporte_placa(Integer suporte_placa) {
		this.suporte_placa = suporte_placa;
	}
	public Integer getMotor() {
		return motor;
	}
	public void setMotor(Integer motor) {
		this.motor = motor;
	}
	public Integer getFarolete() {
		return farolete;
	}
	public void setFarolete(Integer farolete) {
		this.farolete = farolete;
	}
	public Integer getSeta_dir() {
		return seta_dir;
	}
	public void setSeta_dir(Integer seta_dir) {
		this.seta_dir = seta_dir;
	}
	public Integer getSeta_esq() {
		return seta_esq;
	}
	public void setSeta_esq(Integer seta_esq) {
		this.seta_esq = seta_esq;
	}
	public Integer getEscapamento() {
		return escapamento;
	}
	public void setEscapamento(Integer escapamento) {
		this.escapamento = escapamento;
	}
	public Integer getRoda_traseira() {
		return roda_traseira;
	}
	public void setRoda_traseira(Integer roda_traseira) {
		this.roda_traseira = roda_traseira;
	}
	public Integer getRoda_dianteira() {
		return roda_dianteira;
	}
	public void setRoda_dianteira(Integer roda_dianteira) {
		this.roda_dianteira = roda_dianteira;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public String getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}
	public String getProprietario() {
		return proprietario;
	}
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	public String getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getAtravesDE() {
		return atravesDE;
	}
	public void setAtravesDE(String atravesDE) {
		this.atravesDE = atravesDE;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEntrada() {
		return entrada;
	}
	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}
	public String getRenavam() {
		return renavam;
	}
	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getGuincho() {
		return guincho;
	}
	public void setGuincho(String guincho) {
		this.guincho = guincho;
	}
	public String getCpf_cnpj() {
		return cpf_cnpj;
	}
	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getBagagito() {
		return bagagito;
	}
	public void setBagagito(String bagagito) {
		this.bagagito = bagagito;
	}
	public String getRetrovisor_eletrico() {
		return retrovisor_eletrico;
	}
	public void setRetrovisor_eletrico(String retrovisor_eletrico) {
		this.retrovisor_eletrico = retrovisor_eletrico;
	}
	public String getRetrovisor_comum() {
		return retrovisor_comum;
	}
	public void setRetrovisor_comum(String retrovisor_comum) {
		this.retrovisor_comum = retrovisor_comum;
	}
	public String getFarois_auxiliares() {
		return farois_auxiliares;
	}
	public void setFarois_auxiliares(String farois_auxiliares) {
		this.farois_auxiliares = farois_auxiliares;
	}
	public String getRoda_comuns() {
		return roda_comuns;
	}
	public void setRoda_comuns(String roda_comuns) {
		this.roda_comuns = roda_comuns;
	}
	public String getRodas_de_liga() {
		return rodas_de_liga;
	}
	public void setRodas_de_liga(String rodas_de_liga) {
		this.rodas_de_liga = rodas_de_liga;
	}
	public String getRadio_toca_cds() {
		return radio_toca_cds;
	}
	public void setRadio_toca_cds(String radio_toca_cds) {
		this.radio_toca_cds = radio_toca_cds;
	}
	public String getAmplificador() {
		return amplificador;
	}
	public void setAmplificador(String amplificador) {
		this.amplificador = amplificador;
	}
	public String getMata_cachorro() {
		return mata_cachorro;
	}
	public void setMata_cachorro(String mata_cachorro) {
		this.mata_cachorro = mata_cachorro;
	}
	public String getBuzinas() {
		return buzinas;
	}
	public void setBuzinas(String buzinas) {
		this.buzinas = buzinas;
	}
	public String getBateria() {
		return bateria;
	}
	public void setBateria(String bateria) {
		this.bateria = bateria;
	}
	public String getCalotas() {
		return calotas;
	}
	public void setCalotas(String calotas) {
		this.calotas = calotas;
	}
	public String getAlarme() {
		return alarme;
	}
	public void setAlarme(String alarme) {
		this.alarme = alarme;
	}
}
