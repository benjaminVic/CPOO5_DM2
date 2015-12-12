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
			//TODO CHANGE TO PROPER STREAM
	        System.out.println(Minishell.getCurrentDir());
		} catch (PatternSyntaxException e) {
			System.out.println("Mauvaise expression régulière");
			e.printStackTrace();
		} catch (MauvaiseSyntaxeException i) {
			//TODO Renvoyer à l'utilisateur un message indiquant sa mauvaise syntaxe
			System.out.println("Commande incorrecte, la syntaxe est :\n ls");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//TODO close thread 
		}
	}

}
