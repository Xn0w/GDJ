package ex_practice;

import java.util.Scanner;

public class EX01_Practice {

	public static void main(String[] args) {

		System.out.println("=====문제1=====");
		//q1();
		System.out.println("=====문제2=====");
		//q2();
		System.out.println("=====문제3=====");
		//q3();
		System.out.println("=====문제4=====");
		//q4();
		System.out.println("=====문제5=====");
		//q5();
		System.out.println("=====문제6=====");
		//q6();
		System.out.println("=====문제7=====");
		//q7();
		System.out.println("=====문제8=====");
		//q8();
		System.out.println("=====문제9=====");
		//q9();
		System.out.println("=====문제10=====");
		//q10();
	}

	
	public static void q1() {
		// 1.점수와 학년을 입력받아 60점 이상이면 합격, 60점 미만이면 불합격을 출력하시오.
		// 4학년인 경우 70점 이상이어야 합격이다.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 입력 >>> ");
		int score = sc.nextInt();
	
		
		System.out.print("학년을 입력하세요 >>> ");
		int grade = sc.nextInt();
		
		if (grade == 4 && score >= 70) {
			System.out.println("합격 !");
		} else if (grade == 4 && score < 70) {
			System.out.println("불합격 !");
		} else if(score >= 60) {
			System.out.println("합격 !");
		} else if (score < 60) {
			System.out.println("불합격 !");
		}
		
		/* git 답
		if (score >= 60) {  // 60점 이상 합격
			if (year != 4)
				System.out.println("합격!");   // 4학년 아니면 합격
			else if (score >= 70)
				System.out.println("합격!");   // 4학년이 70점 이상이면 합격
			else
				System.out.println("불합격!"); // 4학년이 70점 미만이면 불합격
		} else {  // 60점 미만 불합격
			System.out.println("불합격!");
		}
		*/

	}
	
	public static void q2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("무슨 커피를 드릴까요? >>> ");
		String str = sc.next();
		int cost = 0;
		switch(str) {
			case "에스프레소" : 
				cost = 3500;
				System.out.println(str + "는 " + cost + " 원 입니다.");
				break;
			
			case "아메리카노" : 
				cost = 2000;
				System.out.println(str + "는 " + cost + " 원 입니다.");
				break;
				
			default :
				System.out.println(str + "는 메뉴에 없습니다.");
				break;
		}
		
