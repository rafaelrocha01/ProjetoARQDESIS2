package br.usjt.arqdesis.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.usjt.arqdesis.factory.ConnectionFactory;
import br.usjt.arqdesis.javabens.Empresa;
import br.usjt.arqdesis.javabens.Usuario;

public class UsuarioDAO {
	private Connection connection;

	public void EmpresaDao() throws SQLException {


	}
	
	
	public int adiciona(Usuario usuario) {
		String sql = "insert into usuario " + "(login,tipo,senha,nome,cpf)" + " values (?,?,?,?,?)";

		 try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stmt = conn.prepareStatement(sql);) {

			// seta os valores

			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getTipo());
			stmt.setString(3, usuario.getSenha());
			stmt.setString(4, usuario.getNome());
			stmt.setString(5, usuario.getCpf());
	

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		 return usuario.getId();
	}
	 
	public void atualiza(Usuario usuario) {
		String sqlUpdate = "UPDATE usuario SET login=?,tipo=?,senha=?,nome=?,cpf=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stmt = conn.prepareStatement(sqlUpdate);) {
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getTipo());
			stmt.setString(3, usuario.getSenha());
			stmt.setString(4, usuario.getNome());
			stmt.setString(5, usuario.getCpf());
	
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int id) {
		String sqlDelete = "DELETE FROM usuario WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Usuario carregar(int id) {
		Usuario usuario = new Usuario();
		usuario.setId(id);
		String sqlSelect = "SELECT login,tipo,senha,nome,cpf FROM usuario WHERE usuario.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, usuario.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					usuario.setLogin(rs.getString("login"));
					usuario.setTipo(rs.getString("tipo"));
					usuario.setSenha(rs.getString("senha"));
					usuario.setNome(rs.getString("nome"));
					usuario.setCpf(rs.getString("cpf"));
				} else {
					usuario.setId(-1);
					usuario.setLogin(null);
					usuario.setTipo(null);
					usuario.setSenha(null);
					usuario.setNome(null);
					usuario.setCpf(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return usuario;
	}
	

}
