package com.edwardv.proCo.year2014;

import java.util.Scanner;

public class AdvG {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int n = Integer.parseInt(scanner.nextLine());
		String[] stufffStrings = scanner.nextLine().split(" ");
		
		int[] nums = new int[n];
		for (int i=0;i<n;i++) {
			nums[i] = Integer.parseInt(stufffStrings[i]);
		}
		
		int numshots = 0;
		while (true) {
			
			int largest = 0;
			int finalStart = 0;
			int finalEnd = 0;
			
			int startIndex = -1;
			int endIndex = -1;
			
			for (int i=0;i<nums.length;i++) {
				if (nums[i] > 0) {
					if (startIndex == -1) {					
						startIndex = i;
						endIndex = i;
					} else {
						endIndex++;
					}
				} else {
					if (startIndex != -1) {
						if (endIndex - startIndex+1 >= largest) {
							largest = endIndex - startIndex;
							finalStart = startIndex;
							finalEnd = endIndex;
							startIndex = -1;
							endIndex = -1;
						}
					}
				}
			}
			
			if (endIndex - startIndex >= largest && startIndex != -1) {
				largest = endIndex - startIndex;
				finalStart = startIndex;
				finalEnd = endIndex;
				startIndex = -1;
				endIndex = -1;
			}
			
			for (int i=finalStart;i<=finalEnd;i++) {
				nums[i]--;
			}
			
			numshots++;
			
			boolean all0 = true;
			for (int i : nums) {
				if (i > 0) {
					all0 = false;
//					break;
				}
			}
			
			if (all0) {
				break;
			}
		}
		
		System.out.println(numshots);
		
		scanner.close();
	}
}
