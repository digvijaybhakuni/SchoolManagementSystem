package sms.hibernateBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class StudentAdmission {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "regno")
	private long regno;
	
	@Column(name="rollno")
	private long rollno=0l;
	
	public long getRollno() {
		return rollno;
	}
	public void setRollno(long rollno) {
		this.rollno = rollno;
	}
	@Column(name = "fname")
	private String fName;
	
	@Column(name = "lname")
	private String lame;
	
	@Column(name = "name")
	private String mName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "pin")
	private String pin;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "phone")
	private String mobile;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "sex")
	private String sex;
	
	@Column(name = "dob")
	private String dob;
	
	@Column(name = "dor")
	private String dateOfAdmission;
	
	@Column(name = "sclass")
	private String studentClass;
	
	@Column(name = "BLOODGROUP")
	private String bloodGroup;
	
	@Column(name="BRANCHCODE")
	private String branchcode;
	
	
	public String getBranchcode() {
		return branchcode;
	}
	public void setBranchcode(String branchcode) {
		this.branchcode = branchcode;
	}
	public long getRegno() {
		return regno;
	}
	public void setRegno(long regno) {
		this.regno = regno;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getLame() {
		return lame;
	}
	public void setLame(String lame) {
		this.lame = lame;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDateOfAdmission() {
		return dateOfAdmission;
	}
	public void setDateOfAdmission(String dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}
	public String getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

}
