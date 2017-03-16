package br.usjt.ardesis.test;




import br.usjt.arqdesis.dao.UsuarioDAO;
import br.usjt.arqdesis.javabens.Usuario;
import br.usjt.arqdesis.service.EmpresaService;

public class Teste {

	public static void main(String[] args) {
		
		Usuario usuario = new Usuario();
		usuario.setCpf("111111");
		usuario.setLogin("22222");
		usuario.setNome("rafael");
		usuario.setSenha("22333");
		usuario.setTipo("um");
    
		  
		//UsuarioDAO dao = new UsuarioDAO();
		//dao.adiciona(usuario);
		//dao.atualiza(usuario);
		//dao.carregar(2);
		usuario.toString();
	}

}
