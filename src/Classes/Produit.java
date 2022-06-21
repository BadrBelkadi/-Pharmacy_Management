package Classes;
import java.io.Serializable;
import java.sql.Date;


public class Produit implements Serializable{
	
	private int Id_P;
	private String Nom_P;
	private String Exp_P;
	private double Prix;
	private int Quantite_P;
	private String Dosage;
	
	/***Getters and Setters ******/

	
	public int getId_P() {
		return Id_P;
	}
	public void setId_P(int id_P) {
		Id_P = id_P;
	}
	public String getNom_P() {
		return Nom_P;
	}
	public void setNom_P(String nom_P) {
		Nom_P = nom_P;
	}
	public String getExp_P() {
		return Exp_P;
	}
	public void setExp_P(String exp_P) {
		Exp_P = exp_P;
	}
	public double getPrix() {
		return Prix;
	}
	public void setPrix(double prix) {
		Prix = prix;
	}
	public int getQuantite_P() {
		return Quantite_P;
	}
	public void setQuatite_P(int quantite_P) {
		Quantite_P = quantite_P;
	}
	public String getDosage() {
		return Dosage;
	}
	public void setDosage(String dosage) {
		Dosage = dosage;
	}


}
