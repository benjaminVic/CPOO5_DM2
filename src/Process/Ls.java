package process;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import shell.Process;


public class Ls extends Process {

	public Ls(int pid, String commande) {
		super(pid, commande);
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
		} catch (PatternSyntaxException e) {
			System.out.println("Mauvaise expression régulière");
			e.printStackTrace();
		} catch (MauvaiseSyntaxeException i) {
			//TODO Renvoyer à l'utilisateur un message indiquant sa mauvaise syntaxe
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//TODO close thread 
		}
	}

}
