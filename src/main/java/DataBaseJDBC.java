import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseJDBC {
	
	public static Connection connect(String dbName) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:derby:"+dbName+";create=true");
		}  catch (Exception e) {
            e.printStackTrace();
        }
		
		return conn;
	}
	
	public void disconnect(Connection conn) {
		try {
			conn.close();
		}  catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public void initDB (String dbName) {
		try {
           Connection conn = DriverManager.getConnection("jdbc:derby:"+dbName+";create=true");
            String pers = "CREATE TABLE Personnel("
            		+ "Nom varchar(30),"
                    + "Prenom varchar(30),"
                    + "fonctions varchar(30),"
                    + "groupe int,"             
                    + "PRIMARY KEY(Nom)"
                    + ")";
           
            Statement stmt = conn.createStatement();

            try {
                stmt.execute(pers);
                System.out.println("table Carre created");
            } catch (SQLException e) {
                e.printStackTrace();
                }
   
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
