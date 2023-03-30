package ejercicio09;

import connectionUtils.DBConnect;

public class MainApp {

	public static void main(String[] args) {

		// ***********************************************
		
		// *****  Ejercicio 09 - Los investigadores  *****
		
		// ***********************************************

		DBConnect conn = new DBConnect();
		conn.connect(); // Creamos la conexion con el servidor SQL
		String db = "Investigadores";
		
		conn.createDB(db); // Creamos la base de datos para tienda
		
		// Creamos la Query para crear la tabla Facultad
		String Facultad = "CREATE TABLE Facultad("
				+ "Codigo INT AUTO_INCREMENT PRIMARY KEY,"
				+ "Nombre NVARCHAR(100));";

		// Creamos la Query para crear la tabla Investigadores
		String Investigadores = "CREATE TABLE Investigadores("
				+ "DNI VARCHAR(8) PRIMARY KEY,"
				+ "NomApels NVARCHAR(255),"
				+ "Facultad INT,"
				+ "FOREIGN KEY(facultad) REFERENCES Facultad(Codigo));";
		
		// Creamos la Query para crear la tabla Equipos
		String Equipos = "CREATE TABLE Equipos("
				+ "NumSerie CHAR(4) PRIMARY KEY,"
				+ "Nombre NVARCHAR(100),"
				+ "Facultad INT,"
				+ "FOREIGN KEY (Facultad) REFERENCES Facultad(Codigo));";
		
		// Creamos la Query para crear la tabla Reserva
		String Reserva = "CREATE TABLE Reserva("
				+ "DNI varchar(8),"
				+ "NumSerie char(4),"
				+ "Comienzo DATETIME,"
				+ "Fin DATETIME,"
				+ "primary key (DNI, NumSerie),"
				+ "FOREIGN KEY (DNI) REFERENCES Investigadores(DNI),"
				+ "FOREIGN KEY (NumSerie) REFERENCES Equipos(NumSerie));";
		
		// Creamos la Query para insertamos datos en la tabla Facultad
		String insert_Facultad = "INSERT INTO Facultad (Nombre) VALUE "
				+ "(\"Facultad 1\"),"
				+ "(\"Facultad 2\"),"
				+ "(\"Facultad 3\"),"
				+ "(\"Facultad 4\"),"
				+ "(\"Facultad 5\");";
		
		// Creamos la Query para insertamos datos en la tabla Investigadores
		String insert_Investigadores = "INSERT INTO Investigadores (DNI, NomApels, Facultad) VALUE "
				+ "(\"12345678\", \"Jose Marin\", 1),"
				+ "(\"32165487\", \"Marc Rojo\", 2),"
				+ "(\"45678912\", \"Andrea Del Pezzo\", 3),"
				+ "(\"56123798\", \"Paul Stanescu\", 4),"
				+ "(\"98756432\", \"Cientifico 5\", 5);";
		
		// Creamos la Query para insertamos datos en la tabla Equipos
		String insert_Equipos = "INSERT INTO Equipos (NumSerie, Nombre, Facultad) VALUE "
				+ "(\"0001\", \"Equipo 1\", 1),"
				+ "(\"0002\", \"Equipo 2\", 2),"
				+ "(\"0003\", \"Equipo 3\", 3),"
				+ "(\"0004\", \"Equipo 4\", 4),"
				+ "(\"0005\", \"Equipo 5\",5);";
		
		// Creamos la Query para insertamos datos en la tabla Reserva
		String insert_Reserva = "INSERT INTO Reserva (DNI, NumSerie, Comienzo, Fin) VALUE "
				+ "('12345678', '0001', '2023-04-01 09:00:00', '2023-04-01 12:00:00'),"
				+ "('32165487', '0002', '2023-04-01 14:00:00', '2023-04-01 18:00:00'),"
				+ "('45678912', '0003', '2023-04-02 10:00:00', '2023-04-02 13:00:00'),"
				+ "('56123798', '0004', '2023-04-03 11:00:00', '2023-04-03 14:00:00'),"
				+ "('98756432', '0005', '2023-04-04 09:00:00', '2023-04-04 12:00:00');";
		
		conn.createTable(db, Facultad); // Creamos la tabla de Facultad
		conn.createTable(db, Investigadores); // Creamos la tabla de Investigadores
		conn.createTable(db, Equipos); // Creamos la tabla de Equipos
		conn.createTable(db, Reserva); // Creamos la tabla de Reserva
		
		conn.insertData(db, insert_Facultad); // Insertamos valores en la tabla de Facultad
		conn.insertData(db, insert_Investigadores); // Insertamos valores en la tabla de Investigadores
		conn.insertData(db, insert_Equipos); // Insertamos valores en la tabla de Equipos
		conn.insertData(db, insert_Reserva); // Insertamos valores en la tabla de Reserva
		
		conn.closeConnection(); // Cerramos conexión con el servidor SQL
		
	}

}
