package Interface_DAO;

import java.util.ArrayList;

import Classes.Produit;

public interface IProduit {
	public void Ajouter_P(Produit P);
	public void Modifier_P(int Id_P);
	public void Supprimer_P(int Id_P);
	public ArrayList<Produit> Afficher_P();
}
