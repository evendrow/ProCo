package com.edwardv.proCo.year2014;

import java.util.Scanner;

public class AdvD {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		double p = Double.parseDouble(scanner.nextLine());
		
		int currP = -1;
		for (int i=1;i<366;i++) {
			
			double d = 1;
			for (int k=365;k>366-i;k--) {
				d = d*k/366;
			}
			
			if ((1-p) > d) {
				currP = i;
				break;
			}
			
		}
		
		System.out.println(currP);
		
		scanner.close();
	}
	
	public static double fact(int i) {
		double answer = 1;
		for (int k=2;k<=i;k++) {
			answer *= i;
		}
		return answer;
	}
	
}
