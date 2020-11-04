package cruz;

import java.util.ArrayList;

public class Game {
    private final int ATTEMPTS_NUMBER=5;
    private SecretCombination secretCombination;
    private ArrayList<Result> results;
    
    public Game() {
        this.secretCombination=new SecretCombination();
        this.results=new ArrayList<Result>();
    }
    
    public void play(){
        Console console=new Console();
        
        this.secretCombination=this.secretCombination.getRandomCombination();
        console.outln("secretCombination= "+this.secretCombination.toString());
        
        boolean isRight;
		int n=0;
		do {
            String input=this.inputCombination();
            results.add(this.createResult(input));
			isRight=this.secretCombination.isSecretCombination(results.get(results.size()-1));
			console.outln("isRight= "+isRight);
			n++;
			this.PrintResults((n==this.ATTEMPTS_NUMBER)||isRight);
		}
		while(n<this.ATTEMPTS_NUMBER && !isRight);
        if (isRight) {
			console.outln("You win");
		}
		else {
			console.outln("You have exceeded the number of attempts");
		}
    } // play

    private String inputCombination() {
		Console console=new Console();
		console.outln(Colors.printAllColors());
		String inputs;
		do {
			inputs=console.inString("Propose a combination, p.e. rgby: ");
			console.outln("repeated: "+this.repeatedColor(inputs));
		}while(!Colors.contains(inputs) || inputs.length()!=Combination.COMBINATION_NUMBER || this.repeatedColor(inputs));
		return inputs;
    } // inputCombination
    
    private boolean repeatedColor(String input) {
		ArrayList<String> testColors=new ArrayList<String>();
		for(int i=0;i<input.length();i++) {
			if(testColors.contains(input.substring(i, i+1))) {
				return true;
			}
			testColors.add(input.substring(i, i+1));
		}
		return false;
    }
    
    private void PrintResults(boolean displaySecretCombination){
        Console console=new Console();
        console.outln();
		System.out.printf("%-28s     %5s   %5s\n","COMBINATION","WHITE","BLACK");
		console.outln("-----------------------------------------------");
		if(displaySecretCombination) {
			console.outln(this.secretCombination.toString());
		}
		else {
			System.out.printf("%-7s%-7s%-7s%-7s\n","X","X","X","X");
		}
		for (Result result:this.results) {
			console.outln(result.toString());
		}
		console.outln();
    }

    private Result createResult(String input){
        ProposedCombination proposedCombination=new ProposedCombination();
        proposedCombination.createProposedCombination(input);
        return new Result(proposedCombination);
    }
}
