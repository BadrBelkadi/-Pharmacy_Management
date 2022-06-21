package Interface_Graphique;

import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.ResultSetMetaData;
import java.sql.*;

import Classes.Connect;
import Classes.Vente;

import javax.swing.border.LineBorder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Vente_IG extends JFrame implements ActionListener{
	
	public Connection con;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblLesVentes;
	private JLabel lblNewLabel;
	private JTextField Id_V;
	private JTextField Nom_P;
	private JTextField Quantite_V;
	private JLabel lblNomProduit;
	private JLabel lblQuantit;
	private JButton Add;
	private JButton btnAnnuler;
	private JTextField DeleteR;
	private JLabel Total_V;
	public static Vente_IG frame = new Vente_IG();
	private JTable table_1;
	private Image logo=new ImageIcon(Vente_IG.class.getResource("/res/medical.png")).getImage().getScaledInstance(600,300,Image.SCALE_SMOOTH);


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
	public Vente_IG() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Badreddine Belkadi\\Desktop\\phar.png"));
		setTitle("Les Ventes");
		setBounds(450, 100, 899, 636);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(-2, 1, 884, 601);
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setForeground(Color.BLACK);
		table.setFont(new Font("Times New Roman", Font.BOLD, 11));
		table.setBackground(Color.WHITE);
		table.setColumnSelectionAllowed(true);
		table.setBorder(new LineBorder(Color.RED, 2));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Ref\u00E9rence Vente", "Nom Produit", "Quantit\u00E9", "Produit", "Prix Total", "Date Vente"},
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
				"Ref\u00E9rence Vente", "Nom Produit", "Quantit\u00E9", "Produit", "Prix Total", "Date Vente"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(125);
		table.setBounds(318, 157, 556, 434);
		panel.add(table);
		
		lblLesVentes = new JLabel("Les Ventes");
		lblLesVentes.setForeground(Color.BLACK);
		lblLesVentes.setBackground(new Color(0, 128, 128));
		lblLesVentes.setFont(new Font("Nirmala UI", Font.PLAIN, 29));
		lblLesVentes.setBounds(18, 11, 267, 95);
		panel.add(lblLesVentes);
		
		lblNewLabel = new JLabel("Ref\u00E9rence");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(18, 152, 97, 26);
		panel.add(lblNewLabel);
		
		Id_V = new JTextField();
		Id_V.setColumns(10);
		Id_V.setBounds(115, 150, 158, 29);
		panel.add(Id_V);
		
		Nom_P = new JTextField();
		Nom_P.setColumns(10);
		Nom_P.setBounds(115, 202, 158, 29);
		panel.add(Nom_P);
		
		Quantite_V = new JTextField();
		Quantite_V.setColumns(10);
		Quantite_V.setBounds(115, 262, 158, 29);
		panel.add(Quantite_V);
		
		lblNomProduit = new JLabel("Nom Produit");
		lblNomProduit.setForeground(Color.BLACK);
		lblNomProduit.setBounds(18, 201, 94, 26);
		panel.add(lblNomProduit);
		
		lblQuantit = new JLabel("Quantit\u00E9");
		lblQuantit.setForeground(Color.BLACK);
		lblQuantit.setBounds(18, 256, 94, 26);
		panel.add(lblQuantit);
		
		Add = new JButton("Ajouter");
		Add.setBackground(Color.WHITE);
		Add.setBounds(115, 352, 97, 35);
		panel.add(Add);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBackground(Color.WHITE);
		btnAnnuler.setBounds(116, 514, 94, 35);
		panel.add(btnAnnuler);
		
		DeleteR = new JTextField();
		DeleteR.setColumns(10);
		DeleteR.setBounds(115, 457, 158, 29);
		panel.add(DeleteR);
		
		JLabel lblNewLabel_1 = new JLabel("Ref\u00E9rence");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(18, 458, 97, 26);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Veuillez Entrez la ref\u00E9rence pour annuler une vente");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(18, 403, 290, 26);
		panel.add(lblNewLabel_2);
		
		Total_V = new JLabel("");
		Total_V.setFont(new Font("Tahoma", Font.BOLD, 17));
		Total_V.setForeground(Color.GREEN);
		Total_V.setBackground(Color.WHITE);
		Total_V.setBounds(30, 312, 255, 29);
		panel.add(Total_V);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		table_1.setRowSelectionAllowed(false);
		table_1.setForeground(Color.WHITE);
		table_1.setBackground(Color.RED);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"R\u00E9f\u00E9rence", "Nom Produit", "Quantit\u00E9", "Produit", "Prix Total", "Date Vente"},
			},
			new String[] {
				"R\u00E9f\u00E9rence Vente", "Nom Produit", "Quantit\u00E9", "Produit", "Prix Total", "Date Vente"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_1.getColumnModel().getColumn(0).setPreferredWidth(125);
		table_1.setBorder(new LineBorder(Color.RED, 2));
		table_1.setBounds(318, 140, 556, 16);
		panel.add(table_1);
		
		JLabel Logolbl = new JLabel("");
		Logolbl.setHorizontalAlignment(SwingConstants.RIGHT);
		Logolbl.setBounds(254, -16, 614, 155);
		Logolbl.setIcon(new ImageIcon(logo));
		panel.add(Logolbl);
		
		
		/********************Listeners********************/
		Add.addActionListener(this);
		btnAnnuler.addActionListener(this);
		this.Table();
	}
	public void Table(){
        int a ;
        Connection con =(Connection) Connect.getCon();
        DefaultTableModel df = new DefaultTableModel();
        String req="SELECT * FROM Vente order by id_V ";

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
                    v1.add(rs.getString("Id_V"));
                    v1.add(rs.getString("NOM_P"));
                    v1.add(rs.getString("Quantite_V"));
                    v1.add(rs.getString("Id_P"));              
                    v1.add(rs.getString("Total_V"));
                    v1.add(rs.getString("Date_V"));
                    
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
			
			
			String Nom_pro=Nom_P.getText();
			int Quantite=Integer.parseInt(Quantite_V.getText());
		
			con=(Connection)Connect.getCon();
			
			String req="SELECT Id_P ,Prix From Produit where Nom_P=?";
			java.sql.PreparedStatement stm;
			try {
				stm = con.prepareStatement(req);
				stm.setString(1, Nom_pro);
				ResultSet rs=stm.executeQuery();
				double Total_vente=0;
				if(rs.next()) {
					int Id=Integer.parseInt(Id_V.getText());
					int Id_P=Integer.parseInt(rs.getString("Id_P"));
					double Prix =Integer.parseInt(rs.getString("Prix"));
					Total_vente=Prix*Quantite;
					Total_V.setText("Total à payer : "+Total_vente+" DH");
					Vente vente = new Vente();
					vente.setId_V(Id);
					vente.setId_P(Id_P);
					vente.setNom_P(Nom_pro);
					vente.setQuantite(Quantite);
					vente.setTotal_V(Total_vente);
					 Socket sA=new Socket("localhost",8000);
					 OutputStream os=sA.getOutputStream();
					 ObjectOutputStream oos=new ObjectOutputStream(os);
					 oos.writeObject(vente);
					 InputStream isVA=sA.getInputStream();
					 if(isVA.read()==1) {
						 this.Table();

					 }
					 
				}
//				
//				
//				
			} catch (Exception e1) {
				e1.printStackTrace();
			} 
	

		}
		if(e.getSource()==btnAnnuler) {
			int dialog=JOptionPane.YES_NO_OPTION;
			int option=JOptionPane.showConfirmDialog(null,"Are you sure?","Warning",dialog);
			if(option==0) {
			
				int input_id=Integer.parseInt(DeleteR.getText());
			
				 try {
					 Socket sD=new Socket("localhost",8000);
					 OutputStream os=sD.getOutputStream();
					 os.write(input_id);
					 InputStream is=sD.getInputStream();
					 if(is.read()==1) {
						 this.Table();
					 }
					
				 }catch(Exception exx) {
					 exx.getMessage();
				 }
			 
			}else  {
				DeleteR.setText("");
					}
		}
		
	}
}
