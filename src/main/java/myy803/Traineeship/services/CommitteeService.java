package myy803.Traineeship.services;

import java.util.List;

import myy803.Traineeship.domainmodel.Committee;
import myy803.Traineeship.domainmodel.Student;

public interface CommitteeService {
	public Committee retrieveProfile(Committee committee);
	public void saveProfile(Committee committee);
	public List<Student> listOfStudentsWhoAppliedForPositions(String username);
}
