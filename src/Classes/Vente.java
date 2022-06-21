package Classes;

import java.sql.Date;
import java.io.Serializable;
import java.sql.Date;


public class Vente implements Serializable {
	private int Id_V;
	private String Nom_P;
	private int Quantite_V;
	private int Id_P;
	private double Total_V;
	private Date Date_V ;
	
	/***Getters and Setters ******/
	
	public int getId_V() {
		return Id_V;
	}
	public void setId_V(int id_V) {
		Id_V = id_V;
	}
	public String getNom_P() {
		return Nom_P;
	}
	public void setNom_P(String nom_P) {
		Nom_P = nom_P;
	}
	public int getQuantite() {
		return Quantite_V;
	}
	public void setQuantite(int quantite_V) {
		Quantite_V = quantite_V;
	}
	public int getId_P() {
		return Id_P;
	}
	public void setId_P(int id_P) {
		Id_P = id_P;
	}
	public double getTotal_V() {
		return Total_V;
	}
	public void setTotal_V(double total_V) {
		Total_V = total_V;
	}
	public Date getDate_V() {
		return Date_V;
	}
	public void setDate_V(Date date_V) {
		Date_V = date_V;
	}
	
	
	
	
}
