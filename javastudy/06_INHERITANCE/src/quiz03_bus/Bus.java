package quiz03_bus;

public class Bus {

	private Seat[] seats; 		// 배열 선언
	private int limit;
	
	// Bus 생성자에서 배열 생성을 진행함
	public Bus(int cnt) {
		seats = new Seat[cnt];  // 배열 생성, new Bus(25)인 경우 Seat가 25개 생성됨
		limit = cnt;
		for(int i = 0; i < cnt; i++) {
			seats[i] = new Seat();
		}
	}
	
	// ride () 메소드
	public void ride(int seatNo, Person person) {
		// 존재하지 않는 시트번호
		if(seatNo <= 0 || seatNo > limit) {
			return; // ride() 메소드 종료
		}
		// 시트가 비어 있으면, 시트번호에 Person 저장하기
		Seat seat = seats[seatNo - 1];
		Person p = seat.getPerson();
		if(p == null) {
			seat.setPerson(person);
		}
	}
	
	// info() 메소드
	public void info() {
		for(int i = 0; i < limit; i++) {	// limit은 seats 배열의 length와 같음
			Seat seat = seats[i]; // 좌석 하나
			if(seat != null) {	// 윗 줄 없애고 if(seats[i] != null) 하면 됨
				Person person = seat.getPerson();	// Person person = seats[i].getPerson();
				if(person != null) {	// if(seat.getPerson() != null), if(seats[i].getPerson() != null)
					System.out.println((i + 1) + "," + person.getName());
					// System.out.println((i + 1) + "," + seat.getPerson().getName());
					// System.out.println((i + 1) + "," + seats[i].getPerson().getName());
				} else {
					System.out.println((i + 1) + ". 비어 있음");
				}
			}
		}
	}	
}
