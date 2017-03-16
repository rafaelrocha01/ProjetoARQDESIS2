package br.usjt.ardesis.test;




import br.usjt.arqdesis.dao.UsuarioDAO;
import br.usjt.arqdesis.javabens.Usuario;
import br.usjt.arqdesis.service.EmpresaService;
import br.usjt.arqdesis.service.UsuarioService;

public class Teste {

	public static void main(String[] args) {
		UsuarioService service = new UsuarioService();
		Usuario usuario = new Usuario();
		usuario.setCpf("11");
		usuario.setLogin("22222");
		usuario.setNome("rafael");
		usuario.setSenha("22333");
		usuario.setTipo("um");
    
		service.atualiza(usuario);
		//UsuarioDAO dao = new UsuarioDAO();
		//dao.adiciona(usuario);
		//dao.atualiza(usuario);
		//dao.carregar(2);
		//usuario.toString();
	}

}
