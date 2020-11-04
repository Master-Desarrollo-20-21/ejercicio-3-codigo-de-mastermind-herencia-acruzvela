package cruz;

import java.util.HashMap;

public enum Colors {
    BLUE('b'),
    GREEN('g'),
    CYAN('c'),
    RED('r'),
    PURPLE('p'),
    ORANGE('o'),
    VIOLET('v'),
    YELLOW('y');

    private char nickname;
    
    private Colors(char nickname){
        this.nickname=nickname;
    }
    
    public char getNickname(){
        return this.nickname;
    }
    
    public void setNickname(char nickname) {
    	this.nickname=nickname;
    }
    
    public static String printAllColors(){
        String out="";
    
        for (Colors color : Colors.values()) {
            out+=color+"("+color.getNickname()+"), ";
        }
        return out.substring(0,out.length()-2);
    }
    
    public static boolean contains(String cadena) {
    	boolean contained;
		for(int i=0;i<cadena.length();i++) {
			contained=false;
			for (Colors color : Colors.values()) {
				if(color.getNickname()==cadena.charAt(i)) {
					contained=true;
				}
			}
			if(contained==false) {
				return false;
			}
		}
		return true;
    }
    
    public static HashMap<Character, Colors> getMap() {
		HashMap<Character,Colors> map=new HashMap<Character,Colors>();
		for (int i=0;i<Colors.values().length;i++) {
			map.put(Colors.values()[i].getNickname(), Colors.values()[i]);
		}
		return map;
	}

}
