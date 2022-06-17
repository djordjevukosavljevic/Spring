package pjbgzadatak4.klijent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class PJBGZadatak4Klijent {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		Socket soket = new Socket("localhost", 9001);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(soket.getInputStream()));
		PrintWriter out = new PrintWriter(soket.getOutputStream(), true);
		
		System.out.println(in.readLine()); // Dostavlja informaciju od servera da je konekcija uspesna
		
		out.println(sc.nextLine()); // Klijent salje informacije ka serveru
		
	}

}
  