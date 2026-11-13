package myy803.Traineeship.mappers;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import myy803.Traineeship.domainmodel.Company;
import myy803.Traineeship.domainmodel.Student;




public interface CompanyMapper extends JpaRepository<Company, String>{
	Optional<Company> findByCompanyName(String companyName);
	Optional<Company> findByUsername(String username);
}
