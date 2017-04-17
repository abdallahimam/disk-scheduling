package diskSceduling.algorithms;

import java.util.ArrayList;

public class SSTF {

	private ArrayList<Integer> queue;
	private ArrayList<Integer> nearest;
	private int length;
	private int startingHead;
	private int totalCylinder;

	public SSTF() {
		this.queue = new ArrayList<>();
		this.nearest = new ArrayList<>();
		this.startingHead = 0;
		this.length = 0;
		this.totalCylinder = 0;
	}

	public SSTF(int[] queue, int initial) {
		this.queue = new ArrayList<>();
		this.nearest = new ArrayList<>();
		for (Integer i : queue) {
			this.queue.add(i);
		}
		this.startingHead = initial;
		this.length = queue.length;
		this.totalCylinder = 0;
	}

	public int run() {
		int current = startingHead;
		nearest.add(startingHead);
		while (!queue.isEmpty()) {
			int get = findClosest(current);
			nearest.add(get);
			totalCylinder += Math.abs(get - current);
			current = get;
			queue.remove(queue.indexOf(get));
		}
		//System.out.println(totalCylinder);
		return totalCylinder;
	}

	public int findIndex(int value) {
		int count = -1;
		for (Integer i : queue) {
			count++;
			if (value == i) {
				return count + 1;
			}
		}
		return -1;
	}
	
	public void display() {
		for (Integer n : nearest) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	private int findClosest(int current) {
		int close = Integer.MAX_VALUE;
		for (int i = 0; i < queue.size(); i++) {
			if (Math.abs(queue.get(i) - current) < close) {
				close = queue.get(i);
			}
		}
		return close;
	}
}
