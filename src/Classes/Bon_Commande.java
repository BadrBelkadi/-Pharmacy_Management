package Classes;
import java.io.Serializable;
import java.sql.Date;

public class Bon_Commande implements Serializable {
	private int Id_B;
	private Date Date_B;
	private String Nom_B;
	
	/***Getters and Setters ******/

	
	public int getId_B() {
		return Id_B;
	}
	public void setId_B(int id_B) {
		Id_B = id_B;
	}
	public Date getDate_B() {
		return Date_B;
	}
	public void setDate_B(Date date_B) {
		Date_B = date_B;
	}
	public String getNom_B() {
		return Nom_B;
	}
	public void setNom_B(String nom_B) {
		Nom_B = nom_B;
	}

}
