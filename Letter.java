public class Letter {
    private char letter;
    private int label;
    private final int UNSET = 0;
    private final int UNUSED = 1;
    private final int USED = 2;
    private final int CORRECT = 3;

    public Letter(char c) {
        letter = c;
        label = UNSET;
    }

    public boolean equals(Object otherObject) {
        if (otherObject instanceof Letter) {
            return letter == ((Letter) otherObject).letter;
        }
        return false;
    }
    public String decorator() {
        switch (label) {
            case USED:
                return "+";
            case UNSET:
                return " ";  
            case CORRECT:
                return "!";     
            case UNUSED:
                return "-"; 
            default:
                return " ";      
        }
    }
    public String toString() {
        return decorator() + letter + decorator();
    }
    public void setUnused() {
        label = UNUSED;
    }
    public void setUsed() {
        label = USED;
    }
    public void setCorrect() {
        label = CORRECT;
    }
    public static Letter[] fromString(String s) {
        Letter[] letters = new Letter[s.length()];
        for (int i = 0; i < s.length(); i++) {
            letters[i] = new Letter(s.charAt(i));
        }
        return letters;
    }
}
