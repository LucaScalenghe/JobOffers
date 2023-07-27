package jobOffers; 
import java.util.*;
import java.util.stream.Collectors;


public class JobOffers  {

	
	
	private Map<String, Skill> skills = new HashMap<>();
	private Map<String, Position> positions = new HashMap<>();
	private Map<String, Candidate> candidates = new HashMap<>();
	/*
	 * 
	 * 
	 * RIGUARDARSI COME CONFRONTARE String[] qualcosa, vedere se tutto è contenuto in un altro oggetto
	 * */
//R1
	public int addSkills (String... skills) {
		for(String s : skills){
			if(!this.skills.containsKey(s)) {
				Skill sk = new Skill(s);
				this.skills.put(s, sk);
			}
		}
		
		return this.skills.size();
	}
	
	public int addPosition (String position, String... skillLevels) throws JOException {

		if(positions.containsKey(position)) throw new JOException("Error");
		
		Position p = new Position(position);

		int contatore = 0;
		int sum = 0;
		for (String s : skillLevels) {
			
			String[] c = s.split(":");
			String capacita = c[0];
			int quanto = Integer.parseInt(c[1]);
			
			if(!skills.containsKey(capacita) || (quanto < 4 & quanto >8) ) throw new JOException("Error");
			
			contatore ++;
			sum = sum + quanto;
			
			
			p.addSkill(capacita,quanto);
		}
		
		positions.put(position, p);
		
		
		
		return sum/contatore;
	}
	
//R2	
	public int addCandidate (String name, String... skills) throws JOException {
		if(candidates.containsKey(name) ) throw new JOException("");
		
		for(String s : skills){
			if(!this.skills.containsKey(s)) {throw new JOException("");}
			}
		
		Candidate c = new Candidate(name,skills);
		candidates.put(name,c);
		
		for(String s : skills) {
			this.skills.get(s).addCandidate(name,c);
		}
		
		return skills.length;
	}
	
	
	
	public List<String> addApplications (String candidate, String... positions) throws JOException {
		if(!candidates.containsKey(candidate)) throw new JOException("");
		
		for(String p : positions) {
			if(!this.positions.containsKey(p)) throw new JOException("");
		}
		for (String p : positions) {
			System.out.println(p);
			if(!this.positions.get(p).checkIfCompatible(candidates.get(candidate).getSkillsAsList())) throw new JOException("");
		}
		
		
		List<String> l = new LinkedList<>();

		for(String s : positions) {
			String str = candidate + ":" + s;
			l.add(str);
		}
		
		return l.stream().sorted().collect(Collectors.toList());
	} 
	
	public TreeMap<String, List<String>> getCandidatesForPositions() {
		return null;
	}
	
	
//R3
	public int addConsultant (String name, String... skills) throws JOException {
		return -1;
	}
	
	public Integer addRatings (String consultant, String candidate, String... skillRatings)  throws JOException {
		return -1;
	}
	
//R4
	public List<String> discardApplications() {
		return null;
	}
	
	 
	public List<String> getEligibleCandidates(String position) {
		return null;
	}
	

	
}

		
