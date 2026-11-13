package myy803.Traineeship.domainmodel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "traineeshipPosition")
public class TraineeshipPosition {
	@Id
	@Column(name ="traineeship_id", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name ="traineeship_title")
	private String traineeship_title;
	
	@Column(name = "traineeship_description")
	private String traineeship_description;
	
	@Column(name = "traineeship_startDate")
	private LocalDate traineeship_startDate;
	
	@Column(name="traineeship_endDate")
	private LocalDate traineeship_endDate;
	
	@Column(name ="traineeship_topics")
	private String traineeship_topics;
	
	@Column(name = "traineeship_skills")
	private String traineeship_skills;
	
	@Column(name="traineeship_isAssigned")
	private boolean traineeship_isAssigned;
	
	@Column(name = "traineeship_studentLogbook")
	private String traineeship_studentLogbook;
	
	@Column(name ="traineeship_passFailGrade")
	private boolean traineeship_passFailGrade;
	
	@OneToOne
	@JoinColumn(name = "student_username")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "professor_username")
	private Professor professor;
	
	@ManyToOne
	@JoinColumn(name = "company_username")
	private Company company;
	
	@ManyToOne
	private Committee committee;

	

	
	/*@ManyToMany
    @JoinTable(
        name = "traineeship_evaluation",  // Name of the junction table
        joinColumns = @JoinColumn(name = "traineeship_id"),  // FK to TraineeshipPosition
        inverseJoinColumns = @JoinColumn(name = "evaluation_id")  // FK to Evaluation
    )
	private List<Evaluation> evaluations;*/
	public TraineeshipPosition() {}
	
	public TraineeshipPosition(LocalDate traineeship_startDate, LocalDate traineeship_endDate, String traineeship_description,
			String traineeship_skills, String traineeship_topics) {
		this.traineeship_startDate = traineeship_startDate;
		this.traineeship_endDate = traineeship_endDate;
		this.traineeship_description = traineeship_description;
		this.traineeship_skills = traineeship_skills;
		this.traineeship_topics = traineeship_topics;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer traineeship_id) {
		this.id = traineeship_id;
	}
	
	public String getTitle() {
		return traineeship_title;
	}
	
	public void setTitle(String traineeship_title) {
		this.traineeship_title= traineeship_title;
	}
	
	public String getTraineeship_description() {
	    return traineeship_description;
	}

	public void setTraineeship_description(String traineeship_description) {
	    this.traineeship_description = traineeship_description;
	}
	
	public LocalDate getTraineeship_startDate() {
		return traineeship_startDate;
	}
	
	public void setTraineeship_startDate(LocalDate traineeship_startDate) {
		this.traineeship_startDate = traineeship_startDate;
	}
	
	public LocalDate getTraineeship_endDate() {
		return traineeship_endDate;
	}
	
	public void setTraineeship_endDate(LocalDate traineeship_endDate) {
		this.traineeship_endDate = traineeship_endDate;
	}
	
	public String getTraineeship_topics() {
		return traineeship_topics;
	}
	
	public void setTraineeship_topics(String traineeship_topics) {
		this.traineeship_topics = traineeship_topics;
	}
	
	public String getTraineeship_skills() {
		return traineeship_skills;
	}
	
	public void setTraineeship_skills(String traineeship_skills) {
		this.traineeship_skills = traineeship_skills;
	}
	
	public boolean getIsAssigned() {
		return traineeship_isAssigned;
	}
	
	public void setIsAssigned(boolean traineeship_isAssigned) {
		this.traineeship_isAssigned = traineeship_isAssigned;
	}
	
	public String getStudentLogbook() {
		return traineeship_studentLogbook;
	}
	
	public void setStudentLogbook(String traineeship_studentLogbook) {
		this.traineeship_studentLogbook = traineeship_studentLogbook;
	}
	
	public boolean getPassFailGrade() {
		return traineeship_passFailGrade;
	}
	
	public void setPassFailGrade(boolean traineeship_passFailGrade) {
		this.traineeship_passFailGrade = traineeship_passFailGrade;
	}
	
	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public Professor getProfessor() {
		return professor;
	}
	
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public Company getCompany() {
		return company;
	}
	
	public void setCompany(Company company) {
		this.company = company;
	}
	
	public Committee getCommittee() {
		return committee;
	}
	
	public void setCommittee(Committee committee) {
		this.committee = committee;
	}
	
	/*public List<Evaluation> getEvaluations(){
		return evaluations;
	}
	
	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}*/
	
	
	

}
