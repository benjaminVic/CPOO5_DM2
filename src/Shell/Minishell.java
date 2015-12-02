package shell;
import java.util.*;


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
	
}
