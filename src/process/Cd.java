package process;

import java.io.*;
import java.util.*;
import java.util.regex.PatternSyntaxException;

import shell.Minishell;
import shell.Process;


public class Cd extends Process{

	public Cd(String commande) {
		super(commande);
		this.regexp = "\\s*cd\\s+"/*/?*/+"(([^\\/:*?\"\\.<>|]+[\\s]*)*|(\\.\\.))"/*/?"*/;
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
		try {
			regexp();
			String[] path = commande.split("\\s*cd\\s+");
			String cmd = purgeEmptyString(path);
			
			if (path[0].contains("..")) {
				int endOfPath = path[0].lastIndexOf("/");
				//TODO HANDLE \
					File directory = new File(path[0].substring(0, endOfPath));
					System.out.println(directory);
			} else {
				//TODO HANDLE ABSOLUTE PATH
				File directory = new File(Minishell.getCurrentDir() + "/"
						+ path[0]);
				if (directory.isDirectory() == true) {
					System.setProperty(Minishell.getCurrentDir(),
							directory.getAbsolutePath());
				} else {
					System.out.println(1 + " n'est pas un repertoire.");
				}
			}
		} catch (PatternSyntaxException e) {
			System.out.println("Mauvaise expression régulière");
			e.printStackTrace();
		} catch (MauvaiseSyntaxeException i) {
			// TODO Renvoyer à l'utilisateur un message indiquant sa mauvaise
			// syntaxe
			System.out.println("Commande incorrecte, la syntaxe est :\n ps");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// TODO close thread
		}
	}

	/**
	 * 
	 * @param sTable : tableau généré via la commande
	 * @return : String n'étant pas "" donc le path ou ..
	 */
	public String purgeEmptyString(String[] sTable){
		for (int i = 0; i<sTable.length ; ++i){
			if (!Objects.equals(sTable[i],"")){
				return sTable[i];
			}
		}
		return null;
	}
	
}
