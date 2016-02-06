package com.terry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class PathFinder {
	int m[][];
	int n;
	int chk[];
	Stack <Integer> stack = new Stack();
	
	public PathFinder(int n){
		this.n = n;
		m = new int[n+1][n+1];
		chk = new int[n+1];
		chk[1] = 1;
		
	}
	
	public boolean findPath(int start,int end){
	
		// found path
		// print path
		if(start == end){
			int size = stack.size();
			for(int i=0;i<size;i++){
				System.out.print(stack.get(i) + ">");
			}
			System.out.println("");
			return true;
		}
		for(int i=1;i<=n;i++){
			if(m[start][i] != 0 && chk[i]!=1){
				chk[i] = 1;
				stack.push(new Integer(i));
					findPath(i,end);
				stack.pop();
				chk[i] = 0;
			}
		}
		return false;
		
	}
	public void connect(int start,int end,int weight){
		m[start][end] = m[end][start] = weight;
	}
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt(); // # of node
		int np = scan.nextInt(); // # of path
		
		PathFinder p = new PathFinder(n);
		
		String str;
		int s,e,w;
		for(int i=0;i<np;i++){
			s = scan.nextInt();
			e = scan.nextInt();
			w = scan.nextInt();
			
			p.connect(s,e,w);
		}
		
		p.findPath(1,7);
		
	}
}
