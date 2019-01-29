package br.com.infox.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import br.com.infox.dal.ModuloConexao;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import br.com.infox.view.TelaPrincipal;
import java.sql.*;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	// usando variável de conexão do DAL
	Connection conexao = null;
	// Criando variáveis especiais para conexão do banco
	// Prepareted Statement e Resultset são frameworks do pacote java.sql
	// e servem para preparar e executar as instruções SQL
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	public static JLabel lblStatus;

	// criando o método logar
	public void logar() {
		String sql = "select * from tbusuarios where login=? and senha=?";
		try {
			// as linhas abaixo preparam a consulta ao banco em função do que foi digitado
			// nas caixas de texto
			// o ? é substituido pelo conteúdo das variáveis
			pst = conexao.prepareStatement(sql);
			pst.setString(1, txtUsuario.getText());
			pst.setString(2, txtSenha.getText());
			// a linha abaixo executa a consulta ao banco de dados
			rs = pst.executeQuery();
			// se existir usuário e senha correspondente
			if (rs.next()) {
				// a linha abaixo obtem o conteudo do campo perfil da tabela tbusuario
				String perfil = rs.getString(6);
				// System.out.println(perfil);
				// a estrutura abaixo faz o tratamento do perfil
				if (perfil.equals("Admin")) {
					TelaPrincipal principal = new TelaPrincipal();
					principal.setVisible(true);

					TelaPrincipal.menCadUsu.setEnabled(true);
					TelaPrincipal.menRel.setEnabled(true);
					TelaPrincipal.lblPerfil.setText(perfil);
					TelaPrincipal.lblPerfil.setForeground(Color.red);
					TelaPrincipal.lblUsuario.setText(rs.getString(2));
					TelaPrincipal.lblUsuario.setForeground(Color.red);

					// fechando a tela de login ao logar
					this.dispose();
				} else {
					TelaPrincipal principal = new TelaPrincipal();
					principal.setVisible(true);
					TelaPrincipal.lblUsuario.setText(rs.getString(2));
					this.dispose();
				}
				// fechando a conexão com o banco de dados
				conexao.close();
			} else {
				JOptionPane.showMessageDialog(null, "Usuário e ou senha inválido(s)");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {

		conexao = ModuloConexao.conector();
		
		/**if (conexao != null) {

			lblStatus.setIcon(new ImageIcon(TelaLogin.class.getResource("/br/com/infox/icones/dbOK1.png")));
			
		} else {

			lblStatus.setIcon(new ImageIcon(TelaLogin.class.getResource("/br/com/infox/icones/dbErro1.png")));

		}*/

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuário");
		lblUsuario.setBounds(145, 54, 46, 14);
		contentPane.add(lblUsuario);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(145, 112, 46, 14);
		contentPane.add(lblSenha);

		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logar();
			}
		});

		lblStatus = new JLabel("");
		lblStatus.setBounds(10, 177, 77, 74);
		contentPane.add(lblStatus);
		btnLogar.setBounds(150, 180, 89, 23);
		contentPane.add(btnLogar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnCancelar.setBounds(291, 180, 89, 23);
		contentPane.add(btnCancelar);

		JLabel imgLogUsu = new JLabel("");
		imgLogUsu.setIcon(new ImageIcon(TelaLogin.class.getResource("/br/com/infox/icones/user.png")));
		imgLogUsu.setBounds(0, 38, 115, 115);
		contentPane.add(imgLogUsu);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(202, 51, 143, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(201, 109, 144, 20);
		contentPane.add(txtSenha);
	}

	public JLabel getLblStatus() {
		return lblStatus;
	}
}
