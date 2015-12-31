package process;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import shell.Process;


public class DateFunction extends Process{

	/*
	%d : jour du mois (01-31)
	%H : heure /24 (0-23)
	%m : mois (01-12)
	%M : minute (00-59)
	%Y : année (ex : 2015)
	*/
	//Liste des caractères supportés : G y Y M w W D d F E u a H k K h m s S z Z X
	//[^GyYMwWDdFEuaHkKhmsSzZX]
	public DateFunction(String commande) {
		super(commande);
		// TODO finish regexp
		this.regexp = "[\\s]*date([\\s]+\\+(.)*)?";
				/*+ "%(G|y|Y|M|w|W|D|d|F|E|u|a|H|k|K|h|m|s|S|z|Z|X)+?)*"
				+ ")?";*/
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			String[] dateString = commande.split("\\s*date\\s*?");
			String cmd = purgeEmptyString(dateString);
			System.out.println(cmd);
			if (Objects.isNull(cmd)){
				Date dNow = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("+%Y-%M-%d");
				System.out.println(sdf.format(dNow));
			} else {
				this.regexp();
				SimpleDateFormat sdf = new SimpleDateFormat(cmd);
			}
		} catch (MauvaiseSyntaxeException m) {
			System.out.println("\tLa string doit être de la forme +%Y-%m-%d\n"
					+ "\tLes caractères supportés sont GyYmwWDdFEuaHkKhmsSzZX");
		} catch (IllegalArgumentException i) {
			System.out.println("\tLes caractères supportés sont GyYmwWDdFEuaHkKhmsSzZX");
			i.printStackTrace();
		} catch (Exception e){
			System.out.println("CHOCAPIC C FORT EN CHOCOLAT");
			e.printStackTrace();
		}
	}

}
