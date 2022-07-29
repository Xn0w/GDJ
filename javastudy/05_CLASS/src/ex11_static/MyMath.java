package ex11_static;

public class MyMath {

	// static
	// 1. 정적 요소
	// 2. 객체 생성 이전에 메모리에 미리 만들어 지는 공유 요소
	// 3. 클래스에서 1개만 만들어 짐
	// 4. 클래스를 이용해서 호출하기 때문에 클래스 변수, 클래스 메소드라고 부름.
	// Math함수는 대부분 static을 포함하고 있음.
	
	// 필드
	// 원주율
	public static final double PI = 3.141592;
	
	//메소드
	
	// 절대값
	public static int abs(int n) {
		return (n >= 0) ? n : -n;
	}
	
	// n의 m제곱 복습할 것 
	public static int pow(int n, int m) {
		int result = 1;
		for(int cnt = 0; cnt < m; cnt++) {
			result *= n;
		}
		return result;
	}
}
