package br.com.loja.Assistec.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {
	private JTextField textUsuario;
	public JPasswordField txtSenha;
	public JLabel lblStatus;
	public JTextField txtUsuario;
	public JButton btnLogin;
	
	public LoginView() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblUsuario = new JLabel("Usuário");
		
		JLabel lblSenha = new JLabel("Senha");
		
		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		
		txtSenha = new JPasswordField();
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		lblStatus = new JLabel("");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(69)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUsuario)
						.addComponent(lblSenha))
					.addPreferredGap(ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtSenha)
						.addComponent(textUsuario))
					.addContainerGap(88, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(141)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(182, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblStatus)
					.addContainerGap(378, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsuario)
						.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenha)
						.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addComponent(lblStatus)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);

	}
}
