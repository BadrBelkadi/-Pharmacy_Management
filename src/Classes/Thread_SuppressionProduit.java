package Classes;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;

public class Thread_SuppressionProduit extends Thread {
	Socket s;
	Connection con;
	public Thread_SuppressionProduit(Socket s) {
		this.s=s;
	}
	@Override
	public void run() {
		try {
			System.out.println("connected Suppression");
			InputStream isPS=s.getInputStream();
			ObjectInputStream oisPS=new ObjectInputStream(isPS);
			Produit produitS=(Produit)oisPS.readObject();
			
			String reqS="DELETE FROM produit where id_P=?";
			con=(Connection)Connect.getCon();
			java.sql.PreparedStatement stmPS=con.prepareStatement(reqS);
			stmPS.setInt(1, produitS.getId_P());
			stmPS.executeUpdate();
			OutputStream osPS=s.getOutputStream();
			osPS.write(1);
		}catch(Exception e) {
			e.getMessage();
		}

	}
}
