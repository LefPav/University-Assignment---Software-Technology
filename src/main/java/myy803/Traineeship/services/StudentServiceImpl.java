package myy803.Traineeship.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myy803.Traineeship.domainmodel.Committee;
import myy803.Traineeship.domainmodel.Student;
import myy803.Traineeship.domainmodel.TraineeshipPosition;
import myy803.Traineeship.domainmodel.User;
import myy803.Traineeship.mappers.CommitteeMapper;
import myy803.Traineeship.mappers.StudentMapper;
import myy803.Traineeship.mappers.TraineeshipPositionsMapper;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private CommitteeMapper committeeMapper;
	
	@Override
	public Student retrieveProfile(Student student) {
		Optional<Student> optionalStudent = studentMapper.findByUsername(student.getUsername());
		return optionalStudent.orElseThrow(() ->
        new RuntimeException("Student profile not found for username: " + student.getUsername())
    );
		
	}
	
	@Override
	public void saveProfile(Student student) {
		studentMapper.save(student);
	}
	
	
	@Override
	public String applyToTraineeship(String studentUsername, String committeeUsername) {
	    Student student = studentMapper.findByUsername(studentUsername).orElseThrow(() -> new RuntimeException("Student not found"));
	    Committee committee = committeeMapper.findByUsername(committeeUsername).orElseThrow(() -> new RuntimeException("Committee not found"));
	    System.out.println(student.getLookingForTraineeship());
	   
	    if (student.getLookingForTraineeship()) {
	        throw new RuntimeException("Student " + studentUsername + " has already applied for a traineeship.");
	    }
	    student.setLookingForTraineeship(true);
	    student.setAppliedForTraineeship(committee);
	    committee.getApplicants().add(student);
	    committeeMapper.save(committee);
	    studentMapper.save(student);

	    return "Successfully applied to " + committeeUsername;
	}





}
