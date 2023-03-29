package ejercicio01;

import connectionUtils.DBConnect;

public class MainApp {

	public static void main(String[] args) {
		DBConnect conn = new DBConnect();
		String db = "Tienda";
		
		
		conn.createDB(db);
		
		String fabricantes = "CREATE TABLE fabricantes (codigo INT PRIMARY KEY AUTO_INCREMENT, Nombre VARCHAR(50));";

		String articulos = "CREATE TABLE articulos ("
				+ "codigo INT NOT NULL,"
				+ "nombre NVARCHAR(100),"
				+ "precio INT,"
				+ "fabricante INT,"
				+ "codigo_fabricantes INT NOT NULL,"
				+ "PRIMARY KEY (codigo),"
				+ "FOREIGN KEY (codigo_fabricantes)"
				+ " REFERENCES fabricantes (codigo)"
				+ " ON DELETE CASCADE "
				+ "ON UPDATE CASCADE" + ");";
		
		String insert_fabricantes = "INSERT INTO fabricantes (Nombre) VALUE (\"Fabricante 1\"), (\"Fabricante 2\"), (\"Fabricante 3\"), (\"Fabricante 4\"), (\"Fabricante 5\");";
		
		String insert_articulos = "";
		
		conn.createTable(db, fabricantes); // Creamos la tabla de fabricantes
		conn.createTable(db, articulos); // Creamos la tabla de articulos
		conn.insertData(db, insert_fabricantes); // Insertamos valores en la tabla de fabricantes

	}

}
