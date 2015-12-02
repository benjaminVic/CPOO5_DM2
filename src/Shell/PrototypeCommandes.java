package Shell;
import java.io.File;

public class PrototypeCommandes {
	
	public static void ls(){
		String path = System.getProperty("user.dir");
		File directory = new File(path);
		String[] list = directory.list();
		for (int i =0; i<list.length; i++){
			System.out.println(list[i]);
		}
	}
	
	public static void pwd(){
		String pwd = System.getProperty("user.dir");
        System.out.println(pwd);
	}
	
	public static void cd(String[] args){
		if(args.length==2){
            File directory = new File(args[1]);
            if(directory.isDirectory()==true) {
                System.setProperty("user.dir", directory.getAbsolutePath());
            } else {
                System.out.println(args[1] + " n'est pas un repertoire.");
            }
        }
	}
	
	public static void main(String args[]){
		if(args.length==1){
			if(args[0].equals("ls")) ls();
			else if(args[0].equals("pwd")) pwd();
			else System.out.println("Pas assez d'arguments");
		}
		if(args.length==2){
			if(args[0].equals("cd")) cd(args);
		}
	}
}
