package br.com.loja.Assistec.visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarUsuariosView extends JFrame {
	private JTextField textLocalizar;
	private JButton btnFechar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarUsuariosView frame = new ListarUsuariosView();
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
	public ListarUsuariosView() {
		setBounds(100, 100, 855, 587);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarUsuariosView cuv = new CadastrarUsuariosView();
				cuv.setLocationRelativeTo(cuv);
				cuv.setVisible(true);
				
			}
		});
		btnCadastrar.setBounds(10, 44, 105, 36);
		getContentPane().add(btnCadastrar);
		
		textLocalizar = new JTextField();
		textLocalizar.setBounds(125, 48, 151, 28);
		getContentPane().add(textLocalizar);
		textLocalizar.setColumns(10);
		
		btnFechar = new JButton("New button");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setIcon(new ImageIcon("C:\\Users\\Aluno\\Downloads\\shika.jpg"));
		btnFechar.setBounds(286, 384, 285, 153);
		getContentPane().add(btnFechar);

	}
}
