package com.cg.entity;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="Customer_Detailss")
public class Customer {
	@Id
	@JoinColumn(name="USER_ID")
	private Long userId;
	@Column(name="USER_NAME")
	private String name;
	@Column(name="USER_EMAIL")
	private String email;
	@Column(name="CONTACT_NO")
	private String contactNo;
	@Column(name="USER_DOB")
	private  LocalDate dob;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "DOOR_NO")
	private Address address;
	public Customer() {
		super();
	}
	public Customer(Long userId, String name, String email,String contactNo,LocalDate dob,Address address) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.contactNo=contactNo;
		this.dob=dob;
		this.address=address;
				
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo
				+ ", dob=" + dob + ", address=" + address + "]";
	}
	
	
	
}
