package temp;
import java.io.File;
import java.util.regex.PatternSyntaxException;

import tempshell.Minishell;
import tempshell.Process;


public class Ls extends Process {

	public Ls(String commande) {
		super(commande);
		this.regexp = "[\\s]*ls[\\s]*";
	}

	@Override
	public void run() {
		// TODO Auto-generated constructor stub
		try {
			regexp();
			File directory = new File(Minishell.getCurrentDir());
			String[] list = directory.list();

			//TODO remplacer les affichage par qlq chose de plus propre
			for (int i =0; i<list.length; i++){
				System.out.println(list[i]);
			}
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
