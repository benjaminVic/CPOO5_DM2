package process;

import java.io.*;
import java.util.*;
import java.util.regex.PatternSyntaxException;

import shell.Minishell;
import shell.Process;


public class Cd extends Process{

	public Cd(String commande) {
		super(commande);
		this.regexp = "uneccesary";
						//"\\s*cd\\s(([A-Z]:)?/)?(([^\\/:*?\"\\.<>|]+[\\s]*)*|(\\.\\.))/?";
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
			
			//regexp();
			String[] path = commande.split("\\s*cd\\s+");
			String cmd = purgeEmptyString(path);
			
			/*if (cmd.contains("..")) {
				int endOfPath = Minishell.getCurrentDir().lastIndexOf(File.separatorChar);
				File directory = new File(Minishell.getCurrentDir().substring(0, endOfPath));
				if (directory.isDirectory() == true) {
					Minishell.setCurrentDir(Minishell.getCurrentDir().substring(0, endOfPath));
				} else {
					System.out.println(1 + " n'est pas un repertoire.");
				}
			/*} else A PATH OR ABSOLUTE PATH{*/
				//ABSOLUTE PATH
				if (cmd.contains(":") || cmd.indexOf("/", 0) == 1) {
					File directory = new File(cmd);
					if (directory.isDirectory() == true) {
						Minishell.setCurrentDir(cmd);
						System.out.println(directory.getCanonicalPath());
					} else {
						System.out.println(Minishell.getCurrentDir()+File.separatorChar+cmd + " n'est pas un repertoire.");
						throw new MauvaiseSyntaxeException();
					}
				} else /*NORMAL PATH*/ {
					File directory = new File (Minishell.getCurrentDir()+File.separatorChar+cmd);
					if (directory.isDirectory() == true) {
							Minishell.setCurrentDir(directory.getCanonicalPath());
							System.out.println(directory.getCanonicalPath());
					} else {
						System.out.println(Minishell.getCurrentDir()+File.separatorChar+cmd + " n'est pas un repertoire.");
						throw new MauvaiseSyntaxeException();
					}
				}
			//}
			
		} catch (PatternSyntaxException e) {
			System.out.println("Mauvaise expression régulière");
			e.printStackTrace();
		} catch (MauvaiseSyntaxeException i) {
			// TODO Renvoyer à l'utilisateur un message indiquant sa mauvaise
			// syntaxe
			System.out.println("Commande incorrecte, la syntaxe est :\n cd <..>|<sous-répertoire>|<chemin absolu>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// TODO close thread
		}
	}

	/**
	 * Récupère la première cellule non-vide de sTable
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
