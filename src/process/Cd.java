package process;

import java.io.*;
import java.util.regex.PatternSyntaxException;

import shell.Minishell;
import shell.Process;


public class Cd extends Process{

	public Cd(String commande) {
		super(commande);
		this.regexp = "uneccesary";
						//"\\s*cd\\s(([A-Z]:)?/)?(([^\\/:*?\"\\.<>|]+[\\s]*)*|(\\.\\.))/?";
	}
	
	@Override
	public void run() {
		try {
			String[] path = commande.split("\\s*cd\\s+");
			String cmd = purgeEmptyString(path);
			
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
			} 
			//NORMAL PATH
			else {
				File directory = new File (Minishell.getCurrentDir()+File.separatorChar+cmd);
				if (directory.isDirectory() == true) {
						Minishell.setCurrentDir(directory.getCanonicalPath());
						System.out.println(directory.getCanonicalPath());
				} else {
					System.out.println(Minishell.getCurrentDir()+File.separatorChar+cmd + " n'est pas un repertoire.");
					throw new MauvaiseSyntaxeException();
				}
			}
		} 
		catch (PatternSyntaxException e) {
			System.out.println("Mauvaise expression régulière");
			e.printStackTrace();
		} 
		catch (MauvaiseSyntaxeException i) {
			System.out.println("Commande incorrecte, la syntaxe est :\n cd <..>|<sous-répertoire>|<chemin absolu>");
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
}
