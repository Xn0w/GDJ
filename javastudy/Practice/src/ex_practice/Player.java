package ex_practice;

import java.util.Scanner;

public class Player {
	private String name;
	private Scanner sc;
	
	public Player(String name) {
		this.name = name;
		if(sc == null)
			sc = new Scanner(System.in);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public double turn() { // 엔터와 엔터 사이의 시간을 초로 반환하는 메소드
		System.out.println(name + "님 시작하려면 <Enter>를 누르세요!");
		sc.nextLine();
		long begin = System.currentTimeMillis();
		System.out.println("10초가 된 것 같으면 <Enter>를 누르세요!");
		sc.nextLine();
		long end = System.currentTimeMillis();
		return (end - begin) * 0.001;
	}
}
