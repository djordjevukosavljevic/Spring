package rs.ac.singidunum.fir.pj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
		
		/*
		Kamera kamera = (Kamera) context.getBean("kamera");
		kamera.napraviFotografiju();
		
		kamera.napraviFotografiju(1000);
		
		*/
		
		Telefon telefon = (Telefon) context.getBean("telefon");
		try{
			telefon.pozovi("123456789", true);
			
		} catch (Exception e) {
			
		}
			
		((FileSystemXmlApplicationContext)context).close();
		
	}	

}
