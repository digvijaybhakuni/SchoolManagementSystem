package sms.hibernateBean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="staff")
public class StaffRegistrationBean {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EMPNO")
	private long empNo;

	@Column(name="EMPNAME")
	private String name;

	@Column(name="ADDRESS")
	private String address;

	@Column(name="STATE")
	private String state;

	@Column(name="PIN")
	private String pin;

	@Column(name="CITY")
	private String city;

	@Column(name="PHONE")
	private String phone;

	@Column(name="MOBILE")
	private String mobile;

	@Column(name="EMAIL")
	private String email;

	@Column(name="SEX")
	private char sex;

	@Column(name="M_STATUS")
	private String maritalStatus;

	@Column(name="DOB")
	private Date dob;

	@Column(name="DOJOINING")
	private Date dateOfJoining;

	@Column(name="NATURE_OF_JOB")
	private String natureOfJob;

	@Column(name="SPECIALIZATION")
	private String specialization;


	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public long getEmpNo() {
		return empNo;
	}
	public void setEmpNo(long empNo) {
		this.empNo = empNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getNatureOfJob() {
		return natureOfJob;
	}
	public void setNatureOfJob(String natureOfJob) {
		this.natureOfJob = natureOfJob;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}



}
