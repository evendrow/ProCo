package com.edwardv.proCo.year2014;

import java.util.Scanner;

public class AdvA {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String[] inputNu = scanner.nextLine().split(" ");
		int r = Integer.parseInt(inputNu[0]);
		int c = Integer.parseInt(inputNu[1]);
		
		String code = scanner.nextLine();
		
		String[][] matrix = new String[c][r];
		
		int index =  0;
		for (int k=0;k<c;k++) {
			for (int i=0;i<r;i++) {
				matrix[k][i] = code.substring(index, index+1);
				index++;
			}
		}
		
		String answer = "";
		
		for (int i=0;i<r;i++) {
			for (int k=0;k<c;k++) {
				answer += matrix[k][i];
			}
		}
		
		System.out.println(answer);
		
		scanner.close();
	}
	
}
