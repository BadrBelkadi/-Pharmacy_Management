package Classes;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import java.sql.Connection;

public class Connect {
	private static Connection con;
	static {
		try {
			/*************Oracle DB*********************/
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system","0000");
//		    System.out.println("Working oracle");
			
			/************MYSQL DB***********************/
			Class.forName("com.mysql.jdbc.Driver");		
			con=DriverManager.getConnection("jdbc:mysql://localhost/GestionPharmacie","root","");
			System.out.println("Working mysql");
			
		}catch(ClassNotFoundException e) {
			System.out.println("Probl�me au niveau du pilote");
			
		}
		catch(SQLException e) {
			System.out.println("Probl�me au niveau de base au acc�s au donn�es");
		}
	}
	
	public static Connection getCon() {
		return con;
	}

}
