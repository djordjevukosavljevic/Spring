package rs.ac.singidunum.fir.pj;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

public class MainProgram {

	public static void main(String[] args) {
	ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
		
		OglasiDAO oglasiDao = (OglasiDAO)context.getBean("dao");
		try {
		List<Oglas> oglasi = oglasiDao.getOglasi();
		for(Oglas oglas : oglasi) {
			System.out.println(oglas);
			}
		/*
		System.out.println("Dohvatanje oglasa po ID");
		Oglas oglas = oglasiDao.getOglasbyID(1);
		System.out.println(oglas);
		
		oglasiDao.insert(new Oglas(3, "Laza Lazic", "llazic@gmail.com", "Java programer"));
		oglasiDao.insert(new Oglas(5, "Milan Mladenovic", "milanm@gmail.com", "Software arhitekta"));
		
		System.out.println("Nakon dodavanja: ");
		
		oglasi = oglasiDao.getOglasi();
		for(Oglas oglas2 : oglasi) {
			System.out.println(oglas2);
		} */
		
		} catch (CannotGetJdbcConnectionException e) {
			System.out.println("Nije moguce konektovati se na bazu...");
		} catch (DataAccessException e) {
			System.out.println("Uhvacen generalni springov dae");
		}
		((FileSystemXmlApplicationContext)context).close();
	}

}
