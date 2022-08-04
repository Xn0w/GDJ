package parking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 2. Car 클래스의 생성자와 메소드는 롬복(lombok) 라이브러리를 이용해서 생성하시오.
@AllArgsConstructor // 1-2)     constructor
@NoArgsConstructor  // 1-2)     constructor
@Getter				// 1-3)-(1) getter
@Setter				// 1-3)-(2) setter
@ToString			// 1-3)-(3) toString()

public class Car {		  // 1) field

	private String carNo; // 차량번호
	private String model; // 차량모델
	
}
