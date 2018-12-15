package com.cg.pwa.Dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.*;
	@Entity
	@Table(name = "banktransactions")
	public class PrintTransactions {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer tranId;
		@Column(name="mobileNumber")
		private String mobileNumber;
		@Column(name="tranType")
		private String tranType;
		@Column(name="amount")
		private double amount;
		@Column(name="tranDate")
		private Date tranDate;
		
		public PrintTransactions() {
			// TODO Auto-generated constructor stub
		}
		
		public PrintTransactions(String mobileNumber, String tranType, double amount) {
			// TODO Auto-generated constructor stub
			this.mobileNumber = mobileNumber;
			this.tranType = tranType;
			this.amount = amount;
			this.tranDate = new Date();
		}
		
		public Integer getTranId() {
			return tranId;
		}
		public void setTranId(Integer tranId) {
			this.tranId = tranId;
		}
		public String getMobileNumber() {
			return mobileNumber;
		}
		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}
		public String getTranType() {
			return tranType;
		}
		public void setTranType(String tranType) {
			this.tranType = tranType;
		}
		public double getAmount() {
			return amount;
		}
		public Date getTranDate() {
			return tranDate;
		}

		public void setTranDate(Date tranDate) {
			this.tranDate = tranDate;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		@Override
		public String toString() {
			return "Transaction ID: " + tranId + ", Mobile Number: "
					+ mobileNumber + ", Transaction Type: " + tranType + ", Amount: "
					+ amount + ", Transaction Date: " + tranDate;
		}
		
		
}
