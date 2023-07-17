package com.ssafy.ws.step3;

/**
 * 직각삼각형 모양의 숫자 출력하는 클래스
 */
public class DigitTest1 {

	public static void main(String[] args) {
		int[] arr = new int[15];

		for (int i = 0; i < arr.length; i++)
			arr[i] = i + 1;

		int k = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++)
				System.out.print("   ");
			for (int j = 5; j > i; j--) {

				System.out.print(String.format("%-3d", arr[k++]));
			}
		
		System.out.println();
		}
	}

}
