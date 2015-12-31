package process;
import java.io.File;
import java.util.regex.PatternSyntaxException;

import shell.Minishell;
import shell.Process;


public class Ls extends Process {

	public Ls(String commande) {
		super(commande);
		this.regexp = "[\\s]*ls[\\s]*";
	}

	@Override
	public void run() {
		try {
			regexp();
			File directory = new File(Minishell.getCurrentDir());
			String[] list = directory.list();
			System.out.println("Répertoire courant : "+Minishell.getCurrentDir());
			for (int i =0; i<list.length; i++){
				System.out.println(list[i]);
			}
		} 
		catch (PatternSyntaxException e) {
			System.out.println("Mauvaise expression régulière");
			e.printStackTrace();
		} 
		catch (MauvaiseSyntaxeException i) {
			System.out.println("Commande incorrecte, la syntaxe est :\n ls");
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
