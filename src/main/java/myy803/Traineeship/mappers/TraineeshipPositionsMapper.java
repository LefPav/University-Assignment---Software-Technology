package myy803.Traineeship.mappers;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import myy803.Traineeship.domainmodel.TraineeshipPosition;



public interface TraineeshipPositionsMapper extends JpaRepository<TraineeshipPosition, Integer>{
	Optional<TraineeshipPosition> findById(Integer id);
}
