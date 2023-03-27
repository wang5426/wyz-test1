package com.hdp.pojo;

import java.io.Serializable;

public class Emp implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String sex;
	private String phone;
	private String email;
	private String address;
	private String idCard;
	private String weChat;
	private String notes;
	private Dept dept;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getIdCard() {
		return idCard;
	}


	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}


	public String getWeChat() {
		return weChat;
	}


	public void setWeChat(String weChat) {
		this.weChat = weChat;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public Dept getDept() {
		return dept;
	}


	public void setDept(Dept dept) {
		this.dept = dept;
	}


	public Emp(int id, String name, String sex, String phone, String email, String address, String idCard,
			String weChat, String notes, Dept dept) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.idCard = idCard;
		this.weChat = weChat;
		this.notes = notes;
		this.dept = dept;
	}
	
	


	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", sex=" + sex + ", phone=" + phone + ", email=" + email
				+ ", address=" + address + ", idCard=" + idCard + ", weChat=" + weChat + ", notes=" + notes + ", dept="
				+ dept + "]";
	}


	public Emp() {
		// TODO Auto-generated constructor stub
	}

}
