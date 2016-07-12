package it.buracchi.cifrari.gui.shift;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShiftGUIcodifica extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	
	public ShiftGUIcodifica() {
		setTitle("SHIFT CIPHER");
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
		txtpnInserireIlMessaggio.setText("Inserire il messaggio da cifrare");
		txtpnInserireIlMessaggio.setBounds(10, 11, 414, 187);
		txtpnInserireIlMessaggio.setLineWrap(true);
		contentPane.add(txtpnInserireIlMessaggio);
		
		Choice choice = new Choice();
		choice.setBounds(10, 204, 414, 20);
		choice.add("Selezionare il numero di posizioni di shifting");
		for(int i = 1; i < 26; i++){
			choice.add(""+i);
		}
		contentPane.add(choice);
		
		JButton btnCifrare = new JButton("Cifrare");
		btnCifrare.setBounds(10, 230, 414, 20);
		btnCifrare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = txtpnInserireIlMessaggio.getText().replaceAll("[^A-Za-z]", "").toLowerCase();
				int shift = choice.getSelectedIndex();
				ShiftGUIcodificaRes nw = new ShiftGUIcodificaRes(msg,shift);
				dispose();
				nw.setVisible(true);
			}
		});
		contentPane.add(btnCifrare);
		
		
	}

}