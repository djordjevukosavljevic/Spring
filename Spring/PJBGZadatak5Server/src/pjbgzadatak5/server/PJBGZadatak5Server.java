package pjbgzadatak5.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class Konekcija extends Thread {

	private Socket soket;
	
	public Konekcija(Socket soket) {
		this.soket = soket;
	}

	@Override
	public void run() {
		System.out.println("U ovom trenutku je konektovan novi klijent na server...");
		BufferedReader in;
		try {
			in = new BufferedReader(new InputStreamReader(soket.getInputStream()));
			PrintWriter out = new PrintWriter(soket.getOutputStream(), true);
			
			out.println("Uspesna konekcija od strane klijenta!");
			System.out.println("Poruka od klijenta je: " + in.readLine());
		} catch (IOException ex) {
			System.out.println("Doslo je do greske prilikom konekcije sa serverom!");
		}
	}
}


public class PJBGZadatak5Server {

	public static void main(String[] args) throws IOException {
		Socket socket = null;
		ServerSocket server = new ServerSocket(9001);
		System.out.println("U ovom trenutku server je pokrenut...");
		
		try {
			while(true) {
				new Konekcija(server.accept()).start();
			}
		} catch (IOException ex) {
			System.out.println("Doslo je do greske prilikom pokretanja servera");
		} finally {
			socket.close();
		}
		
	}

}
