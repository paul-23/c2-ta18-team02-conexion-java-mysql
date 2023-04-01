package ejercicio06;

import connectionUtils.DBConnect;

public class MainApp {

	public static void main(String[] args) {
		
		// *************************************************
		
		// ***  Ejercicio 06 - Piezas y Proveedores  ***
		
		// *************************************************
		
		DBConnect conn = new DBConnect();
		conn.connect(); // Creamos la conexion con el servidor SQL
		String db = "PiezasProveedores";
		
		conn.createDB(db); // Creamos la base de datos
		
		// Creamos la Query para crear la tabla piezas
		String piezas = "CREATE TABLE Piezas (Codigo INT AUTO_INCREMENT PRIMARY KEY, Nombre NVARCHAR(100));";
		
		// Creamos la Query para crear la tabla proveedores
		String proveedores = "CREATE TABLE Proveedores ( Id CHAR(4) PRIMARY KEY, Nombre NVARCHAR(100));";
		
		// Creamos la Query para crear la tabla suministra
		String suministra = "CREATE TABLE Suministra ("
				+ "CodigoPieza INT,"
				+ "IdProveedor CHAR(4),"
				+ "Precio INT,"
				+ "PRIMARY KEY(CodigoPieza,IdProveedor),"
				+ "KEY(CodigoPieza),"
				+ "FOREIGN KEY (CodigoPieza) REFERENCES Piezas(Codigo)"
				+ "ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "FOREIGN KEY (IdProveedor) REFERENCES Proveedores(Id)"
				+ "ON DELETE CASCADE ON UPDATE CASCADE);";

		
		// Creamos la Query para insertamos datos en la tabla piezas
		String insert_piezas = "INSERT INTO Piezas (Nombre) VALUES"
				+ "('Pieza1'),"
				+ "('Pieza2'),"
				+ "('Pieza3'),"
				+ "('Pieza4'),"
				+ "('Pieza5'),"
				+ "('Pieza6'),"
				+ "('Pieza7'),"
				+ "('Pieza8'),"
				+ "('Pieza9'),"
				+ "('Pieza10');";
		
		// Creamos la Query para insertamos datos en la tabla proveedores
		String insert_proveedores = "INSERT INTO Proveedores (Id, Nombre) VALUES"
				+ "('0001', 'Proveedor 1'),"
				+ "('0002', 'Proveedor 2'),"
				+ "('0003', 'Proveedor 3'),"
				+ "('0004', 'Proveedor 4'),"
				+ "('0005', 'Proveedor 5'),"
				+ "('0006', 'Proveedor 6'),"
				+ "('0007', 'Proveedor 7'),"
				+ "('0008', 'Proveedor 8'),"
				+ "('0009', 'Proveedor 9'),"
				+ "('0010', 'Proveedor 10');";
		
		// Creamos la Query para insertamos datos en la tabla proveedores
		String insert_suministra = "INSERT INTO Suministra (CodigoPieza, IdProveedor, Precio) VALUES"
				+ "	(1, '0001', 100),"
				+ "	(2, '0002', 200),"
				+ "	(3, '0003', 150),"
				+ "	(4, '0004', 120),"
				+ "	(5, '0005', 300),"
				+ "	(6, '0006', 250),"
				+ "	(7, '0007', 180),"
				+ "	(8, '0008', 220),"
				+ "	(9, '0009', 90),"
				+ "	(10, '0010', 280);";
		
		conn.createTable(db, piezas); // Creamos la tabla piezas
		conn.createTable(db, proveedores); // Creamos la tabla proveedores
		conn.createTable(db, suministra); // Creamos la tabla suministra
		conn.insertData(db, insert_piezas); // Insertamos valores en la tabla de piezas
		conn.insertData(db, insert_proveedores); // Insertamos valores en la tabla de proveedores
		conn.insertData(db, insert_suministra); // Insertamos valores en la tabla de proveedores
		conn.closeConnection(); // Cerramos conexión con el servidor SQL
		
	}

}