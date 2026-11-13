package myy803.Traineeship.services;

import java.util.List;

import myy803.Traineeship.domainmodel.Company;
import myy803.Traineeship.domainmodel.TraineeshipPosition;


public interface CompanyService {
	public Company retrieveProfile(Company company);
    public void saveProfile(Company company);
    public void addTraineeshipPosition(String username, TraineeshipPosition traineeshipPosition);
    public List<TraineeshipPosition> listAvailablePositions(String username);
}
