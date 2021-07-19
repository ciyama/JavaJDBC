package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection(); //conecta ao banco de dados
			
			st = conn.createStatement(); // instancia o meu Statment
			
			rs = st.executeQuery("select * from department");
			
			while (rs.next()) {
				System.out.println(rs.getInt("id") + ", " + rs.getString("name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeResultSet(null);;
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
