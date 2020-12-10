package com.cg.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="user_table")
public class User {
	
	@Id
	@NotNull(message="Userid should not be empty")
	@Column(name="USER_ID")
	private Long userId;
	@NotEmpty(message="Password should not be empty")
	@Size(min=3, max=5, message="Invalid Password")
	@Column(name="password")
	private String password;
	@NotEmpty(message="Role cannot be null")
	@Column(name="role")
	private String role;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Long userId, String password, String role) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", role=" + role + "]";
	}
	
	
}