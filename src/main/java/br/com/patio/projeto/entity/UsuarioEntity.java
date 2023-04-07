package br.com.patio.projeto.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;




@Entity
@Table(name="usuario")
public class UsuarioEntity  extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
   

    @Size(max = 500)
    @Column(name="nm_usuario", nullable=false, length=100)
    private String nmusuario;

    @Size(max = 500)
    @Column(name="nr_cpf", nullable=false, length= 100)
    private  String nrcpf;


    @Size(max = 500)
    @Column(name="ds_senha", nullable=false, length=100)
    private String dssenha;
    
    @Size(max = 500)
    @Column(name="nm_recursos", nullable=false)
    private String nmrecursos;
    
    @Size(max = 500)
    @Column(name="ds_login", nullable=false, length=100)
    private String dsLogin;
  
	
	public String getDsLogin() {
		return dsLogin;
	}

	public void setDsLogin(String dsLogin) {
		this.dsLogin = dsLogin;
	}


	public String getDSSenha() {
		return dssenha;
	}

	public void setDSSenha(String dssenha) {
		this.dssenha = dssenha;
	}

	public String getNrcpf() {
		return nrcpf;
	}

	public void setNrcpf(String nrcpf) {
		this.nrcpf = nrcpf;
	}

    
    public String getNMUsuario() {
		return nmusuario;
    }
    
    public void setNMUsuario(String nmusuario) {
		this.nmusuario = nmusuario;
    }
    
   
	
}
    