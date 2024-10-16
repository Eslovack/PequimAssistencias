package br.com.loja.Assistec.visao;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import br.com.loja.Assistec.controle.LoginController;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class Loginview extends JFrame {

	LoginController controller = new LoginController();

	private static final long serialVersionUID = 1L;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	private JButton btnLogin;
	private JLabel lblStatus;
	private JLabel lblUsuario;
	private JLabel lblSenha;

	public Loginview() {
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				LoginController lc = new LoginController();
				
				try {
					if (lc.verificarBancoOnline()) {
						lblStatus.setIcon(new ImageIcon(getClass().getResource("/br/com/loja/assistec/icones/dbok.png")));
					} else {
						lblStatus.setIcon(new ImageIcon(getClass().getResource("/br/com/loja/assistec/icones/dberror.png")));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("CRUD - LOGIN");
		setResizable(false);

		iniciarComponentes();
		
		getRootPane().setDefaultButton(btnLogin);
		
//		controller.executa(this);
	}

	public void iniciarComponentes() {
		lblUsuario = new JLabel();
		lblSenha = new JLabel();
		txtUsuario = new JTextField();
		txtSenha = new JPasswordField();
		btnLogin = new JButton();
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					onClickBtnLogin();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblStatus = new JLabel();

		lblUsuario.setText("Usuário");
		lblSenha.setText("Senha");
		btnLogin.setText("Login");
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(37).addComponent(lblStatus))
						.addGroup(groupLayout.createSequentialGroup().addGap(189).addComponent(btnLogin))
						.addGroup(groupLayout.createSequentialGroup().addGap(130)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 36,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblUsuario))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, 128,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, 127,
												GroupLayout.PREFERRED_SIZE))))
				.addContainerGap(180, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap(60, Short.MAX_VALUE)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblUsuario).addComponent(
						txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblSenha)
						.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
				.addGap(35).addComponent(btnLogin).addGap(22).addComponent(lblStatus).addGap(61)));
		getContentPane().setLayout(groupLayout);
		pack();
		setLocationRelativeTo(null);
	}
	
	
	private void onClickBtnLogin() throws SQLException {
		ArrayList<String> autenticado = new ArrayList<String>();
		
		if(txtUsuario.getText() != null && !txtUsuario.getText().isEmpty() && !String.valueOf(txtSenha.getPassword()).isEmpty() ) {
			LoginController lc = new LoginController();
			try {
				autenticado = lc.autenticar(txtUsuario.getText(), new String(txtSenha.getPassword()));
				if (autenticado.get(0) !=null) {
					JOptionPane.showMessageDialog(this, " Bem-vindo " + autenticado.get(0) + "Acesso liberado", "Atenção", JOptionPane.INFORMATION_MESSAGE);
					this.dispose();
					PrincipalView  telaPrincipal = new PrincipalView(autenticado.get(0), autenticado.get(1));
					telaPrincipal.setVisible(true);
				}
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(this, "Usuario ou Senha ta erroado");
			}
		} else {
			JOptionPane.showMessageDialog(this, "cuzinho");
		}
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public JPasswordField getTxtSenha() {
		return txtSenha;
	}

	public JLabel getLblStatus() {
		return lblStatus;
	}

}
