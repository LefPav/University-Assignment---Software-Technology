package myy803.Traineeship.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import myy803.Traineeship.domainmodel.Company;
import myy803.Traineeship.domainmodel.TraineeshipPosition;
import myy803.Traineeship.mappers.CompanyMapper;
import myy803.Traineeship.mappers.TraineeshipPositionsMapper;

@Service
public class CompanyServiceImpl  implements CompanyService {
	
	@Autowired
	private CompanyMapper companyMapper;
	@Autowired
	private TraineeshipPositionsMapper traineeshipPositionMapper;
	
	public Company retrieveProfile(Company company) {
		Optional<Company> optionalCompany = companyMapper.findByUsername(company.getUsername());
		return optionalCompany.orElseThrow(() ->
        new RuntimeException("Student profile not found for username: " + company.getUsername())
       );
	}
	
	public void saveProfile(Company company) {
		companyMapper.save(company);
	}
	
	public void addTraineeshipPosition(String username, TraineeshipPosition traineeshipPosition) {
		Optional<Company> optionalCompany = companyMapper.findByUsername(username);

	    if (optionalCompany.isPresent()) {
	        Company company = optionalCompany.get();

	        if (company.getPositions() == null) {
	            company.setPositions(new ArrayList<>());
	        }

	        company.getPositions().add(traineeshipPosition);
	        traineeshipPosition.setCompany(company);
	        traineeshipPositionMapper.save(traineeshipPosition);

	        companyMapper.save(company); 
	    } else {
	        throw new RuntimeException("Company not found with username: " + username);
	    }
	}
	
	public List<TraineeshipPosition> listAvailablePositions(String username) {
		Optional<Company> optionalCompany = companyMapper.findByUsername(username);
		
		if (optionalCompany.isPresent()) {
	        Company company = optionalCompany.get();
	        return company.getPositions();
	        
		}
		return Collections.emptyList();   
	}
	
}
