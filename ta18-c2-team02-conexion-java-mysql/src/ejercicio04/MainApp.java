package ejercicio04;

import connectionUtils.DBConnect;

public class MainApp {

	public static void main(String[] args) {
		DBConnect conn = new DBConnect();
		String db = "Cine";
		
		conn.createDB(db);
		
		String peliculas = "CREATE TABLE peliculas (codigo INT, nombre NVARCHAR(100), calificaciones_edad INT, "
				+ "PRIMARY KEY (codigo));";

		String salas = "CREATE TABLE salas (codigo INT, nombre NVARCHAR(100), pelicula INT, "
				+ "PRIMARY KEY (codigo), "
				+ "FOREIGN KEY (pelicula) REFERENCES peliculas (codigo) ON DELETE CASCADE ON UPDATE CASCADE);";
		
		String insertPeliculas = "INSERT INTO peliculas (codigo, nombre, calificaciones_edad) VALUE (1,'John Wick 4', 16), "
				+ "(2, 'DeadPool 3', 12), (3, 'As Bestas', 12), (4, 'El método Williams', 7), (5, 'Fast & Furious 10', 3);";
		
		String insertSalas = "INSERT INTO salas (codigo, nombre, pelicula) "
				+ "VALUE (1, 'Sala 1', 3), (2, 'Sala 2 Dolby Atmos', 2), (3, 'Sala 3, de 3D', 1), "
				+ "(4, 'Sala 4', 4), (5, 'Sala 5', 5);";
		
		conn.createTable(db, peliculas);
		conn.createTable(db, salas);
		conn.insertData(db, insertPeliculas);
		conn.insertData(db, insertSalas);
	}

}
