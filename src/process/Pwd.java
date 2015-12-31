package process;

import java.util.regex.PatternSyntaxException;

import shell.Minishell;
import shell.Process;


public class Pwd extends Process{

	public Pwd(String commande) {
		super(commande);
		this.regexp = "[\\s]*pwd[\\s]*";
	}

	@Override
	public void run() {
		try {
			regexp();
	        System.out.println(Minishell.getCurrentDir());
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
