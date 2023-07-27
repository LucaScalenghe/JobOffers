package jobOffers;

import java.util.*;
import static java.util.stream.Collectors.*;
public class Position {
	private String position;
	private Map<String, Integer> skillLevels;
	private List<Candidate> candidates = new ArrayList<>();
	
	public Position(String position) {
		super();
		this.skillLevels = new HashMap<>();
		this.position = position;
	}
	
	public void addSkill(String skill, int level) {
		skillLevels.put(skill, level);
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Map<String, Integer> getSkillLevels() {
		return skillLevels;
	}

	public void setSkillLevels(Map<String, Integer> skillLevels) {
		this.skillLevels = skillLevels;
	}

	public void addCandidate(Candidate candidate) {
		// TODO Auto-generated method stub
		candidates.add(candidate);
	}

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

	public List<String> getCandidatesAsString() {
		// TODO Auto-generated method stub
		return this.candidates.stream().map(Candidate::getName).sorted().collect(toList());
	}
	
	public boolean isEligible(Candidate cand) {
		Map<String, Rating> ratings = cand.getRatings();
		for(Map.Entry<String, Integer> pair: skillLevels.entrySet()) {
			Rating r = ratings.get(pair.getKey());
			if(r == null || r.getLevel()<pair.getValue())
				return false;
		}
		
		
		return true;
		
		
	}
	
	
}
