package Interface_Graphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.border.MatteBorder;
import javax.swing.JDesktopPane;
import javax.swing.Box;

public class Accueil_IG extends JFrame implements ActionListener{

	private JPanel contentPane;
	JButton Espace_Produit = new JButton("Produits");
	JButton Espace_Vente = new JButton("Ventes");
	JButton Bon_Commande = new JButton("Bons de Commandes");
	JButton Sign_Out = new JButton("Sign Out");
	public static Accueil_IG frame = new Accueil_IG();




	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Accueil_IG frame = new Accueil_IG();
					 frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Accueil_IG() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Badreddine Belkadi\\Desktop\\phar.png"));
		setTitle("Gestion de Pharmacie");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(360, 100, 646, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(-3, -4, 639, 459);
		contentPane.add(panel);
		Espace_Produit.setFocusable(false);
		
		Espace_Produit.setBackground(Color.WHITE);
		Espace_Produit.setBounds(60, 214, 174, 71);
		panel.add(Espace_Produit);
		Espace_Vente.setFocusable(false);
		
		Espace_Vente.setBackground(Color.WHITE);
		Espace_Vente.setBounds(399, 213, 174, 71);
		panel.add(Espace_Vente);
		Bon_Commande.setFocusable(false);
		
		Bon_Commande.setBackground(Color.WHITE);
		Bon_Commande.setBounds(232, 320, 174, 71);
		panel.add(Bon_Commande);
		Sign_Out.setFocusable(false);
		
		Sign_Out.setBackground(Color.WHITE);
		Sign_Out.setBounds(534, 11, 89, 23);
		panel.add(Sign_Out);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Badreddine Belkadi\\Desktop\\logo.png"));
		lblNewLabel.setBounds(193, 27, 224, 152);
		panel.add(lblNewLabel);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(101, 158, -42, -51);
		panel.add(horizontalBox);

		Espace_Produit.addActionListener(this);
		Espace_Vente.addActionListener(this);
		Bon_Commande.addActionListener(this);
		Sign_Out.addActionListener(this);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Espace_Produit) {
//			Produit_IG produit=new Produit_IG();
			Produit_IG.frame.setVisible(true);
		}
		if(e.getSource()==Espace_Vente) {
//			Vente_IG vente=new Vente_IG();
			Vente_IG.frame.setVisible(true);
		}
		if(e.getSource()==Bon_Commande) {
			try {
				
				Desktop.getDesktop().open(new File("C:\\Users\\Badreddine Belkadi\\eclipse-workspace\\Gestion_Pharmacie"));

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==Sign_Out) {
			try {
				Accueil_IG.frame.setVisible(false);
				Vente_IG.frame.setVisible(false);
				Produit_IG.frame.setVisible(false);
				Login_IG.frame.setVisible(true);
				
				
			} catch (Exception e7) {
				e7.printStackTrace();
			}
			
		}
		
	}
}


