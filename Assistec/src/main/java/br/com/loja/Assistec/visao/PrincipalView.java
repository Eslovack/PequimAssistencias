package br.com.loja.Assistec.visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.Spring;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalView extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalView frame = new PrincipalView("","");
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
	public PrincipalView(String user, String perfil) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Aluno\\Downloads\\shika.jpg"));
		setTitle("shika");
		setBounds(100, 100, 1294, 751);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblUsuario = new JLabel("");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Aluno\\Downloads\\shika.jpg"));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(lblUsuario))
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 1341, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 659, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblUsuario)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuArquivo = new JMenu("Arquivo");
		menuBar.add(menuArquivo);
		
		JMenuItem menuSair = new JMenuItem("Sair");
		menuSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sair = JOptionPane.showConfirmDialog(null, "Vós tem certezas que desejas isto?","skibidi", JOptionPane.YES_NO_OPTION);
				if (sair == 0) {
					System.exit(0);
				}
			}
		});
		menuArquivo.add(menuSair);
		
		JMenu menuCadastro = new JMenu("Cadastro");
		menuCadastro.setEnabled(false);
		menuBar.add(menuCadastro);
		
		JMenuItem menuUsuarios = new JMenuItem("Usuarios");
		menuUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				listarUsuarios();
				
			}
		});
		menuCadastro.add(menuUsuarios);
		
		JMenu menuRelatorio = new JMenu("Relatorios");
		menuRelatorio.setEnabled(false);
		menuBar.add(menuRelatorio);
		
		JMenu menuAjuda = new JMenu("Ajuda");
		menuBar.add(menuAjuda);
		
		JMenuItem menuSobre = new JMenuItem("Sobre");
		menuSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Shika");
			}
		});
		menuAjuda.add(menuSobre);
		lblUsuario.setText(user);
		
		if ("Admin".equalsIgnoreCase(perfil)) {
			
			menuCadastro.setEnabled(true);
			menuRelatorio.setEnabled(true);
		}

	}

	protected void listarUsuarios() {
		ListarUsuariosView frame = new ListarUsuariosView();
		frame.setLocationRelativeTo(frame);
		frame.setVisible(true);
		// TODO Auto-generated method stub
		
	}
}
