package br.usjt.arqdesis.service;

import br.usjt.arqdesis.javabens.*;

import br.usjt.arqdesis.dao.UsuarioDAO;
import br.usjt.arqdesis.javabens.Usuario;

public class UsuarioService {
	
		UsuarioDAO dao = new UsuarioDAO();
		
		public int adiciona(Usuario usuario) {
			return dao.adiciona(usuario);
		}
		
		public void atualiza(Usuario usuario){
			dao.atualiza(usuario);
		}
		
		public void excluir(int id){
			dao.excluir(id);
		}
		
		public Usuario carregar(int id){
			return dao.carregar(id);
		}

}
