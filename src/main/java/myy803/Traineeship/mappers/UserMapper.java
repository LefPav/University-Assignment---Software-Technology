package myy803.Traineeship.mappers;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import myy803.Traineeship.domainmodel.User;


public interface UserMapper extends JpaRepository<User, String> {
	
	Optional<User> findByUsername(String username);

}
