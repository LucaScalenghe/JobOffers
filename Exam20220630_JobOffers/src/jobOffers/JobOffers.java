package jobOffers; 
import java.util.*;

import static java.util.stream.Collectors.*;

public class JobOffers  {
	Set <String> skills = new HashSet<>();
	Map <String, Position> positions = new HashMap<>();
	Map <String, Person> candidates = new HashMap<>();
	Map <String, Person> consultants = new HashMap<>();
	
	
	
//R1
	public int addSkills (String... skills) {
		for(String skill: skills)
			this.skills.add(skill);
		
		return this.skills.size();
	}
	
	public int addPosition (String position, String... skillLevels) throws JOException {
		if(positions.containsKey(position))
			throw new JOException("Position already entered");
		
		Position pos = new Position(position);
		positions.put(position, pos);
		int count = 0;
		int sum = 0;
		
		for(String sl: skillLevels) {
			String fs[] = sl.split(":");
			Integer level = Integer.parseInt(fs[1]);
			if(skills.contains(fs[0]) & level >3 & level < 9) {
				pos.addSkill(fs[0], level);
				count++;
				sum += level;
			}else {
				throw new JOException("Invalid skill or Level");
			}
		}
		
		
		return sum/count;
	}
	
//R2	
	public int addCandidate (String name, String... skills) throws JOException {
		if(candidates.containsKey(name)) {
			throw new JOException("candidate already defined.");
		}
		
		Person cand = new Candidate(name, skills, this.skills);
		candidates.put(name, cand);
	
		return cand.getSkills().size();
	}
	
	
	public List<String> addApplications (String candidate, String... positions) throws JOException {
		
		Candidate cand = (Candidate) candidates.get(candidate);
		List<String> apps = new ArrayList<>();
		if(cand != null) {
			for(String pos: positions) {
				Position position = this.positions.get(pos);
				if(position != null) {
					cand.addApplication(position);
					apps.add(cand.getName()+":"+pos);
				}else {
					throw new JOException("Position not found");
				}
			}
		}else {
			throw new JOException("Candidate not Found");
		}
		
		Collections.sort(apps);
		return apps;
	} 
	
	public TreeMap<String, List<String>> getCandidatesForPositions() {
		TreeMap<String, List<String>> res;
		res = 
		positions.values().stream()
		.filter(p -> p.getCandidates().size()>0)
		.collect(toMap(Position::getPosition, 
					   Position::getCandidatesAsString,
					   (a,b)-> a ,
					   TreeMap::new));
		
		return res;
	}
	
	
//R3
	public int addConsultant (String name, String... skills) throws JOException {
		if(consultants.containsKey(name)) {
			throw new JOException("Consultant already defined.");
		}
		Person cons = new Consultant(name, skills, this.skills);
		consultants.put(name, cons);
	
		return cons.getSkills().size();
	}
	

	public Integer addRatings (String consultant, String candidate, String... skillRatings)  throws JOException {
		Consultant cons = (Consultant) consultants.get(consultant);
		Candidate cand = (Candidate) candidates.get(candidate);
		int sum = 0;
		int count = 0;
		
		if(cons != null & cand != null) {
			Set<String> consSkills = cons.getSkills();
			if(consSkills.containsAll(cand.getSkills())==false)
				throw new JOException("skills missmatch");
			
			for(String skill: skillRatings) {
				String[] fs = skill.split(":");
				Integer level = Integer.parseInt(fs[1]);
				if(consSkills.contains(fs[0]) & level > 3 & level < 11) {
					Rating r = new Rating(cons, cand ,fs[0], level);
					cons.addRating(r);
					cand.addRating(r);
					sum += level;
					count++;
				}else {
					throw new JOException("skills invalid");
				}
			}
				
		}else{
			throw new JOException("Candidate or Consultant not found");
		}
		
		return sum/count;
	}
	
//R4
	public List<String> discardApplications() {
		List<String> discarded = new ArrayList<>();
		
		for(Person cand: candidates.values()) {
			List<String> invalidApps = ((Candidate) cand).getInvalidApps();
			discarded.addAll(invalidApps);
		}
		
		Collections.sort(discarded);
		System.out.println(discarded);
		return discarded;
	}
	
	 
	public List<String> getEligibleCandidates(String position) {
		
		List<String> eligibles = new ArrayList<>();
		eligibles = 
		candidates.values().stream()
		.filter(c -> ((Candidate) c).getApplications().contains(positions.get(position)))
		.filter(c-> positions.get(position).isEligible((Candidate)c))
		.map(c -> c.getName())
		.sorted()
		.collect(toList());
		
		return eligibles;
		
	}
	

	
}

		
