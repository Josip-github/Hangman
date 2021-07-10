package vjesalo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

public class Hangman {
	
	String[] listaRijeci = { "laptop", "rije�", "politika", "znanost", "filozofija", 
			"umjetnost", "glazba", "instrument", "violina", "kum", "svadba", "komarac", "more", "mjesec", "ra�unalo" };
	
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
		
		System.out.println("Igra po�inje!");
		System.out.println("Rije� ima " + rijec.length() + " slova.");
		System.out.println("Imate " + zivoti + " �ivota.");
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
		
		rijecSadrziSlovo = Hangman2.slovoSeNalaziURije�i(korisnikovoSlovo, rijec);
		if (rijecSadrziSlovo) {
			Hangman2.ispisiTrenutnoStanjeRijeci(korisnikoviPokusaji, rijecArray);
			System.out.println("\nTo�no! Imate �ivota: " + zivoti + "; nastavite!");
		}else {
			zivoti--;
			System.out.println("\nNiste pogodili, preostalo je �ivota: " + zivoti);
		}
		
		korisnikPogodioRijec = Hangman2.korisnikPogadjaCijeluRijec(rijec);
		if (korisnikPogodioRijec) {
			JOptionPane.showMessageDialog(null, "Pobijedili ste, �estitam!! Rije�: " + rijec);
			System.out.println("\nPobijedili ste, �estitam!! Rije�: " + rijec);
			break;
		}else if(!korisnikPogodioRijec && zivoti >= 1) {
			JOptionPane.showMessageDialog(null, "Igra se nastavlja. Preostalo je �ivota: " + zivoti);
		}else if (!korisnikPogodioRijec && zivoti == 0) {
			System.out.println("Na�alost niste uspjeli, vi�e sre�e drugi put... Rije�: " + rijec);
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
