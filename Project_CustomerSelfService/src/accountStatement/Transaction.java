package accountStatement;

public class Transaction {
	private String acc_number,transaction_date,description;
	private int amount,balance;

	public String getAcc_number() {
		return acc_number;
	}

	public void setAcc_number(String acc_number) {
		this.acc_number = acc_number;
	}

	public String getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Transaction(String acc_number, String transaction_date, String description, int amount, int balance) {
		super();
		this.acc_number = acc_number;
		this.transaction_date = transaction_date;
		this.description = description;
		this.amount = amount;
		this.balance = balance;
	}

	public Transaction() {
		super();
	}
	
}
