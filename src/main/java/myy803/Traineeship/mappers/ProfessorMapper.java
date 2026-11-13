package myy803.Traineeship.mappers;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import myy803.Traineeship.domainmodel.Professor;




public interface ProfessorMapper extends JpaRepository<Professor, String>{
	Optional<Professor> findByUsername(String username);
}
