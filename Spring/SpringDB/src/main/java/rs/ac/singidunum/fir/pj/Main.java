package rs.ac.singidunum.fir.pj;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;


public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
		OglasiDAO oglasiDao = (OglasiDAO)context.getBean("oglasiDao");
		try {
		List<Oglas> oglasi = oglasiDao.getOglasi();
		for(Oglas oglas: oglasi) {
			System.out.println(oglas);
		}
	} catch (CannotGetJdbcConnectionException e) {
		System.out.println("Nije moguce konektovati se na bazu... ");
	} catch (DataAccessException  e) {
		System.out.println("DAE greska u springu");
	}
		((FileSystemXmlApplicationContext)context).close();
	}
}
