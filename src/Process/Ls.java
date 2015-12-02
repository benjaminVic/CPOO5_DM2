package Process;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Shell.Process;


public class Ls extends Process {

	public Ls(int pid) {
		super(pid);
		this.regexp = "ls";
		// TODO Auto-generated constructor stub
	}

	public void regexp(String toEvaluate) throws Exception {
		Pattern p = Pattern.compile(this.regexp);
		Matcher m = p.matcher(toEvaluate);
		
		if (!m.matches()) throw new Exception();
	}

	@Override
	public Process call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
