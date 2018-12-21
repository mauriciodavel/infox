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

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JMenuItem menCadUsu;
	private JMenu menRel;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		
		
		
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
		menCad.add(menCadUsu);
		
		JMenuItem menCadCli = new JMenuItem("Clientes");
		menCad.add(menCadCli);
		
		JMenuItem menCadOs = new JMenuItem("Ordem de Serviço");
		menCad.add(menCadOs);
		
		menRel = new JMenu("Relatórios");
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
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 692, 1198, -672);
		contentPane.add(desktopPane);
		
		label = new JLabel("");
		label.setBounds(1199, 47, 46, 14);
		contentPane.add(label);
	}
	public JMenuItem getMenCadUsu() {
		return menCadUsu;
	}
	public JMenu getMenRel() {
		return menRel;
	}
	public JLabel getLabel() {
		return label;
	}
}
