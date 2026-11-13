package myy803.Traineeship.domainmodel;
import jakarta.persistence.*;

@Entity
@Table(name="evaluation")
public class Evaluation {
	@Id
	@Column(name="evaluation_id", unique= true)
	private Integer evaluation_id;
	
	//@Column(name="evaluvationType")
	//private EvaluationType evaluationType;
	
	@Column(name="motivation")
	private int motivation;
	
	@Column(name="efficiency")
	private int efficiency;
	
	@Column(name="effectiveness")
	private int effectiveness;
	
	
	public Integer getId(){
		return evaluation_id;
	}
	
	public void setId(Integer evaluation_id) {
		this.evaluation_id = evaluation_id;
	}
	
	//public EvaluationType getEvaluationType() {
	//return evaluationType;
	//}
	
	//public void setEvaluationType(EvaluationType evaluationType) {
	//	this.evaluationType = evaluationType;
	//}
	
	public int getMotivation() {
		return motivation;
	}
	
	public void setMotivation(int motivation) {
		this.motivation = motivation;
	}
	
	public int getEfficiency() {
		return efficiency;
	}
	
	public void setEfficiency(int efficiency) {
		this.efficiency = efficiency;
	}
	
	public int getEffectiveness() {
		return effectiveness;
	}
	
	
	public void setEffectiveness(int effectiveness) {
		this.effectiveness = effectiveness;
	}

}
