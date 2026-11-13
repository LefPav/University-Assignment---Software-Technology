package myy803.Traineeship.domainmodel;

import java.util.List;
import jakarta.persistence.*;


@Entity
@Table(name= "professor")
@PrimaryKeyJoinColumn(name = "username") 
public class Professor extends User{ 
	
	private static final long serialVersionUID = 1L;

	@Column(name= "professorName")
	private String professorName;
	
	@Column(name= "professor_interests")
	private String professor_interests;
	
	@OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TraineeshipPosition> supervisedPositions;
	
	public Professor() {}
	
	public Professor(String username, String password, Role role) {
	    this.username = username;
	    this.password = password;
	    this.role = role;
	}
	
	
	public String getProfessorName() {
		return professorName;
	}
	
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	
	public String getProfessor_interests() {
		return professor_interests;
	}
	
	public void setProfessor_interests(String professor_interests) {
		this.professor_interests = professor_interests;
	}
	
	public List<TraineeshipPosition> getSupervisedPositions(){
		return supervisedPositions;
	}
	
	public void setSupervisedPositions(List<TraineeshipPosition> supervisedPositions) {
		this.supervisedPositions = supervisedPositions;
	}
}
