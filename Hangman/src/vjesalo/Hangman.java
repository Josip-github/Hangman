package vjesalo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

public class Hangman {
	
	String[] listaRijeci = { "laptop", "rijeè", "politika", "znanost", "filozofija", 
			"umjetnost", "glazba", "instrument", "violina", "kum", "svadba", "komarac", "more", "mjesec", "raèunalo" };
	
	Random rand = new Random();
	String rijec = listaRijeci[rand.nextInt(listaRijeci.length)];
	char[] rijecArray = rijec.toCharArray();
	List<Character> korisnikoviPokusaji = new ArrayList<>();
	boolean rijecSadrziSlovo;
	boolean korisnikPogodioRijec;
	
	int zivoti = 6;

	public Hangman() {
		
		igraPocinje();
		igraj();
		
	}
	
	private void igraPocinje() {
		
		System.out.println("Igra poèinje!");
		System.out.println("Rijeè ima " + rijec.length() + " slova.");
		System.out.println("Imate " + zivoti + " života.");
		Hangman2.ispisiSkrivenuRijec(rijecArray);
		System.out.println();
		
	}

	private void igraj() {
		
		while(zivoti > 0) {
		String korisnikovoSlovo, korisnikovaRijec;
		
		
		while (true) {
			korisnikovoSlovo = Hangman2.korisnikPogadja();
			try {
				Hangman2.provjeraIspravnostiUnosa(korisnikovoSlovo);
				korisnikoviPokusaji.add(korisnikovoSlovo.charAt(0));
				break;
			} catch (ObavezanUnosSlova e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				continue;
			}
		}
		
		rijecSadrziSlovo = Hangman2.slovoSeNalaziURijeèi(korisnikovoSlovo, rijec);
		if (rijecSadrziSlovo) {
			Hangman2.ispisiTrenutnoStanjeRijeci(korisnikoviPokusaji, rijecArray);
			System.out.println("\nToèno! Imate života: " + zivoti + "; nastavite!");
		}else {
			zivoti--;
			System.out.println("\nNiste pogodili, preostalo je života: " + zivoti);
		}
		
		korisnikPogodioRijec = Hangman2.korisnikPogadjaCijeluRijec(rijec);
		if (korisnikPogodioRijec) {
			JOptionPane.showMessageDialog(null, "Pobijedili ste, èestitam!! Rijeè: " + rijec);
			System.out.println("\nPobijedili ste, èestitam!! Rijeè: " + rijec);
			break;
		}else if(!korisnikPogodioRijec && zivoti >= 1) {
			JOptionPane.showMessageDialog(null, "Igra se nastavlja. Preostalo je života: " + zivoti);
		}else if (!korisnikPogodioRijec && zivoti == 0) {
			System.out.println("Nažalost niste uspjeli, više sreæe drugi put... Rijeè: " + rijec);
		}
		Hangman2.ispisiTrenutnoStanjeRijeci(korisnikoviPokusaji, rijecArray);
		System.out.println();
		Hangman2.ispisiSveKorisnikovePokusaje(korisnikoviPokusaji);
	}
		
	}

	public static void main(String[] args) {
		
		new Hangman();
	}
}
