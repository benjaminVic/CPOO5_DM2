package process;

import java.util.List;
import java.util.regex.PatternSyntaxException;

import shell.Minishell;
import shell.Process;


public class Ps extends Process{

	public Ps(String commande) {
		super(commande);
		this.regexp = "[\\s]*ps[\\s]*";
	}

	@Override
	public void run() {
		try {
			regexp();
			List<Process> list = Minishell.getListProcess();

			//TODO arranger l'zffichage
			System.out.println("PID  \t\t CMD");
			for (int i =0; i<list.size(); i++){
				System.out.println(list.get(i).getPid()+"\t"+list.get(i));
			}
		} catch (PatternSyntaxException e) {
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
