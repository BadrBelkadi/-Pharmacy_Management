package Interface_Graphique;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import Classes.Admin;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;

public class Login_IG extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField Login_F;
	private JPasswordField Password_F;
	JButton Login = new JButton("Login");
	JButton Exit = new JButton("Exit");
	JLabel Password_Verification = new JLabel("");
	private Image user_icon=new ImageIcon(Login_IG.class.getResource("/res/user.png")).getImage().getScaledInstance(22,22,Image.SCALE_SMOOTH);
	private Image password_icon=new ImageIcon(Login_IG.class.getResource("/res/password.png")).getImage().getScaledInstance(25,25,Image.SCALE_SMOOTH);

	public static Login_IG frame = new Login_IG(); ;

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
	public Login_IG() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Badreddine Belkadi\\Desktop\\phar.png"));
		setTitle("Gestion de Pharmacie");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 547, 366);
		contentPane.add(panel);
		
		Login.setForeground(new Color(51, 0, 51));
		Login.setBackground(Color.WHITE);
		Login.setBounds(111, 300, 103, 42);
		panel.add(Login);
		
		Exit.setBackground(Color.WHITE);
		Exit.setBounds(340, 300, 103, 42);
		panel.add(Exit);
		
		Password_Verification.setHorizontalAlignment(SwingConstants.CENTER);
		Password_Verification.setForeground(Color.RED);
		Password_Verification.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Password_Verification.setBounds(148, 139, 273, 31);
		panel.add(Password_Verification);
		
		Login_F = new JTextField();
		
		Login_F.setHorizontalAlignment(SwingConstants.CENTER);
		Login_F.setBackground(Color.WHITE);
		Login_F.setText("Username");
		Login_F.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login_F.setText("");
				Login_F.setFont(new Font("Verdana", Font.BOLD, 12));
				Login_F.setForeground(Color.BLACK);
			}
			
		});
		Login_F.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Login_F.setForeground(Color.LIGHT_GRAY);
		
		Login_F.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Login_F.setColumns(20);
		Login_F.setBounds(192, 181, 209, 31);
		panel.add(Login_F);
		
		JLabel Icon = new JLabel("");
		Icon.setIcon(new ImageIcon("C:\\Users\\Badreddine Belkadi\\Desktop\\Logo.png"));
		Icon.setBounds(160, 11, 268, 124);
		panel.add(Icon);
		
		Password_F = new JPasswordField();
		Password_F.setText("Password\r\n");
		Password_F.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Password_F.setHorizontalAlignment(SwingConstants.CENTER);
		Password_F.setFont(new Font("Verdana", Font.BOLD, 12));
		Password_F.setBounds(192, 228, 209, 31);
		Password_F.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Password_F.setText("");
				Password_F.setFont(new Font("Verdana", Font.BOLD, 12));
				Password_F.setForeground(Color.BLACK);
			}
		});
		Password_F.setForeground(Color.LIGHT_GRAY);
		panel.add(Password_F);
		
		JLabel userlbl = new JLabel("");
		userlbl.setHorizontalAlignment(SwingConstants.CENTER);
		userlbl.setIcon(new ImageIcon(user_icon));
		userlbl.setBounds(136, 181, 46, 31);
		panel.add(userlbl);
		
		JLabel passwordlbl = new JLabel("");
		passwordlbl.setHorizontalAlignment(SwingConstants.CENTER);
		passwordlbl.setBounds(136, 228, 46, 31);
		passwordlbl.setIcon(new ImageIcon(password_icon));
		panel.add(passwordlbl);
		
		JLabel Userlabel = new JLabel("");
		Userlabel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Userlabel.setBackground(Color.RED);
		Userlabel.setBounds(131, 181, 259, 31);
		panel.add(Userlabel);
		
		JLabel Userlabel_1 = new JLabel("");
		Userlabel_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Userlabel_1.setBackground(Color.RED);
		Userlabel_1.setBounds(131, 228, 270, 31);
		panel.add(Userlabel_1);
		Login.addActionListener(this);
		Exit.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Login) {
			String UserName=Login_F.getText();
			String Password=Password_F.getText();
			Admin admin=new Admin();
			admin.setUserName(UserName);
			admin.setPassword(Password);
			try {
				Socket s=new Socket("localhost",8000);
				OutputStream os=s.getOutputStream();
				ObjectOutputStream oos=new ObjectOutputStream(os);
				oos.writeObject(admin);
				InputStream is=s.getInputStream();
				if(is.read()==1) {
//					Accueil_IG acceuil=new Accueil_IG();
					Login_F.setText("");
					Password_F.setText("");
					Accueil_IG.frame.setVisible(true);	
					Login_IG.frame.setVisible(false);
					
				}
				else {
					Password_Verification.setText("Username ou Mot de passe incorrecte");
				}
				
//				oos.writeObject(admin);
			}catch(IOException io) {
				io.printStackTrace();
			}
		}
		if(e.getSource()==Exit) {
		      System.exit(0);

		}
		
	}
}
