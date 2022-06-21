package Classes;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.ArrayList;

import Interface_DAO.*;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
import java.sql.*;

public class Server{
	public static void main(String[] args) {
		Connection con;
		Socket serviceA=null;
		Socket serviceP=null;
		Socket servicePU=null;
		Socket servicePS=null;
		Socket serviceVA=null;
		Socket serviceVS=null;

		try {
			ServerSocket server=new ServerSocket(8000);
			while(true) {

				/************************************Login************************************************************/
				serviceA=server.accept();
				Thread_Admin admin=new Thread_Admin(serviceA);
				admin.start();
				admin.join();
				/************************************Ajout Produit************************************************************/
				serviceP=server.accept();
				Thread_AjoutProduit ajoutproduit=new Thread_AjoutProduit(serviceP);
				ajoutproduit.start();
				ajoutproduit.join();
				/************************************Modification Produit************************************************************/
				servicePU=server.accept();
				Thread_ModificationProduit modificationproduit=new Thread_ModificationProduit(servicePU);				
				modificationproduit.start();
				modificationproduit.join();
				/************************************Suppression Produit************************************************************/
				servicePS=server.accept();
				Thread_SuppressionProduit suppressionproduit=new Thread_SuppressionProduit(servicePS);
				suppressionproduit.start();
				suppressionproduit.join();
				/************************************Ajout Vente************************************************************/
				serviceVA=server.accept();
				Thread_AjoutVente ajoutvente=new Thread_AjoutVente(serviceVA);
				ajoutvente.start();
				ajoutvente.join();
				/************************************Annulation Vente************************************************************/
				serviceVS =server.accept();
				Thread_AnnuleVente annulevente=new Thread_AnnuleVente(serviceVS);
				annulevente.start();
				annulevente.join();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
