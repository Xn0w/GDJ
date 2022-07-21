package ex03_number;

public class EX03 {

	public static void main(String[] args) {
		
		// 대입 연산
		int score = 100; // 등호(=)가 대입 연산자이다.
		System.out.println(score);
		
		// 연습
		// x에 10이 있고 y에 20이 있다.
		// x와 y에 저장된 값을 서로 교환하시오.
		// 거진 단골로 나오는 값 바꾸기 기억 할 것
		int x = 10;
		int y = 20;
		
		int temp; //힌트
		
		temp = x;
		x = y;
		y = temp;
		
		System.out.println(x);
		System.out.println(y);
		
		// 복합 대입 연산자
		// +=, -=, *=, /=, %= 등
		int wallet = 0;
		wallet = wallet + 5000;
		wallet += 5000; // wallet = wallet + 5000;
		wallet -= 3000; // wallet = wallet - 3000;
		System.out.println(wallet);
		
		// 연습
		// 잔액에서 이자 5%를 받았음을 나타내자.
		// 10% 아래의 복합 대입 연산자 문제는 많이 접해본적이 없으니 기억 할 것
		long balance = 10000;
		balance *= 1.05; // balance를 double로 promotion해서 처리한다.
		System.out.println(balance);
		
		/* 
			balance = balance * 1.05; 실패. balance * 10.5 결과는 double이기 때문에
			long balance에 저장할 수 없다.
			balance = (long)(balance * 1.05); 성공. balance * 1.05 결과를
			long으로 casting해서 저장할 수 있다.
		*/
		/* 
			balance = balance + balance * 0.05; 실패. balance + balance * 0.05결과는
			double 이기 때문에 long balance에 저장할 수 없다.
			balance = (long)(balance + balance * 0.05); 성공. balance + balance * 1.05결과를
			long으로 casting해서 저장 할 수 있다.
		*/
	}

}
