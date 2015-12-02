package shell;

import java.util.concurrent.Callable;

//TODO Verfier le fonctionnement de Callable et remplacer par Runnable au cas où
public abstract class Process implements Runnable{
	
	protected int pid;
	protected String regexp;
	protected String commande;
	
	/**
	 * Constructeur de Process
	 * @param pid : n° unique de processus
	 */
	//TODO Faire la génération d'un pid unique basé sur une seed de temps
	public Process(int pid, String commande){
		this.pid = pid;
		this.regexp = "";
		this.commande = commande;
	}
	
	public abstract void regexp() throws Exception;
}
