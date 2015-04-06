package com.edwardv.proCo.year2014;

import java.util.Scanner;

public class AdvF {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String[] stuff = scanner.nextLine().split(" ");
		int numDwarves = Integer.parseInt(stuff[0]);
		int t = Integer.parseInt(stuff[1]);
		
		int[] position = new int[numDwarves];
		int[] movement = new int[numDwarves];
		int[] id = new int[numDwarves];
		
		for (int i=0;i<numDwarves;i++) {
			String[] d = scanner.nextLine().split(" ");
			position[i] = Integer.parseInt(d[0]);
			movement[i] = (d[1].equals("-") ? -1 : 1);
			id[i] = i;
		}
		
		for (int i=0;i<movement.length;i++) {
			position[i] += movement[i];
		}
		
		for (int a=1;a<t;a++) {
			
			for (int i=0;i<movement.length;i++) {
				for (int j=i;j<movement.length;j++) {
					if (position[j] == position[i]) {
						movement[j] *= -1;
						movement[i] *= -1;
					} else if (position[j] + 1 == position[i] && movement[i] == 1 && movement[j] == -1) {
						position[i]--;
						position[j]++;
						movement[j] *= -1;
						movement[i] *= -1;
					}
				}
			}
			
			for (int i=0;i<movement.length;i++) {
				position[i] += movement[i];
			}
			
//			for (int i=0;i<id.length;i++) {
//				System.out.println(position[i] + " " + (movement[i] == 1 ? "+" : "-"));
//			}
		}
		
		for (int i=0;i<id.length;i++) {
			System.out.println(position[i] + " " + (movement[i] == 1 ? "+" : "-"));
		}
		
		scanner.close();
	}
}
