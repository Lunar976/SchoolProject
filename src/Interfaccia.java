// Tonsuso Michael, 4A inf, Esercizio vacanze di Natale
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;



/**
 * 	Classe Interfaccia: Gestisce l'interfaccia grafica del gioco 
 *  @author Michael Tonsuso
 */

public class Interfaccia {

	// attributi
	private JFrame frame;
	private JTextField txtPoints;
	private JButton btnCarta0;
	private JButton btnCarta1;
	private JButton btnCarta2;
	private int carteSelezionate = 0;
	
	//istanziamo l'oggetto
	Mazzo m1 = new Mazzo(100);
	
	//array di bottoni
	JButton[] bottoni;
	
	
	/**
	 * metodo principale per avviare l'applicazione.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaccia window = new Interfaccia();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Costruttore della classe Interfaccia :  
	 * inizializza l'interfaccia grafica e mischia le carte.	
	 */
	public Interfaccia() {
		initialize();
		m1.mischiaMazzo();
	}

	/**
	 * Inizializza il contenuto del frame dell'applicazione.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(214, 243, 215));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Gioco Carte");
		frame.getContentPane().setLayout(null);
		
		
		
		
		// label 
		
		// titolo
		JLabel lblTitle = new JLabel("Trova il Jolly!");
		lblTitle.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblTitle.setBounds(154, 11, 130, 32);
		frame.getContentPane().add(lblTitle);
		
		
		// button
		
		// bottone carta 0 
		JButton btnCarta0 = new JButton("0");
		btnCarta0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (m1.isCartaVincente(0)) {
					btnCarta0.setIcon(new ImageIcon("src\\Jolly.jpg"));
					JOptionPane.showMessageDialog(btnCarta0,"Grande, la carta vincente e' la 0");
					m1.addPunteggio();
					resetCarte(bottoni);
					// ogni volta che la carta e' il jolly giustamente le carteSelezionate di devono azzerare
					carteSelezionate = 0;
					
				} else {
					btnCarta0.setIcon(new ImageIcon("src\\Picche.jpg"));
					JOptionPane.showMessageDialog(btnCarta0, "Mi dispiace, la Carta 0 non e' quella vincente.");
					m1.remPunteggio();
					/*
					 * Nota : tutte le volte che la carta selezionata
					 * non e' il jolly viene incrementata questa variabile che ho creato,
					 * cartaSelezionata, poi se essa e' uguale a due si resettano le immagini
					 */
					carteSelezionate++;
					if (carteSelezionate == 2) {
						JOptionPane.showMessageDialog(btnCarta0, "Mi dispiace non hai trovato il jolly");
						resetCarte(bottoni);
					}

				}
				// richiamiamo il metodo per aggiornare il punteggio
				aggiornaPunteggio();
				checkVittoria();

			}
		});
		btnCarta0.setIcon(new ImageIcon("src\\RetroCarte.jpg"));
		btnCarta0.setBounds(29, 54, 89, 129);
		frame.getContentPane().add(btnCarta0);
		
		// bottone carta 1
		JButton btnCarta1 = new JButton("1");
		btnCarta1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (m1.isCartaVincente(1)) {
					btnCarta1.setIcon(new ImageIcon("src\\Jolly.jpg"));
					JOptionPane.showMessageDialog(btnCarta1,"Grande, la carta vincente e' la 1");
					m1.addPunteggio();
					resetCarte(bottoni);
					carteSelezionate = 0;
				} else {
					btnCarta1.setIcon(new ImageIcon("src\\Picche.jpg"));
					JOptionPane.showMessageDialog(btnCarta1,"Mi dispiace, la Carta 1 non e' quella vincente.");
					m1.remPunteggio();
					carteSelezionate++;
					if (carteSelezionate == 2) {
						JOptionPane.showMessageDialog(btnCarta1 ,"Mi dispiace non hai trovato il jolly");
						resetCarte(bottoni);
					}
				
				}
				// richiamiamo il metodo per aggiornare il punteggio
				aggiornaPunteggio();
				checkVittoria();
				

			}
		});
		btnCarta1.setIcon(new ImageIcon("src\\RetroCarte.jpg"));
		btnCarta1.setBounds(165, 54, 89, 129);
		frame.getContentPane().add(btnCarta1);
		
		// bottone carta 2
		JButton btnCarta2 = new JButton("2");
		btnCarta2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (m1.isCartaVincente(2)) {
					btnCarta2.setIcon(new ImageIcon("src\\Jolly.jpg"));
					JOptionPane.showMessageDialog(btnCarta2,"Grande, la carta vincente e' la 2");
					m1.addPunteggio();
					resetCarte(bottoni);
					carteSelezionate = 0;
					
				} else {
					btnCarta2.setIcon(new ImageIcon("src\\Picche.jpg"));
					JOptionPane.showMessageDialog(btnCarta2,"Mi dispiace, la Carta 2 non e' quella vincente.");
					m1.remPunteggio();
					carteSelezionate++;
					if (carteSelezionate == 2) {
						JOptionPane.showMessageDialog(btnCarta2,"Mi dispiace non hai trovato il jolly");
						resetCarte(bottoni);
					}
				
				}
				// richiamiamo il metodo per aggiornare il punteggio
				aggiornaPunteggio();
				checkVittoria();
				
				

			}
		});
		btnCarta2.setIcon(new ImageIcon("src\\RetroCarte.jpg"));
		btnCarta2.setBounds(300, 54, 89, 129);
		frame.getContentPane().add(btnCarta2);
		
		// Inizializziamo l'array bottoni
		bottoni = new JButton[] {btnCarta0, btnCarta1, btnCarta2};
		
		
		// bottone per mischiare le carte
		JButton btnMischiaCarte = new JButton("Mischia");
		btnMischiaCarte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m1.mischiaMazzo();
				btnCarta0.setIcon(new ImageIcon("src\\RetroCarte.jpg"));
				btnCarta1.setIcon(new ImageIcon("src\\RetroCarte.jpg"));
				btnCarta2.setIcon(new ImageIcon("src\\RetroCarte.jpg"));
			}
		});
		btnMischiaCarte.setBounds(343, 194, 81, 23);
		frame.getContentPane().add(btnMischiaCarte);
		
		
		// bottone per uscire
		JButton btnEsci = new JButton("Esci");
		btnEsci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnEsci.setBounds(343, 227, 81, 23);
		frame.getContentPane().add(btnEsci);
		
		
		// Punteggio
		
		// label testo 
		JLabel lblPoints = new JLabel("Punteggio");
		lblPoints.setBounds(29, 198, 68, 14);
		frame.getContentPane().add(lblPoints);
		
		// textField per il punteggio
		txtPoints = new JTextField();
		txtPoints.setEditable(false);
		txtPoints.setBounds(29, 217, 68, 20);
		txtPoints.setText(" " + m1.getPunteggio());
		frame.getContentPane().add(txtPoints);
		txtPoints.setColumns(10);
		

	}
	
	/**
	 * Aggiorna il punteggio corrente.
	 */
	public void aggiornaPunteggio() {
		txtPoints.setText(" " + m1.getPunteggio());
	}
	
	/**
	 * Resetta le immagini delle carte a quella di default (retro).
	 */
	public void resetCarte(JButton[] bottoni) {
		for(JButton bottone : bottoni) {
			bottone.setIcon(new ImageIcon("src\\RetroCarte.jpg"));
		}
	}
	
	
	/**
	 * Controlla se il punteggio corrisponde a una vittoria o una sconfitta,
	 * attraverso il metodo checkPunteggio.
	 * Se il gioco è terminato, viene resettato.
	 */
	public void checkVittoria() {
		if (m1.checkPunteggio()) {
			resetGioco();
		}
	}
	
	/**
	 * Resetta il gioco: crea un nuovo mazzo, mischia le carte, aggiorna l'interfaccia e reimpostiamo carteSelezionate a 0.
	 */
	public void resetGioco(){
		m1 = new Mazzo(100);
		m1.mischiaMazzo();
		aggiornaPunteggio();
		resetCarte(bottoni);
		carteSelezionate = 0;
	}
	
	
}
