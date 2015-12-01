
public abstract class Process {
	
	protected int pid;
	protected String regexp;
	
	public Process(int pid){
		this.pid = pid;
		this.regexp = "";
	}
	
	public abstract void regexp(String toEvaluate);
}
