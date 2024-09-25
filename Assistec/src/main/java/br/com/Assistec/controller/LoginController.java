package br.com.Assistec.controller;

import javax.swing.JOptionPane;

import br.com.loja.Assistec.model.UsuarioModel;
import br.com.loja.Assistec.view.LoginView;

public class LoginController {
	
	private LoginView view;
	private UsuarioModel model;
	
	public LoginController(LoginView view) {
		
		this.view = view;
		this.model = new UsuarioModel();
		
		
		if (model.conexao != null) {
			
			System.out.println("Sim");
		} else {
			System.out.println("Não");
		}
		this.view.btnLogin.addActionListener(e -> logar());
	}
	public void logar() {
		String login = view.txtUsuario.getText();
		String senha = new String(view.txtSenha.getPassword());
		String perfil = model.autenticar(login, senha);
		
		if (perfil != null) {
			
			JOptionPane.showMessageDialog(null, "Login");
			
		} else {
			
			JOptionPane.showMessageDialog(null, "Login ou senha ta errado fio");
			
		}
	}
}
