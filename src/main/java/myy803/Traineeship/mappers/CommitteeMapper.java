package myy803.Traineeship.mappers;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import myy803.Traineeship.domainmodel.Committee;


public interface CommitteeMapper extends JpaRepository<Committee, String>{
	Optional<Committee> findByCommitteeName(String committeeName);
	Optional<Committee> findByUsername(String username);
}