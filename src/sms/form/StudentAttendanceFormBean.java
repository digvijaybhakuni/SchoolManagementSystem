package sms.form;

public class StudentAttendanceFormBean {

	private String className;
	private String [] studentNameList;
	private String [] sRegList;
	private String [] status;
	private String sName;
	private String sReg;
	
	
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsReg() {
		return sReg;
	}
	public void setsReg(String sReg) {
		this.sReg = sReg;
	}
	public String[] getsRegList() {
		return sRegList;
	}
	public void setsRegList(String[] sRegList) {
		this.sRegList = sRegList;
	}
	public String[] getStatus() {
		return status;
	}
	public void setStatus(String[] status) {
		this.status = status;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String[] getStudentNameList() {
		return studentNameList;
	}
	public void setStudentNameList(String[] studentNameList) {
		this.studentNameList = studentNameList;
	}
	
}
