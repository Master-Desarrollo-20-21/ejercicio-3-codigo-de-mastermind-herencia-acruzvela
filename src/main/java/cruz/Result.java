package cruz;

import java.util.HashMap;
import java.util.Map.Entry;

public class Result {
    private Combination combination;
    private HashMap<Peg, Integer> pegs;

    public Result(Combination combination) {
        this.combination = combination;
        pegs = new HashMap<Peg, Integer>();
    }

    public Combination getCombination() {
        return this.combination;
    }

    public HashMap<Peg, Integer> getPegs() {
        return this.pegs;
    }

    public void setPeg(Peg peg, int valor) {
        this.pegs.put(peg, valor);
    }

    public int getPeg(Peg peg) {
        return this.pegs.get(peg);
    }

    @Override
    public String toString(){
        String out="";
		for (Entry<Peg, Integer> peg: pegs.entrySet()) {
			out +="   "+String.format("%5s",Integer.toString(peg.getValue()));
		}
        return combination.toString()+out;
    }
    
}
