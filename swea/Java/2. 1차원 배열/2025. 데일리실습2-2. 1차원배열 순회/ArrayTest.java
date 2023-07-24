package com.ssafy.ws.step2;

import java.util.Scanner;

public class ArrayTest {
	public static void main(String[] args) {
		int[] intArray = { 1, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		for (int i = 0; i < intArray.length; i++)
			System.out.print(intArray[i]);
		System.out.println();

		Scanner sc = new Scanner(System.in);

		int number = sc.nextInt();
		sc.nextLine();

		String[] stringArray = new String[number];

		for (int i = 0; i < stringArray.length; i++) {
			stringArray[i] = sc.nextLine();
		}

		for (int i = 0; i < stringArray.length; i++) {
			System.out.println(stringArray[i]);
		}
	}
}
