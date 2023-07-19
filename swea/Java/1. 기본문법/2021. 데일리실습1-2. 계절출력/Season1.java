package com.ssafy.ws.step2;

import java.util.Scanner;

public class Season1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {
			System.out.print("월 입력>>");
			int month = sc.nextInt();
			String season = null;

			if (month >= 3 && month <= 5) {
				season = "봄";
			} else if (month >= 6 && month <= 8) {
				season = "여름";
			} else if (month >= 9 && month <= 11) {
				season = "가을";
			} else if (month >= 12 && month <= 2) {
				season = "겨울";
			}

			System.out.println(month + "월은 " + season + "입니다.");
		}

	}

}
