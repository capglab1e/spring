package com.cg.springass2.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.springass2.Dto.Trainee;



@Repository("traineedao")
public class TraineeDaoImpl implements TraineeDao {
	@PersistenceContext
	EntityManager em;

	@Override
	public void addTrainee(Trainee trainee) {
		// TODO Auto-generated method stub
	em.persist(trainee);
	em.flush();
	}

	@Override
	public List<Trainee> retrieveAllTrainee() {
		// TODO Auto-generated method stub
		Query queryOne=em.createQuery("FROM Trainee");
		List<Trainee> myList=queryOne.getResultList();
		return myList;
		
	}

	@Override
	public Trainee retrieveATrainee(int id) {
		// TODO Auto-generated method stub
		Query QueryTwo=em.createQuery("FROM Trainee WHERE traineeId=:tid");
		QueryTwo.setParameter("tid", id);
		Trainee tran=(Trainee) QueryTwo.getResultList().get(0);
		return tran;
	}

	@Override
	public void deleteATrainee(int id) {
		// TODO Auto-generated method stub
		/*Query QueryThree=em.createQuery("DELETE FROM Trainee WHERE traineeId=:tid");
		QueryThree.setParameter("tid", id);
		QueryThree.executeUpdate();*/
		Trainee obj=em.find(Trainee.class, id);
		em.remove(obj);
	}

	/*@Override
	public void modifyATrainee(int id) {
		// TODO Auto-generated method stub
		Query QueryThree=em.createQuery("UPDATE Trainee SET traineeName=:nm,traineeDesignation=:dg WHERE traineeId=:tid");
		QueryThree.setParameter("tid",id);
		QueryThree.executeUpdate();
	}*/

	@Override
	public Trainee modifyATrainee(Trainee trainee) {
		// TODO Auto-generated method stub
		Query QueryThree=em.createQuery("UPDATE Trainee SET traineeName=:nm,traineeDomain=:dm WHERE traineeId=:tid");
		QueryThree.setParameter("tid",trainee.getTraineeId());
		QueryThree.setParameter("nm",trainee.getTraineeName());
		QueryThree.setParameter("dm",trainee.getTraineeDomain());
		QueryThree.executeUpdate();
		
		Query querySearch1 =em.createQuery("FROM Trainee WHERE traineeId=:traineedata2");
		querySearch1.setParameter("traineedata2",trainee.getTraineeId());
		Trainee traineeSearch1=(Trainee) querySearch1.getResultList().get(0);
		
		// TODO Auto-generated method stub
		return traineeSearch1;
	}


	
	
}
