package shell;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import process.Ls;


public class Minishell {
	//De la forme C:\Users\Hoddafas Doaken\Documents\GitHub\CPOO5_DM2
	private static String currentDir;
	private List<Process> listProcess;
	

	//USE ExecutorService
	
	public Minishell(){
		currentDir = System.getProperty("user.dir");
		System.out.println(currentDir);
		setListProcess(new ArrayList<Process>());	
	}

	public void processMatcher(String s){
		//TODO enlever le prompt si récupéré
		String results[] = s.split("[\\s]*");
		//10 est une valeur arbitraire
		ExecutorService es = Executors.newFixedThreadPool(10);
		switch (results[0]){
		
		case ("ls") :
			Ls l = new Ls(s);
		
			break;
		
		default :
			break;
		}
	}
	
	//_____________________GETTEURS ET SETTEURS___________________________

	public static String getCurrentDir() {
		return currentDir;
	}

	public static void setCurrentDir(String currentDir) {
		currentDir = currentDir;
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
