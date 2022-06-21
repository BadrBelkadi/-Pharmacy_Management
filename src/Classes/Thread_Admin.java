package Classes;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.ResultSet;

import Interface_DAO.IProduit;

import java.sql.*;

public class Thread_Admin extends Thread{
	Socket s;
	Connection con;
	Thread_Admin(Socket s){
		this.s=s;
	}
	@Override
	public void run() {
		
		try {
			System.out.println("connected Authentification");
			InputStream isA=s.getInputStream();
			ObjectInputStream oisA= new ObjectInputStream(isA);
			Admin admin=(Admin)oisA.readObject();
			con=(Connection)Connect.getCon();
			OutputStream osA=s.getOutputStream();
			
			
			String reqA="SELECT * FROM ADMIN WHERE USERNAME=? AND PASSWORD=?";
			PreparedStatement stmA=con.prepareStatement(reqA);
			stmA.setString(1, admin.getUserName());
			stmA.setString(2, admin.getPassword_A());
			ResultSet rs=stmA.executeQuery();
			
			
			if(rs.next()) {
				osA.write(1);
			}else{ 
				osA.write(0);
				}
			}catch(Exception e) {
				e.getMessage();
			}
	}
}
