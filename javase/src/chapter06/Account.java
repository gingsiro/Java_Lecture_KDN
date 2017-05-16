package chapter06;

/**
 * 마이너스 출금이 안되는 단순 계좌로 입, 출금 기능만 제공된다.
 * @author edu009
 */
public class Account {
	private String no;
	/**계좌 비밀 번호*/
	private String password;
	/**계좌 잔액*/
	protected int balance;
	
	public Account(){}
	
	public Account(String no, String password, int balance){
		setNo(no);
		setPassword(password);
		setBalance(balance);
	}
	
	public void setNo(String no) {
		this.no = no;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}

	/**
	 * 입금기능
	 * @param amount 입금 할 금액
	 * @return 입금 후 잔액
	 */
	public int deposit(int amount){
		this.balance += amount;
		return balance;
	}
	
	/**
	 * 출금기능
	 * @param password 비밀번호
	 * @param amount 출금 할 금액
	 * @return 출금 후 잔액
	 */
	public int withdraw(String password, int amount){
		// password 비교후 어마운트를 비교할 것이기때문에
		// 먼저 비교해주는 조건을 입력한다.
		if(this.password == password){
			if(this.balance >= amount) 
				this.balance -= amount;
			else
				System.out.println("error : 잔액이 부족합니다.");
		}else{
			System.out.println("error : 비밀번호 오류입니다.");
		}
		return balance;
	}
	
	public String getNo() {
		return no;
	}

	public String getPassword() {
		return password;
	}

	public int getBalance() {
		return balance;
	}
}
