package Shell;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Process.MauvaiseSyntaxeException;

//TODO Verfier le fonctionnement de Callable et remplacer par Runnable au cas où
public abstract class Process implements Runnable{
	
	//protected long pid;//ATOMIC INT
	
	protected static AtomicInteger pid = new AtomicInteger(0);
	//pid.getAndIncrement();
	protected final int currentProcessPid;
	protected String regexp;
	protected String commande;
	protected String localDir;
	
	/**
	 * Constructeur de Process
	 * @param pid : n° unique de processus
	 */
	//TODO Faire la génération d'un pid unique basé sur une seed de temps
	public Process(String commande){
		this.currentProcessPid = pid.incrementAndGet();
		this.regexp = "";
		this.commande = commande;
		this.localDir = Minishell.getCurrentDir();
	}
	
	public void regexp() throws Exception {
		Pattern p = Pattern.compile(this.regexp);
		Matcher m = p.matcher(this.commande);
		
		if (!m.matches()) throw new MauvaiseSyntaxeException();
	}
}
