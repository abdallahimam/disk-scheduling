package diskSceduling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import diskSceduling.algorithms.*;

public class Main {

	public static void run(int[] queue, int starting) {
		
		System.out.println("FCFS:");
		FCFS fcfs = new FCFS(queue, starting);
		int totalFCFS = fcfs.run();
		System.out.println("\ttotal number of head movements --> " + totalFCFS);
		
		System.out.println("SSTF:");
		SSTF sstf = new SSTF(queue, starting);
		int totalSSTF = sstf.run();
		System.out.print("\tSequence is --> ");
		sstf.display();
		System.out.println("\ttotal number of head movements --> " + totalSSTF);
		
		System.out.println("SCAN:");
		SCAN scan = new SCAN(queue, starting);
		int totalSCAN = scan.run();
		System.out.print("\tSequence is --> ");
		scan.display();
		System.out.println("\ttotal number of head movements --> " + totalSCAN);
		
		System.out.println("C-SCAN:");
		C_SCAN c_scan = new C_SCAN(queue, starting);
		int totalC_SCAN = c_scan.run();
		System.out.print("\tSequence is --> ");
		c_scan.display();
		System.out.println("\ttotal number of head movements --> " + totalC_SCAN);
		
		System.out.println("LOOK:");
		LOOK look = new LOOK(queue, starting);
		int totalLOOK = look.run();
		System.out.print("\tSequence is --> ");
		look.display();
		System.out.println("\ttotal number of head movements --> " + totalLOOK);
		
		System.out.println("C-LOOK:");
		C_LOOK c_look = new C_LOOK(queue, starting);
		int totalC_LOOK = c_look.run();
		System.out.print("\tSequence is --> ");
		c_look.display();
		System.out.println("\ttotal number of head movements --> " + totalC_LOOK);
		
	}

	public static void main(String[] args) {
		Scanner in;
		int[] read = new int[10000];
		try {
			in = new Scanner(new File("queue.txt"));
			int len, startingHead;
			int count = 0;
			while (in.hasNextInt()) {
				read[count++] = in.nextInt();
			}
			int[] queue = new int[count];
			for (int i = 0; i < count; i++) {
				queue[i] = read[i];
			}
			System.out.print("Enter the starting head: ");
			in.close();
			in = new Scanner(System.in);
			startingHead = in.nextInt();
			run(queue, startingHead);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
