package accountPage;

public class Account {
	private String account_number,username,balance,type;

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public Account() {
		super();
	}

	public Account(String account_number, String username, String balance, String type) {
		super();
		this.account_number = account_number;
		this.username = username;
		this.balance = balance;
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
