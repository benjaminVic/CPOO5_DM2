package Shell;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import Process.*;

import org.w3c.dom.ls.LSException;


public class Minishell {
	
	private String currentDir;
	private List<Process> listProcess;
	

	//USE ExecutorService
	
	public Minishell(){
		this.currentDir = "user.dir";
		setListProcess(new ArrayList<Process>());	
	}

	public void processMatcher(String s){
		//TODO enlever le prompt si récupéré
		String results[] = s.split("[\\s]*");
		
		switch (results[0]){
		
		case ("ls") :
			Ls l = new Ls(s);
		
			break;
		
		default :
			break;
		}
	}
	
	//_____________________GETTEURS ET SETTEURS___________________________

	public String getCurrentDir() {
		return currentDir;
	}

	public void setCurrentDir(String currentDir) {
		this.currentDir = currentDir;
	}

	public List<Process> getListProcess() {
		return listProcess;
	}

	public void setListProcess(List<Process> listProcess) {
		this.listProcess = listProcess;
	}
	
	//_____________________________________________________________________
	

	/*public void template() {
		ExecutorService es = Executors.newFixedThreadPool(4);
		Callable<Void> call = Executors.<Void>callable(task, void);
		//task : instance de commande a execter
		Future<Void> f = es.<Void>submit(task, null);
		f.get(); // appel bloquant
	}*/
	
}
