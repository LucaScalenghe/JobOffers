package jobOffers;

import java.util.*;

public class Candidate extends Person {
	private Set<Position> applications;

	public Candidate(String name, String[] skills, Set<String> skills2) throws JOException {
		// TODO Auto-generated constructor stub
		super(name, skills, skills2);
		applications = new HashSet<>();
	}

	public void addApplication(Position position) throws JOException {
		// TODO Auto-generated method stub
		if(this.getSkills().containsAll(position.getSkillLevels().keySet())) {
			applications.add(position);
			position.addCandidate(this);
		}else {
			throw new JOException("skill missing.");
		}
		
	}

	public List<String> getInvalidApps() {
		// TODO Auto-generated method stub
		List<String> invalidApps = new ArrayList<>();
		List<Position> tmp = new ArrayList<>();
		for( Position pos : applications) {
			if(pos.isEligible(this)==false) {
				tmp.add(pos);
				invalidApps.add(getName()+":"+pos.getPosition());
			}
			
		}
		applications.removeAll(tmp);		
		
		return invalidApps;
	}

	public Set<Position> getApplications() {
		return applications;
	}

	public void setApplications(Set<Position> applications) {
		this.applications = applications;
	}
	
	
	
	
}
