package ex_practice;

public class Gun {
	private String model;
	private int bullet;
	private final int FULL_BULLET = 6;
	
	public Gun(String model) {
		this.model = model;
	}
	
	public void reload(int bullet) {
		this.bullet += bullet;
		if(this.bullet > FULL_BULLET)
			this.bullet = FULL_BULLET;
	}
	
	public void shoot() {
		if(bullet <= 0) {
			System.out.println("총알이 없다.");
			return;
		}
		bullet --;
		System.out.println("빵! " + bullet + "발 남았다.");
	}
	
	public void info() {
		System.out.println(model + "(" + bullet + ")");
	}
}
