package quiz08_schedule;

import java.util.Scanner;

public class WeekScheduler {
	
	private int nthWeek;	// 1 ~ n 주차
	private Day[] week;
	private String[] dayNames = {"일", "월", "화", "수", "목", "금", "토"};
	private Scanner sc;
	
	public WeekScheduler(int nthWeek) {
		sc = new Scanner(System.in);
		this.nthWeek = nthWeek;
		week = new Day[7];
	}
	
	private void makeSchedule() {
		System.out.println("▦▦▦ 등록 ▦▦▦");
		System.out.print("요일 입력 >>> ");
		String dayName = sc.next().substring(0, 1);
		sc.nextLine();
		for(int i = 0; i < week.length; i++) { 
			if(dayName.equals(dayNames[i])) {
				if(week[i] == null) {	// 등록된 스케줄이 없으면
					System.out.print("스케줄 입력 >>> ");
					String schedule = sc.nextLine();	// 스케줄에 공백 입력이 가능함.
					Day day = new Day();				// 스케줄을 만들어서
					day.setSchedule(schedule);			// 스케줄을 하나를 넣는다.
					week[i] = day;
					System.out.println(dayName + "요일에 새 스케줄이 등록되었습니다.");
				} else {
					System.out.println(dayName + "요일은 이미 스케줄이 있습니다.");
				}
				return;
			}
		}
		System.out.println(dayName + "요일은 없는 요일입니다.");
	}
	
	private void changeSchedule() {
		System.out.println("▒▒▒ 수정 ▒▒▒");
		System.out.print("변경할 요일 입력 >>> ");
		String dayName = sc.next().substring(0, 1);
		sc.nextLine();
		for(int i = 0; i < week.length; i++) {
			if(dayName.equals(dayNames[i])) {
				if(week[i] == null) {
					System.out.println(dayName + "요일은 스케쥴이 없습니다.");
					System.out.print("새 스케쥴을 등록할까요?(y/n) >>> ");
					String yesNo = sc.next().substring(0, 1);
					sc.nextLine();
					if(yesNo.equalsIgnoreCase("y")) {
						System.out.print("새 스케쥴 입력 >> ");
						String schedule = sc.nextLine();
						Day day = new Day();
						day.setSchedule(schedule);
						week[i] = day;
						System.out.println(dayName + "요일에 새 스케쥴이 등록되었습니다.");
					} else {
						System.out.println("스케쥴 변경이 취소되었습니다.");
					}
				} else {
					System.out.println(dayName + "요일의 스케쥴은 " + week[i].getSchedule() + "입니다.");
					System.out.print("변경할까요?(y/n) >>> ");
					String yesNo = sc.next().substring(0, 1);
					sc.nextLine();
					if(yesNo.equalsIgnoreCase("y")) {
						System.out.print("변경할 스케쥴 입력 >> ");
						String schedule = sc.nextLine();
						week[i].setSchedule(schedule);
						System.out.println(dayName + "요일의 스케쥴이 변경되었습니다.");
					} else {
						System.out.println("스케쥴 변경이 취소되었습니다.");
					}
				}
				return;
			}
		}
		System.out.println(dayName + "요일은 없는 요일입니다.");
	}
	
	private void deleteSchedule() {
		System.out.println("▦▦▦ 삭제 ▦▦▦");
		System.out.println("삭제할 요일 입력 >>> ");
		String dayName = sc.next().substring(0, 1);
		sc.nextLine();
		for(int i = 0; i < week.length; i++) {
			if(dayName.equals(dayNames[i])) {
				if(week[i] == null) {
					System.out.println(dayName + "요일은 스케줄이 없습니다.");
				} else {
					System.out.println(dayName + "요일의 스케줄은 " + week[i].getSchedule() + "입니다.");
					System.out.println("삭제할까요?(y/n) >>> ");
					String yesNo = sc.next().substring(0, 1);
					sc.nextLine();
					if(yesNo.equalsIgnoreCase("y")) {
						week[i] = null;
						System.out.println(dayName + "요일의 스케줄이 취소되었습니다.");
					} else {
						System.out.println("스케줄 삭제가 취소되었습니다.");
					}
				}
				return;
			}
		}
		System.out.println(dayName + "요일은 없는 요일입니다.");
	}
	
	private void printWeekSchedule() {
		System.out.println("▦▦▦ 전체조회 ▦▦▦");
		System.out.println(nthWeek + "주차 스케줄 안내");
		for(int i = 0; i < week.length; i++) {
			System.out.println(dayNames[i] + "요일 - ");
			System.out.println(week[i] == null ? "X" : week[i].getSchedule());
		}
	}

	public void manage() {
		
		while(true) {
			// 실행 시 나오는 첫 출력문
			System.out.print("1.등록 2.수정 3.삭제 4.전체조회 0.종료 >>> ");
			int choice = sc.nextInt();  // 숫자
			sc.nextLine();				// Enter
			
			switch(choice) {
				case 1 : makeSchedule();
					break;
			
				case 2 : changeSchedule();
					break;

				case 3 : deleteSchedule();
					break;
			
				case 4 : printWeekSchedule();
					break;
			
				case 0 : System.out.println("스케줄러를 종료합니다.");
					return;
			
				default : System.out.println("인식할 수 없는 명령입니다.");
					
			}			
		}
	}
}
