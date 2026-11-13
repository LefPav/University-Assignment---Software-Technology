package myy803.Traineeship.services;

import myy803.Traineeship.domainmodel.Professor;

public interface ProfessorService {
	public Professor retrieveProfile(Professor professor);
    public void saveProfile(Professor professor);
}
