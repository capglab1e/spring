package com.cg.springass2.Dao;

import java.util.List;

import com.cg.springass2.Dto.Trainee;


public interface TraineeDao {
	public void addTrainee(Trainee trainee);
	public List<Trainee> retrieveAllTrainee();
	public Trainee retrieveATrainee(int id);
	public void deleteATrainee(int id);
	public Trainee modifyATrainee(Trainee trainee);
	
}
