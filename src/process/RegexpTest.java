package process;

import static org.junit.Assert.*;

import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

import shell.Minishell;

public class RegexpTest {
	
	@Test
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
	}
	
	@Test
	public void cdTest(){
		Minishell ms = new Minishell();
		//String s = "         cd JE MAnGE D3S Nà0S";
		String s = " cd ..";
		Cd cd = new Cd(s);		
		try {
			cd.regexp();
		} catch (Exception e) {
			e.printStackTrace();
			fail("this string is wrong");
		}
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
	}
	
}
