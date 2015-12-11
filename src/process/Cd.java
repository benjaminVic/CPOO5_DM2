package process;

import java.io.File;

import shell.Process;


public class Cd extends Process{

	public Cd(String commande) {
		super(commande);
		this.regexp = "[\\s]*cd[\\s]+" +"(/)?" + /*File.separator +"?"+*/"(([^\\/:*?\"<>|]+[\\s]*)*|(.)|(..))"/*+ File.separator*/ +"(/)?"; //TODO FORMAT FOR FILESYSTEM PATH
		System.out.println(regexp);
	}
	
	/*EXO5
	 * gère les sous-domaines && www.
	 * "((https?://))(%s.)+%s(%s)* /?"
	 * "[a-ZA-Z]+"+
	 * "((ca)|(fr)|(org)|(com)|(co.uk))"+
	 * "[a-zA-Z]+"
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
	}


}
