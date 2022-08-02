package ex10_downcasting;

public class Main {

	public static void main(String[] args) {
		
			// 클래스타입 : Person
			// 객체(인스턴스) : p
		
		Person p = new Alba();	// 업 캐스팅
		
		// instance of 연산자 
		// 특정 인스턴스가 어떤 클래스타입인지 점검하는 연상자.
		// 해당 클래스타입이면 true변환, 아니면 false 변환

		System.out.println(p instanceof Person);
		System.out.println(p instanceof Student);
		System.out.println(p instanceof Alba);
				
		
		// p가Student 타입의 인스턴스이면 study() 메소드를 호출할 수 있다.
		if(p instanceof Student) {
			((Student) p).study();
		}
		
		if(p instanceof Alba) {
			((Alba) p).work();
		}
		
		
		
		
	}

}
