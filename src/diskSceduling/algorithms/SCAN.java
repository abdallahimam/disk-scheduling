package diskSceduling.algorithms;

import java.util.Arrays;

public class SCAN {

	int[] queue;
	int[] finalQueue;
	int startingHead;

	public SCAN() {

	}

	public SCAN(int[] scan, int start) {
		queue = scan;
		finalQueue = new int[queue.length + 2];
		startingHead = start;
	}

	public int run() {
		int total = 0;
		calculateScanDisk();
		for (int i = 1; i < finalQueue.length; i++) {
			total += Math.abs(finalQueue[i - 1] - finalQueue[i]);
		}
		return total;
	}

	public void display() {
		for (int i = 0; i < finalQueue.length; i++) {
			System.out.print(finalQueue[i] + " ");
		}
		System.out.println();
	}
	
	public int[] calculateScanDisk() {
		int[] tempFirst = new int[queue.length];
		int[] firstPart;

		int count = 0;
		for (int i = 0; i < queue.length; i++) {
			if (queue[i] >= 0 && queue[i] < startingHead) {
				tempFirst[count] = queue[i];
				count++;
			}
		}

		firstPart = new int[count];
		for (int i = 0; i < firstPart.length; i++) {
			firstPart[i] = tempFirst[i];
		}
		Arrays.sort(firstPart);
		int num = 0;
		finalQueue[num] = startingHead;
		num++;
		for (int i = firstPart.length - 1; i >= 0; i--) {
			finalQueue[num] = firstPart[i];
			num++;
		}

		finalQueue[num] = 0;
		num++;
		int[] tempSecond = new int[finalQueue.length];

		int b = 0;
		for (int i = 0; i < queue.length; i++) {
			if (queue[i] > startingHead) {
				tempSecond[b] = queue[i];
				b++;
			}
		}

		int secondPart[] = new int[b];
		for (int i = 0; i < secondPart.length; i++) {
			secondPart[i] = tempSecond[i];
		}

		Arrays.sort(secondPart);
		for (int i = 0; i < secondPart.length; i++) {
			finalQueue[num] = secondPart[i];
			num++;
		}
		return finalQueue;
	}
}
