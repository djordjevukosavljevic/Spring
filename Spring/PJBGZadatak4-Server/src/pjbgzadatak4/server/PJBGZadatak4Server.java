package pjbgzadatak4.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class PJBGZadatak4Server {

	public static void main(String[] args) throws IOException {
		Socket soket = null;
		try {
			ServerSocket server = new ServerSocket(9001); // PORT U LOKALNOJ MREZI (192.168.0.10:9001)
			System.out.println("U ovom trenutku server je pokrenut...");
			
			while(true) { // Visestruka konekcija
				soket = server.accept();
				System.out.println("U ovom trenutku je konektovan novi klijent...");
				
				BufferedReader in = new BufferedReader(new InputStreamReader(soket.getInputStream()));
				PrintWriter out = new PrintWriter(soket.getOutputStream(), true);
				
				out.println("Uspesna konekcija od strane klijenta!");
				System.out.println("Poruka od klijenta je sledeca: " + in.readLine());
			}
		} catch (IOException ex) {
			System.out.println("Doslo je do greske prilikom pokretanja instance servera");
		} finally {				// Ovaj deo koda ce se uvek izvrsiti
			soket.close();
		}
		
	}

}
