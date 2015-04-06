package com.edwardv.proCo.year2014;

import java.util.Scanner;

public class AdvB {

	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		double b = Double.parseDouble(scanner.nextLine());
		int n = Integer.parseInt(scanner.nextLine());
		
		double[] price = new double[n];
		double[] utility = new double[n];
		double[] realUtility = new double[n];
		
		for (int i=0;i<n;i++) {
			String[] inputStrings = scanner.nextLine().split(" ");
			price[i] = Double.parseDouble(inputStrings[0]);
			utility[i] = Double.parseDouble(inputStrings[1]);
			realUtility[i] = utility[i]/price[i];
		}
		
		double answer = 0d;
		
		while (b > 0) {
			int index = getLargest(realUtility);
			
			if (price[index] > b) {
				answer += utility[index]*(b/price[index]);
				break;
			} else {
				answer += utility[index];
				b -= price[index];
			}
			
			realUtility[index] = 0;
		}
		
		System.out.println(answer);
		
		scanner.close();
	}
	
	public static int getLargest(double[] arr) {
		
		int index = 0;
		double largest = 0;
		for (int i=0;i<arr.length;i++) {
			if (arr[i] > largest) {
				index = i;
				largest = arr[i];
			}
		}
		
		return index;
	}
	
}
