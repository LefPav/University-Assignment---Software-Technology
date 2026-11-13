package myy803.Traineeship.services;

import myy803.Traineeship.domainmodel.Student;
import myy803.Traineeship.domainmodel.TraineeshipPosition;


public interface StudentService {
	public Student retrieveProfile(Student student);
    public void saveProfile(Student student);
    public String applyToTraineeship(String studentUsername, String committeeUsername);
   // public void saveLogBook(TraineeshipPosition position);
}

