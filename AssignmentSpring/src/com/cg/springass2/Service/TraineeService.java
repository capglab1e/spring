package com.cg.springass2.Service;

import java.util.List;

import com.cg.springass2.Dto.Trainee;

public interface TraineeService {
	public void addTrainee(Trainee trainee);
	public List<Trainee> retrieveAllTrainee();
	public Trainee retrieveATrainee(int id);
	public void deleteATrainee(int id);
	public Trainee modifyATrainee(Trainee trainee);
}
