package Shell;

import java.util.concurrent.atomic.AtomicInteger;

//TODO Verfier le fonctionnement de Callable et remplacer par Runnable au cas où
public abstract class Process implements Runnable{
	
	//protected long pid;//ATOMIC INT
	
	protected static AtomicInteger pid;
	//pid.getAndIncrement();
	protected final int currentProcessPid;
	protected String regexp;
	protected String commande;
	
	/**
	 * Constructeur de Process
	 * @param pid : n° unique de processus
	 */
	//TODO Faire la génération d'un pid unique basé sur une seed de temps
	public Process(String commande){
		this.currentProcessPid = pid.getAndIncrement();
		this.regexp = "";
		this.commande = commande;
	}
	
	public abstract void regexp() throws Exception;
}
