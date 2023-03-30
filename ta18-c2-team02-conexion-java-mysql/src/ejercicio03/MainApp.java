/**
 * 
 */
package ejercicio03;

import connectionUtils.DBConnect;

public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// ************************************************
		
		// ********  Ejercicio 03 - Los Almacenes  ********
		
		// ************************************************
		
		DBConnect conn = new DBConnect();
		conn.connect(); // Creamos la conexion con el servidor SQL
		String db = "Almacenes";
		
		conn.createDB(db); // Creamos la base de datos para tienda
		
		// Creamos la Query para crear la tabla almacenes
		String almacenes = "CREATE TABLE almacenes("
				+ "Codigo INT AUTO_INCREMENT PRIMARY KEY,"
				+ "Lugar NVARCHAR(100),"
				+ "Capacidad INT);";

		// Creamos la Query para crear la tabla cajas
		String cajas = "CREATE TABLE cajas("
				+ "NumReferencia CHAR(5) PRIMARY KEY,"
				+ "Contenido NVARCHAR(100),"
				+ "Valor INT,"
				+ "Almacen INT,"
				+ "FOREIGN KEY (Almacen) REFERENCES almacenes(Codigo)"
				+ "ON DELETE CASCADE ON UPDATE CASCADE);";
		
		// Creamos la Query para insertamos datos en la tabla fabricantes
		String insert_almacenes = "INSERT INTO almacenes (Lugar, Capacidad) VALUE (\"Almacen 1\", 200), (\"Almacen 2\", 150), (\"Almacen 3\", 350), (\"Almacen 4\", 100), (\"Almacen 5\", 500);";
		
		// Creamos la Query para insertamos datos en la tabla articulos
		String insert_cajas = "INSERT INTO cajas (NumReferencia, Contenido, Valor, Almacen) VALUE "
				+ "(\"00001\", \"Contenido Caja 1\", 100, 1),"
				+ "(\"00002\", \"Contenido Caja 2\", 150, 2),"
				+ "(\"00003\", \"Contenido Caja 3\", 190, 3),"
				+ "(\"00004\", \"Contenido Caja 4\", 200, 4),"
				+ "(\"00005\", \"Contenido Caja 5\", 300, 5);";
		
		conn.createTable(db, almacenes); // Creamos la tabla de almacenes
		conn.createTable(db, cajas); // Creamos la tabla de cajas
		conn.insertData(db, insert_almacenes); // Insertamos valores en la tabla de almacenes
		conn.insertData(db, insert_cajas); // Insertamos valores en la tabla de cajas
		conn.closeConnection(); // Cerramos conexión con el servidor SQL
	}

}
