package com.cg.springass2.Dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="TraineeData")
public class Trainee {
	@Id
	@Column(name="trainee_id")
	int traineeId;
	@Column(name="trainee_name")
	String traineeName;
	@Column(name="trainee_domain")
	String traineeDomain;
	@Column(name="trainee_location")
	String traineeLocation;
	
	public Trainee() {
		// TODO Auto-generated constructor stub
	}
	
	public Trainee(Integer traineeid, String traineeName, String traineeDomain, String traineeLocation){
		this.traineeId = traineeid;
		this.traineeName = traineeName;
		this.traineeDomain = traineeDomain;
		this.traineeLocation = traineeLocation;
		
	}
	
	public int getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	public String getTraineeDomain() {
		return traineeDomain;
	}
	public void setTraineeDomain(String traineeDomain) {
		this.traineeDomain = traineeDomain;
	}
	public String getTraineeLocation() {
		return traineeLocation;
	}
	public void setTraineeLocation(String traineeLocation) {
		this.traineeLocation = traineeLocation;
	}

	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", traineeName="
				+ traineeName + ", traineeDomain=" + traineeDomain
				+ ", traineeLocation=" + traineeLocation + "]";
	}
	
	
}
