package ejercicio05;

import connectionUtils.DBConnect;

public class MainApp {

	public static void main(String[] args) {
		
		// *************************************************
		
		// ***  Ejercicio 05 - Los Directores  ***
		
		// *************************************************
		
		DBConnect conn = new DBConnect();
		conn.connect(); // Creamos la conexion con el servidor SQL
		String db = "Directores";
		
		conn.createDB(db); // Creamos la base de datos
		
		// Creamos la Query para crear la tabla despachos
		String despachos = "CREATE TABLE Despachos (Numero INT, Capacidad INT PRIMARY KEY (Numero));";

		// Creamos la Query para crear la tabla directores
		String directores = "CREATE TABLE Directores("
				+ "DNI VARCHAR(8)"
				+ "NomApels NVARCHAR(255)"
				+ "DNIJefe VARCHAR(8)"
				+ "Despacho INT"
				+ "PRIMARY KEY (DNI)"
				+ "FOREIGN KEY (Despacho) REFERENCES Despachos (Numero) ON DELETE CASCADE ON UPDATE CASCADE"
				+ "FOREIGN KEY (DNIJefe) REFERENCES Directores (DNI) ON DELETE CASCADE ON UPDATE CASCADE));";
		
		// Creamos la Query para insertamos datos en la tabla despachos
		String insert_despachos = "INSERT INTO Despachos (Numero, Capacidad) VALUES"
				+ "	(1, 4), (2, 6), (3, 5), (4, 7), (5, 3), (6, 5), (7, 4), (8, 6), (9, 5), (10, 7);";
		
		// Creamos la Query para insertamos datos en la tabla directores
		String insert_directores = "INSERT INTO Directores (DNI, NomApels, DNIJefe, Despacho) VALUES"
				+ "	('12345678', 'Pérez García, Ana', NULL, 1),"
				+ "	('23456789', 'González Martín, Juan', '12345678', 2),"
				+ "	('34567890', 'Fernández López, Carmen', '12345678', 3),"
				+ "	('45678901', 'Martínez Sánchez, Luis', '23456789', 4),"
				+ "	('56789012', 'García Fernández, María', NULL, 5),"
				+ "	('67890123', 'Sánchez Pérez, Pedro', '34567890', 6),"
				+ "	('78901234', 'López Martínez, Isabel', '34567890', 7),"
				+ "	('89012345', 'Rodríguez García, David', NULL, 8),"
				+ "	('90123456', 'Pérez Martínez, Laura', '45678901', 9),"
				+ "	('01234567', 'González Fernández, Javier', '56789012', 10);";
		
		conn.createTable(db, despachos); // Creamos la tabla de despachos
		conn.createTable(db, directores); // Creamos la tabla de directores
		conn.insertData(db, insert_despachos); // Insertamos valores en la tabla despachos
		conn.insertData(db, insert_directores); // Insertamos valores en la tabla de directores
		conn.closeConnection(); // Cerramos conexión con el servidor SQL
	}
}