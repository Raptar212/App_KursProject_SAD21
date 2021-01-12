package LEHA;
/*
* developed be Zlatous
*/
public class Slovo implements I_Slovo {
    private String text;
    private int beginInd;
    private int endInd;

    public Slovo(String slova) {
        this.text = slova;
        endInd = slova.length();
    }

    public Slovo(String slova, int beginInd) {
        this.text = slova;
        this.beginInd = beginInd;
        endInd = beginInd + slova.length();
    }

    @Override
    public int getBeginInd() {
        return beginInd;
    }

    @Override
    public void setBeginInd(int ind) {
        beginInd = ind;
    }

    @Override
    public int getEndInd() {
        return endInd;
    }

    @Override
    public void setEndInd(int ind) {
        endInd = ind;
    }

    @Override
    public int getLength() {
        return text.length();
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setWord(Slovo slova) {
        this.text = slova.getText();
        this.beginInd = slova.getBeginInd();
    }
}
