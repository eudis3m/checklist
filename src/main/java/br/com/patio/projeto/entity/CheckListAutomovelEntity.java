package br.com.patio.projeto.entity;

import java.io.Serializable;
import java.sql.Blob;
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
@Table(name="checklist_automovel")
public class CheckListAutomovelEntity  implements Serializable {

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
    
	@Column(name="foto", nullable=true)
	byte[] foto;
	
	@Column(name="foto_2", nullable=true)
	byte[] foto_2;
	
	@Column(name="foto_3", nullable=true)
	byte[] foto_3;
	
	@Column(name="foto_4", nullable=true)
	byte[] foto_4;

	@Column(name="foto_5", nullable=true)
	byte[] foto_5;
	
	@Column(name="vidro_diant_dir", nullable=true, length=100)
    private Integer vidro_diant_dir;
	
	@Column(name="bau_dir", nullable=true, length=100)
    private Integer bau_dir;
	
	@Column(name="tanque", nullable=true, length=100)
    private Integer tanque;
	
	@Column(name="roda_tras_dir", nullable=true, length=100)
    private Integer roda_tras_dir;
	
	@Column(name="bau_esq", nullable=true, length=100)
    private Integer bau_esq;
	
	@Column(name="caminhao", nullable=true, length=100)
    private String caminhao;
	
	
	@Column(name="capo", nullable=true, length=100)
    private Integer capo;
    
   

	@Column(name="parabrisa", nullable=true, length=100)
    private Integer parabrisa;
    
   

	@Column(name="retrovisor_dir", nullable=true, length=100)
    private Integer retrovisor_dir;
    
    

	@Column(name="farol_dir", nullable=true, length=100)
    private Integer farol_dir;
    

	@Column(name="lateral_tras", nullable=true, length=100)
    private Integer lateral_tras;
    
    

	@Column(name="vidro_tras_esq", nullable=true, length=100)
    private Integer vidro_tras_esq;
    
    

	@Column(name="porta_tras_esq", nullable=true, length=100)
    private Integer porta_tras_esq;
    
   

	@Column(name="vidro_diant_esq", nullable=true, length=100)
    private Integer vidro_diant_esq;
    
   

	@Column(name="porta_diant_esq", nullable=true, length=100)
    private Integer porta_diant_esq;
    
   
	@Column(name="farol_esq", nullable=true, length=100)
    private Integer farol_esq;
    
   

	@Column(name="retrovisor_esq", nullable=true, length=100)
    private Integer retrovisor_esq;
    
   
	@Column(name="seta_esq", nullable=true, length=100)
    private Integer seta_esq;
	
	@Column(name="seta_dir", nullable=true, length=100)
    private Integer seta_dir;
    

	@Column(name="para_choque", nullable=true, length=100)
    private Integer para_choque;
    

	@Column(name="farolete_dir", nullable=true, length=100)
    private Integer farolete_dir;
    

	@Column(name="farolete_esq", nullable=true, length=100)
    private Integer farolete_esq;
    
   
	@Column(name="vidro_tras", nullable=true, length=100)
    private Integer vidro_tras;
    

	@Column(name="traseira", nullable=true, length=100)
    private Integer traseira;
    

	@Column(name="tam_porta_malas", nullable=true, length=100)
    private Integer tam_porta_malas;
    
   
	@Column(name="vidro_tras2", nullable=true, length=100)
    private Integer vidro_tras2;
    
    
	@Column(name="teto", nullable=true, length=100)
    private Integer teto;
    
   
	@Column(name="capo2", nullable=true, length=100)
    private Integer capo2;
    

	@Column(name="roda_tras_esq", nullable=true, length=100)
    private Integer roda_tras_esq;
    
   
	@Column(name="roda_diant_esq", nullable=true, length=100)
    private Integer roda_diant_esq;
    

	@Column(name="lateral_diant_esq", nullable=true, length=100)
    private Integer lateral_diant_esq;
    

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
	
	@Column(name="automovel", nullable=true, length=100)
    private String automovel;

  
    public String getAutomovel() {
		return automovel;
	}

	public void setAutomovel(String automovel) {
		this.automovel = automovel;
	}

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
    
	
	@Column(name="empresa", nullable=true, length=100)
    private String empresa;
 

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

	@Column(name="local", nullable=true, length=100)
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

