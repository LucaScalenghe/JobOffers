package jobOffers;

import java.util.*;
import java.util.Set;

public class Person {
	private String name;
	private Set<String> skills;
	private Map<String ,Rating> ratings;
	
	public Person(String name) {
		super();
		skills = new HashSet<>();
		ratings = new HashMap<>();
		this.name = name;
	}

	public Person(String name, String[] skills, Set<String> definedSkills) throws JOException {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.skills = new HashSet<>();
		ratings = new HashMap<>();

		for(String skill: skills) {
				if(definedSkills.contains(skill)) {
					this.addSkill(skill);
				}else {
					throw new JOException("skill not found");
				}
			}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addSkill(String skill) {
		// TODO Auto-generated method stub
		skills.add(skill);
	}

	public Set<String> getSkills() {
		return skills;
	}

	public void setSkills(Set<String> skills) {
		this.skills = skills;
	}

	public void addRating(Rating r) {
		ratings.put(r.getSkill(),r);
	}

	public Map<String, Rating> getRatings() {
		return ratings;
	}

	public void setRatings(Map<String, Rating> ratings) {
		this.ratings = ratings;
	}

	
	
	
}
