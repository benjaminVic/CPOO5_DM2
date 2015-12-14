package shell;

import java.io.*;
import java.util.*;

public class Console {
	static String s = null;
	static Scanner scan = new Scanner(System.in);
	
	static Thread threadRead;
	static Thread threadWrite; 
	static Thread threadReadError;
	
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
	
	public static void readError(BufferedReader stdError) {
		try {
			while ((s = stdError.readLine()) != null) {
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
			final BufferedReader stdError = new BufferedReader
					(new InputStreamReader (p.getErrorStream()) );

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
		    
		    Runnable readError = new Runnable() {
		        public void run() {
		        	readError(stdError);
		        }
			};	      
		    threadReadError = new Thread(readError, "threadReadError");
		    threadReadError.start();
		    
		    
			if((stdInput.readLine()) != "quit"){
				System.out.println("_________________!=quit");
				write(stdOutput);
			}
			
					
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
