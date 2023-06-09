package ejercicio01;

import connectionUtils.DBConnect;

public class MainApp {

	public static void main(String[] args) {
		
		// *************************************************
		
		// ***  Ejercicio 01 - La Tienda de Informática  ***
		
		// *************************************************
		
		DBConnect conn = new DBConnect();
		conn.connect(); // Creamos la conexion con el servidor SQL
		String db = "Tienda";
		
		conn.createDB(db); // Creamos la base de datos para tienda
		
		// Creamos la Query para crear la tabla fabricantes
		String fabricantes = "CREATE TABLE fabricantes (codigo INT PRIMARY KEY AUTO_INCREMENT, Nombre VARCHAR(50));";

		// Creamos la Query para crear la tabla articulos
		String articulos = "CREATE TABLE articulos ("
				+ "codigo INT NOT NULL,"
				+ "nombre NVARCHAR(100),"
				+ "precio INT,"
				+ "codigo_fabricantes INT NOT NULL,"
				+ "PRIMARY KEY (codigo),"
				+ "FOREIGN KEY (codigo_fabricantes)"
				+ " REFERENCES fabricantes (codigo)"
				+ " ON DELETE CASCADE "
				+ "ON UPDATE CASCADE" + ");";
		
		// Creamos la Query para insertamos datos en la tabla fabricantes
		String insert_fabricantes = "INSERT INTO fabricantes (Nombre) VALUE (\"Fabricante 1\"), (\"Fabricante 2\"), (\"Fabricante 3\"), (\"Fabricante 4\"), (\"Fabricante 5\");";
		
		// Creamos la Query para insertamos datos en la tabla articulos
		String insert_articulos = "INSERT INTO articulos (codigo, nombre, precio, codigo_fabricantes) VALUES "
				+ "(1, \"Articulo 1\", 35, 1),"
				+ "(2, \"Articulo 2\", 10, 2),"
				+ "(3, \"Articulo 3\", 19, 3),"
				+ "(4, \"Articulo 4\", 12, 4),"
				+ "(5, \"Articulo 5\", 30, 5);";
		
		conn.createTable(db, fabricantes); // Creamos la tabla de fabricantes
		conn.createTable(db, articulos); // Creamos la tabla de articulos
		conn.insertData(db, insert_fabricantes); // Insertamos valores en la tabla de fabricantes
		conn.insertData(db, insert_articulos); // Insertamos valores en la tabla de articulos
		conn.closeConnection(); // Cerramos conexión con el servidor SQL
		
	}

}
