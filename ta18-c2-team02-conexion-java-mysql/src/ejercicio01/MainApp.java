package ejercicio01;


public class MainApp {

	public static void main(String[] args) {
		Tienda tiendaInformatica = new Tienda();
		tiendaInformatica.createDatabase();
		String fabricantes = "CREATE TABLE Fabricantes"
		        + "(codigo INT PRIMARY KEY AUTO_INCREMENT, Nombre VARCHAR(50)";
		
		String articulos = "CREATE TABLE articulos ("
				+ "	codigo INT NOT NULL,"
				+ "nombre NVARCHAR(100),"
				+ "precio INT,"
				+ "fabricante INT,"
				+ "codigo_fabricantes INT NOT NULL,"
				+ "PRIMARY KEY (codigo),"
				+ "FOREIGN KEY (codigo_fabricantes)"
				+ "REFERENCES fabricantes (codigo)"
				+ "ON DELETE CASCADE"
				+ "ON UPDATE CASCADE"
				+ ")";
		
		tiendaInformatica.createTable(fabricantes);
		tiendaInformatica.createTable(articulos);
		
	}

}
