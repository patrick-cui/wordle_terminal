/**
 * This class represents a word. Each word has a linear node of letters of firsletter
 * @author CS1027 assignment 2
 */
public class Word {
    /**
     * first letter of word
     */
    private LinearNode<Letter> firstLetter;

    /**
     * Constructor creates a word with the given array of letters
     * @param letters array of letters
     */
    public Word(Letter[] letters) {
        firstLetter = new LinearNode<Letter>(letters[0]);
        LinearNode<Letter> current = firstLetter;
        for (int i = 1; i < letters.length; i++) {
            current.setNext(new LinearNode<Letter>(letters[i]));
            current = current.getNext();
        }
    }

    /**
     * Method that return a string presentation of the word
     * @return string representation of the word
     */
    public String toString() {
        String str = "Word: ";
        LinearNode<Letter> current = firstLetter;
        while (current != null) {
            Letter letter = ((Letter)current.getElement());
            str += letter.toString() + " ";
            current = current.getNext();
        }
        return str;
    }

    /**
     * Method that update each of the letter's label attribute
     * @param mystery word
     * @return whether the word is identical to the mystery word
     */
    public boolean labelWord( Word mystery ) {
        LinearNode<Letter> current = firstLetter;
        LinearNode<Letter> currentMystery = mystery.firstLetter;
        boolean identical = true;
        while (current != null) {
            if (currentMystery != null) {
                if (current.getElement().equals(currentMystery.getElement())) {
                    current.getElement().setCorrect();
                } else {
                    identical = false;
                    current.getElement().setUnused();
                    Letter letter = current.getElement();
                    LinearNode<Letter> tmpMystery = mystery.firstLetter;
                    while (tmpMystery != null) {
                        if (letter.equals(tmpMystery.getElement())) {
                            current.getElement().setUsed();
                            break;
                        }
                        tmpMystery = tmpMystery.getNext();
                    }
                }

                currentMystery = currentMystery.getNext();
            } else {
                identical = false;
                current.getElement().setUnused();
                Letter letter = current.getElement();
                LinearNode<Letter> tmpMystery = mystery.firstLetter;
                while (tmpMystery != null) {
                    if (letter.equals(tmpMystery.getElement())) {
                        current.getElement().setUsed();
                        break;
                    }
                    tmpMystery = tmpMystery.getNext();
                }
            }
            current = current.getNext();
        }
        return identical;  
    }
}
