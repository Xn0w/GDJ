package ex02_constructor;

public class User {

	
	private int userNo;
	private String id;
	private String email;

	public User(int userNo, String id, String email) {
		super();
		this.userNo = userNo;
		this.id = id;
		this.email = email;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
}
