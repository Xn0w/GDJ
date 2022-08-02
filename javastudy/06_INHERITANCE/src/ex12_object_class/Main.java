package ex12_object_class;

public class Main {

	public static void main(String[] args) {
		
		// Object 클래스는 모든 객체(변수)를 저장할 수 있다.
		// Object에 저장된 객체는 캐스팅해서 사용한다.
		// 객체 정보 확인을 위해서는 toString() 메소드를 만든다.
		// 객체 정보 비교를 위해서는 equals() 메소드를 만든다.
		// -source 메뉴에 가면 toString(), equals() 를 만들어 준다.
		
		Object p = new Person();
		
		// Object 클래스타입의 개체는
		// 항상 다운케스팅해서 사용해야 한다.
		
		if(p instanceof Person) {
			((Person) p).eat();
		}
		
		Person person = new Person();
		person.setName("james");
	
		
		System.out.println(person); // 이름 : james
		
		
		// 새로운 Person(equlals() 확인용)
		Person p1 = new Person();
		Person p2 = new Person();
		p1.setName("kim");
		p2.setName("kim");
		System.out.println(p1.equals(p2)); // 동일한 name은 true
		
	}
}
