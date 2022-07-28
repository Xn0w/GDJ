package ex04_method;

public class VendingMachine {

	//복습할 것
	String getCoffee(int money, int button) {
		
		String[] menu = {"아메리카노", "카페라떼"};
		return menu[button - 1] + " " + (money / 1000) + "잔";
		
		/* 같은 의미
		String[] menu = {"", "아메리카노", "카페라떼"};
		return menu[button] + " " + (money / 1000) + "잔";
		*/
	}

}
