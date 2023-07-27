package jobOffers;

public class Rating {
	
	Consultant consultant; Candidate candidate; String skill; Integer level;



	public Rating(Consultant consultant, Candidate candidate, String skill, Integer level) {
		super();
		this.consultant = consultant;
		this.candidate = candidate;
		this.skill = skill;
		this.level = level;
	}



	public Consultant getConsultant() {
		return consultant;
	}



	public void setConsultant(Consultant consultant) {
		this.consultant = consultant;
	}



	public Candidate getCandidate() {
		return candidate;
	}



	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}



	public String getSkill() {
		return skill;
	}



	public void setSkill(String skill) {
		this.skill = skill;
	}



	public Integer getLevel() {
		return level;
	}



	public void setLevel(Integer level) {
		this.level = level;
	}

}