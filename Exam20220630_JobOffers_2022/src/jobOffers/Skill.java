package jobOffers;

import java.util.HashMap;
import java.util.Map;

public class Skill {

	private String name;
	private Map<String, Candidate> candidates = new HashMap<>();

	public Skill(String name) {
		this.name = name;
	}

	public void addCandidate(String nameCandidate, Candidate c) {
		candidates.put(nameCandidate, c);
	}
	
	
	
	

}