	@Column(name="borrachao_lateral", nullable=true, length=100)
    private String borrachao_lateral;
    
    public String getBorrachao_lateral() {
		return borrachao_lateral;
	}

	public void setBorrachao_lateral(String borrachao_lateral) {
		this.borrachao_lateral = borrachao_lateral;
	}

	@Column(name="break_light", nullable=true, length=100)
    private String break_light;
    
    public String getBreak_light() {
		return break_light;
	}

	public void setBreak_light(String break_light) {
		this.break_light = break_light;
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

	@Column(name="banco_dianteiro", nullable=true, length=100)
    private String banco_dianteiro;
    
    public String getBanco_dianteiro() {
		return banco_dianteiro;
	}

	public void setBanco_dianteiro(String banco_dianteiro) {
		this.banco_dianteiro = banco_dianteiro;
	}

	@Column(name="banco_traseiro", nullable=true, length=100)
    private String banco_traseiro;
    
    public String getBanco_traseiro() {
		return banco_traseiro;
	}

	public void setBanco_traseiro(String banco_traseiro) {
		this.banco_traseiro = banco_traseiro;
	}

	@Column(name="tapetes", nullable=true, length=100)
    private String tapetes;
    
    public String getTapetes() {
		return tapetes;
	}

	public void setTapetes(String tapetes) {
		this.tapetes = tapetes;
	}

	@Column(name="protetor_carter", nullable=true, length=100)
    private String protetor_carter;
    
    public String getProtetor_carter() {
		return protetor_carter;
	}

	public void setProtetor_carter(String protetor_carter) {
		this.protetor_carter = protetor_carter;
	}

	@Column(name="extintor", nullable=true, length=100)
    private String extintor;
    
    public String getExtintor() {
		return extintor;
	}

	public void setExtintor(String extintor) {
		this.extintor = extintor;
	}

	@Column(name="triangulo", nullable=true, length=100)
    private String triangulo;
    
    public String getTriangulo() {
		return triangulo;
	}

	public void setTriangulo(String triangulo) {
		this.triangulo = triangulo;
	}

	@Column(name="console_interno", nullable=true, length=100)
    private String console_interno;
    
    public String getConsole_interno() {
		return console_interno;
	}

	public void setConsole_interno(String console_interno) {
		this.console_interno = console_interno;
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

	@Column(name="macaco", nullable=true, length=100)
    private String macaco;
    
    public String getMacaco() {
		return macaco;
	}

	public void setMacaco(String macaco) {
		this.macaco = macaco;
	}

	@Column(name="chave_de_roda", nullable=true, length=100)
    private String chave_de_roda;
    
    
    public String getChave_de_roda() {
		return chave_de_roda;
	}

	public void setChave_de_roda(String chave_de_roda) {
		this.chave_de_roda = chave_de_roda;
	}

	@Column(name="calotas", nullable=true, length=100)
    private String calotas;
    
    public String getCalotas() {
		return calotas;
	}

	public void setCalotas(String calotas) {
		this.calotas = calotas;
	}

	@Column(name="alarme", nullable=true, length=100)
    private String alarme;

	public String getAlarme() {
		return alarme;
	}

	public void setAlarme(String alarme) {
		this.alarme = alarme;
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
	
		 public Integer getTeto() {
				return teto;
		}

	    public void setTeto(Integer teto) {
				this.teto = teto;
		}
	    public Integer getCapo2() {
			return capo2;
		}

		public void setCapo2(Integer capo2) {
			this.capo2 = capo2;
		}
		
		public Integer getRoda_diant_esq() {
			return roda_diant_esq;
	}

	public void setRoda_diant_esq(Integer roda_diant_esq) {
			this.roda_diant_esq = roda_diant_esq;
	}
	
	public Integer getRoda_tras_esq() {
		return roda_tras_esq;
     }
	
   public void setRoda_tras_esq(Integer roda_tras_esq) {
	this.roda_tras_esq = roda_tras_esq;
      }
   
   public Integer getLateral_diant_esq() {
		return lateral_diant_esq;
      }

   public void setLateral_diant_esq(Integer lateral_diant_esq) {
		this.lateral_diant_esq = lateral_diant_esq;
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
	public Integer getSeta_dir() {
		return seta_dir;
	}

	public void setSeta_dir(Integer seta_dir) {
		this.seta_dir = seta_dir;
	}
}
    