package Classes;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;

public class Thread_AnnuleVente extends Thread {
	Socket s;
	Connection con;
	public Thread_AnnuleVente(Socket s) {
		this.s=s;
	}
	@Override
	public void run() {
		try {
			System.out.println("connected Suppression de vente ");
			InputStream opsVS=s.getInputStream();
			int id_vs =opsVS.read();
			String reqVS="DELETE FROM Vente where id_V=?";
			con=(Connection)Connect.getCon();
			java.sql.PreparedStatement stmVS=con.prepareStatement(reqVS);
			stmVS.setInt(1,id_vs);
			stmVS.executeUpdate();
			OutputStream oVS=s.getOutputStream();
			oVS.write(1);
		}catch(Exception e) {
			e.getMessage();
		}
		}

}
