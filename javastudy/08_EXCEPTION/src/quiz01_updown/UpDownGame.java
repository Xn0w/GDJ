package quiz01_updown;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UpDownGame {

	// 필드
	private int rand;	// 1~100 사이 난수
	private int count;	//시도 횟수
	private Scanner sc;
	
	// 생성자
	public UpDownGame() {
		//rand, sc 만들기
		rand = (int)(Math.random() * 100 + 1);
		sc = new Scanner(System.in);
		
	}
	
	// 입력
	public int input() {
		try {
			count++;	// 사용자가 count 시도했다
			System.out.print("입력 >>> ");
			int n = sc.nextInt();
			if(n < 1 || n > 100) {
				throw new RuntimeException("1~100 사이 정수만 입력할 수 있습니다.");
			}
			return n;
		} catch (InputMismatchException e) {
			System.out.println("정수만 입력할 수 있습니다.");
			sc.next();
			input();
		} catch(RuntimeException e) {
			System.out.println(e.getMessage());
			input();
		}
		return 0;
	}
	
	// 실행
	public void play() {
		
		while(true) {
			int n = input();
			if(n < rand) {
				System.out.println("Up!");
			} else if (n > rand) {
				System.out.println("Down!");
			} else {
				System.out.println(rand + "정답입니다" + count + "번만에 정답입니다");
				break;
			}

		}
		
		// 맞힐때까지 무한루프
		
	}
	
	
}
