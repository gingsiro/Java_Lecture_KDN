package chapter06;

/**
 * 마이너스 출금 계좌로 입, 출금 기능을 제공한다. 또한 출금시 설정한 한도만큼 마이너스출금이 가능하다.
 * 
 * @author edu009
 */
public class MinusAccount extends Account {
	/** 마이너스 출금할 수 있는 한도 */
	private int limit = 0;

	/**
	 * 출금기능 balance와 limit이 합쳐진 금액 만큼 잔액이 내려갈 수 있다.
	 * 
	 * @param password
	 *            비밀번호
	 * @param amount
	 *            출금 할 금액
	 * @return 출금 후 잔액
	 */
	public MinusAccount() {
		super();
	}

	public MinusAccount(String no, String password, int balance, int limit) {
		super(no, password, balance);
		setLimit(limit);
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	@Override
	public void setBalance(int balance) {
		if (balance >= -limit) {
			this.balance = balance;
		} else {
			System.out.printf("잔액은 한도 %d원 이하로 설정할 수 없습니다.");
		}
	}

	public int withdraw(String password, int amount) {
		if (password.equals(getPassword())) {
			int balance = getBalance();
			if (balance + limit >= amount)
				setBalance(balance - amount);
			else
				System.out.println("error : 한도가 부족하여 출금할 수 없습니다.");
		} else {
			System.out.println("error : 비밀번호 오류입니다.");
		}
		return getBalance();
	}

	public int getLimit() {
		return limit;
	}
}
