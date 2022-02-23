public class ExtendedLetter extends Letter {
    private String content;
    private int family;
    private boolean related;
    private int SINGLETON = -1;

    public ExtendedLetter(String s) {
        super('c');
        content = s;
        related = false;
        family = SINGLETON;
    }
    public ExtendedLetter(String s, int fam) {
        super('c');
        content = s;
        related = false;
        family = fam;
    }

    public boolean equals(Object other) {
        if (other instanceof ExtendedLetter) {
            if (family == ((ExtendedLetter) other).family) {
                related = true;
            }
            if (content.equals(((ExtendedLetter) other).content)) {
                return true;
            }
        }
        return false;
    }
    public String toString() {
        if (decorator() == "-" && related) {
            return "." + content + ".";
        }
        String str = decorator();
        return str + content + str;
    }
    public static Letter[] fromStrings(String[] content, int[] codes) {
        Letter[] letters = new Letter[content.length];
        if (codes == null) {
            for (int i=0; i<content.length; i++) {
                letters[i] = new ExtendedLetter(content[i]);
            }
        } else {
            for (int i=0; i<content.length; i++) {
                letters[i] = new ExtendedLetter(content[i], codes[i]);
            }
        }
        return letters;
    }
}
