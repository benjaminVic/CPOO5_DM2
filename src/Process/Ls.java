package Process;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import Shell.Process;


public class Ls extends Process {

	public Ls(String commande) {
		super(commande);
		this.regexp = "[\\s]*ls[\\s]*";
	}

	public void regexp() throws Exception {
		Pattern p = Pattern.compile(this.regexp);
		Matcher m = p.matcher(this.commande);
		
		if (!m.matches()) throw new MauvaiseSyntaxeException();
	}

	@Override
	public void run() {
		// TODO Auto-generated constructor stub
		try {
			regexp();
			System.out.println("IT IS ALIVE");
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
