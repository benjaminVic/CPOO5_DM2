package shell;

import java.io.*;
import java.util.*;

public class Console {
	static String s = null;
	static Scanner scan = new Scanner(System.in);
	
	static Thread threadRead;
	static Thread threadWrite; 	
	
	public static void write(BufferedWriter stdOut){
		System.out.print("MinishellPrompt$ ");
		String input = scan.nextLine();
		input += "\n";		
		try {
			stdOut.write(input);			
			stdOut.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public static void read(BufferedReader stdInput) {
		try {
			while ((s = stdInput.readLine()) != null) {
				System.out.println(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){		
		
		try {
			
			ProcessBuilder builder = new ProcessBuilder("/bin/bash");
			builder.redirectErrorStream(true);
			java.lang.Process p = builder.start();

			final BufferedReader stdInput = new BufferedReader
					(new InputStreamReader (p.getInputStream()) );
			final BufferedWriter stdOutput = new BufferedWriter
					(new OutputStreamWriter (p.getOutputStream()) );			

			Runnable write = new Runnable() {
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
		    threadWrite.wait();
		    
		    System.out.println("threadread  "+threadRead.getState());
		    System.out.println("threadwrite  "+threadWrite.getState());
		    	
			if((stdInput.readLine()) != "quit"){
				if(!threadWrite.isAlive()){
					write(stdOutput);
				}
			}			
					
		} 
		catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
