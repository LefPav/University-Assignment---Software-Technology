package myy803.Traineeship.domainmodel;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "committee")
@PrimaryKeyJoinColumn(name = "username")
public class Committee extends User {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "name")
	private String committeeName;
	
	@OneToMany(mappedBy = "appliedForTraineeship", cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
	private List<Student> applicants;
	
	@OneToMany(mappedBy = "committee")
	private List<TraineeshipPosition> positions;
	
	public Committee() {}
	
	public Committee(String username, String password, Role role) {
	    this.username = username;
	    this.password = password;
	    this.role = role;
	}
	
	public List<Student> getApplicants(){
		return applicants;
	}
	
	public void setApplicants(List<Student> applicants) {
		this.applicants = applicants;
	}

	public String getCommitteeName() {
		return committeeName;
	}
	
	public void setCommitteeName(String committeeName) {
		this.committeeName = committeeName;
	}
	
	

	
	
	
	

}
