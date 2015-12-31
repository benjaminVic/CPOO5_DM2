package shell;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import process.MauvaiseSyntaxeException;

public abstract class Process implements Runnable{
	

	//L'atomic interger permet d'avoir un pid distinct pour chaque Thread
	protected static AtomicInteger pid = new AtomicInteger(0);
	protected final int currentProcessPid;
	protected String regexp;
	protected String commande;
	protected String localDir;
	
	
	/**
	 * Constructeur de Process
	 * @param commande : la commande dont la synthae sera vérifiée
	 */
	public Process(String commande){
		this.currentProcessPid = pid.incrementAndGet();
		this.regexp = "";
		this.commande = commande;
		this.localDir = Minishell.getCurrentDir();
	}
	
	/**
	 * Compare l'expression régulière avec l'entré utilisateur et lève une Exception si besoin
	 * @throws MauvaiseSyntaxeException : Indique une erreur de l'entrée utilisateur
	 */
	public void regexp() throws Exception {
		Pattern p = Pattern.compile(this.regexp);
		Matcher m = p.matcher(this.commande);
		if (!m.matches()) throw new MauvaiseSyntaxeException();
	}
	
	/**
	 * Indique la pid du processus
	 * @return : int du pid
	 */
	public int getPid(){
		return this.currentProcessPid;
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

	public static String[] removeNullValue(String[] v) {
	    List<String> list = new ArrayList<String>();
	    for(String s : v) {
	        if(s != null && s.length() > 0) {
	           list.add(s);
	        }
	     }
	     v = list.toArray(new String[list.size()]);
	     return v;
	}
}
