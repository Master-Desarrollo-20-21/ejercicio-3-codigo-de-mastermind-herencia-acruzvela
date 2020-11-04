package cruz;


public class Combination {
    protected static final int COMBINATION_NUMBER=4;
    protected Colors[] colors;

    public Combination() {
        this.colors=new Colors[Combination.COMBINATION_NUMBER];
    }

    public String toString() {
		String out="";
		for(Colors color:this.colors) {
			out+=String.format("%-7s", color.toString().substring(0, color.toString().length()<7?color.toString().length():6));
		}
		return out;
    }
    
    public Colors[] getColors(){
        return this.colors;
    }
    
    
}
