package shell;

import java.io.*;
import java.util.*;

public class Console {

	private static InputStreamReader in = new InputStreamReader(System.in);
	private static OutputStreamWriter out = new OutputStreamWriter(System.out);
	
	public static final BufferedReader stdInput = new BufferedReader(in);
	public static final BufferedWriter stdOutput = new BufferedWriter(out);	
	
	public static void main(String[] args){		
		
		try {
			Minishell m = new Minishell();
			String lastLine;
			do{
				System.out.print("MinishellPrompt$ ");
				lastLine = stdInput.readLine();
				m.processMatcher(lastLine);
			} while(!Objects.equals(lastLine,"quit"));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
