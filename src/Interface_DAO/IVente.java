package Interface_DAO;

import java.util.ArrayList;

import Classes.Vente;


public interface IVente {
	public void Ajouter_V(Vente V);
	public void Modifier_V(int Id_V);
	public void Supprimer_V(int Id_V);
	public ArrayList<Vente> Afficher_V();
}
