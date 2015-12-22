package process;

import shell.Process;


public class Date extends Process{

	/*
	%d : jour du mois (01-31)
	%H : heure /24 (0-23)
	%m : mois (01-12)
	%M : minute (00-59)
	%Y : année (ex : 2015)
	*/
	//Liste des caractères supportés : G y Y M w W D d F E u a H k K h m s S z Z X
	public Date(String commande) {
		super(commande);
		// TODO finish regexp
		this.regexp = "[\\s]*date([\\s]+\\+[])?";
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	}

}
