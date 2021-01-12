package LEHA;
/*
* developed be Zlatous
*/
public interface I_Text {
    String getText();

    void setText(String text);

    Slovo[] findWords(Slovo slova);

    void cutWord(Slovo slova);

    void copyWord(Slovo slova);

    void pasteWord(int slova);
}
