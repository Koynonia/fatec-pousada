/**
 * @author GUILHERME JATOBÁ
 * Matéria Engenharia de Software 2
 * FATEC ZL 5º ADS - Tarde
 * 24/10/2016
 */

package edu.pousada.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.pousada.entity.Transporte;

public class TransporteDAOImpl implements TransporteDAO {

	private Connection con = DBUtil.getInstance().getConnection();

	/**
	 * CREATE TABLE transporte(
	 * id INT AUTO_INCREMENT PRIMARY KEY,
	 * placa VARCHAR(100) UNIQUE NOT NULL,
	 * estado VARCHAR(30) NOT NULL,
	 * destino VARCHAR(200) NOT NULL,
	 * dtReserva DATE NOT NULL,
	 * hrReserva DATE NOT NULL,
	 * valor DECIMAL(7,2) NOT NULL
	 * );
	 */
	
	@Override
	public void adicionar(Transporte t) throws SQLException {
		
		String sql = "INSERT INTO transporte VALUES (NULL,?,?,?,?,?,?) ";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, t.getPlaca());
		ps.setString(2, t.getEstado());
		ps.setString(3, t.getDestino());
		ps.setDate(4, new java.sql.Date( t.getDtReserva().getTime() ));
		ps.setDate(5, new java.sql.Date( t.getHrReserva().getTime() ));
		ps.setFloat(6, t.getValor());
		ps.execute();
		ps.close();
	}

	@Override
	public void alterar(Transporte t) throws SQLException {
		
		String sql = "UPDATE transporte SET "
				+ "placa = ?, "
				+ "estado = ?, "
				+ "destino = ? "
				+ "dtReserva = ?, "
				+ "hrReserva = ?, "
				+ "valor = ? "
				+ "WHERE placa = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, t.getPlaca());
		ps.setString(2, t.getEstado());
		ps.setString(3, t.getDestino());
		ps.setDate(4, new java.sql.Date( t.getDtReserva().getTime() ));
		ps.setDate(5, new java.sql.Date( t.getHrReserva().getTime() ));
		ps.setFloat(6, t.getValor());
		ps.setString(7, t.getPlaca());
		ps.execute();
		ps.close();
	}

	@Override
	public void excluir(Transporte t) throws SQLException {
		
		String sql = "DELETE FROM transporte WHERE id = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, t.getId());
		ps.execute();
		ps.close();
	}

	@Override
	public Transporte consultar(Transporte t) throws SQLException {
		
		String sql = "SELECT * FROM transporte WHERE id = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, t.getId());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			t.setPlaca(rs.getString("placa"));
			t.setEstado(rs.getString("estado"));
			t.setDestino(rs.getString("destino"));
			t.setDtReserva(rs.getDate("dtReserva"));
			t.setHrReserva(rs.getDate("hrReserva"));
			t.setValor(rs.getFloat("valor"));
		}
		rs.close();
		ps.close();
		
		return t;
	}

	@Override
	public List<Transporte> todos() throws SQLException {
		
		String sql = "SELECT * FROM transporte";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Transporte> lista = new ArrayList<Transporte>();
		while (rs.next()) {
			Transporte t = new Transporte();
			t.setPlaca(rs.getString("placa"));
			t.setEstado(rs.getString("estado"));
			t.setDestino(rs.getString("destino"));
			t.setDtReserva(rs.getDate("dtReserva"));
			t.setHrReserva(rs.getDate("hrReserva"));
			t.setValor(rs.getFloat("valor"));
			lista.add(t);
		}
		rs.close();
		ps.close();
		
		return lista;
	}
}