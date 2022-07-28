package ex08_access_modifier;

public class UserMain {

	public static void main(String[] args) {
		
		User user = new User();
		
		user.setId("admin");
		System.out.println(user.getId());
		
		user.setPassword("1234");
		System.out.println(user.getPassword());
		
		user.setEmail("lyinsics@gmail.com");
		System.out.println(user.getEmail());
		
		user.setPoint(1000);
		System.out.println(user.getPoint());
		
		
		System.out.println(user.getVip());
		
	}

}
