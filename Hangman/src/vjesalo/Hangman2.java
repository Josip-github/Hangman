package vjesalo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

public class Hangman2 {

	public static String korisnikPogadja() {
		
		String slovo;
		while (true) {
			slovo = JOptionPane.showInputDialog
					("Pogodite slovo. Molim Vas, unesite samo jedno slovo."
							+ "\nUkoliko unesete više od jednog slova, program ga neæe uèitati.");
			slovo = slovo.toLowerCase();
			if (slovo.length() > 1) {
				continue;
			}
			break;
		}
		return slovo;
		
	}
	
	public static String provjeraIspravnostiUnosa(String slovo) throws ObavezanUnosSlova {
		String abc = "q,w,e,r,t,z,u,i,o,p,š,ð,a,s,d,f,g,h,j,k,l,è,æ,ž,y,x,c,v,b,n,m";
		List<String> lista = new ArrayList<String>(Arrays.asList(abc.split(",")));
		
		if (lista.contains(slovo) == true) {
			return slovo;
		}else {
			throw new ObavezanUnosSlova("Morate unijeti slovo, a ne neki broj ili znak.");
		}
		
	}
	
	public static boolean slovoSeNalaziURijeèi(String slovo, String rijeè) {
		boolean sadrziSlovo;
		List<String> listaSlovaOdRijeèi = new ArrayList<String>(Arrays.asList(rijeè.split("")));
		
		if (listaSlovaOdRijeèi.contains(slovo) == true) {
			sadrziSlovo = true;
		}else {
			sadrziSlovo = false;
		}	
		return sadrziSlovo;
	}
	
	public static void ispisiSkrivenuRijec(char[] niz) {
		for (int i = 0; i < niz.length; i++) {
			System.out.print("-");
		}
	}
	
	public static boolean korisnikPogadjaCijeluRijec(String rijec) {
		String korisnikovUnos;
		while(true) {
			korisnikovUnos = JOptionPane.showInputDialog("Pogaðajte rijeè!\nUkoliko želite, sada možete pokušati "
					+ "pogoditi cijelu rijeè!\nAko smatrate da to još ne možete, upišite \"dalje\"!");
			korisnikovUnos = korisnikovUnos.toLowerCase();
			if (korisnikovUnos.length() > rijec.length()) {
				JOptionPane.showMessageDialog(null, "Vaš unos je veæi od rijeèi :/");
				continue;
			}
				break;
		}
		if (korisnikovUnos.equals(rijec)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public static void ispisiTrenutnoStanjeRijeci(List<Character> korisnikoviPokusaji, char[] niz) {
		for(int i = 0; i < niz.length; i++) {
			if (korisnikoviPokusaji.contains(niz[i])) {
				System.out.print(niz[i]);
			}else {
				System.out.print("-");
			}
		}
	}
	
	public static void ispisiSveKorisnikovePokusaje(List<Character> korisnikoviPokusaji) {
		System.out.print("Dosad unesena slova: ");
		for (Character character : korisnikoviPokusaji) {
			System.out.print(character + ", ");
		}
		System.out.println();
	}
	
}