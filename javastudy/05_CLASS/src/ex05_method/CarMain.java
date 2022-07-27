package ex05_method;

public class CarMain {

	public static void main(String[] args) {
		
		// 객체 생성
		Car car = new Car();
		
		car.addOil(50); // 50은 Car에 있는 int o로 이동한다.
		car.addOil(5);
		car.addOil(100);
		
		car.pushAccel();
		car.pushAccel();
		
		car.pushBrake();
		
		car.panel();
		
		
	}

}
