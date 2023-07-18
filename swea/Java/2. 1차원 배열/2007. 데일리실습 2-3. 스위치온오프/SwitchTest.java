package com.ssafy.ws.step3;

import java.util.Scanner;

public class SwitchTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// N개의 스위치, M개의 입력
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		// N개의 배열 arr
		int[] arr = new int[N];
		// M개의 인덱스를 담은 배열 idx
		int[] idx = new int[M];
		
		
		for (int i = 0; i < idx.length; i++) {
			idx[i] = sc.nextInt();
			
			// 인덱스-1번부터 배수만큼 toggle
			for (int j = idx[i] - 1; j < arr.length; j += idx[i]) {
				if (arr[j] == 0)
					arr[j] = 1;
				else
					arr[j] = 0;
			}
		}

		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

}
