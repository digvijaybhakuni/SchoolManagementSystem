package sms.hibernateBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="result")
public class ResultBean {

	@Id
	@Column(name="REGNO")
	private long regNo;
	
	@Column(name="SUBJECT_NAME")	
	private String subjectName;
	
	@Column(name="MAX_MARKS")
	private int maxMarks;
	
	@Column(name="PASS_MARKS")
	private int passMarks;
	
	@Column(name="MARKS_OBT")
	private int marksObtn;
	
	@Column(name="status")
	private String status;
	
	@Column(name="sclass")
	private String sClass;

	public long getRegNo() {
		return regNo;
	}

	public void setRegNo(long regNo) {
		this.regNo = regNo;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getMaxMarks() {
		return maxMarks;
	}

	public void setMaxMarks(int maxMarks) {
		this.maxMarks = maxMarks;
	}

	public int getPassMarks() {
		return passMarks;
	}

	public void setPassMarks(int passMarks) {
		this.passMarks = passMarks;
	}

	public int getMarksObtn() {
		return marksObtn;
	}

	public void setMarksObtn(int marksObtn) {
		this.marksObtn = marksObtn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getsClass() {
		return sClass;
	}

	public void setsClass(String sClass) {
		this.sClass = sClass;
	}
	
}
