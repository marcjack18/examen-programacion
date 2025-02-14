package repaso_swing;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import repaso_swing.VentanaPrincipal.Borrado;

public class VentanaPrincipal {

	List <Integer> lista=new ArrayList<>();
	List <Integer> lista2=new ArrayList<>();
	Random azar=new Random();
	int numero_azar=0;
	int numero_pares1=0;
	int numero_pares2=0;
	
	enum Borrado{POSICION,NUMERO};
	Borrado borrado;
	
	
	private JFrame frame;
	private JTextField textFieldLista1;
	private JTextField textFieldLista2;
	private JButton btnBorrarNumerosLista;
	private JComboBox comboBoxLista2;
	private JButton btnBorrarNumeroLista2;
	private JTextField textFieldBorrar1;
	private JTextField textFieldBorrar2;
	private JButton btnBorrarLista;
	private JButton btnBorrarLista2;

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
		frame.setBounds(100, 100, 662, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textFieldLista1 = new JTextField();
		textFieldLista1.setBounds(400, 34, 144, 19);
		frame.getContentPane().add(textFieldLista1);
		textFieldLista1.setColumns(10);
		
		textFieldLista2 = new JTextField();
		textFieldLista2.setBounds(400, 95, 144, 19);
		frame.getContentPane().add(textFieldLista2);
		textFieldLista2.setColumns(10);
		
		JButton btnLista1 = new JButton("Añadir numero a lista1");
		btnLista1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do {
				numero_azar=(azar.nextInt(100));
				}while(numero_azar%2==1); 
				
				lista.add(numero_azar);
				textFieldLista1.setText(lista.toString());
			}
		});
		btnLista1.setBounds(88, 31, 262, 25);
		frame.getContentPane().add(btnLista1);
		
		JButton btnLista2 = new JButton("Añadir numero a lista2");
		btnLista2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do {
					numero_azar=(azar.nextInt(100));
					}while(numero_azar%2==1); 
					
					lista2.add(numero_azar);
					textFieldLista2.setText(lista2.toString());
			
			}
		});
		btnLista2.setBounds(88, 92, 262, 25);
		frame.getContentPane().add(btnLista2);
		
		JComboBox comboBoxLista1 = new JComboBox();
		comboBoxLista1.setModel(new DefaultComboBoxModel(Borrado.values()));
		comboBoxLista1.setBounds(403, 147, 109, 24);
		frame.getContentPane().add(comboBoxLista1);
		
		comboBoxLista2 = new JComboBox();
		comboBoxLista2.setModel(new DefaultComboBoxModel(Borrado.values()));
		comboBoxLista2.setBounds(403, 196, 109, 24);
		frame.getContentPane().add(comboBoxLista2);
		
		textFieldBorrar1 = new JTextField();
		textFieldBorrar1.setBounds(536, 150, 114, 19);
		frame.getContentPane().add(textFieldBorrar1);
		textFieldBorrar1.setColumns(10);
		
		textFieldBorrar2 = new JTextField();
		textFieldBorrar2.setBounds(536, 199, 114, 19);
		frame.getContentPane().add(textFieldBorrar2);
		textFieldBorrar2.setColumns(10);
		
		btnBorrarNumerosLista = new JButton("Borrar numeros Lista1");
		btnBorrarNumerosLista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				switch(comboBoxLista1.getSelectedIndex()){
				case 0:
					try {
					int pos=Integer.parseInt(textFieldBorrar1.getText());
					
					lista.remove(pos);
					if(lista.size()<=0) {
						textFieldLista1.setText("Lista vacia");
						}else {
							textFieldLista1.setText(lista.toString());
						}
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(null, "POSICION INCORRECTA");;
					}
					break;
					
				case 1:
					try {
					int elemento=Integer.parseInt(textFieldBorrar1.getText());
					lista.remove(lista.indexOf(elemento));
					if(lista.size()<=0) {
						textFieldLista1.setText("Lista vacia");
						}else {
							textFieldLista1.setText(lista.toString());
						}
					}catch(Exception e2) {
						JOptionPane.showMessageDialog(null,"El numero no esta en la lista");
					}
				}
				
			}
		});
		btnBorrarNumerosLista.setBounds(88, 147, 262, 25);
		frame.getContentPane().add(btnBorrarNumerosLista);
		
		
		btnBorrarNumeroLista2 = new JButton("Borrar numero Lista2");
		btnBorrarNumeroLista2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switch(comboBoxLista2.getSelectedIndex()){
				case 0:
					try {
					int pos=Integer.parseInt(textFieldBorrar2.getText());
					lista2.remove(pos);
					if(lista2.size()<=0) {
					textFieldLista2.setText("Lista vacia");
					}else {
						textFieldLista2.setText(lista2.toString());
					}
					
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(null, "POSICION INCORRECTA");;
					}
					break;
					
				case 1:
					try {
					int elemento=Integer.parseInt(textFieldBorrar2.getText());
					lista2.remove(lista2.indexOf(elemento));
					if(lista2.size()<=0) {
						textFieldLista2.setText("Lista vacia");
						}else {
							textFieldLista2.setText(lista2.toString());
						}
					}catch(Exception e2) {
						JOptionPane.showMessageDialog(null,"El numero no esta en la lista");
					}
				}
			}
		});
		btnBorrarNumeroLista2.setBounds(88, 196, 262, 25);
		frame.getContentPane().add(btnBorrarNumeroLista2);
		
		btnBorrarLista = new JButton("Borrar Lista1 entera");
		btnBorrarLista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lista.clear();
				textFieldLista1.setText("Lista vacia");
			}
		});
		btnBorrarLista.setBounds(268, 263, 189, 25);
		frame.getContentPane().add(btnBorrarLista);
		
		btnBorrarLista2 = new JButton("Borrar Lista2 entera");
		btnBorrarLista2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lista2.clear();
				textFieldLista2.setText("Lista vacia");
			}
		});
		btnBorrarLista2.setBounds(268, 312, 189, 25);
		frame.getContentPane().add(btnBorrarLista2);
		
	}
}
