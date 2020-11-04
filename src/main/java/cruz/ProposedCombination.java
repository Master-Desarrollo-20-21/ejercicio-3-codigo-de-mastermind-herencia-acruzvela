package cruz;

import java.util.HashMap;

public class ProposedCombination extends Combination {

    public void createProposedCombination(String inputs) {
		HashMap<Character,Colors> map=Colors.getMap();
		for(int i=0; i<inputs.length();i++) {
			this.colors[i]=map.get(inputs.charAt(i));
		}
	}
    
}
