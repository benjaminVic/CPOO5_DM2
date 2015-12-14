package process;

import java.io.*;
import java.util.*;
import java.util.regex.PatternSyntaxException;

import shell.Minishell;
import shell.Process;


public class Cd extends Process{

	public Cd(String commande) {
		super(commande);
		this.regexp = "\\s*cd\\s+/?(([^\\/:*?\"<>|]+[\\s]*)*|(\\.)|(\\.\\.))/?";
		//TODO FORMAT FOR FILESYSTEM PATH		
		System.out.println(regexp);
	}
	
	/*EXO5
	 * gère les sous-domaines && www.
	 * "((https?://))(%s.)+%s(%s)* /?"
	 * "[a-ZA-Z]+"+
	 * "((ca)|(fr)|(org)|(com)|(co.uk))"+
	 * "[a-zA-Z]+"
	 */
	
	@Override
	public void run() {
		try{
			regexp();		
			
	        File directory = new File("1");
	        if(directory.isDirectory()==true) {
	            System.setProperty(Minishell.getCurrentDir(), directory.getAbsolutePath());
	        } else {
	            System.out.println(1 + " n'est pas un repertoire.");
	        }
			
		}
		catch (PatternSyntaxException e) {
			System.out.println("Mauvaise expression régulière");
			e.printStackTrace();
		} catch (MauvaiseSyntaxeException i) {
			//TODO Renvoyer à l'utilisateur un message indiquant sa mauvaise syntaxe
			System.out.println("Commande incorrecte, la syntaxe est :\n ps");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//TODO close thread 
		}
	}


}
