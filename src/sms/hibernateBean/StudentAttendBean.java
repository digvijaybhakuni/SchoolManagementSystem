package sms.hibernateBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="studentAttendance")
public class StudentAttendBean {

	@Id
	@Column(name="REGNO")
	private long regNo;
	
	@Column(name="sCLASS")
	private String sClass;
	
	@Column(name="AttDATE")
	private String attDate;
	
	@Column(name="ATTSTATUS")
	private char attStatus;
	
	@Column(name="BRANCHCODE")
	private String branchCode;

	public long getRegNo() {
		return regNo;
	}

	public void setRegNo(long regNo) {
		this.regNo = regNo;
	}

	public String getsClass() {
		return sClass;
	}

	public void setsClass(String sClass) {
		this.sClass = sClass;
	}

	public String getAttDate() {
		return attDate;
	}

	public void setAttDate(String attDate) {
		this.attDate = attDate;
	}

	public char getAttStatus() {
		return attStatus;
	}

	public void setAttStatus(char attStatus) {
		this.attStatus = attStatus;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	
	
}
