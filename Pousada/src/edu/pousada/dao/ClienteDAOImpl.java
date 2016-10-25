/**
 * @author Guilherme Jatobá
 * Matéria Engenharia de Software 2
 * FATEC ZL 5º ADS - Tarde
 * 24/10/2016
 */

package edu.pousada.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.pousada.entity.Cliente;

public class ClienteDAOImpl implements ClienteDAO {

	/*
	 * nome VARCHAR(100) NOT NULL, email VARCHAR(30) UNIQUE NOT NULL, documento
	 * VARCHAR(15) PRIMARY KEY, docTipo VARCHAR(15), dtNasc DATE NOT NULL,
	 * telefone VARCHAR(11) UNIQUE, celular VARCHAR(12) UNIQUE NOT NULL,
	 * endereco VARCHAR(200) NOT NULL, bairro VARCHAR(30) NOT NULL, cidade
	 * VARCHAR(30) NOT NULL, estado VARCHAR(15) NOT NULL, pais VARCHAR(10) NOT
	 * NULL, cep VARCHAR(8) NOT NULL, dtCadastro DATE NOT NULL, ativo BOOLEAN
	 * NOT NULL );
	 */
	
	private Connection con = DBUtil.getInstance().getConnection();

	public void adicionarCliente(Cliente cliente) throws SQLException {
		String sql = "INSERT INTO cliente VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, cliente.getNome());
		ps.setString(2, cliente.getEmail());
		ps.setString(3, cliente.getDocumento());
		ps.setString(4, cliente.getDocTipo());
		ps.setDate(5, (Date) cliente.getDtNasc());
		ps.setString(6, cliente.getTelefone());
		ps.setString(7, cliente.getCelular());
		ps.setString(8, cliente.getEndereco());
		ps.setString(9, cliente.getBairro());
		ps.setString(10, cliente.getCidade());
		ps.setString(11, cliente.getEstado());
		ps.setString(12, cliente.getPais());
		ps.setLong(13, cliente.getCep());
		ps.setDate(14, (Date) cliente.getDtCadastro());
		ps.setBoolean(15, cliente.getAtivo());

		ps.execute();
		ps.close();
	}

	public void alterarCliente(Cliente cliente) throws SQLException {
		String sql = "UPDATE cliente SET nome = ?, email = ?, docTipo = ?, dtNasc = ?, telefone = ?, celular = ?, endereco = ?, "
				+ "bairro = ?, cidade = ?, estado = ?, pais = ?, cep = ?, dtCadastro = ?, ativo = ? WHERE documento = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, cliente.getNome());
		ps.setString(2, cliente.getEmail());
		ps.setString(3, cliente.getDocTipo());
		ps.setDate(4, (Date) cliente.getDtNasc());
		ps.setString(5, cliente.getTelefone());
		ps.setString(6, cliente.getCelular());
		ps.setString(7, cliente.getEndereco());
		ps.setString(8, cliente.getBairro());
		ps.setString(9, cliente.getCidade());
		ps.setString(10, cliente.getEstado());
		ps.setString(11, cliente.getPais());
		ps.setString(12, cliente.getCep());
		ps.setDate(13, (Date) cliente.getDtCadastro());
		ps.setBoolean(14, cliente.getAtivo());

		ps.setString(15, cliente.getDocumento());

		ps.execute();
		ps.close();
	}

	@Override
	public void excluiCliente(Cliente cliente) throws SQLException {
		String sql = "DELETE cliente WHERE documento = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, cliente.getDocumento());
		ps.execute();
		ps.close();

	}


	public Cliente consultaCliente(Cliente cliente) throws SQLException {
		String sql = "SELECT * FROM clientes WHERE documento =  ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, cliente.getDocumento());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			cliente.setNome(rs.getString("nome"));
			cliente.setEmail(rs.getString("email"));
			cliente.setDocumento(rs.getString("documento"));
			cliente.setDocTipo(rs.getString("docTipo"));
			cliente.setDtNasc(rs.getDate("dtNasc"));
			cliente.setTelefone(rs.getString("telefone"));
			cliente.setCelular(rs.getString("celular"));
			cliente.setEndereco(rs.getString("endereco"));
			cliente.setBairro(rs.getString("bairro"));
			cliente.setCidade(rs.getString("cidade"));
			cliente.setEstado(rs.getString("estado"));
			cliente.setPais(rs.getString("pais"));
			cliente.setCep(rs.getString("cep"));
			cliente.setDtCadastro(rs.getDate("dtCadastro"));
			cliente.setAtivo(rs.getBoolean("ativo"));
		}
		rs.close();
		ps.close();

		return cliente;
	}

	public List<Cliente> listaCliente() throws SQLException {
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		String sql = "SELECT * FROM cliente";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Cliente cliente = new Cliente();
			cliente.setNome(rs.getString("nome"));
			cliente.setEmail(rs.getString("email"));
			cliente.setDocumento(rs.getString("documento"));
			cliente.setDocTipo(rs.getString("docTipo"));
			cliente.setDtNasc(rs.getDate("dtNasc"));
			cliente.setTelefone(rs.getString("telefone"));
			cliente.setCelular(rs.getString("celular"));
			cliente.setEndereco(rs.getString("endereco"));
			cliente.setBairro(rs.getString("bairro"));
			cliente.setCidade(rs.getString("cidade"));
			cliente.setEstado(rs.getString("estado"));
			cliente.setPais(rs.getString("pais"));
			cliente.setCep(rs.getString("cep"));
			cliente.setDtCadastro(rs.getDate("dtCadastro"));
			cliente.setAtivo(rs.getBoolean("ativo"));
			listaCliente.add(cliente);
		}

		return listaCliente;
	}

}