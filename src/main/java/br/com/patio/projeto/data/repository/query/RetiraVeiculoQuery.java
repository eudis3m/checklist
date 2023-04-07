package br.com.patio.projeto.data.repository.query;

public class RetiraVeiculoQuery {
	
	 public static final String RetiraVeiculo= 
			 " SELECT r , c.entrada "+
					 " FROM RetiraVeiculoEntity r , CheckListAutomovelEntity c "
					 +" WHERE ( upper(r.placa) LIKE upper(:placa)  "
					 + " AND upper(c.placa) LIKE upper(:placa) ) ";
	 
	 public static final String RetiraMotocicleta= 
			 " SELECT r , m.entrada "+
					 " FROM RetiraVeiculoEntity r , CheckListMotocicletaEntity m "
					 +" WHERE ( upper(r.placa) LIKE upper(:placa) "
					 + " AND upper(m.placa) LIKE upper(:placa) ) ";
	 
	 public static final String BuscaPlaca= 
			 " SELECT r  "+
					 " FROM RetiraVeiculoEntity r "
					 +" WHERE ( upper(r.placa) LIKE upper(:placa)) ";

}
