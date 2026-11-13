package myy803.Traineeship.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myy803.Traineeship.domainmodel.Professor;
import myy803.Traineeship.mappers.ProfessorMapper;

@Service
public class ProfessorServiceImpl implements ProfessorService{
	
	@Autowired
	private ProfessorMapper professorMapper;
	
	public Professor retrieveProfile(Professor professor) {
		Optional<Professor> optionalProfessor = professorMapper.findByUsername(professor.getUsername());
		return optionalProfessor.orElseThrow(() ->
        new RuntimeException("Student profile not found for username: " + professor.getUsername())
		);
	}
	
	public void saveProfile(Professor professor) {
		professorMapper.save(professor);
	}
	
	

}
