package cruz;

import java.util.HashMap;
import java.util.Random;

public class SecretCombination extends Combination {

    public SecretCombination getRandomCombination() {
		HashMap<Character,Colors> map=Colors.getMap();
        Random rnd=new Random();
        for (int i=0;i<Combination.COMBINATION_NUMBER;i++){
            int number;
            int j=Combination.COMBINATION_NUMBER;
            do{
                number=rnd.nextInt(Colors.values().length);
                for(j=0;j<i;j++) {
                    if (map.get(Colors.values()[number].getNickname())==colors[j]) {
                    	break;
                    }
                }
            }while(j<i);
            this.colors[i]=Colors.values()[number];
        }
		return this;
    } // getRandomCombination
    
    public boolean isSecretCombination(Result result) {
		Colors[] aux=new Colors[Combination.COMBINATION_NUMBER];
		for (int i=0;i<Combination.COMBINATION_NUMBER;i++) {
			aux[i]=result.getCombination().getColors()[i];
		}
		calculatePeg(result, aux, Peg.BLACK);
		calculatePeg(result, aux, Peg.WHITE);

		if(result.getPeg(Peg.BLACK)==Combination.COMBINATION_NUMBER) {
			return true;
		}
		return false;
	}

	private void calculatePeg(Result result, Colors[] aux, Peg color){
		result.setPeg(color, 0);
		for(int i=0;i<this.getColors().length;i++) {
			for(int j=0;j<aux.length;j++) {
				if(this.getColors()[i]==aux[j] && ((i==j && color==Peg.BLACK) || color==Peg.WHITE)) {
					result.setPeg(color, result.getPeg(color)+1);
					aux[j]=null;
				}
			}
		}
	}
}
