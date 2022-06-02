package rs.ac.singidunum.fir.pj;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Loger {
	
	@Pointcut("execution (void rs.ac.singidunum.fir.pj.Telefon.posaljiPoruku())")
	public void telefonPoruka() {
		// prazna, dummy metoda, sluzi iskljucivo da nosi anotaciju za pointCut
	}
	
	@Pointcut("execution (void rs.ac.singidunum.fir.pj.Kamera.napraviFotografiju())")
	public void kameraSnimak() {
		// prazna, dummy metoda, sluzi iskljucivo da nosi anotaciju za pointCut
	}
	
	// obuhvatamo sve metode sa imenom napraviFotografiju(), void tip povratnog podatka
	// i ne razmatramo argument
	@Pointcut("execution (void rs.ac.singidunum.fir.pj.Kamera.napraviFotografiju(..))")
	public void kameraSnimak2() {
		// prazna, dummy metoda, sluzi iskljucivo da nosi anotaciju za pointCut
	}
	
	// sve metode napraviFotografiju nevezano za argumente i povratni tip
	@Pointcut("execution (* rs.ac.singidunum.fir.pj.Kamera.napraviFotografiju(..))")
	public void kameraSnimak3() {
		// prazna, dummy metoda, sluzi iskljucivo da nosi anotaciju za pointCut
	}
	
	
	// @Pointcut("execution (* *.*(..)") // - Bilo koji tip*, Bilo koja klasa * ., Bilo koja metoda*, sa bilo kojim parametrima (..)

	
	@Before("kameraSnimak3()")
	public void preSnimanjaKamerom() {
		System.out.println("Loger: pre snimanja");
	}
	
	@After("kameraSnimak3()")
	public void posleSnimanjaKamerom() {
		System.out.println("Loger: posle snimanja");
	}
	
	@AfterReturning("telefonPoruka()")
	public void posleUspesnogSlanjaPoruke() {
		System.out.println("Loger: Poruka uspesno poslata.");
	}
	
	@AfterThrowing("telefonPoruka()")
	public void posleNeuspesnogSlanjaPoruke() {
		System.out.println("Loger: Poruka nije uspesno poslata.");
	}
	
	@Around("telefonPoruka()")
	public void aroundAdvice(ProceedingJoinPoint p) {
		System.out.println("Loger: Around advice (before)...");
		try {
			p.proceed();
			System.out.println("Loger: in Around advice: Successfull returning");
		} catch (Throwable e) {
			System.out.println("Loger: in Around advice..." + e.getMessage());
		}
		
		System.out.println("Around advice (after)...");
	}
	
	@Pointcut("execution (* rs.ac.singidunum.fir.pj.Telefon.pozovi(..))")
	public void telefonPozovi() {
		
	}
	
	@Before("telefonPozovi()")
	public void hvatanjeArgumenata(JoinPoint jp) {
		System.out.println("Loger: pozvana metoda pozovi()");
		System.out.println("Loger: presretanje argumenata pozvane metode");
		
		for(Object obj: jp.getArgs()) {
			System.out.println("ARG: " + obj);
		}  
		
		Object[] args = jp.getArgs();
		String brojTelefona = (String) args[0];
		System.out.println("Loger: pozvani broj telefona je: " + brojTelefona);
	}
}
