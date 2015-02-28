package sms.form;

public class FeeFormBean {

	
	private String regNo;
	private String feeDaposited;
	private String depDate;
	private String fine;
	private String studentClass;
	
	
	/*create table fee(
REGNO		bigint not null,
ROLLNO		bigint,
sCLASS		VARCHAR(10) NOT NULL,
FEEDEP		VARCHAR(10),
DEPDATE		DATETIME,
FINE		VARCHAR(10),
BRANCHCODE		VARCHAR(10)
)
	 * 
	 * */
	
	
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public String getFeeDaposited() {
		return feeDaposited;
	}
	public void setFeeDaposited(String feeDaposited) {
		this.feeDaposited = feeDaposited;
	}
	public String getDepDate() {
		return depDate;
	}
	public void setDepDate(String depDate) {
		this.depDate = depDate;
	}
	public String getFine() {
		return fine;
	}
	public void setFine(String fine) {
		this.fine = fine;
	}
	public String getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
	
}
