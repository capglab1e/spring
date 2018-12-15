package com.cg.pwa.Dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Spring")
public class Account {
	
	@Column(name="name")
	String name;
	@Id
	@Column(name="mobile")
	String mobileno;
	@Column(name="balance")
	double bal;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(String Name, String Mobileno, double Bal) {
		super();
		this.name = Name;
		this.mobileno = Mobileno;
		this.bal = Bal;
	}

	public String getName() {
		return name;
	}

	public void setName(String Name) {
		name = Name;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String Mobileno) {
		mobileno = Mobileno;
	}

	public double getBal() {
		return bal;
	}

	public void setBal(double Bal) {
		bal = Bal;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", mobileno=" + mobileno + ", bal="
				+ bal + "]";
	}

	
	
	
	
	
}
