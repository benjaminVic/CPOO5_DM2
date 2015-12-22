package process;

import static org.junit.Assert.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

import shell.Minishell;

public class RegexpTest {
	
/*	@Test
	public void testLs() {
		Ls l = new Ls("ls");		
		try {
			l.regexp();
		} catch (Exception e) {
			e.printStackTrace();
			fail("this regular expression is wrong");
		}
		
		l = new Ls("     ls    ");		
		try {
			l.regexp();
		} catch (Exception e) {
			e.printStackTrace();
			fail("this regular expression is wrong");
		}
	}

	@Test
	public void lsTest(){
		ExecutorService es = Executors.newFixedThreadPool(10);
		Runnable l = new Ls(" ls  ");
		//task : instance de commande a execter
		Future<Void> f = es.<Void>submit(l, null);
		try {
			f.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // appel bloquant
		if (!System.getProperty("os.name").contains("Windows")){
			fail("HAHA t'es sur mac hafça :p");
		}
	}*/
	
	/*@Test
	public void cdTest(){
		String s = "         cd ../..";
		//String s = " cd C:\\Windows\\System32\\Dism";
		//String s = " cd ..";
		Cd cd = new Cd(s);
		ExecutorService es = Executors.newFixedThreadPool(10);
		//task : instance de commande a execter
		Future<Void> f = es.<Void>submit(cd, null);
		try {
			f.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // appel bloquant
		if (!System.getProperty("os.name").contains("Windows")){
			fail("HAHA t'es sur mac hafça :p");
		}
	}*/
	
	@Test
	public void dateTest(){
		/*SimpleDateFormat sdf = new SimpleDateFormat("YYYYYYYYYYY");
		java.util.Date date = new java.util.Date();
		//sdf.format("yyyy.mm.dd");
		System.out.println(sdf.format(date));*/
		String s = " date +";
		Date date = new Date(s);
		try {
			date.regexp();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Mauvaise expression");
		}
	}
}
