package pjbgzadatak6.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

class Aranzman {
	private int brDana;
	private double cena;
	private String destinacija;
	
	public Aranzman(int brDana, double cena, String destinacija) {
		this.brDana = brDana;
		this.cena = cena;
		this.destinacija = destinacija;
	}

	public int getBrDana() {
		return brDana;
	}

	public double getCena() {
		return cena;
	}

	public String getDestinacija() {
		return destinacija;
	}

	@Override
	public String toString() {
		String result = "";
		result += "Destinacija: " + destinacija + "\n" + "Cena: " + cena + "\n" + "Broj dana: " + brDana;
		return result;
	}
}

class Konekcija extends Thread{
	private Socket soket;
	private int brKlijenata;
	List<Aranzman> lista;

	public Konekcija(Socket soket, int brKlijenata, List<Aranzman> lista) {
		this.soket = soket;
		this.brKlijenata = brKlijenata;
		this.lista = lista;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(soket.getInputStream()));
			PrintWriter out = new PrintWriter(soket.getOutputStream(), true);
			System.out.println("Konektovan klijent" + brKlijenata);
			out.println("Konekcija sa serverom je uspesna. Konekotvan je klijent broj: " + brKlijenata);
			
			// Citamo cenu i broj dana koje je korisnik uneo
			
			double max = Double.parseDouble(in.readLine()); // Parsiramo vrendost da bude double
			
			int dani = Integer.parseInt(in.readLine());
			System.out.println("Klijent " + brKlijenata + " trazi apartmane cija je cena jeftinija od: " + max + "€" );
	
			for(Aranzman a1 : lista) {
				if(a1.getCena() <= max && a1.getBrDana() >= dani) {
					out.println(a1.toString());
				}
			}
			System.out.println("Klijent sa brojem " + brKlijenata + " je zavrsio svoju pretragu");
			in.close();
			out.close();
		} catch (IOException ex) {
			System.out.println("Doslo je do greske prilikom pokretanja servera"); 
		}
	} 
}

public class PJBGZadatak6Server {

	public static void main(String[] args) throws IOException {
		List<Aranzman> lista = new ArrayList<Aranzman>();
		int max = 10;
		int min = 1;
		int range = max - min + 1;
		
		for(int i = 0; i < 10; i++) {
			lista.add(new Aranzman((int) (Math.random() * range), ((int) (Math.random() * range) * 1000.26), "Beograd"));
			
			System.out.println("Lista je formirana! Server je pokrenut!");
			int brKl = 0;
			ServerSocket server = new ServerSocket(8784);
		
			while(true) {
				new Konekcija(server.accept(), brKl++, lista).start();
			}
		}
	}

}
