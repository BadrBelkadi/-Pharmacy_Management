package Interface_Graphique;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.ResultSetMetaData;

import java.sql.*;
import Classes.Connect;
import Classes.Produit;

import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class Produit_IG extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private JTextField Id_P;
	private JTextField Nom_P;
	private JTextField Date_P;
	private JTextField Prix;
	private JTextField Quantite_P;
	private JTextField Dosage;
	JButton Add = new JButton("Ajouter");
	JButton Update = new JButton("Modifier");
	JButton Delete = new JButton("Supprimer");
	private JTable table_1;
	public static Produit_IG frame = new Produit_IG();
	private Image logo=new ImageIcon(Produit_IG.class.getResource("/res/medical.png")).getImage().getScaledInstance(600,300,Image.SCALE_SMOOTH);
	private JLabel Logolbl;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
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
	public Produit_IG() {
		setResizable(false);
		setTitle("Liste des Produits");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Badreddine Belkadi\\Desktop\\phar.png"));
		setBounds(450, 100, 902, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 896, 584);
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setForeground(Color.BLACK);
		table.setColumnSelectionAllowed(true);
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Times New Roman", Font.BOLD, 11));
		table.setBorder(new LineBorder(Color.RED, 2, true));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Id Produit", "Nom Produit", "Date Exp", "Prix", "Quantit\u00E9", "Dosage"},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID Produit ", "Nom Produit", "Date Expiration ", "Prix", "Quantite", "Dosage"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		table.setBounds(336, 149, 539, 367);
		panel.add(table);
		
		JLabel lblNewLabel = new JLabel("Les Produits");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Nirmala UI", Font.PLAIN, 29));
		lblNewLabel.setBounds(26, 11, 296, 64);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID Produit");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(26, 150, 76, 26);
		panel.add(lblNewLabel_1);
		
		Id_P = new JTextField();
		Id_P.setBounds(136, 149, 158, 29);
		panel.add(Id_P);
		Id_P.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nom Produit");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setBounds(26, 211, 76, 26);
		panel.add(lblNewLabel_1_1);
		
		Nom_P = new JTextField();
		Nom_P.setColumns(10);
		Nom_P.setBounds(136, 210, 158, 29);
		panel.add(Nom_P);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Date Exp");
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setBounds(26, 275, 76, 26);
		panel.add(lblNewLabel_1_1_1);
		
		Date_P = new JTextField();
		Date_P.setColumns(10);
		Date_P.setBounds(136, 274, 158, 29);
		panel.add(Date_P);
		
		Prix = new JTextField();
		Prix.setColumns(10);
		Prix.setBounds(136, 336, 158, 29);
		panel.add(Prix);
		
		Quantite_P = new JTextField();
		Quantite_P.setColumns(10);
		Quantite_P.setBounds(136, 397, 158, 29);
		panel.add(Quantite_P);
		
		Dosage = new JTextField();
		Dosage.setColumns(10);
		Dosage.setBounds(136, 454, 158, 29);
		panel.add(Dosage);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Prix");
		lblNewLabel_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1.setBounds(26, 337, 76, 26);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Quantit\u00E9");
		lblNewLabel_1_1_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_2.setBounds(26, 398, 76, 26);
		panel.add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("Dosage");
		lblNewLabel_1_1_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_3.setBounds(26, 455, 76, 26);
		panel.add(lblNewLabel_1_1_1_3);
		Add.setForeground(SystemColor.desktop);
		
		
		Add.setBackground(Color.WHITE);
		Add.setBounds(355, 527, 109, 46);
		panel.add(Add);
		Update.setForeground(Color.BLACK);
		
		
		Update.setBackground(Color.WHITE);
		Update.setBounds(543, 527, 109, 46);
		panel.add(Update);
		Delete.setForeground(Color.BLACK);
		
		Delete.setBackground(Color.WHITE);
		Delete.setBounds(732, 527, 109, 46);
		panel.add(Delete);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		table_1.setRowSelectionAllowed(false);
		table_1.setForeground(Color.WHITE);
		table_1.setBackground(Color.RED);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID Produit", "Nom Produit", "Date Exp", "Prix", "Quantit\u00E9", "Dosage"},
			},
			new String[] {
				"ID Produit", "Nom Produit", "Date Exp", "Prix", "Quantit\u00E9", "Dosage"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_1.setBorder(new LineBorder(Color.RED, 2));
		table_1.setBounds(336, 132, 539, 16);
		panel.add(table_1);
		
		Logolbl = new JLabel("");
		Logolbl.setHorizontalAlignment(SwingConstants.RIGHT);
		Logolbl.setBounds(261, -18, 614, 155);
		Logolbl.setIcon(new ImageIcon(logo));
		panel.add(Logolbl);
		
		Add.addActionListener(this);
		Update.addActionListener(this);
		Delete.addActionListener(this);
		
		this.Table();
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
		
	}
	
	public void Table(){
        int a ;
        Connection con =(Connection) Connect.getCon();
        DefaultTableModel df = new DefaultTableModel();
        String req="SELECT * FROM Produit ORDER BY ID_P";

        try {
            PreparedStatement ps=(PreparedStatement) con.prepareStatement(req);
            ResultSet rs = ps.executeQuery(req);
            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            a = rsmd.getColumnCount();
            df = (DefaultTableModel)table.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v1 = new Vector();
                for (int i=1;i<=a;i++){
                    v1.add(rs.getString("Id_P"));
                    v1.add(rs.getString("Nom_P"));
                    v1.add(rs.getString("Exp_P"));
                    v1.add(rs.getString("Prix"));              
                    v1.add(rs.getString("Quantite_P"));
                    v1.add(rs.getString("Dosage"));
                    
                }
                df.addRow(v1);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Add) {
			try {
				int Id_pro=Integer.parseInt(Id_P.getText());
				String Nom_pro=Nom_P.getText();
				String Exp_pro=Date_P.getText();
				double Prix_pro=Integer.parseInt(Prix.getText());
				int Quantite_pro=Integer.parseInt(Quantite_P.getText());
				String Dosage_pro=Dosage.getText();
				Produit produit=new Produit();
				produit.setDosage(Dosage_pro);
				produit.setExp_P(Exp_pro);
				produit.setId_P(Id_pro);
				produit.setNom_P(Nom_pro);
				produit.setPrix(Prix_pro);
				produit.setQuatite_P(Quantite_pro);
				Socket s=new Socket("localhost",8000);
				OutputStream os=s.getOutputStream();
				ObjectOutputStream oos=new ObjectOutputStream(os);
				oos.writeObject(produit);
				InputStream is=s.getInputStream();
				if(is.read()==1) {
					this.Table();
				}else {
					JOptionPane.showMessageDialog(null, "Vérifier les champs remplis!");
				}
				
			}catch(Exception io) {
				io.printStackTrace();
			}
		}
		if(e.getSource()==Update) {
			int dialog=JOptionPane.YES_NO_OPTION;
			int option=JOptionPane.showConfirmDialog(null,"Are you sure?","Warning",dialog);
			if(option==0) {
				try {
					int Id_pro=Integer.parseInt(Id_P.getText());
					String Nom_pro=Nom_P.getText();
					String Exp_pro=Date_P.getText();
					double Prix_pro=Integer.parseInt(Prix.getText());
					int Quantite_pro=Integer.parseInt(Quantite_P.getText());
					String Dosage_pro=Dosage.getText();
					Produit produitU=new Produit();
					produitU.setDosage(Dosage_pro);
					produitU.setExp_P(Exp_pro);
					produitU.setId_P(Id_pro);
					produitU.setNom_P(Nom_pro);
					produitU.setPrix(Prix_pro);
					produitU.setQuatite_P(Quantite_pro);
					Socket sU=new Socket("localhost",8000);
					OutputStream os=sU.getOutputStream();
					ObjectOutputStream oos=new ObjectOutputStream(os);
					oos.writeObject(produitU);
					InputStream is=sU.getInputStream();
					if(is.read()==1) {
						this.Table();
					}else {
						JOptionPane.showMessageDialog(null, "Vérifier les champs remplis!");
					}
			}catch(Exception eU) {
				eU.getMessage();
			}
			}else  {
				Nom_P.setText("");
				Id_P.setText("");
				Date_P.setText("");
				Prix.setText("");
				Quantite_P.setText("");
				Dosage.setText("");
			}	
		}
		if(e.getSource()==Delete) {
			int dialog=JOptionPane.YES_NO_OPTION;
			
			int option=JOptionPane.showConfirmDialog(null,"Are you sure?","Warning",dialog);
			if(option==0) {
			
				try {
					int Id_pro=Integer.parseInt(Id_P.getText());
					String Nom_pro=Nom_P.getText();
					String Exp_pro=Date_P.getText();
					double Prix_pro=Integer.parseInt(Prix.getText());
					int Quantite_pro=Integer.parseInt(Quantite_P.getText());
					String Dosage_pro=Dosage.getText();
					Produit produitS=new Produit();
					produitS.setDosage(Dosage_pro);
					produitS.setExp_P(Exp_pro);
					produitS.setId_P(Id_pro);
					produitS.setNom_P(Nom_pro);
					produitS.setPrix(Prix_pro);
					produitS.setQuatite_P(Quantite_pro);
					Socket sD=new Socket("localhost",8000);
					OutputStream os=sD.getOutputStream();
					ObjectOutputStream oos=new ObjectOutputStream(os);
					oos.writeObject(produitS);
					InputStream is=sD.getInputStream();
					if(is.read()==1) {
						this.Table();
					}
	
				}catch(Exception ex) {
					ex.getMessage();
				}
			}else  {
				Nom_P.setText("");
				Id_P.setText("");
				Date_P.setText("");
				Prix.setText("");
				Quantite_P.setText("");
				Dosage.setText("");
			}
		}
	}
}
