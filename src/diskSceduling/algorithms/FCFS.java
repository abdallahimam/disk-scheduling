package diskSceduling.algorithms;

public class FCFS {

	private int[] queue;
	private int length;
	private int initial;
	private int totalCylinder;

	public FCFS() {
		initial = 0;
		length = 0;
		totalCylinder = 0;
	}

	public FCFS(int[] q, int s) {
		initial = s;
		length = q.length;
		totalCylinder = 0;
		queue = new int[length];
		for (int i = 0; i < length; i++) {
			queue[i] = q[i];
		}
	}

	public int run() {
		int current = initial;
		System.out.print("\tSequence is --> " + initial);
		for (int i = 0; i < length; i++) {
			totalCylinder += Math.abs(queue[i] - current);
			current = queue[i];
			System.out.print(" " + queue[i]);
		}
		System.out.println();
		return totalCylinder;
	}

}
