package Classes;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;

public class Thread_ModificationProduit extends Thread {
	Socket s;
	Connection con;
	public Thread_ModificationProduit(Socket s) {
		this.s=s;
	}
	@Override
	public void run() {
		try {
			System.out.println("connected modification produit");
			InputStream isPU=s.getInputStream();
			ObjectInputStream oisPU= new ObjectInputStream(isPU);
			Produit produitU=(Produit)oisPU.readObject();
			
			String reqPU="UPDATE Produit SET Nom_P=?,Exp_P=?,Prix=?,Quantite_P=?,Dosage=? WHERE Id_P=?";
			con=(Connection)Connect.getCon();
			java.sql.PreparedStatement stmPU=con.prepareStatement(reqPU);
			stmPU.setString(1, produitU.getNom_P());
			stmPU.setString(2, produitU.getExp_P());
			stmPU.setDouble(3, produitU.getPrix());
			stmPU.setInt(4, produitU.getQuantite_P());
			stmPU.setString(5,produitU.getDosage());
			stmPU.setInt(6, produitU.getId_P());
			stmPU.executeUpdate();
			int u =stmPU.executeUpdate();
			OutputStream osPU=s.getOutputStream();
			if(u==1) {
				osPU.write(1);
			}else {
				osPU.write(0);
			}
			
		}catch(Exception e) {
			e.getMessage();
		}
	}

}
