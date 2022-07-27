package ex05_method;

public class Car {

	// 필드
	int oil;
	int speed;
	
	// 메소드 
	
	// 1. 기름 넣기
	// 반환타입 : void (반환값이 없다)
	// 메소드명 : addOil
	// 매개변수 : int o
	void addOil (int o) {
		oil += o;
		if(oil > 60) {
			oil = 60;
		}
		
	}
	
	// 2. 달리기
	// 반환타입 : void
	// 메소드명 : pushAccel
	// 매개변수 : X
	void pushAccel() {
		if(oil == 0) {
			return; // 반환 타입이 void 일 때만 사용 가능	
		}

		if(speed == 120) {
			oil --;
			return;
		}

		// 속도는 25씩 증가 최대 속도는 120
		// 기름은 1씩 사용				
		speed += 25;
		if (speed > 120) {
			speed = 120;
		}
		oil --;
	}
	
	// 3. 멈추기
	// 반환타입 : void
	// 메소드명 : pushBrake
	// 매개변수 : X
	void pushBrake() {
		
		// 속도는 밟으면 25씩 줄어든다.
		// oil을 먹지 않는다.
		if (speed == 0) {
			return;
		}
		speed -= 25;
		if(speed < 0) {
			speed = 0;
		}
	}
	
	// 4. 계기판(기름, 속도) 확인
	// 반환타입 : void
	// 메소드명 : panel
	// 매개변수 : X
	
	void panel() {
		System.out.println("기름 " + oil);
		System.out.println("속도 " + speed);
	}
	
}
