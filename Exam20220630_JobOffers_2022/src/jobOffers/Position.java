package jobOffers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Position {

	private String name;
	private Map<String,Integer> skills = new HashMap<>();
	public Position(String name) {
		this.name = name;
	}

	
	public void addSkill(String capacita, int quanto) {

		skills.put(capacita, quanto);
	}


	public boolean checkIfCompatible(List<String> skillsAsList) {
		System.out.println(skillsAsList);
		for(String s : skillsAsList) {
			System.out.println("Ciao");

			if(!skills.containsKey(s)) {
				System.out.println("PASSA");
				return false;
			}
		}
		
		return true;
	}
	

}
