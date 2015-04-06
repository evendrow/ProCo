package com.edwardv.proCo.year2014;

import java.util.Scanner;

public class AdvI {

	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int n = Integer.parseInt(scanner.nextLine());
		String[] stufffStrings = scanner.nextLine().split(" ");
		
		int maxHeight = 0;
		int[] heights = new int[n];
		for (int i=0;i<n;i++) {
			heights[i] = Integer.parseInt(stufffStrings[i]);
			if (heights[i] > maxHeight) {
				maxHeight = heights[i];
			}
		}
		
		
		int maxIslands = 0;
		
		for (int i = 0; i < maxHeight; i++) {
			
			int numIslands = 0;
			
			boolean isLand = false;
			
			for (int height : heights) {
				if (height > i) {
					if (!isLand) {
						isLand = true;
					}
				} else {
					if (isLand) {
						numIslands++;
						isLand = false;
					}
				}
			}
			
			if (isLand) {
				numIslands++;
			}
			
			if (numIslands > maxIslands) {
				maxIslands = numIslands;
			}
			
		}
		
		System.out.println(maxIslands);
		
		scanner.close();
	}
}
