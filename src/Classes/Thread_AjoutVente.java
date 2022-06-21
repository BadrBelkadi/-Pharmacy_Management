package Classes;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;

public class Thread_AjoutVente extends Thread {
	Socket s;
	Connection con;
	public Thread_AjoutVente(Socket s) {
		this.s=s;
	}
	@Override
	public void run() {
		try {
			System.out.println("connected Ajout de vente ");
			InputStream isVA=s.getInputStream();
			ObjectInputStream oisV=new ObjectInputStream(isVA);
			Vente venteA=(Vente)oisV.readObject();
			con=Connect.getCon();
			
			String reqVA="INSERT INTO Vente (Id_V,Nom_P,Quantite_V,Id_P,Total_V) VALUES(?,?,?,?,?)";
			java.sql.PreparedStatement stmVA=con.prepareStatement(reqVA);
			stmVA.setInt(1, venteA.getId_V());
			stmVA.setString(2,venteA.getNom_P());
			stmVA.setInt(3, venteA.getQuantite());
			stmVA.setInt(4, venteA.getId_P());
			stmVA.setDouble(5,venteA.getTotal_V());
			stmVA.executeUpdate();
			OutputStream osVA=s.getOutputStream();
			osVA.write(1);
			String reqB="SELECT * FROM Vente where Id_V=?";
			PreparedStatement stmB=con.prepareStatement(reqB);
			stmB.setInt(1, venteA.getId_V());
			ResultSet resB=stmB.executeQuery();
			while(resB.next()) {
				String nomF=resB.getInt("Id_V")+"_"+resB.getString("Nom_P")+"_"+resB.getDate("Date_V")+".txt";
				DataOutputStream f=new DataOutputStream(new FileOutputStream(nomF));
				f.writeChars("Reférence :       "+resB.getInt("Id_V")+"\n");
				f.writeChars("Nom du Produit :    "+resB.getString("Nom_P")+"\n");
				f.writeChars("Total à payer :    "+resB.getDouble("Total_V")+" DH"+"\n");
				
			}
		}catch(Exception e) {
			e.getMessage();
		}
}
}
