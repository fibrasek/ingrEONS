package com.gabrielbellon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.gabrielbellon.db.ConnectionFactory;
import com.gabrielbellon.model.Portal;

public class PortalDAO {

	private Connection con;
	private ArrayList<Portal> lista = null;

	public PortalDAO() {
		this.con = new ConnectionFactory().getConnection();
	}

	public void insere(Portal p) {
		String sql = "INSERT INTO \"portal\" ( \"address\", \"lat\", \"lon\", \"name\") VALUES (?, ?, ?, ?);";

		PreparedStatement stm;
		try {
			stm = con.prepareStatement(sql);

			stm.setString(1, p.getAddress()/* "Rua Engenheiro Farid Surugi, 318-416 - Tarumã, PR, 82800-110" */);
			stm.setDouble(2, p.getLat()/*-25.43267918*/);
			stm.setDouble(3, p.getLon()/*-49.2219497*/);
			stm.setString(4, p.getName()/* "Portal de Casa" */);

			stm.execute();
			stm.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Portal p) {
		String sql = "UPDATE \"portal\" SET \"address\" = ?, \"lat\" = ?, \"lon\" = ?, \"name\" = ? WHERE \"id\"= ?;";
		
		PreparedStatement stm;
		try {
			stm = con.prepareStatement(sql);

			stm.setString(1, p.getAddress());
			stm.setDouble(2, p.getLat());
			stm.setDouble(3, p.getLon());
			stm.setString(4, p.getName());
			stm.setInt(5, p.getId());

			stm.executeUpdate();
			stm.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int id){
		String sql = "DELETE FROM \"portal\" WHERE id = ?";
		
		PreparedStatement stm;
		try {
			stm = con.prepareStatement(sql);
			
			stm.setInt(1, id);
			
			stm.executeUpdate();
			stm.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void lerTudo() {
		String sql = "SELECT * FROM \"portal\";";

		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("id"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("lat"));
				System.out.println(rs.getString("lon"));
				System.out.println(rs.getString("address"));
			}

			stm.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Portal> getLista() {
		String sql = "SELECT * FROM \"portal\";";

		ArrayList<Portal> lista = new ArrayList<Portal>();
		Portal p;
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				p = new Portal();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setLat(rs.getDouble("lat"));
				p.setLon(rs.getDouble("lon"));
				p.setAddress(rs.getString("address"));

				lista.add(p);
			}

			stm.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}
}