		/* git 답
		Scanner sc = new Scanner(System.in);

		System.out.print("무슨 커피 드릴까요? >>> ");
		String order = sc.next();
		int price = 0;
		switch (order) {
			case "에스프레소":
			case "카푸치노":
			case "카페라떼":
				price = 3500;
				break;
			case "아메리카노":
				price = 2000;
				break;
			default:
				System.out.println(order + "는 메뉴에 없습니다.");
		}
		
		if (price != 0)
			System.out.print(order + "는 " + price + "원입니다.");
		
		sc.close();
		 */
	}
	
	public static void q3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("금액을 입력하시오 >> ");
		int money = sc.nextInt();
		
		int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};
		
		int m1 = (money / unit[0]);
		int m2 = (money % unit[0]) / unit[1];
		int m3 = (money % unit[1]) / unit[2];
		int m4 = (money % unit[2]) / unit[3];
		int m5 = (money % unit[3]) / unit[4];
		int m6 = (money % unit[4]) / unit[5];
		int m7 = (money % unit[5]) / unit[6];
		int m8 = (money % unit[6]) / unit[7];
		int m9 = (money % unit[7]) / unit[8];
		int m10 = (money % unit[8]) / unit[9];
		
		System.out.println(unit[0] + "원 짜리 : " + m1 + "개");
		System.out.println(unit[1] + "원 짜리 : " + m2 + "개");
		System.out.println(unit[2] + "원 짜리 : " + m3 + "개");
		System.out.println(unit[3] + "원 짜리 : " + m4 + "개");
		System.out.println(unit[4] + "원 짜리 : " + m5 + "개");
		System.out.println(unit[5] + "원 짜리 : " + m6 + "개");
		System.out.println(unit[6] + "원 짜리 : " + m7 + "개");
		System.out.println(unit[7] + "원 짜리 : " + m8 + "개");
		System.out.println(unit[8] + "원 짜리 : " + m9 + "개");
		System.out.println(unit[9] + "원 짜리 : " + m10 + "개");
		
		/* git 답
		int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};
		int[] count = new int[unit.length];
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("금액 입력 >>> ");
		int money = sc.nextInt();
		
		for(int i = 0; i < unit.length; i++) {
			count[i] = money / unit[i];
			money = money % unit[i];
			System.out.println(unit[i] + "원 " + count[i] + "개");
		}
		*/
	}
	
	public static void q4() {
		// 입력 받은 정수 -> 배열의 길이로 사용하기
		// 1~100만 가능
		Scanner sc = new Scanner(System.in);
		
		System.out.print("몇 개 생성할까요? >>> ");
		int count = sc.nextInt();
		
		if(count < 1 || count > 100) {
			System.out.println("1~100 사이만 가능합니다.");
			return;
		}
		
		int[] arr = new int[count];
		
		// 배열 arr에 난수(1~100) 저장
		// 중복 생성되면 재생성
		for(int i = 0; i < arr.length; i++) {
			int random = (int)(Math.random() * 100) + 1;
			// random 검사 메소드
			// 중복이 있으면 true 반환, 중복이 없으면 false 반환
			// exists(배열arr, 인덱스, 난수)
			if(exists(arr, i, random)) {
				i--;
				continue;
			}
			arr[i] = random;
		}
		
		// 배열 arr의 출력
		// 한 줄에 10개씩
		
		for(int i = 0; i < arr.length; i++) {
			if(i != 0 && i % 10 == 0)
				System.out.println();
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
		
	}  // main
	
	public static boolean exists(int[] arr, int idx, int random) {
		
		// 배열arr의 인덱스 0부터 idx까지 random이 존재하는가?
		for(int i = 0; i <= idx; i++)
			if(arr[i] == random)
				return true;
		
		return false;
		
		
		/* 내 답
		Scanner sc = new Scanner(System.in);
		
		System.out.print("몇 개의 랜덤을 생성할까요? >>> ");
		int n = sc.nextInt();
		
		if (n > 100 || n < 0) {
			System.out.println("다음에는 1~100사이로 입력하세요!");
		}
		
		for(int i = 0; i < n; i++) {
			System.out.print((i+1) * ((int)(Math.random() * 100) + 1) + "\t");
			if ((i-9) % 10 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		*/
	}
	
	public static void q5() {
		Scanner sc = new Scanner(System.in);
		
		String[] name = {"피카츄", "뽀로로", "브레드"};
		
		int[] scores = new int[name.length];
		
		for (int i = 0; i < scores.length; i++) {
			scores[i] = (int)(Math.random() * 101);
		}
		
		int total = scores[0];
		int max = scores[0];
		int min = scores[0];
		int top = 0;
		int bottom = 0;
		for(int i = 1; i < scores.length; i++) {
			total += scores[i];
			if(max < scores[i]) {
				max = scores[i];
				top = i;
			}
			if(min > scores[i]) {
				min = scores[i];
				bottom = i;
			}
		}
		
		double average = (double)total / scores.length;
		System.out.println("평균 : " + average + "점");
		System.out.println("1등 점수 : " + max + "점");
		System.out.println("1등 이름 : " + name[top]);
		System.out.println("꼴등 점수 : " + min + "점");
		System.out.println("꼴등 이름 : " + name[bottom]);
		
	}
	
	public static void q6() {
		
		String[] yut = {
				"",	"도","개","걸","윷","모"
		};
		int total = 0;
		
		while(true) {
		int m = ((int)(Math.random() * 5) + 1);
		
		total += m;
		
				if(m <= 3) {
					System.out.println(yut[m] + ", " + total + "칸 이동한다.");
					break;
				} else {
					System.out.print(yut[m] + ", ");
				}
		}
	}
	
	public static void q7() {
		Player p1 = new Player("철수");
		Player p2 = new Player("영희");
		
		double res1 = p1.turn();
		double res2 = p2.turn();
		
		if(Math.abs(res1 - 10) < Math.abs(res2 - 10)) {
			System.out.println(p1.getName() + "님 승리. " + res1 + "초 소요.");
		} else {
			System.out.println(p2.getName() + "님 승리. " + res2 + "초 소요.");		
		}	
	}
	
	public static void q8() {
		Watch watch = new Watch(16, 15, 30);
		
		watch.addHour(25);
		watch.addMinute(61);
		watch.addSecond(3615);
		
		watch.see();
	}
	
	public static void q9() {
		BankAccount me = new BankAccount("1234", 50000L);
		BankAccount mom = new BankAccount("4321", 50000L);
		
		mom.transfer(me, 30000);
		
		me.inquiry();
		mom.inquiry();
	}
	
	public static void q10() {
				
		Soldier soldier = new Soldier(new Gun("K2"), "람보");
		
		soldier.reload(6);
		soldier.shoot();

		soldier.reload(10);
		soldier.info();
	}
	
}
