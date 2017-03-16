package br.usjt.ardesis.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.usjt.arqdesis.javabens.Usuario;
import br.usjt.arqdesis.service.UsuarioService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioTest {
	Usuario usuario, copia;
	UsuarioService UsuarioService;
	static int id = 0;


	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		usuario = new Usuario();
		usuario.setId(id);
		usuario.setNome("Batista Cepelos");
		usuario.setLogin("batista");
		usuario.setSenha("@123");
		usuario.setCpf("777777777-79");
		usuario.setTipo("funcionario");
		copia = new Usuario();
		copia.setId(id);
		copia.setNome("Batista Cepelos");
		copia.setLogin("batista");
		copia.setSenha("@123");
		copia.setCpf("777777777-79");
		copia.setTipo("funcionario");
		UsuarioService = new UsuarioService();
		System.out.println(usuario);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		br.usjt.arqdesis.javabens.Usuario fixture = new Usuario();
		fixture.setId(1);
		fixture.setNome("Carlos Drummond de Andrade");
		fixture.setLogin("carlos");
		fixture.setSenha("carlos123");
		fixture.setCpf("222222222-23");
		fixture.setTipo("sindico");
		UsuarioService novoService = new UsuarioService();
		Usuario novo = novoService.carregar(1);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		System.out.println("criar");
		id = UsuarioService.adiciona(usuario);
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", usuario, copia);
	}

	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		usuario.setLogin("carlos.a");
		copia.setSenha("123@123");		
		UsuarioService.atualiza(usuario);
		usuario = UsuarioService.carregar(usuario.getId());
		assertEquals("testa atualizacao", usuario, copia);
	}

	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setLogin(null);
		copia.setSenha(null);
		copia.setCpf(null);
		copia.setTipo(null);
		UsuarioService.excluir(id);
		usuario = UsuarioService.carregar(id);
		assertEquals("testa exclusao", usuario, copia);
	}
}