package diskSceduling.algorithms;

import java.util.Arrays;

public class C_LOOK {

	int[] queue;
	int[] finalQueue;
	int startingHead;

	public C_LOOK() {

	}

	public C_LOOK(int[] scan, int start) {
		queue = scan;
		finalQueue = new int[queue.length + 1];
		startingHead = start;
	}

	public int run() {
		int total = 0;
		calculateCLookDisk();
		for (int i = 1; i < finalQueue.length; i++) {
			if (finalQueue[i] <= finalQueue[i - 1]) {
				total += finalQueue[i - 1] - finalQueue[i];
			}
		}
		return total;
	}
	
	public void display() {
		for (int i = 0; i < finalQueue.length; i++) {
			System.out.print(finalQueue[i] + " ");
		}
		System.out.println();
	}
	
	public void calculateCLookDisk() {
		int[] tempFirst = new int[queue.length];
		int[] firstPart;
		int count = 0;
		for (int i = 0; i < queue.length; i++) {
			if (queue[i] < startingHead && queue[i] >= 0) {
				tempFirst[count] = queue[i];
				count++;
			}
		}

		firstPart = new int[count];
		for (int i = 0; i < count; i++) {
			firstPart[i] = tempFirst[i];
		}

		Arrays.sort(firstPart);
		int num = 0;
		finalQueue[num++] = startingHead;
		
		for (int i = firstPart.length - 1; i >= 0; i--) {
			finalQueue[num++] = firstPart[i];
		}

		int[] tempSecond = new int[finalQueue.length];
		int[] secondPart;
		count = 0;
		for (int i = 0; i < queue.length; i++) {
			if (queue[i] > startingHead)
				tempSecond[count++] = queue[i];
		}
		secondPart = new int[count];
		for (int i = 0; i < count; i++) {
			secondPart[i] = tempSecond[i];
		}

		Arrays.sort(secondPart);

		for (int i = secondPart.length - 1; i >= 0; i--) {
			finalQueue[num++] = secondPart[i];
		}

	}

}
