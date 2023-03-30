package ejercicio07;

import connectionUtils.DBConnect;

public class MainApp {

	public static void main(String[] args) {
		
		// ************************************************
		
		// *******  Ejercicio 07 - Los Científicos  *******
		
		// ************************************************

		DBConnect conn = new DBConnect();
		conn.connect(); // Creamos la conexion con el servidor SQL
		String db = "Cientificos";
		
		conn.createDB(db); // Creamos la base de datos para tienda
		
		// Creamos la Query para crear la tabla proyecto
		String proyecto = "CREATE TABLE proyecto ("
				+ "id CHAR(4),"
				+ "nombre NVARCHAR(255),"
				+ "horas INT,"
				+ "PRIMARY KEY (id)"
				+ ");";

		// Creamos la Query para crear la tabla cientificos
		String cientificos = "CREATE TABLE cientificos ("
				+ "DNI VARCHAR(8),"
				+ "nombre_apels NVARCHAR(255),"
				+ "PRIMARY KEY (DNI)"
				+ ");";
		
		// Creamos la Query para crear la tabla asignado_a
		String asignado_a = "CREATE TABLE asignado_a ("
				+ "cientifico VARCHAR(8),"
				+ "proyecto CHAR(4),"
				+ "FOREIGN KEY (cientifico) REFERENCES cientificos (DNI) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "FOREIGN KEY (proyecto) REFERENCES proyecto (id) ON DELETE CASCADE ON UPDATE CASCADE"
				+ ");";
		
		// Creamos la Query para insertamos datos en la tabla proyecto
		String insert_proyecto = "INSERT INTO proyecto (id, nombre, horas) VALUE "
				+ "(\"0001\", \"Proyecto 1\", 50),"
				+ "(\"0002\", \"Proyecto 2\", 30),"
				+ "(\"0003\", \"Proyecto 3\", 60),"
				+ "(\"0004\", \"Proyecto 4\", 80),"
				+ "(\"0005\", \"Proyecto 5\", 90);";
		
		// Creamos la Query para insertamos datos en la tabla cientificos
		String insert_cientificos = "INSERT INTO cientificos (DNI, nombre_apels) VALUE "
				+ "(\"12345678\", \"Jose Marin\"),"
				+ "(\"32165487\", \"Marc Rojo\"),"
				+ "(\"45678912\", \"Andrea Del Pezzo\"),"
				+ "(\"56123798\", \"Paul Stanescu\"),"
				+ "(\"98756432\", \"Cientifico 5\");";
		
		// Creamos la Query para insertamos datos en la tabla asignado_a
		String insert_asignado_a = "INSERT INTO asignado_a (cientifico, proyecto) VALUE "
				+ "(\"12345678\", \"0001\"),"
				+ "(\"32165487\", \"0002\"),"
				+ "(\"45678912\", \"0003\"),"
				+ "(\"56123798\", \"0004\"),"
				+ "(\"98756432\", \"0005\");";
		
		conn.createTable(db, proyecto); // Creamos la tabla de proyecto
		conn.createTable(db, cientificos); // Creamos la tabla de cientificos
		conn.createTable(db, asignado_a); // Creamos la tabla de asignado_a
		conn.insertData(db, insert_proyecto); // Insertamos valores en la tabla de proyecto
		conn.insertData(db, insert_cientificos); // Insertamos valores en la tabla de cientificos
		conn.insertData(db, insert_asignado_a); // Insertamos valores en la tabla de asignado_a
		conn.closeConnection(); // Cerramos conexión con el servidor SQL
		
	}

}
