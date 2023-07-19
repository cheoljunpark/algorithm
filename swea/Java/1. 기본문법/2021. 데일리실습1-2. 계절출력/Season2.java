package com.ssafy.ws.step2;

import java.util.Scanner;

public class Season2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int i=0;
		
		while (i<3) {
			System.out.print("월 입력>>");
			int month = sc.nextInt();
			String season = null;

			switch(month) {
			case 3:
			case 4:
			case 5:
				season = "봄";
				break;
			case 6:
			case 7:
			case 8:
				season = "여름";
				break;
			case 9:
			case 10:
			case 11:
				season = "가을";
				break;
			case 12:
			case 1:
			case 2:
				season = "겨울";
				break;
			}

			System.out.println(month + "월은 " + season + "입니다.");
			i++;
		}
	}

}
