package myy803.Traineeship.domainmodel;

import java.util.List;
import jakarta.persistence.*;


@Entity
@Table(name = "company")
@PrimaryKeyJoinColumn(name = "username")
public class Company extends User{
	
	private static final long serialVersionUID = 1L;

	@Column(name= "companyName")
	private String companyName;
	
	@Column(name= "companyLocation")
	private String companyLocation;
	
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TraineeshipPosition> positions;
	
	public Company() {}
	
	public Company(String username, String password, Role role) {
	    this.username = username;
	    this.password = password;
	    this.role = role;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getCompanyLocation() {
		return companyLocation;
	}
	
	public void setCompanyLocation(String companyLocation) {
		this.companyLocation = companyLocation;
	}
	
	public List<TraineeshipPosition> getPositions(){
		return positions;
	}
	
	public void setPositions(List<TraineeshipPosition> positions) {
		this.positions = positions;
	}
}
