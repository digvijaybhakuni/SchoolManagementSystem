package sms.hibernateBean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fee")
public class StudentFeeBean {

	private static final long serialVersionUID = -723583058586873479L;

	@Id
	@Column(name="REGNO")
	private long regNo;
	
	@Column(name="FEEDEP")
	private String feeDaposited;
	
	@Column(name="DEPDATE")
	private String depDate;
	
	@Column(name="FINE")
	private String fine;
	
	@Column(name="sCLASS")
	private String studentClass;
	
	@Column(name="ROLLNO")
	private long rollno;
	
	@Column(name="BRANCHCODE")
	private String branchCode;
	
	
	public long getRollno() {
		return rollno;
	}
	public void setRollno(long rollno) {
		this.rollno = rollno;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public long getRegNo() {
		return regNo;
	}
	public void setRegNo(long regNo) {
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
