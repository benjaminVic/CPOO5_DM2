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
		this.regexp = "[\\s]*date([\\s]+\\+(%.)*)?";
				/*+ "%(G|y|Y|M|w|W|D|d|F|E|u|a|H|k|K|h|m|s|S|z|Z|X)+?)*"
				+ ")?";*/
	}

	@Override
	public void run() {
		try{
			String[] dateString = commande.split("\\s*date((\\s)*+)?");
			String cmd = purgeEmptyString(dateString);
			if (Objects.isNull(cmd)){
				Date dNow = new Date();
				String correctedFormat = replaceArguments("+%Y-%M-%d");
				SimpleDateFormat sdf = new SimpleDateFormat(correctedFormat);
				System.out.println(sdf.format(dNow));
			} else {
				String correctedFormat = replaceArguments(cmd);
				Date dNow = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat(correctedFormat);
				System.out.println(sdf.format(dNow));
			}
		} catch (MauvaiseSyntaxeException m) {
			System.out.println("\tLa string doit être de la forme +%y-%M-%d\n"
					+ "\tLes caractères supportés sont GyYmwWDdFEuaHkKhmsSzZX");
		} catch (IllegalArgumentException i) {
			System.out.println("\tLes caractères supportés sont GyYmwWDdFEuaHkKhmsSzZX"
					+ "\n\tVeuillez utiliser des '-' comme séparateurs entre les lettres.");
			i.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public String replaceArguments(String cmd) throws MauvaiseSyntaxeException{
		StringBuilder sb = new StringBuilder();
		char[] timeVortex = cmd.toCharArray();
		if (!(timeVortex[0] == '+')) throw new MauvaiseSyntaxeException();		
		for (int i = 1 ; i<timeVortex.length ; i++) {
			if (timeVortex[i]=='%'){
				i++;
				switch (timeVortex[i]){

				case ('G') :
					sb.append("GG");
				break;

				case ('y') : 
					sb.append("yyyy");
				break;

				case ('Y') :
					sb.append("YYYY");
				break;

				case ('M') :
					sb.append("MM");
				break;

				case ('w') :
					sb.append("ww");
				break;

				case ('W') :
					sb.append("W");
				break;

				case ('D') :
					sb.append("DDD");
				break;

				case ('d') :
					sb.append("dd");
				break;

				case ('F') :
					sb.append("F");
				break;

				case ('E') :
					sb.append("EEEEEEE");
				break;

				case ('u') :
					sb.append("u");
				break;

				case ('a') :
					sb.append("aa");
				break;

				case ('H') :
					sb.append("H");
				break;

				case ('k') :
					sb.append("kk");
				break;

				case ('K') :
					sb.append("K");
				break;

				case ('h') :
					sb.append("hh");
				break;

				case ('m') :
					sb.append("mm");
				break;

				case ('s') :
					sb.append("ss");
				break;

				case ('S') :
					sb.append("SSS");
				break;

				case ('z') :
					sb.append("z");
				break;

				case ('Z') :
					sb.append("Z");
				break;

				case ('X') :
					sb.append("X");
				break;

				default : 
					throw new IllegalArgumentException();
				}
			} else {
				sb.append(timeVortex[i]);
			}
		}
		return sb.toString();
	}
}
