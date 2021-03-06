/**
 * @author FERNANDO MORAES OLIVEIRA
 * Materia Engenharia de Software 2
 * FATEC ZL 5º ADS - Tarde
 * 23/10/2016
 */

package edu.pousada.dao;

import java.sql.SQLException;
import java.util.List;

import edu.pousada.entity.Reserva;

public interface ReservaDAO {
	
	public void adicionar(Reserva obj) throws SQLException;
	public void alterar(Reserva obj) throws SQLException;
	public void excluir(Reserva obj) throws SQLException;
	public Reserva consultar(Reserva obj) throws SQLException;
	public List<Reserva> todos() throws SQLException;
}