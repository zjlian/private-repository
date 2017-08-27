package tool;

public class Stopwatch {
	private final long start;
	public Stopwatch() {
		start = System.currentTimeMillis();
	}
	public long elapsedTime() {
		long now = System.currentTimeMillis();
		return (now - start);
	}
}
