package kr.ac.kopo.account;

public class AccountVO {

	private String id;
	private String accountName;
	private String accountNo;
	private String accountPw;
	private int balance;
	private String openDate;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountPw() {
		return accountPw;
	}
	public void setAccountPw(String accountPw) {
		this.accountPw = accountPw;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getOpenDate() {
		return openDate;
	}
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}
	@Override
	public String toString() {
		return "AccountVO [id=" + id + ", accountName=" + accountName + ", accountNo=" + accountNo + ", accountPw="
				+ accountPw + ", balance=" + balance + ", openDate=" + openDate + "]";
	}
	
	
	
	
}


