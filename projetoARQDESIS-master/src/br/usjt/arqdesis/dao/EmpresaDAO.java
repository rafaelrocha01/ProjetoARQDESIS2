package br.usjt.arqdesis.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import br.usjt.arqdesis.factory.ConnectionFactory;
import br.usjt.arqdesis.javabens.Empresa;

public class EmpresaDAO {



	public void EmpresaDao() throws SQLException {
		

	}
	public void adiciona(Empresa empresa) {
		String sql = "insert into empresa " + "(cnpj,razaSocial,conjunto,valorTemperatura,horarioArCondicionado)" + " values (?,?,?,?,?,?)";

		try (Connection conn = ConnectionFactory.obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sql);) {
			// prepared statement para inserção
		

			// seta os valores
			
			stm.setString(1, empresa.getCnpj());
			stm.setString(2, empresa.getRazaSocial());
			stm.setInt(3, empresa.getConjunto());
			stm.setInt(4, empresa.getValorTemperatura());
			stm.setString(5, empresa.getHorarioArCondicionado());
			stm.setString(6, empresa.getHorarioDeFuncionameto());

			// executa
			stm.execute();
			stm.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void atualiza(Empresa empresa) {
		String sqlUpdate = "UPDATE cliente SET cnpj=?,razaSocial=?,conjunto=?,valorTemperatura=?,horarioArCondicionado=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stmt = conn.prepareStatement(sqlUpdate);) {
			stmt.setString(1, empresa.getCnpj());
			stmt.setString(2, empresa.getRazaSocial());
			stmt.setInt(3, empresa.getConjunto());
			stmt.setInt(4, empresa.getValorTemperatura());
			stmt.setString(5, empresa.getHorarioArCondicionado());
			stmt.setString(5, empresa.getHorarioDeFuncionameto());

			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM cliente WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Empresa carregar(int id) {
		Empresa empresa = new Empresa();
		empresa.setId(id);
		String sqlSelect = "SELECT nome, fone, email FROM empresa WHERE empresa.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stmt = conn.prepareStatement(sqlSelect);) {
			stmt.setInt(1, empresa.getId());
			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					stmt.setString(1, empresa.getCnpj());
					stmt.setString(2, empresa.getRazaSocial());
					stmt.setInt(3, empresa.getConjunto());
					stmt.setInt(4, empresa.getValorTemperatura());
					stmt.setString(5, empresa.getHorarioArCondicionado());
					stmt.setString(6, empresa.getHorarioDeFuncionameto());

				} else {
					empresa.setId(-1);
					empresa.setCnpj(null);
					empresa.setConjunto((Integer) null);
					empresa.setHorarioArCondicionado(null);
					empresa.setHorarioArCondicionado(null);
					empresa.setRazaSocial(null);
					empresa.setValorTemperatura((Integer)null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return empresa;
	}}
