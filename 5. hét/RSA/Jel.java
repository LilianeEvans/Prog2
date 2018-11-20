
public class Jel {

    private String szoveg;
    private int elofordulas;
    private char c;

    public Jel(String a) {
        szoveg = new String(a);
        elofordulas = 1;
        c = '_';
    }

    public int getElofordulas() {
        return elofordulas;
    }

    public void incElofordulas() {
        elofordulas++;
    }

    public void setElofordulas(int el) {
        elofordulas = el;
    }

    public String getValue() {
        return szoveg;
    }

    public void setValue(String a) {
        szoveg = a;
    }

    public void setChar(char a) {
        c = a;
    }

    public char getChar() {
        return c;
    }
}
