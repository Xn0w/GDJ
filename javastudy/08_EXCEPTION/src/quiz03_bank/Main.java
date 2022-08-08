package quiz03_bank;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank me = new Bank("11111", 10_000);
		Bank mom = new Bank("2222", 100_000);
		
		try {
				mom.transfer(me, 50_000);
		} catch (BankException e) {
			System.out.println(e.getMessage() + "," + e.getErrorCode());
		}
		
		me.inquiry();
		mom.inquiry();
	}

}
