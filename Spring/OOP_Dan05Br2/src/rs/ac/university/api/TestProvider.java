package rs.ac.university.api;

import java.util.ArrayList;
import java.util.List;

import rs.ac.university.models.Student;
import rs.ac.university.models.Subject;
import rs.ac.university.models.Test;

public class TestProvider {
	public static List<Test> getAll(){
		List<Test> testovi = new ArrayList<>();
		
		Subject opj = new Subject("Osnove programiranja - Java", "OPJ");
		Subject oop = new Subject("Objektno orjentisano programiranje - Java", "OOP");
		Subject mat = new Subject("Matematika", "MAT1");
		Subject bp = new Subject("Baze podataka ", "BP2");
		
		Student pperic = new Student("Pera", "Peric", "2021302403");
		Student mmilic = new Student("Milica", "Milic", "2020202343");
		Student nnikic = new Student("Nikolina", "Nikic", "2018904921");
		Student jjocic = new Student("Jovana", "Jocic", "2022402493");
		Student llukic = new Student("Ljiljana", "Lukic", "2019102932");
		
		testovi.add(new Test(opj, llukic, "2021-06-13", 22.45));
		testovi.add(new Test(opj, pperic, "2021-06-13", 18.23));
		testovi.add(new Test(opj, mmilic, "2021-06-13", 26.22));
		testovi.add(new Test(opj, nnikic, "2021-06-13", 21.78));
		testovi.add(new Test(opj, jjocic, "2021-06-13", 19.56));
		
		testovi.add(new Test(mat, llukic, "2021-06-26", 25.32));
		testovi.add(new Test(mat, pperic, "2021-06-26", 6.21));
		testovi.add(new Test(mat, mmilic, "2021-06-26", 17.11));
		testovi.add(new Test(mat, nnikic, "2021-06-26", 11.23));
		testovi.add(new Test(mat, jjocic, "2021-06-26", 22.33));
		
		testovi.add(new Test(oop, llukic, "2021-07-03", 10.11));
		testovi.add(new Test(oop, pperic, "2021-07-03", 8.76));
		testovi.add(new Test(oop, mmilic, "2021-07-03", 11.11));
		testovi.add(new Test(oop, nnikic, "2021-07-03", 25.43));
		testovi.add(new Test(oop, jjocic, "2021-07-03", 16.99));
		
		testovi.add(new Test(bp, llukic, "2021-07-09", 19.45));
		testovi.add(new Test(bp, pperic, "2021-07-09", 22.43));
		testovi.add(new Test(bp, mmilic, "2021-07-09", 23.78));
		testovi.add(new Test(bp, nnikic, "2021-07-09", 29.33));
		testovi.add(new Test(bp, jjocic, "2021-07-09", 27.02));
		
		return testovi;
	}
}
