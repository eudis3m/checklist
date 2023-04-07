package br.com.patio.projeto.data.repository.query;

public class UsuarioQuery {
	
	 public static final String FIND_TABELA_Example = 
	    		" SELECT u"+
	    		" FROM UsuarioEntity u "+
	    		"WHERE upper(u.nmusuario) LIKE upper(:nmusuario)";
 
 public static final String FIND_TABELA_Usuairo = 
 		" SELECT new br.com.ibrowse.projeto.dto.UsuarioTabelaDTO("
 		+ " u.nmusuario, u.nrcpf, u.dssenha, u.dsLogin, u.nmrecursos"+
 		" ) " +
 		" FROM UsuarioEntity u "+
 		"WHERE (upper(u.nmusuario) LIKE upper(:field))";


}
