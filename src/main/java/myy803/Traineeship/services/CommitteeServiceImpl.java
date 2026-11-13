package myy803.Traineeship.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myy803.Traineeship.domainmodel.Committee;
import myy803.Traineeship.domainmodel.Student;
import myy803.Traineeship.domainmodel.TraineeshipPosition;
import myy803.Traineeship.mappers.CommitteeMapper;


@Service
public class CommitteeServiceImpl implements CommitteeService{
	
	@Autowired
	private CommitteeMapper committeeMapper;
	
	
	public Committee retrieveProfile(Committee committee) {
		Optional<Committee> optionalCommittee = committeeMapper.findByUsername(committee.getUsername());
		return optionalCommittee.orElseThrow(() ->
        new RuntimeException("Committee profile not found for username: " + committee.getUsername())
       );
	}
	
	public void saveProfile(Committee committee) {
		committeeMapper.save(committee);
	}
	
	public List<Student> listOfStudentsWhoAppliedForPositions(String username){
		Optional<Committee> optCommittee = committeeMapper.findByUsername(username);
		if(optCommittee.isPresent()) {
			Committee committee = optCommittee.get();
			System.out.println("HIIIII");
			return committee.getApplicants();
		}
		return Collections.emptyList();
	}

}
