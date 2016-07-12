package it.buracchi.cifrari.gui.substitution;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SubstitutionGUIdecodifica extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public SubstitutionGUIdecodifica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtpnInserireIlMessaggio = new JTextArea();
		txtpnInserireIlMessaggio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtpnInserireIlMessaggio.setText("");
			}
		});
		txtpnInserireIlMessaggio.setBounds(10, 11, 414, 182);
		txtpnInserireIlMessaggio.setLineWrap(true);
		txtpnInserireIlMessaggio.setText("Inserire il messaggio da cifrare");
		contentPane.add(txtpnInserireIlMessaggio);
		
		TextField textField = new TextField();
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
			}
		});
		textField.setBounds(10, 199, 414, 22);
		textField.setText("Inserire la permutazione dell'alfabeto che si vuole utilizzare");
		contentPane.add(textField);
		
		JButton btnCifrare = new JButton("Cifrare");
		btnCifrare.setBounds(10, 227, 414, 23);
		btnCifrare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = txtpnInserireIlMessaggio.getText().replaceAll("[^A-Za-z]", "").toLowerCase();
				String perm = textField.getText();
				SubstitutionGUIdecodificaRes nw = new SubstitutionGUIdecodificaRes(perm,msg);
				dispose();
				nw.setVisible(true);
			}
		});
		contentPane.add(btnCifrare);
		
	}

}