package LEHA;
/*
* developed be Zlatous
*/
public class Text implements I_Text {
    private Slovo pasteBuffer = new Slovo("");
    private String text;

    public Text(String text) {
        this.text = text;
    }

    public String getBuffer(){
        return pasteBuffer.getText();
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public Slovo[] findWords(Slovo slova) {
        Slovo[] searchResult = new Slovo[0];
        int lastIndex = 0;

        while(lastIndex != -1){
            lastIndex = text.indexOf(slova.getText(),lastIndex);

            if(lastIndex != -1){
                searchResult = new Slovo[searchResult.length + 1];
                for(int i = 0; i < searchResult.length-1; i++){
                    searchResult[i] = searchResult[i];
                }
                searchResult[searchResult.length - 1] = new Slovo(slova.getText(), lastIndex);
                lastIndex += 1;
            }
        }

        return searchResult;
    }

    @Override
    public void cutWord(Slovo slova) {
        pasteBuffer = slova;
        text = text.substring(0, slova.getBeginInd()) + text.substring(slova.getEndInd());
    }

    @Override
    public void copyWord(Slovo slova) {
        pasteBuffer = slova;
    }

    @Override
    public void pasteWord(int ind) {
        text = text.substring(0, ind) + pasteBuffer.getText() + text.substring(ind);
    }
}
