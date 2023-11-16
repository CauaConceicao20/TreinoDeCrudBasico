package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

public class ContatoDAO {

	public void save(Contato contato) {
		// variavel que armazenar consulta sql
		String sql = "INSERT INTO contatos (nome, idade, dataCadastro) VALUES (?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Criar um conexão com banco de dados
			conn = ConnectionFactory.creatConnectionToMysql();

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));

			pstm.execute();
			System.out.println("Contato Salvo com Sucesso");
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
	}
	
	public void delete(int id) {
		
		String sql = "DELETE FROM contatos WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.creatConnectionToMysql();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
			System.out.println("Contato Deletado");
			
		}catch(Exception exception) {
			exception.printStackTrace();
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			}catch(Exception exception) {
				exception.printStackTrace();
			}
		}
	}

	public void update(Contato contato) {
		String sql = "UPDATE contatos SET nome = ?, idade = ?, dataCadastro = ?" + "WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.creatConnectionToMysql();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			pstm.setInt(4, contato.getId());
			
			pstm.execute();
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			}catch(Exception exception) {
				exception.printStackTrace();
			}
		}
	}

	public List<Contato> getContato() {

		String sql = "SELECT * FROM Contatos";
		List<Contato> contatos = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			conn = ConnectionFactory.creatConnectionToMysql();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Contato contato = new Contato();

				contato.setId(rset.getInt("id"));
				contato.setNome(rset.getString("nome"));
				contato.setIdade(rset.getInt("idade"));

				contatos.add(contato);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (rset != null) {
					rset.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return contatos;
	}
}
