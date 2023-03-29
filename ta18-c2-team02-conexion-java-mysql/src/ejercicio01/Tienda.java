/**
 * 
 */
package ejercicio01;
import java.sql.SQLException;
import java.sql.Statement;

import connectionUtils.DBConnect;

/**
 * @author team02 (Andrea, Marc Rojo y Paul)
 *
 */
public class Tienda {
	private DBConnect conn = new DBConnect();
	private String db;
	
	public void createDatabase() {
		db = "Tienda";
		conn.createDB(db);
	}
	
	public void createTable(String query) {
		
	    try {
	        String Querydb = "USE " + db + ";";
	        Statement stdb = conn.getConnection().createStatement();
	        stdb.executeUpdate(Querydb);

	        
	        Statement st= conn.getConnection().createStatement();
	        st.executeUpdate(query);
	        System.out.println("Tabla creada con exito!");
	    } catch (SQLException ex){
	        System.out.println(ex.getMessage());
	        System.out.println("Error crando tabla.");
	    }
	}
}
