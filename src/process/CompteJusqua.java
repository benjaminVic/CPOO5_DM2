package process;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import shell.Process;

public class CompteJusqua extends Process {

	private int clock;

	public CompteJusqua(String commande) {
		super(commande);
		clock = 1;
	}

	@Override
	public void run() {

		String arguments[] = commande.split("[\\s]");
		arguments = removeNullValue(arguments);
		int timeLimit=0;
		try {timeLimit = Integer.parseInt(arguments[1]) - 1;}
		catch (NumberFormatException n) {System.out.println("Commande incorrecte, la syntaxe est :\n "
				+ "\tcompteJusqua <entier> [<format>=%d\\n]");}
		TimePrinter timePrint;
		if (arguments.length > 2) {
			timePrint = new TimePrinter(arguments[2]);
		} else {
			timePrint = new TimePrinter("%d\n");
		}
		ScheduledExecutorService tarkin = Executors.newScheduledThreadPool(1);
		for (int i = 0; i<10 ;i++){
			timePrint.run();
			try {
				wait(timeLimit);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private class TimePrinter implements Runnable {

		String cmd;

		public TimePrinter(String s) {
			this.cmd = s;
		}

		@Override
		public void run() {
			try {
				String toPrint = replaceArguments(this.cmd);
				System.out.println(toPrint);
				clock = clock + 1;
			} catch (MauvaiseSyntaxeException e) {
				System.out.println("Commande incorrecte, la syntaxe est :\n "
						+ "\tcompteJusqua <entier> [<format>=%d\n]");
				e.printStackTrace();
			}
		}

		public String replaceArguments(String cmd) throws MauvaiseSyntaxeException {
			StringBuilder sb = new StringBuilder();
			char minutesToMidnight[] = cmd.toCharArray();
			for (int i = 0; i < minutesToMidnight.length; i++) {
				if (minutesToMidnight[i] == '%') {
					i++;
					switch (minutesToMidnight[i]) {

					case ('d'):
						sb.append(clock);
						break;

					default:
						throw new MauvaiseSyntaxeException();
					}
				} else {
					sb.append(minutesToMidnight[i]);
				}
			}
			return sb.toString();
		}
	}
}
