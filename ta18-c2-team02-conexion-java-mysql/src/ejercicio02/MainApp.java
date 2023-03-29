package ejercicio02;

import connectionUtils.DBConnect;

public class MainApp {

	public static void main(String[] args) {
		DBConnect conn = new DBConnect();
		String db = "Empleados";
		
		conn.createDB(db);
		
		String departamentos = "CREATE TABLE Departamentos(Codigo INT, Nombre NVARCHAR(100),"
				+ "Presupuesto INT, PRIMARY KEY (Codigo));";

		String empleados = "CREATE TABLE Empleados (dni VARCHAR(8),"
				+ "Nombre NVARCHAR(100),"
				+ "Apellidos NVARCHAR(255),"
				+ "Departamento INT,"
				+ "FOREIGN KEY (Departamento) REFERENCES Departamentos (Codigo) ON DELETE CASCADE ON UPDATE CASCADE);";
		
		String insertDepartamentos = "INSERT INTO Departamentos (Codigo, Nombre, Presupuesto) VALUE (1,'Ventas',12500), "
				+ "(2, 'Marketing', 5300), (3, 'Compras', 20000), (4, 'Sistemas', 7000), (5, 'RRHH', 1000);";
		
		String insertEmpleados = "INSERT INTO Empleados (dni, Nombre, Apellidos, Departamento) "
				+ "VALUE ('39000001', 'Paul', 'Stanescu', 2), ('39100001', 'Andrea', 'Dal Pezzo', 1), "
				+ "('27123321', 'Jose', 'Marin', 5), ('01001101', 'Josep Maria', 'Elde Sistemas', 4), "
				+ "('39123456', 'Marc', 'Rojo', 3)";
		
		conn.createTable(db, departamentos);
		conn.createTable(db, empleados);
		conn.insertData(db, insertDepartamentos);
		conn.insertData(db, insertEmpleados);
	}

}
