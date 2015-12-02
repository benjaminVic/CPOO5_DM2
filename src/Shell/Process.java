package Shell;

import java.util.concurrent.Callable;

//TODO Verfier le fonctionnement de Callable et remplacer par Runnable au cas où
public abstract class Process implements Callable<Process>{
	
	protected int pid;
	protected String regexp;
	
	/**
	 * Constructeur de Process
	 * @param pid : n° unique de processus
	 */
	//TODO Faire la génération d'un pid unique basé sur une seed de temps
	public Process(int pid){
		this.pid = pid;
		this.regexp = "";
	}
	
	public abstract void regexp(String toEvaluate) throws Exception;
}
