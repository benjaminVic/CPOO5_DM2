package Process;

import Shell.Process;


public class Cd extends Process{

	public Cd(String commande) {
		super(commande);
		this.regexp = "[\\s]*cd[\\s]*" + ""; //TODO FORMAT FOR FILESYSTEM PATH
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	}


}
