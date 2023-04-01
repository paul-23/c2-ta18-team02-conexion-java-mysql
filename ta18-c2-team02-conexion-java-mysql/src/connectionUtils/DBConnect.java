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
			connection = DriverManager.getConnection("jdbc:mysql://localhost?useTimezone=true&server=UTC", "root",
					"root");
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
		System.out.println("-------------------------------------------------------------\n"
				+ "Nos intentamos conectar a las base de datos: " + name
				+ "\n-------------------------------------------------------------");
		try {
			String QueryDrop = "DROP DATABASE IF EXISTS " + name + ";";
			String Query = "CREATE DATABASE " + name + ";";
			Statement st = connection.createStatement();
			st.executeUpdate(QueryDrop);
			st.executeUpdate(Query);
			JOptionPane.showMessageDialog(null, "Se ha creado la base de datos " + name + " de forma exito");
		} catch (SQLException ex) {
			Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void createTable(String db, String query) {
		System.out.println("-------------------------------------------------------------\n"
				+ "Intentamos crear la tabla"
				+ "\n-------------------------------------------------------------");
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = getConnection().createStatement();
			stdb.executeUpdate(Querydb);
			stdb.executeUpdate(query);
			System.out.println("Tabla creada con exito!");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la tabla.");
		}
	}

	// METODO QUE INSERTA DATOS EN TABLAS MYSQL
	public void insertData(String db, String Query) {
		System.out.println("-------------------------------------------------------------\n"
				+ "Intentamos insertar datos en la tabla"
				+ "\n-------------------------------------------------------------");
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = getConnection().createStatement();
			stdb.executeUpdate(Querydb);
			stdb.executeUpdate(Query);
			System.out.println("Datos almacenados correctamente");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el aleacenamiento");
		}
	}
}
