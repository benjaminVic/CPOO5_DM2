import java.util.*;


public class Minishell {
	
	private String currentDir;
	private List<Process> listProcess;
	
	public Minishell(){
		this.currentDir = "user.dir";
		setListProcess(new ArrayList<Process>());	
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
