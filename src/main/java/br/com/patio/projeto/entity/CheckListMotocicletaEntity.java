package br.com.patio.projeto.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.exolab.castor.types.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.patio.projeto.util.JsonParseable;



@Entity
@Table(name="checklist_motocicleta")
public class CheckListMotocicletaEntity implements Serializable {

	private static final Long serialVersionUID = 1L;
	
	
	/*@Column(name="oid_checklist", nullable=true, length=100)
    private Integer oidchecklist;
   

	public Integer getOidchecklist() {
		return oidchecklist;
	}

	public void setOidchecklist(Integer oidchecklist) {
		this.oidchecklist = oidchecklist;
	}
    */
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "OID", nullable = false)
	 private Long oid;
	 
	public Long getOid() {
			return oid;
	}

	public void setOid(Long oid) {
			this.oid = oid;
	}
		
	//@Column(name="foto", nullable=true, length=100)
	byte[] foto;
    
	//@Column(name="foto_2", nullable=true, length=100)
	byte[] foto_2;
	
	//@Column(name="foto_3", nullable=true, length=100)
	byte[] foto_3;
	
	//@Column(name="foto_4", nullable=true, length=100)
	byte[] foto_4;

	//@Column(name="foto_5", nullable=true, length=100)
	byte[] foto_5;
	
	@Column(name="tanque", nullable=true, length=100)
    private Integer tanque;
    
   

	public Integer getTanque() {
		return tanque;
	}

	public void setTanque(Integer tanque) {
		this.tanque = tanque;
	}

	@Column(name="protecao_frontal", nullable=true, length=100)
    private Integer protecao_frontal;
    
   

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

	@Column(name="retrovisor_dir", nullable=true, length=100)
    private Integer retrovisor_dir;
    
    
	@Column(name="retrovisor_esq", nullable=true, length=100)
    private Integer retrovisor_esq;
	
	
	@Column(name="farol", nullable=true, length=100)
    private Integer farol;
    

	@Column(name="banco", nullable=true, length=100)
    private Integer banco;
    
    

	@Column(name="pneu_dianteiro", nullable=true, length=100)
    private Integer pneu_dianteiro;
    
    

	
   

	@Column(name="pneu_traseiro", nullable=true, length=100)
    private Integer pneu_traseiro;
    
   

	@Column(name="bengala", nullable=true, length=100)
    private Integer bengala;
    
   
	@Column(name="freio", nullable=true, length=100)
    private Integer freio;
    
   

	@Column(name="carenagem_dir", nullable=true, length=100)
    private Integer carenagem_dir;
    
   
	@Column(name="carenagem_esq", nullable=true, length=100)
    private Integer carenagem_esq;
    

	@Column(name="suporte_placa", nullable=true, length=100)
    private Integer suporte_placa;
    
   
	@Column(name="motor", nullable=true, length=100)
    private Integer motor;
    

	@Column(name="farolete", nullable=true, length=100)
    private Integer farolete;
    

	@Column(name="seta_dir", nullable=true, length=100)
    private Integer seta_dir;
    
   
	@Column(name="seta_esq", nullable=true, length=100)
    private Integer seta_esq;
    
    
	@Column(name="escapamento", nullable=true, length=100)
    private Integer escapamento;
    
   
	@Column(name="roda_traseira", nullable=true, length=100)
    private Integer roda_traseira;
    

	@Column(name="roda_dianteira", nullable=true, length=100)
    private Integer roda_dianteira;
    
    

	@Column(name="observacao", nullable=true, length=100)
    private String observacao;
    
    
    public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Column(name="solicitante", nullable=true, length=100)
    private String solicitante;

  
    public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	@Column(name="proprietario", nullable=true, length= 100)
    private  String proprietario;


    public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	@Column(name="veiculo", nullable=true, length=100)
    private String veiculo;
	
	@Column(name="motocicleta", nullable=true, length=100)
    private String motocicleta;
    
 
    public String getMotocicleta() {
		return motocicleta;
	}

	public void setMotocicleta(String motocicleta) {
		this.motocicleta = motocicleta;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	@Column(name="chassi", nullable=true)
    private String chassi;
    
 
    public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	@Column(name="local", nullable=true)
    private String local;
    
    public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	@Column(name="atravesDE", nullable=true, length=100)
    private String atravesDE;
    
    public String getAtravesDE() {
		return atravesDE;
	}

	public void setAtravesDE(String atravesDE) {
		this.atravesDE = atravesDE;
	}

	@Column(name="telefone", nullable=true, length=100)
    private String telefone;
    
    public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	//@Temporal(TemporalType.DATE)
	@Column(name="entrada", nullable=true, length=100)
    private String entrada;
    
    public String getEntrada() {
		return entrada;
	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	@Column(name="renavam", nullable=true, length=100)
    private String renavam;
    
    public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	@Column(name="bairro", nullable=true, length=100)
    private String bairro;
    
    public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Column(name="guincho", nullable=true, length=100)
    private String guincho;
    
    public String getGuincho() {
		return guincho;
	}

	public void setGuincho(String guincho) {
		this.guincho = guincho;
	}

	@Column(name="cpf_cnpj", nullable=true, length=100)
    private String cpf_cnpj;
    
    public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	@Column(name="cor", nullable=true, length=100)
    private String cor;
    
    public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@Column(name="produto", nullable=true, length=100)
    private String produto;
    
    public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	@Column(name="cidade", nullable=true, length=100)
    private String cidade;
    
    public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Column(name="placa", nullable=true, length=100)
    private String placa;
    
    public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	/*@Column(name="unidade_federativa", nullable=true, length=100)
    private String unidade_federativa;
    
    public String getUnidade_Federativa() {
		return unidade_federativa;
	}

	public void setUnidade_Federativa(String unidade_federativa) {
		this.unidade_federativa = unidade_federativa;
	}
*/
	@Column(name="uf", nullable=true, length=100)
    private String uf;
	
	@Column(name="empresa", nullable=true, length=100)
    private String empresa;
 
    
    public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	@Column(name="documento", nullable=true, length=100)
    private String documento;
    
    public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	@Column(name="bagagito", nullable=true, length=100)
    private String bagagito;
    
    public String getBagagito() {
		return bagagito;
	}

	public void setBagagito(String bagagito) {
		this.bagagito = bagagito;
	}

	@Column(name="retrovisor_eletrico", nullable=true, length=100)
    private String retrovisor_eletrico;
    
    public String getRetrovisor_eletrico() {
		return retrovisor_eletrico;
	}

	public void setRetrovisor_eletrico(String retrovisor_eletrico) {
		this.retrovisor_eletrico = retrovisor_eletrico;
	}

	@Column(name="retrovisor_comum", nullable=true, length=100)
    private String retrovisor_comum;
    
    public String getRetrovisor_comum() {
		return retrovisor_comum;
	}

	public void setRetrovisor_comum(String retrovisor_comum) {
		this.retrovisor_comum = retrovisor_comum;
	}

	@Column(name="farois_auxiliares", nullable=true, length=100)
    private String farois_auxiliares;
    
    public String getFarois_auxiliares() {
		return farois_auxiliares;
	}

	public void setFarois_auxiliares(String farois_auxiliares) {
		this.farois_auxiliares = farois_auxiliares;
	}

	@Column(name="rodas_comum", nullable=true, length=100)
    private String rodas_comum;
    
    public String getRodas_comum() {
		return rodas_comum;
	}

	public void setRodas_comum(String rodas_comum) {
		this.rodas_comum = rodas_comum;
	}

	@Column(name="rodas_de_liga", nullable=true, length=100)
    private String rodas_de_liga;
    
    public String getRodas_de_liga() {
		return rodas_de_liga;
	}

	public void setRodas_de_liga(String rodas_de_liga) {
		this.rodas_de_liga = rodas_de_liga;
	}

	@Column(name="radio_toca_cds", nullable=true, length=100)
    private String radio_toca_cds;
    
    public String getRadio_toca_cds() {
		return radio_toca_cds;
	}

	public void setRadio_toca_cds(String radio_toca_cds) {
		this.radio_toca_cds = radio_toca_cds;
	}

	
	@Column(name="amplificador", nullable=true, length=100)
    private String amplificador;
    
    public String getAmplificador() {
		return amplificador;
	}

	public void setAmplificador(String amplificador) {
		this.amplificador = amplificador;
	}

	

	@Column(name="mata_cachorro", nullable=true, length=100)
    private String mata_cachorro;
    
    public String getMata_cachorro() {
		return mata_cachorro;
	}

	public void setMata_cachorro(String mata_cachorro) {
		this.mata_cachorro = mata_cachorro;
	}

	@Column(name="buzinas", nullable=true, length=100)
    private String buzinas;
    
    public String getBuzinas() {
		return buzinas;
	}

	public void setBuzinas(String buzinas) {
		this.buzinas = buzinas;
	}

	@Column(name="bateria", nullable=true, length=100)
    private String bateria;
    
    public String getBateria() {
		return bateria;
	}

	public void setBateria(String bateria) {
		this.bateria = bateria;
	}



	@Column(name="alarme", nullable=true, length=100)
    private String alarme;

	public String getAlarme() {
		return alarme;
	}

	public void setAlarme(String alarme) {
		this.alarme = alarme;
	}
    
	
	
public Integer getSeta_esq() {
			return seta_esq;
	}

public void setSeta_esq(Integer seta_esq) {
			this.seta_esq = seta_esq;
	}
	


	/*
	 public Integer getOid() {
			return oid;
		}

	public void setOid(Integer oid) {
			this.oid = oid;
		}
     */
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
	
	
	public Integer getRetrovisor_esq() {
		return retrovisor_esq;
	}

	public void setRetrovisor_esq(Integer retrovisor_esq) {
		this.retrovisor_esq = retrovisor_esq;
	}

 
    public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	public byte[] getFoto_2() {
		return foto_2;
	}

	public void setFoto_2(byte[] foto_2) {
		this.foto_2 = foto_2;
	}

	public byte[] getFoto_3() {
		return foto_3;
	}

	public void setFoto_3(byte[] foto_3) {
		this.foto_3 = foto_3;
	}

	public byte[] getFoto_4() {
		return foto_4;
	}

	public void setFoto_4(byte[] foto_4) {
		this.foto_4 = foto_4;
	}

	public byte[] getFoto_5() {
		return foto_5;
	}

	public void setFoto_5(byte[] foto_5) {
		this.foto_5 = foto_5;
	}
	
}
    