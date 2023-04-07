package br.com.patio.projeto.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.patio.projeto.util.JsonParseable;


@MappedSuperclass
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseEntity implements Serializable, JsonParseable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OID", nullable = false)
    private Long oid;
    
    @Column(name = "DT_CADASTRO", nullable = false)
    private ZonedDateTime dtCadastro;
    
    @Column(name = "DT_ALTERACAO", nullable = false)
    private ZonedDateTime dtAlteracao;
    
    @Column(name = "OID_USUARIO_CADASTRO", nullable = false)
    private Long oidUsuarioCadastro;
    
    @Column(name = "OID_USUARIO_ALTERACAO", nullable = false)
    private Long oidUsuariosAlteracao;

    @Column(name = "ID_ATIVO", nullable = false, insertable = false)
    private String idAtivo;
    
    public void setAuditoria(BaseEntity obj) {
    	setDtCadastro(obj.getDtCadastro());
    	setOidUsuarioCadastro(obj.getOidUsuarioCadastro());
    	setIdAtivo(obj.getIdAtivo());
    }
    
    /*
     * metodo executado sempre antes da insercao dos dados.
     */
    @PrePersist
    protected void onPersist() {
    	ZonedDateTime dateTime = ZonedDateTime.now();
   		
    	setDtCadastro(dateTime);
   		setOidUsuarioCadastro(1L); 

   		setDtAlteracao(dateTime);
        setOidUsuariosAlteracao(1L);
    }
    
    /*
     * metodo executado sempre antes de um update
     */
    @PreUpdate
    protected void onUpdate() {
    	ZonedDateTime dateTime = ZonedDateTime.now();
    	setDtAlteracao(dateTime);
        setOidUsuariosAlteracao(1L);
    }

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public ZonedDateTime getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(ZonedDateTime dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public ZonedDateTime getDtAlteracao() {
		return dtAlteracao;
	}

	public void setDtAlteracao(ZonedDateTime dtAlteracao) {
		this.dtAlteracao = dtAlteracao;
	}

	public Long getOidUsuarioCadastro() {
		return oidUsuarioCadastro;
	}

	public void setOidUsuarioCadastro(Long oidUsuarioCadastro) {
		this.oidUsuarioCadastro = oidUsuarioCadastro;
	}

	public Long getOidUsuariosAlteracao() {
		return oidUsuariosAlteracao;
	}

	public void setOidUsuariosAlteracao(Long oidUsuariosAlteracao) {
		this.oidUsuariosAlteracao = oidUsuariosAlteracao;
	}

	public String getIdAtivo() {
		return idAtivo;
	}

	public void setIdAtivo(String idAtivo) {
		this.idAtivo = idAtivo;
	}
	
}
