package kr.ac.kopo.division;

public class DivisionVO {
	
	
	private String accountNo;
	private String divFrom;
	private String divTo;
	private int divMoney;
	private String divDate;
	private int    basicBal;
	private int    parkingBal;
	private int    fixedBal;
	private int    livingBal;
	private int    myPoc1Bal;
	private int    myPoc2Bal;
	private int    myPoc3Bal;
	
	
	/*
	 *  -- dCode VARCHAR2(10) NOT NULL, --내역 코드
	    -- transCode       VARCHAR2(10) NOT NULL, --거래 분류 코드
	    accountNo       VARCHAR2(20) NOT NULL,
	    divFrom         VARCHAR2(20) NOT NULL,
	    divTo           VARCHAR2(10) NOT NULL,
	    divMoney        NUMBER default 0,
	    divDate         DATE default sysdate,
	    basicBal        NUMBER  default 0, 
	    parkingBal      NUMBER  default 0,
	    fixedBal        NUMBER  default 0,
	    livingBal       NUMBER  default 0,
	    myPoc1Bal       NUMBER  default 0,
	    myPoc2Bal       NUMBER  default 0,
	    myPoc3Bal       NUMBER  default 0
	 */
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getDivFrom() {
		return divFrom;
	}
	public void setDivFrom(String divFrom) {
		this.divFrom = divFrom;
	}
	public String getDivTo() {
		return divTo;
	}
	public void setDivTo(String divTo) {
		this.divTo = divTo;
	}
	public int getDivMoney() {
		return divMoney;
	}
	public void setDivMoney(int divMoney) {
		this.divMoney = divMoney;
	}
	public String getDivDate() {
		return divDate;
	}
	public void setDivDate(String divDate) {
		this.divDate = divDate;
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
	public int getMyPoc1Bal() {
		return myPoc1Bal;
	}
	public void setMyPoc1Bal(int myPoc1Bal) {
		this.myPoc1Bal = myPoc1Bal;
	}
	public int getMyPoc2Bal() {
		return myPoc2Bal;
	}
	public void setMyPoc2Bal(int myPoc2Bal) {
		this.myPoc2Bal = myPoc2Bal;
	}
	public int getMyPoc3Bal() {
		return myPoc3Bal;
	}
	public void setMyPoc3Bal(int myPoc3Bal) {
		this.myPoc3Bal = myPoc3Bal;
	}
	@Override
	public String toString() {
		return "DivisionVO [accountNo=" + accountNo + ", divFrom=" + divFrom + ", divTo=" + divTo + ", divMoney="
				+ divMoney + ", divDate=" + divDate + ", basicBal=" + basicBal + ", parkingBal=" + parkingBal
				+ ", fixedBal=" + fixedBal + ", livingBal=" + livingBal + ", myPoc1Bal=" + myPoc1Bal + ", myPoc2Bal="
				+ myPoc2Bal + ", myPoc3Bal=" + myPoc3Bal + "]";
	}
	
}
