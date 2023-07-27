package jobOffers;

import java.util.LinkedList;
import java.util.List;

public class Candidate {

	private String name;
	private String[] skills;
	private List<String> skillsAsList = new LinkedList<>();
	
	public Candidate(String name, String[] skills) {
		this.name = name;
		this.skills = skills;
		for(String s : skills) {
			skillsAsList.add(s);
		}
	}

	public String getName() {
		return name;
	}

	public String[] getSkills() {
		return skills;
	}

	public List<String> getSkillsAsList() {
		System.out.println(name);
		System.out.print(skillsAsList);
		return skillsAsList;
	}

	
	
	
	
	
//	public Boolean checkPosition(String p) {
//        System.out.println(skillsAsList);
//		if(skillsAsList.contains(p)) return true;
//		return false;
//	}
//	
	
	
	
	
}
