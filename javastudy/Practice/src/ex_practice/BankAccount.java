package ex_practice;

public class BankAccount {
	private String accNo; // 계좌번호
	private long balance; // 잔고
	
	public BankAccount(String accNo, long balance) {
		super();
		this.accNo = accNo;
		this.balance = balance;
	}
	
	// 입금
	
	public void deposit(long money) {
		if(money < 0)
			return;
		balance += money;
	}
	
	// 출금
	
	public boolean withdraw(long money) {
		if(money < 0 || money > balance)
			return false;
		balance -= money;
			return true;
	}
	
	// 이체
	
	public void transfer(BankAccount other, long money) {
		if(this.withdraw(money)) {
			other.deposit(money);
		}
	}
	
	public void inquiry() {
		System.out.println("계좌번호: " + accNo + ", 잔고: " + balance + "원");
	}
}
