package shell;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import process.*;


public class Minishell {
	private static String currentDir;
	private static Map<Process,Future<Void>> mapProcess;
	
	/**
	 * Instance un minishell dont le répertoire est celui de l'executable
	 */
	public Minishell(){
		currentDir = System.getProperty("user.dir");
		//System.out.println(currentDir);
		mapProcess = new HashMap<Process,Future<Void>>();	
	}
	
	/**
	 * Execute la commande contenue dans s sinon indique l'erreur
	 * @param s : string à executer
	 */
	public void processMatcher(String s){
		String results[] = s.split("[\\s]");
		results = Process.removeNullValue(results);
		//10 est une valeur arbitraire
		ExecutorService es = Executors.newFixedThreadPool(10);
		switch (results[0]){
		
		case ("ls") :
			Process ls = new Ls(s);
			Future<Void> futureLs = es.<Void>submit(ls, null);
			try {
				futureLs.get();
				mapProcess.put(ls,futureLs);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} finally {
				mapProcess.remove(ls);
			}
			break;
		
		case ("ps") :
			Process ps = new Ps(s);
			Future<Void> futurePs = es.<Void>submit(ps, null);
			try {
				futurePs.get();
				mapProcess.put(ps,futurePs);
			} catch (InterruptedException e) {
				System.out.println("La commande ps de pid: " + ps.getPid()
						+ " a été interrompue.");
			} catch (ExecutionException e) {
				e.printStackTrace();
			} finally {
				mapProcess.remove(ps);
			}
			break;
			
		case ("pwd") :
			Process pwd = new Pwd(s);
			Future<Void> futurePwd = es.<Void>submit(pwd, null);
			try {
				futurePwd.get();
				mapProcess.put(pwd,futurePwd);
			} catch (InterruptedException e) {
				System.out.println("La commande pwd de pid: " + pwd.getPid()
						+ " a été interrompue.");
			} catch (ExecutionException e) {
				e.printStackTrace();
			} finally {
				mapProcess.remove(pwd);
			}
			break;
			
		case ("cd") :
			Process cd = new Cd(s);
			Future<Void> futureCd = es.<Void>submit(cd, null);
			try {
				futureCd.get();
				mapProcess.put(cd,futureCd);
			} catch (InterruptedException e) {
				System.out.println("La commande cd de pid: " + cd.getPid()
						+ " a été interrompue.");
			} catch (ExecutionException e) {
				e.printStackTrace();
			} finally {
				mapProcess.remove(cd);
			}
			break;
			
		case ("date") :
			Process date = new DateFunction(s);
			Future<Void> futureDate = es.<Void>submit(date, null);
			try {
				futureDate.get();
				mapProcess.put(date,futureDate);
			} catch (InterruptedException e) {
				System.out.println("La commande date de pid: " + date.getPid()
						+ " a été interrompue.");
			} catch (ExecutionException e) {
				e.printStackTrace();
			} finally {
				mapProcess.remove(date);
			}
			break;
			
		case ("find") :
			Process find = new Find(s);
			Future<Void> futureFind = es.<Void>submit(find, null);
			try {
				futureFind.get();
				mapProcess.put(find,futureFind);
			} catch (InterruptedException e) {
				System.out.println("La commande find de pid : " + find.getPid()
						+ " a été interrompue.");
			} catch (ExecutionException e) {
				e.printStackTrace();
			} finally {
				mapProcess.remove(find);
			}
			break;
			
		case ("kill") :
			try {
				String[] pid = s.split("\\s*kill\\s+");
				if(pid.length!=1)
					throw new MauvaiseSyntaxeException();
				else kill(Integer.parseInt(pid[0]));
			} 
			catch (MauvaiseSyntaxeException i) {
				System.out.println("Commande incorrecte, la syntaxe est :\n kill <pid>(int)"
						+ "\n\t ou le pid n'existe pas");
			} 
			catch (Exception e) { 
				System.out.println("Il faut donner un entier en argument!"); 
			}
			break;

		case ("compteJusqua"):
			Process compteJusqua = new CompteJusqua(s);
			Future<Void> futureCompteJusqua = es.<Void> submit(compteJusqua, null);
			try {
				futureCompteJusqua.get();
				mapProcess.put(compteJusqua, futureCompteJusqua);
			} catch (InterruptedException e) {
				System.out.println("La commande date de pid: " + compteJusqua.getPid()
						+ " a été interrompue.");
			} catch (ExecutionException e) {
				e.printStackTrace();
			} finally {
				mapProcess.remove(compteJusqua);
			}
			break;

		default:
			if (!Objects.equals(results[0],"quit")){
				System.out.println("Ceci n'est pas la commande que vous recherchez");
			}
			break;
		}
	}
	
	public int kill(int pid){
		System.out.println("killentree");
		for(Map.Entry<Process,Future<Void>> entree: mapProcess.entrySet()){
			if(entree.getKey().currentProcessPid==pid){
				entree.getValue().cancel(true);
				return 0;
			}				
		}
		return 1;
	}
	
	//_____________________GETTEURS ET SETTEURS___________________________

	/**
	 * Indique le dossier du shell
	 * @return : String du dossier courant
	 */
	public static String getCurrentDir() {
		return currentDir;
	}

	/**
	 * Modifie le dossier courant du shell
	 * @param currentDir : Nouveau dossier courant
	 */
	public static void setCurrentDir(String currentDir) {
		Minishell.currentDir = currentDir;
	}

	/**
	 * Renvoie l'intégralité des processus
	 * @return : Renvoye la liste des processus
	 */
	public static Map<Process,Future<Void>> getMapProcess() {
		return mapProcess;
	}
	
}
