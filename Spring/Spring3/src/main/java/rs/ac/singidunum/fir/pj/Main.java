package rs.ac.singidunum.fir.pj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		/*
		// Tradicionalan nacin 
		KonzolniPisac kp = new KonzolniPisac();
		FajlPisac fp = new FajlPisac();
		
		Loger loger = new Loger();
		loger.setFajlPisac(fp);
		loger.setKonzolniPisac(kp);
		
		loger.pisiNaKonzolu("Hello.");
		loger.pisiUFajl("Hello again.");
		*/
		
		ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
		
		
		Loger loger = (Loger) context.getBean("loger");
		loger.pisiUFajl("Zdravo");
		loger.pisiNaKonzolu("Zdravo opet");
		
		
		KonzolniPisac kp = (KonzolniPisac) context.getBean("konzola");
		kp.pisiLiniju("Tekst iz konzole");

		((FileSystemXmlApplicationContext)context).close();
	}

}
