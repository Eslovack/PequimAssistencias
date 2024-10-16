package br.com.loja.Assistec.controle;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.loja.Assistec.modelo.LoginDAO;
import br.com.loja.Assistec.modelo.Usuario;

public class LoginController{
	
	private Usuario model;

	public LoginController() 
	{

	}

	public void logar() {
			
	}
	public boolean verificarBancoOnline() throws SQLException
	{
		LoginDAO ldao = new LoginDAO();
		return ldao.bancoOnline();
	}
	public ArrayList<String> autenticar (String login, String Senha) throws SQLException{
		ArrayList<String> listaDados = new ArrayList<>();
		LoginDAO dao = new LoginDAO();
		Usuario user = dao.autenticar(login, Senha);
		
	listaDados.add(0, user.getNome());
	listaDados.add(1, user.getPerfil());
	
		return listaDados;
	}
}
