import javax.swing.JOptionPane;



/**
 * 	Classe Mazzo: Gestisce la logica  del gioco 
 *  @author Michael Tonsuso
 */


public class Mazzo {
	
	// attributi
	private boolean carta0;
	private boolean carta1;
	private boolean carta2;
	private int punteggio;
	private int punteggioMax;
	private int pVittoria;
	private int pSconfitta;
	
	// costruttore
	public Mazzo(int punteggio){
		this.punteggio = punteggio;
		this.pVittoria = 10;
		this.pSconfitta = 20;
		this.punteggioMax = 150;
	}
	
	// Metodi
	
	/**
	 * metodo che consente di mischiare il mazzo.
	 */
	public void mischiaMazzo() {
		
		// resettiamo le carte tutte a false
		carta0 = false;
		carta1 = false;
		carta2 = false;
		
		// attraverso il metodo random della libreria Math
		int cartaJolly =  (int)(Math.random()*3);
		
		/*
		 * assegniamo il jolly ad una delle carte
		 * per esempio quindi se la cartaJolly == 0
		 * carta0 diventa true
		 */
		switch(cartaJolly) {
			case 0 :
				carta0 = true;
				break;
			case 1 :
				carta1 = true;;
				break;
			case 2 :
				carta2 = true;
				break;
			default :
				System.out.println("");

		}
		
	}
	
	
	/**
	 * metodo per capire se abbiamo cliccato sulla carta vincente.
	 */
	public boolean isCartaVincente(int carta) {
		
		/*
		 * per esempio quindi se la carta == 0
		 * ci viene ritornata la carta 0,
		 * che in base al metodo mischiaMazzo 
		 * può essere true o false
		 */	
		switch(carta) {
			case 0 : 
				return carta0;
			case 1 : 
				return carta1;
			case 2 : 
				return carta2;
		    default:
		        return false;
		}
		
	}
	
	
	
	/**
	 * metodo getter, ci ritorna il punteggio.
	 */
	public int getPunteggio() {
		return punteggio;
	}
	
	
	/**
	 * metodo per incrementare il punteggio.
	 * incrementiamo il punteggio di pVittoria.
	 */
	public int addPunteggio() {
		return punteggio += pVittoria;
	}
	
	/**
	 * metodo per decrementare il punteggio.
	 * decrementiamo il punteggio di pSconfitta.
	 */
	public int remPunteggio() {
		return punteggio -= pSconfitta;
	}
	
	
	/**
	 * metodo per controllare il punteggio.
	 */
	public boolean checkPunteggio() {
		
		/*
		 * Qualora il punteggio sia maggiore o uguale del
		 * punteggioMax si vince.
		 * Oppure se il punteggio e' minore o uguale a 0
		 * si perde.
		 * Altrimenti il gioco continua
		 */

		if (punteggio >= punteggioMax) {
	        JOptionPane.showMessageDialog(null, "Hai vinto, complimenti");
	        return true;
		}else if (punteggio <= 0) {
			JOptionPane.showMessageDialog(null, "Hai perso, mi dispiace");
		    return true;
		}else {
			return false;
		}

	}
	
	
	

}
