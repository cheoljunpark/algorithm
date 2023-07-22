package com.ssafy.hw.step4;

import java.util.Scanner;

/**
 * 1_기본문법_과제_몇번째 날인지 구하기_Lv4
 * 
 * @author 박철준
 *
 * 1. 월(month)과 일(day)를 입력받는다.
 * 2. 몇번째 날인지 세는 변수(answer)을 0으로 초기화 한다.
 * 3. 1월부터 (month-1)월까지의 날을 answer에 더한다.
 * 4. day를 answer에 더한다.
 */

public class DayCount {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("월과 일을 입력하세요.");
		
		// 1. 월을 입력받는다.
		// 2. 일을 입력받는다.
		int month = sc.nextInt();
		int day = sc.nextInt();
		
		// 3. 입력받은 월의 직전 달까지의 날의 합을 더한다.
		int answer = 0;
		for (int i = 1; i < month; i++) {
			switch (i) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				answer += 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				answer += 30;
				break;
			case 2:
				answer += 28;
				break;
			}
		}
		
		// 4. 일을 더한다.
		answer += day;
		
		System.out.println(month+"월 "+day+"일은 "+answer+"번째 날입니다.");
	}

}
