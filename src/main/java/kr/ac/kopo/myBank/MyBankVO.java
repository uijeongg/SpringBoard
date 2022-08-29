package kr.ac.kopo.myBank;

public class MyBankVO {

	private String accountNo;
	private String accountName;
	private int basicBal;
	private int parkingBal;
	private int fixedBal;
	private int livingBal;
	private int income;
	private String incomeDate;
	private String openDate;
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public int getBasicBal() {
		return basicBal;
	}
	public void setBasicBal(int basicBal) {
		this.basicBal = basicBal;
	}
	public int getParkingBal() {
		return parkingBal;
	}
	public void setParkingBal(int parkingBal) {
		this.parkingBal = parkingBal;
	}
	public int getFixedBal() {
		return fixedBal;
	}
	public void setFixedBal(int fixedBal) {
		this.fixedBal = fixedBal;
	}
	public int getLivingBal() {
		return livingBal;
	}
	public void setLivingBal(int livingBal) {
		this.livingBal = livingBal;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public String getIncomeDate() {
		return incomeDate;
	}
	public void setIncomeDate(String incomeDate) {
		this.incomeDate = incomeDate;
	}
	public String getOpenDate() {
		return openDate;
	}
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}
	@Override
	public String toString() {
		return "MyBankVO [accountNo=" + accountNo + ", accountName=" + accountName + ", basicBal=" + basicBal
				+ ", parkingBal=" + parkingBal + ", fixedBal=" + fixedBal + ", livingBal=" + livingBal + ", income="
				+ income + ", incomeDate=" + incomeDate + ", openDate=" + openDate + "]";
	}
	
	
	
	
}
