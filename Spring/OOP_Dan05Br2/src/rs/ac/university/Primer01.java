package rs.ac.university;

import java.util.List;
import java.util.stream.Collectors;

import rs.ac.university.api.TestProvider;
import rs.ac.university.models.Test;

public class Primer01 {

	public static void main(String[] args) {
		List<Test> testovi = TestProvider.getAll();
		
		// 1: Izracunati prosecan broj bodova na svim testovima
		// na predmetu sa kodom "oop"
		
		// Nacin a)
		double sum = 0;
		int count = 0;
		for(Test test : testovi) {
			if(test.getSubject().getCode().equals("OOP")) {
				sum += test.getScore();
				count++;
			}
		}
		if(count == 0) {
			System.out.println("Nema testova za ovaj predmet");
		} else {
			double average = sum/count;
			System.out.println("Prosek je: " + average);
		}
		
		// Nacin b)
		double average = testovi
		.stream()
		.filter(test -> test.getSubject().getCode().equals("OOP"))
		.mapToDouble(test -> test.getScore())//(Test::getScore) 
		.average()
		.getAsDouble();
		System.out.println("Prosek je: " + average);
		
		
		
		// 2. Prikazati podatke o bodovima za testove predmeta sa kodom "opj"
		// Poredjane po datumu
		// Datum Ime Prezime Indeks Broj_bodova
		
		
		testovi
		.stream()
		.filter(test -> test.getSubject().getCode().equals("OOP"))
		.sorted((a,b) -> a.getStudent().getIndex().compareTo(b.getStudent().getIndex()))
		.forEach(test ->  {
			System.out.printf(
					"%s %30s %30s %10.2f\n",
					test.getDateIso(),
					test.getStudent().getForename() + " " + test.getStudent().getSurrname(),
					test.getStudent().getIndex(),
					test.getScore()
					);
		});
		
		
		
		// 3. Grupisati testove po predmetu, pa prikazati sve testove za taj
		// predmet poredjanje po broju indexa
		
		testovi
		.stream()
		.collect(Collectors.groupingBy(test -> test.getSubject()))
		.forEach((subject, testoviPredmeta) -> {
			System.out.println("Testovi za predmet: " + subject.getName() + " - " + subject.getCode() + " su:");
			testoviPredmeta
			.stream()
			.sorted((a,b) -> a.getStudent().getIndex().compareTo(b.getStudent().getIndex()))
			.forEach(test ->  {
				System.out.printf(
						"%s %30s %30s %10.2f\n",
						test.getDateIso(),
						test.getStudent().getForename() + " " + test.getStudent().getSurrname(),
						test.getStudent().getIndex(),
						test.getScore()
						);
			});
			System.out.println();
		});
	}

}
