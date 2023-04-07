package br.com.patio.projeto.entity;


import java.io.Serializable;
import java.sql.Blob;
import java.text.DateFormat;
import java.time.ZonedDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.exolab.castor.types.DateTime;

import com.itextpdf.text.Image;



@Entity
@Table(name="retiraveiculo")
public class RetiraVeiculoEntity extends BaseEntity  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="total", nullable=true, length=100)
	 Double total;
	
	//@Temporal(TemporalType.DATE)
	@Column(name="saida", nullable=true, length=100)
	String saida;
	
	@Column(name="assinatura", nullable=true, length=100)
	Blob assinatura;
	
	/*@Temporal(TemporalType.DATE)
	@Column(name="entrada", nullable=true, length=100)
	 Date entrada;*/

	@Column(name="nome", nullable=true, length=100)
	 String nome;
	
	@Column(name="rg", nullable=true, length=100)
	 String rg;
	
	@Column(name="ssp", nullable=true, length=100)
	 String ssp;
	
	@Column(name="categoria", nullable=true, length=100)
	 String categoria;
	
	@Column(name="placa", nullable=true, length=100)
	 String placa;
	
	@Column(name="cnh", nullable=true, length=100)
	 String cnh;
	
	@Column(name="diaria", nullable=true, length=100)
	 Integer diaria;

	@ManyToOne
    @JoinColumn(name="oid_checklist")
    private CheckListAutomovelEntity oidchecklist;
	
	public CheckListAutomovelEntity getOidchecklist() {
		return oidchecklist;
	}

	public void setOidchecklist(CheckListAutomovelEntity oidchecklist) {
		this.oidchecklist = oidchecklist;
	}

	public  Double getTotal() {
		return total;
	}

	public String getSaida() {
		return saida;
	}

	public  String getNome() {
		return nome;
	}

	public  String getRg() {
		return rg;
	}

	public  String getSsp() {
		return ssp;
	}

	public  String getCategoria() {
		return categoria;
	}

	public  String getPlaca() {
		return placa;
	}

	public  String getCnh() {
		return cnh;
	}

	
	public  void setTotal(Double total) {
		this.total = total;
	}

	public  void setSaida(String saida) {
		this.saida = saida;
	}

	public  void setNome(String nome) {
		this.nome = nome;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public void setSsp(String ssp) {
		this.ssp = ssp;
	}

	public  void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setPlaca1(String placa) {
		this.placa = placa;
	}

	public  void setCnh(String cnh) {
		this.cnh = cnh;
	}
	
	public Integer getDiaria() {
		return diaria;
	}

	public void setDiaria(Integer diaria) {
		this.diaria = diaria;
	}
	public Blob getAssinatura() {
		return assinatura;
	}

	public void setAssinatura(Blob assinatura) {
		this.assinatura = assinatura;
	}
	
	
	/*public Image getAssinatura() {
		return assinatura;
	}

	public void setAssinatura(Image assinatura) {
		this.assinatura = assinatura;
	}*/
	/*public Date getEntrada() {
		return entrada;
	}

	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}*/


}
