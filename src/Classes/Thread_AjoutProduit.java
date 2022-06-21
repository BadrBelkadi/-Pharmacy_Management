package Classes;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.ArrayList;

import Interface_DAO.IProduit;

import java.sql.*;
public class Thread_AjoutProduit extends Thread implements IProduit{
	Socket s;
	Connection con;
	Thread_AjoutProduit(Socket s){
		this.s=s;
	}
	@Override
	public void run() {
		try {
		System.out.println("connected Ajout");
		InputStream isP;
		isP = s.getInputStream();
		ObjectInputStream oisP= new ObjectInputStream(isP);
		Produit produit=(Produit)oisP.readObject();
		this.Ajouter_P(produit);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void Ajouter_P(Produit P) {
		try {
			
			String reqP="INSERT INTO Produit VALUES (?,?,?,?,?,?)";
			con=(Connection)Connect.getCon();
			java.sql.PreparedStatement stmP=con.prepareStatement(reqP);
			stmP.setInt(1, P.getId_P());
			stmP.setString(2, P.getNom_P());
			stmP.setString(3, P.getExp_P());
			stmP.setDouble(4, P.getPrix());
			stmP.setInt(5, P.getQuantite_P());
			stmP.setString(6,P.getDosage());
			int a =stmP.executeUpdate();
			OutputStream osP=s.getOutputStream();
			if(a==1) {
				osP.write(1);
			}else {
				osP.write(0);
			}
		}catch(Exception e) {
			e.getMessage();
		}
		
	}
	@Override
	public void Modifier_P(int Id_P) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void Supprimer_P(int Id_P) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ArrayList<Produit> Afficher_P() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
