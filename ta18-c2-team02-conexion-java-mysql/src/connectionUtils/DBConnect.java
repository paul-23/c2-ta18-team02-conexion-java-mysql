package connectionUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class DBConnect {
	Connection connection;

	public Connection getConnection() {
		return connection;
	}

	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://192.168.68.108:3306?useTimezone=true&server=UTC",
					"root", "H@rdline60");
			System.out.println("Connected!");
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("Cannot connect to DB");
			System.out.println(ex);
		}
	}

	public void closeConnection() {
		try {
			connection.close();
			JOptionPane.showMessageDialog(null, "Se ha finalizado la conexión con el servidor");
		} catch (SQLException ex) {
			Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void createDB(String name) {
		try {
			connect();
			String QueryDrop = "DROP DATABASE IF EXISTS" + name;
			String Query = "CREATE DATABASE " + name;
			Statement st = connection.createStatement();
			st.executeUpdate(QueryDrop);
			st.executeUpdate(Query);
			JOptionPane.showMessageDialog(null, "Se ha creado la base de datos " + name + " de forma exito");
			closeConnection();
		} catch (SQLException ex) {
			Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
