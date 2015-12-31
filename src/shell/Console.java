package shell;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class Console {
	/*static String s = null;
	static Scanner scan = new Scanner(System.in);*/
	
	private static InputStreamReader in = new InputStreamReader(System.in);
	private static OutputStreamWriter out = new OutputStreamWriter(System.out);
	
	public static final BufferedReader stdInput = new BufferedReader(in);
	public static final BufferedWriter stdOutput = new BufferedWriter(out);	
	
	/*public static int write(BufferedWriter stdOut){
		System.out.print("MinishellPrompt$ ");
		String input = scan.nextLine();
		if(input.equals("quit")){
			return 1;
		}
		input += "\n";		
		try {
			stdOut.write(input);			
			stdOut.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return 0;
	}*/
	
	/*public static void read(BufferedReader stdInput) {
		try {
			while ((s = stdInput.readLine()) != null) {
				System.out.println(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	
	public static void main(String[] args){		
		
		try {
			Minishell m = new Minishell();
			String lastLine;
			do{
				System.out.print("MinishellPrompt$ ");
				lastLine = stdInput.readLine();
				m.processMatcher(lastLine);
			} while(!Objects.equals(lastLine,"quit"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * ExecutorService execute = Executors.newSingleThreadExecutor();
		 * 
		 * Future<Long> ft1 = execute.submit(new Callable(chemin));
		 * ft1.get();
		 * 
		 * FutureTask<>ftt1 = new FutureTask<>(c1);
		 * 
		 * execute.shutdown();
		 * 
		 * */
		
		/*try {
			
			ProcessBuilder builder = new ProcessBuilder("/bin/bash");
			builder.redirectErrorStream(true);
			java.lang.Process p = builder.start();

			final BufferedReader stdInput = new BufferedReader
					(new InputStreamReader (p.getInputStream()) );
			final BufferedWriter stdOutput = new BufferedWriter
					(new OutputStreamWriter (p.getOutputStream()) );			

			ExecutorService execute = Executors.newSingleThreadExecutor();
			
			Callable<Integer> write = new Callable<Integer>(){
				public Integer call() throws Exception {
					return write(stdOutput);
				}			
			};
			Future<Integer> ft1 = execute.submit(write);*/
			
			/*FutureTask<Void> ftwrite = new FutureTask<Void>(write);
			threadWrite = new Thread(ftwrite);
		    threadWrite.start();*/
			/*
		    Callable<Void> read = new Callable<Void>(){
				public Void call() throws Exception {
					read(stdInput);
					return null;
				}			
			};
			Future<Void> ft2 = execute.submit(read);
			
			while(ft1.get()!=1){
				write(stdOutput);
			}*/
			
			
			/*FutureTask<Void> ftread = new FutureTask<Void>(read);
			threadRead = new Thread(ftread);
			threadRead.start();*/
		    
			
			/*Runnable write = new Runnable() {
		        public void run() {
		        	write(stdOutput);
		        }
			};	      
		    threadWrite = new Thread(write, "threadWrite");
		    threadWrite.start();
			
		    
		    Runnable read = new Runnable() {
		        public void run() {
		        	read(stdInput);
		        }
			};	      
		    threadRead = new Thread(read, "threadRead");	    
		    threadRead.start();	
		    	
			while(threadWrite.isAlive()){
				
			}
			
			if((stdInput.readLine()) != "quit"){
				if(!threadWrite.isAlive()){
					write(stdOutput);
				}
			}	*/		
			
		/*	execute.shutdown();		
		} 
		catch (IOException e) {
			e.printStackTrace();	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
	}

}
