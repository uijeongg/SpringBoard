package kr.ac.kopo.addPocket;

public class AddPocketVO {
	
	private String pocketName;
	private String pocketPurpose;
	
	
	public String getPocketName() {
		return pocketName;
	}
	
	public void setPocketName(String pocketName) {
		this.pocketName = pocketName;
	}
	
	public String getPocketPurpose() {
		return pocketPurpose;
	}
	
	public void setPocketPurpose(String pocketPurpose) {
		this.pocketPurpose = pocketPurpose;
	}
	
	@Override
	public String toString() {
		return "AddPocketVO [pocketName=" + pocketName + ", pocketPurpose=" + pocketPurpose + "]";
	}
	
	

}
