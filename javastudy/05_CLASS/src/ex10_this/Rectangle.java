package ex10_this;

public class Rectangle {
	
	// 필드
	private int width;
	private int height;
	
	// 생성자 (생성자의 이름은 클래스와 같다.)
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(int n) {
		this(n, n); // 인수가 2개인 다른 생성자를 호출한다.
		
		/* 같은 의미
		 * this.width = n;
		   this.height = n;
		 */
	}
	
	public int getArea() {
		return width * height;
	}
	
	public int getCircumference() {
		return 2 * (width + height);
	}
	
	
}
