package com.edwardv.proCo.year2014;

import java.awt.Point;
import java.util.Scanner;

public class AdvE {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String[] stuff = scanner.nextLine().split(" ");
		int rows = Integer.parseInt(stuff[0]);
		int cols = Integer.parseInt(stuff[1]);
		
		String[][] maze = new String[rows][cols];
		Point start = new Point(1, 1);
		
		for (int i=0;i<rows;i++) {
			String input = scanner.nextLine();
			for (int k=0;k<input.length();k++) {
				maze[i][k]= input.substring(k, k+1); 
				if (input.substring(k, k+1).equals("S")) {
					start = new Point(i, k);
				}
			}
		}
		
		Point[] aPoints = doMaze(maze, new Point[] {start});
		
		System.out.println(aPoints.length-1);
		
		scanner.close();
	}
	
	public static Point[] doMaze(String[][] maze, Point[] path) {
		
		Point currPoint = path[path.length-1];
		
		Point[] newPath = new Point[path.length+1];
		for (int i=0;i<path.length;i++) {
			newPath[i] = path[i]; 
		}
		
		if (currPoint.x == 0 || currPoint.y == 0 || currPoint.x == maze.length-1 || currPoint.y == maze[0].length-1) {
			newPath[newPath.length-1] = new Point(-1, -1);
			return newPath;
		}
		
		Point[] largestPath = null;
		
		for (int i=-1;i<=1;i++) {
			for (int j=-1;j<=1;j++) {
				if (!(i == 0 && j == 0)) {
					Point newPoint = new Point(currPoint.x + i, currPoint.y + j);
					if (newPoint.x > -1 && newPoint.y > -1 && newPoint.x < maze.length && newPoint.y < maze[0].length) {
						if (maze[newPoint.x][newPoint.y].equals(".") && !containsPoint(path, newPoint)) {
							newPath[newPath.length-1] = newPoint;
//							System.out.println(i + "  " + j);
							Point[] patttt = doMaze(maze, newPath);
							if (patttt != null) {
								if (largestPath != null) {
									if (largestPath.length > patttt.length) {
										largestPath = patttt;
									}
								} else {
									largestPath = patttt;
								}
							}
						}
					}
				}
			}
		}
		
		return largestPath;
	}
	
	public static boolean containsPoint(Point[] path, Point p) {
		for (Point point : path) {
			if (point.x == p.x && point.y == p.y) {
				return true;
			}
		}
		
		return false;
	}
}
