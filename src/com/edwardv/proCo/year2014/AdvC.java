package com.edwardv.proCo.year2014;

import java.util.Scanner;

public class AdvC {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String[] stuff = scanner.nextLine().split(" ");
		
		int[] numerators = new int[(stuff.length+1)/4];
		int[] denominators = new int[(stuff.length+1)/4];
		
		for (int i=0;i<stuff.length;i+=4) {
			numerators[i/4] = Integer.parseInt(stuff[i]);
			denominators[i/4] = Integer.parseInt(stuff[i+2]);
		}
		
		for (int i=0;i<stuff.length;i+=4) {
			if (i+4 < stuff.length) {
				if (stuff[i+3].equals("-")) {
					numerators[(i/4) + 1] *= -1;
				}
			}
		}
		
		
		int finalD = 1;
		
		for (int i=0;i<denominators.length;i++) {
			
			finalD *= denominators[i];
			
			for (int k=0;k<denominators.length;k++) {
				if (i != k) {
//					denominators[k] *= denominators[i];
					numerators[k] *= denominators[i];
				}
			}
		}
		
		int finalN = 0;
		for (int i=0;i<numerators.length;i++) {
			finalN += numerators[i];
		}
		
//		for (int n : numerators) {
//			System.out.print(n + "  ");
//		}
		
		for (int i=2;i<finalD;i++) {
			while (finalN%i == 0 && finalD%i == 0) {
				finalN = finalN / i;
				finalD = finalD / i;
			}
		}
//		
		System.out.println(finalN + " / " + finalD);
		
		scanner.close();
	}
	
	
}
