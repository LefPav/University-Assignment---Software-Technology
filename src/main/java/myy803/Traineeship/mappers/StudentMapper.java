package myy803.Traineeship.mappers;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import myy803.Traineeship.domainmodel.Student;




public interface StudentMapper extends JpaRepository<Student, String>{
	
	Optional<Student> findByUsername(String username);
	Optional<Student> findByStudentName(String studentName);

	
}
