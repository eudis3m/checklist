package br.com.patio.projeto.business.service;

import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.patio.projeto.data.repository.UsuarioRepository;
import br.com.patio.projeto.entity.CheckListAutomovelEntity;
import br.com.patio.projeto.entity.RetiraVeiculoEntity;
import br.com.patio.projeto.entity.UsuarioEntity;
import br.com.patio.projeto.exceptionhandlers.exceptions.EmptyElementException;
import br.com.patio.projeto.exceptionhandlers.exceptions.NotFoundElementException;

@Service
@Transactional
public class UsuarioService {
	
	public UsuarioRepository usuariorepository;
	
	protected Boolean checkNullabilityOfTheEntityAndId(UsuarioEntity obj) {
		return obj != null && obj.getOid() != null && obj.getOid().longValue() > 0L;
	}
	
	protected Boolean checkNullabilityOfId(Long oid) {
		return oid != null && oid.longValue() > 0L;
	}
	@SuppressWarnings("unchecked")
	protected String getGenericName()
    {
        return ((Class<UsuarioEntity>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName();
    }


	public List<UsuarioEntity> findByDslogin(String dsLogin) {
		return usuariorepository.findByDsLogin(dsLogin);
	}

	public List<UsuarioEntity> findByNrcpf(String nrcnpj) {
		return usuariorepository.findByNrcpf(nrcnpj);
	}

	public UsuarioEntity create(UsuarioEntity obj) throws Exception {
		if(obj != null) {
			obj.setOid(null);
//			obj = prepareAudit(obj);
			//obj = validateEntity(obj);
			UsuarioEntity resultSave = usuariorepository.save(obj);
			return resultSave;
		}
		throw new EmptyElementException(getGenericName() + " não pode ser inserido se vazio.");
	}
	
	public UsuarioEntity findById(Long oid) throws Exception {
		if(checkNullabilityOfId(oid)) {
			Optional<UsuarioEntity> obj = usuariorepository.findById(oid);
			return obj.orElseThrow(() -> new NotFoundElementException(getGenericName() + " com identificador único = " + oid + " não encontrado! "));
			//return obj;
		}
		//throw new NotFoundException(getGenericName() + " com identificador único = " + id + " não encontrado! ");
		throw new NotFoundElementException(getGenericName() + " com identificador único = " + oid + " não encontrado! ");
	}
	
	public UsuarioEntity update(UsuarioEntity obj) throws Exception {
		if(checkNullabilityOfTheEntityAndId(obj)) {
//			obj = prepareAudit(obj);
			UsuarioEntity old =  findById(obj.getOid());
		//obj = validateEntity(old);
			
			UsuarioEntity address = usuariorepository.save(old);
			return address;
		}
		throw new EmptyElementException(getGenericName() + " não pode ser atualizado se vazio.");
	}

	//@Override
	public void delete(Long oid) throws Exception {
		UsuarioEntity address = findById(oid);
		address.setIdAtivo("N");
		usuariorepository.delete(address);
	}


 

}
