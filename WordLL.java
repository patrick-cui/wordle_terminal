public class WordLL {
    private Word mysteryWord;
    private LinearNode<Word> history;

    public WordLL(Word mystery) {
        this.mysteryWord = mystery;
        history = new LinearNode<Word>();
    }

    public boolean tryWord(Word guess) {
        System.out.println(guess);
        boolean identical = guess.labelWord(mysteryWord);
        LinearNode<Word> current = history;
        if (current.getElement() == null) {
            history = new LinearNode<Word>(guess);
        } else {
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new LinearNode<Word>(guess));
        }
        return identical;
    }
    public String toString() {
        LinearNode<Word> current = history;
        String str = "";
        while (current != null) {
            str += current.getElement().toString() + "\n";
            current = current.getNext();
        }
        return str;
    }
}
