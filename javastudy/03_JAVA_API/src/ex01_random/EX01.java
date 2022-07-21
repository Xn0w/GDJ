package ex01_random;

public class EX01 {

	public static void main(String[] args) {
		
		// 난수(Random number) 발생
		// Random 클래스, Math 클래스를 주로 활용한다.
		
		System.out.println(Math.random());
		
		
		// 0.0 <= Math.random() < 1.0
		// 0%  <= Math.random() < 100%
		
		// 1.확률처리
		// 10% 확률로 "대박" , 90% 확률로 "쪽박"
		if(Math.random() < 0.1) {
			System.out.println("대박");
		}
		else {
			System.out.println("쪽박");
		}
		
		// 2. 난수 값 생성
		// Math.random()				0.0 <= n < 1.0
		// Math.random() * 5			0.0 <= n < 5.0
		// (int)(Math.random() * 5) 	  0 <= n < 5
		// (int)(Math.random() * 6) + 1	  1 <= n < 7
		// 주사위 두 개 랜덤숫자
		
			for(int n = 0; n < 2; n++) {
				int dice = (int)(Math.random() * 6) + 1;
			System.out.println(dice);
			}
			
		// 인증번호 6자리 숫자로 된 인증번호 만들기
			String code = "";
			for(int n = 0; n < 6; n++) {
				code += (int)(Math.random() * 10);
			}
			System.out.print(code);
			
			/* 내 답
			for(int n = 0; n < 6; n++) {
				String code = String.valueOf((int)(Math.random() * 10));
			System.out.print(code);
			}
			*/
	}
	
}
