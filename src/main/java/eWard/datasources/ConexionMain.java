package eWard.datasources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConexionMain {
	
	public static void main(String[] args) throws SQLException{
		
		conecta();
		
	}
	
	static void conecta() throws SQLException {
		
		Connection con = null;
		String sURL = "jdbc:mariadb://localhost:3306/eward";
		
		try {
			
			log.debug(sURL);
			con = DriverManager.getConnection(sURL, "root", "root");
			
			try (PreparedStatement stmt = con.prepareStatement("SELECT nombre FROM alumno")){
				
				ResultSet rs = stmt.executeQuery();
				
				while (rs.next())
					System.out.println (rs.getString("nombre"));
			} catch (SQLException sqle) { 
				System.out.println("Error en la ejecución:" 
				+ sqle.getErrorCode() + " " + sqle.getMessage());    
			}
				
			
			
		}catch(SQLException sqle) {
			
			sqle.getMessage();
			
		}finally{
			
			if(con!=null) {
				
				con.close();
				
			}
			
		}
	}

}
