package process;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import shell.Minishell;
import shell.Process;


public class Find extends Process{

	public Find(String commande) {
		super(commande);		
	}
	
	public void findFilesName(File directory, String regexp){
		File[] listFiles = directory.listFiles();
		Pattern p = Pattern.compile(regexp);
		for (File f: listFiles){
			if(f.isDirectory()){
				findFilesName(f,regexp);
			}
			else{
				Matcher m = p.matcher(f.getName());
				if (m.matches()) 
					System.out.println(f.getName());
			}
		}
	}
	
	public void findFilesIName(File directory, String regexp){
		File[] listFiles = directory.listFiles();
		Pattern p = Pattern.compile(regexp.toUpperCase());
		for (File f: listFiles){
			if(f.isDirectory()){
				findFilesIName(f,regexp);
			}
			else{
				Matcher m = p.matcher(f.getName().toUpperCase());
				if (m.matches()) 
					System.out.println(f.getName());
			}
		}
	}
	
	@Override
	public void run() {
		try{
			//Sera instancié en fonction du chemin donné par l'utilisateur
			File directory;
			
			//On renvoie le tableau de chaînes calculés en divisant cette chaîne 
			String[] args = commande.split("\\s+");
			//On enleve les chaine de caracteres vides de notre tableau
			args = removeNullValue(args);
			String path = args[1];
			String option = args[2];
			String regexp = args[3];
		
			//On fais des tests sur le chemin donné en argument et on verifie qu'il est bien valide
			if (path.indexOf("/", 1) == 0) {
				directory = new File(path);
				if (directory.isDirectory() == true) {
					Minishell.setCurrentDir(path);
					System.out.println(directory.getCanonicalPath());
				} 
				else {
					System.out.println(Minishell.getCurrentDir()+File.separatorChar+path + " n'est pas un repertoire.");
					throw new MauvaiseSyntaxeException();
				}
			}
			else{
				directory = new File (Minishell.getCurrentDir()+File.separatorChar+path);
				if (directory.isDirectory() == true) {
					Minishell.setCurrentDir(directory.getCanonicalPath());
					System.out.println(directory.getCanonicalPath());
				} 
				else {
					System.out.println(Minishell.getCurrentDir()+File.separatorChar+path+ " n'est pas un repertoire.");
					throw new MauvaiseSyntaxeException();
				}
			}
			
			//On s'occupe maintenant de trouver les fichiers
			//et on verifie que l'option donnée est correcte (pour nous, que c'est bien les options -name ou -iname)
			if(option.equals("-name")){
				findFilesName(directory,regexp);
			}
			else if(option.equals("-iname")){
				findFilesIName(directory,regexp);
				
			}
			else{
				System.out.println("Verifiez l'option choisie.");
				throw new MauvaiseSyntaxeException();
			}
			
			
			
		
		} catch (PatternSyntaxException e) {
			System.out.println("Mauvaise expression régulière");
			e.printStackTrace();
		} catch (MauvaiseSyntaxeException i) {
			System.out.println("Commande incorrecte, la syntaxe est :\n find <..>|<sous-répertoire>|<chemin absolu> -name <expr. reg.>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void regexp() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
