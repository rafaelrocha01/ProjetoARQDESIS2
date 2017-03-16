package br.usjt.arqdesis.service;

import br.usjt.arqdesis.dao.EmpresaDAO;
import br.usjt.arqdesis.javabens.Empresa;

public class EmpresaService {
	
EmpresaDAO dao = new EmpresaDAO();


	
	public void adiciona(Empresa empresa) {
	dao.adiciona(empresa);
	}
	
	public void atualiza(Empresa empresa){
		dao.atualiza(empresa);
	}
	
	public void excluir(int id){
         dao.excluir(id);
	}
	
	public Empresa carregar(int id){
		return dao.carregar(id);
	}

}
