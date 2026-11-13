package myy803.Traineeship.domainmodel;
import jakarta.persistence.*;

@Entity
@Table(name="student")
@PrimaryKeyJoinColumn(name = "username") // 👈 This line is crucial
public class Student extends User{

	private static final long serialVersionUID = 1L;

	@Column(name="studentName")
	private String studentName;
	
	@Column(name="student_AM")
	private String student_AM;
	
	@Column(name="avgGrade")
	private double avgGrade;
	
	@Column(name="preferredLocation")
	private String 	preferredLocation;
	
	@Column(name="student_interests")
	private String student_interests;
	
	@Column(name="student_skills")
	private String student_skills;
	
	@Column(name="lookingForTraineeship")
	private boolean lookingForTraineeship;
	
	
	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
	private TraineeshipPosition assignedTraineeship;
	
	@ManyToOne
	@JoinColumn(name = "committee_username")
	private Committee appliedForTraineeship;
	
	public Student() {}

	public Student(String username, String password, Role role) {
	    this.username = username;
	    this.password = password;
	    this.role = role;
	}

	public Student(String username, String password, Role role, String studentName, String student_AM, String student_skills, String student_interests, String preferredLocation) {
	    this.studentName = studentName;
	    this.student_AM = student_AM;
	    this.student_skills = student_skills;
	    this.student_interests = student_interests;
	    this.preferredLocation = preferredLocation;
	    this.username = username;
	    this.password = password;
	    this.role = role;
	}

	
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	
	public String getStudent_AM() {
		return student_AM;
	}
	
	public void setStudent_AM(String student_AM) {
		this.student_AM = student_AM;
	}
	
	public double getAvgGrade() {
		return avgGrade;
	}
	
	public void setAvgGrade(double avgGrade) {
		this.avgGrade = avgGrade;
	}
	
	public String getPreferredLocation() {
		return preferredLocation;
	}
	
	public void setPreferredLocation(String preferredLocation) {
		this.preferredLocation = preferredLocation;
	}
	
	public String getStudent_interests() {
		return student_interests;
	}
	
	public void setStudent_interests(String student_interests) {
		this.student_interests = student_interests;
	}
	
	public String getStudent_skills() {
		return student_skills;
	}
	
	public void setStudent_skills(String student_skills) {
		this.student_skills = student_skills;
	}
	
	public boolean getLookingForTraineeship() {
		return lookingForTraineeship;
	}
	
	public void setLookingForTraineeship(boolean lookingForTraineeship) {
		this.lookingForTraineeship = lookingForTraineeship;
	}
	
	public TraineeshipPosition getAssignedTraineeship() {
		return assignedTraineeship;
	}
	
	public void setAssignedTraineeship(TraineeshipPosition assignedTraineeship) {
		this.assignedTraineeship = assignedTraineeship;
	}
	
	public Committee getAppliedForTraineeship() {
		return appliedForTraineeship;
	}
	
	public void setAppliedForTraineeship(Committee appliedForTraineeship) {
		this.appliedForTraineeship = appliedForTraineeship;
	}
	
}
