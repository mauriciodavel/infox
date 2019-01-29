package br.com.infox.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Date;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	public static JMenuItem menCadUsu;
	public static JMenu menRel;
	public static JLabel lblData;
	public static JLabel lblUsuario;
	public static JLabel lblPerfil;
	

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			//public void run() {
				//try {
					//TelaPrincipal frame = new TelaPrincipal();
					//frame.setVisible(true);
				//} catch (Exception e) {
					//e.printStackTrace();
				//}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				Date data = new Date();
				DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
				lblData.setText(formatador.format(data));
			}
		});
		
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/br/com/infox/icones/tools.png")));
		setTitle("INFOX - Controle de Serviços ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1264, 768, 1366, 734);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1350, 21);
		contentPane.add(menuBar);
		
		JMenu menCad = new JMenu("Cadastro");
		menuBar.add(menCad);
		
		menCadUsu = new JMenuItem("Usuários");
		menCadUsu.setEnabled(false);
		menCad.add(menCadUsu);
		
		JMenuItem menCadCli = new JMenuItem("Clientes");
		menCad.add(menCadCli);
		
		JMenuItem menCadOs = new JMenuItem("Ordem de Serviço");
		menCad.add(menCadOs);
		
		menRel = new JMenu("Relatórios");
		menRel.setEnabled(false);
		menuBar.add(menRel);
		
		JMenuItem menRelCli = new JMenuItem("Clientes");
		menRel.add(menRelCli);
		
		JMenuItem menRelOs = new JMenuItem("O.S.");
		menRel.add(menRelOs);
		
		JMenuItem menRelUsu = new JMenuItem("Usuários");
		menRel.add(menRelUsu);
		
		JMenu menOpc = new JMenu("Opções");
		menuBar.add(menOpc);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		menOpc.add(mntmLogout);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		menOpc.add(mntmSair);
		
		JDesktopPane Desktop = new JDesktopPane();
		Desktop.setBounds(0, 692, 1141, -669);
		contentPane.add(Desktop);
		
		lblUsuario = new JLabel("New label");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUsuario.setBounds(1185, 33, 155, 21);
		contentPane.add(lblUsuario);
		
		lblData = new JLabel("New label");
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblData.setBounds(1185, 85, 155, 29);
		contentPane.add(lblData);
		
		JLabel lblPerfilTitulo = new JLabel("Perfil");
		lblPerfilTitulo.setForeground(Color.BLUE);
		lblPerfilTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPerfilTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerfilTitulo.setBounds(1185, 149, 155, 21);
		contentPane.add(lblPerfilTitulo);
		
		lblPerfil = new JLabel("Perfil");
		lblPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerfil.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPerfil.setBounds(1185, 181, 155, 21);
		contentPane.add(lblPerfil);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/infox/icones/Logo Principal.jpg")));
		lblLogo.setBounds(1151, 514, 199, 171);
		contentPane.add(lblLogo);
		
		JLabel lblDesktop = new JLabel("");
		lblDesktop.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/infox/icones/Fundo Desktop.jpg")));
		lblDesktop.setBounds(0, 21, 1141, 675);
		contentPane.add(lblDesktop);
		
		this.setExtendedState(MAXIMIZED_BOTH);
	}
	public JMenuItem getMenCadUsu() {
		return menCadUsu;
	}
	public JMenu getMenRel() {
		return menRel;
	}
	

	public JLabel getLblData() {
		return lblData;
	}
	public JLabel getLblUsuario() {
		return lblUsuario;
	}
	public JLabel getLblPerfil() {
		return lblPerfil;
	}
}
