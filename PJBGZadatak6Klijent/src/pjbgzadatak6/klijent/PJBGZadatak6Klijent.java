package pjbgzadatak6.klijent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class PJBGZadatak6Klijent {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Socket soket = new Socket("localhost", 9091);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(soket.getInputStream()));
		PrintWriter out = new PrintWriter(soket.getOutputStream(), true);
		
		System.out.println(in.readLine());
		System.out.println("Unesite maksimalnu cenu aranzmana: ");
		// Saljemo cenu ka serveru
		out.println(sc.nextDouble());
		System.out.println("Unesite minimalan broj dana koji zelite: ");
		// Saljemo broj dana ka serveru
		out.println(sc.nextInt());
		
		String ss;
		
		while((ss = in.readLine()) != null) {
			System.out.println(ss);
		}
		System.out.println("Korisnik zavrsio pretragu!");
		in.close();
		out.close();
		soket.close();
	}

}
