package repaso_swing_hashmaps;

import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class VentanaPrincipal {

	HashMap <Integer,Integer> mapa1=new HashMap();
	HashMap <Integer,Integer> mapa2=new HashMap();
	Random azar=new Random();
	private JFrame frame;
	private JTextField textFieldClave1;
	private JTextField textFieldMapa1;
	private JTextField textFieldClave2;
	private JTextField textFieldMapa2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 661, 454);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textFieldClave1 = new JTextField();
		textFieldClave1.setBounds(320, 36, 114, 19);
		frame.getContentPane().add(textFieldClave1);
		textFieldClave1.setColumns(10);
		
		JLabel lblClaveQueQuieras = new JLabel("Clave numerica");
		lblClaveQueQuieras.setBounds(320, 9, 137, 15);
		frame.getContentPane().add(lblClaveQueQuieras);
		
		textFieldMapa1 = new JTextField();
		textFieldMapa1.setBounds(485, 36, 114, 19);
		frame.getContentPane().add(textFieldMapa1);
		textFieldMapa1.setColumns(10);
		
		textFieldClave2 = new JTextField();
		textFieldClave2.setBounds(320, 86, 114, 19);
		frame.getContentPane().add(textFieldClave2);
		textFieldClave2.setColumns(10);
		
		textFieldMapa2 = new JTextField();
		textFieldMapa2.setBounds(485, 86, 114, 19);
		frame.getContentPane().add(textFieldMapa2);
		textFieldMapa2.setColumns(10);
		
		JButton btnAadirNumero1 = new JButton("Añadir numero al mapa1");
		btnAadirNumero1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				int clave=Integer.parseInt(textFieldClave1.getText());
				int numero_azar=azar.nextInt(100);
				if(mapa1.containsKey(clave)) {
					JOptionPane.showMessageDialog(null, "YA TIENE UN VALOR ASOCIADO");
				}else {
					
					mapa1.put(clave, numero_azar);
				}
				textFieldMapa1.setText(mapa1.values().toString());
				}catch(Exception NumberFormatException ) {
					JOptionPane.showMessageDialog(null, "CLAVE INCORRECTA");;
				}
			}
		});
		
		btnAadirNumero1.setBounds(69, 33, 225, 25);
		frame.getContentPane().add(btnAadirNumero1);
		
		JButton btnAadirNumero2 = new JButton("Añadir numero al mapa2");
		btnAadirNumero2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int clave=Integer.parseInt(textFieldClave2.getText());
					int numero_azar=azar.nextInt(100);
					if(mapa2.containsKey(clave)) {
						JOptionPane.showMessageDialog(null, "YA TIENE UN VALOR ASOCIADO");
					}else {
						
						mapa2.put(clave, numero_azar);
					}
					textFieldMapa2.setText(mapa2.values().toString());
					}catch(Exception NumberFormatException ) {
						JOptionPane.showMessageDialog(null, "CLAVE INCORRECTA");
					}
			}
		});
		btnAadirNumero2.setBounds(69, 83, 225, 25);
		frame.getContentPane().add(btnAadirNumero2);
		
	}

}
