package LEHA;
/*
* developed be Zlatous and Oliinik
*/
import javafx.scene.control.TextArea;

import java.io.File;

public class Controller{
    Zapis zapis = new Zapis();
    Text text;
    TextArea field;

    Controller(TextArea field, Text text){
        this.field = field;
        this.text = text;
    }
    Controller(TextArea field){
        this.field = field;
        this.text = new Text("");
    }

    public void openFile(File file){
        text = zapis.readFromFile(file.getAbsolutePath());
        updateView();
    }

    public void saveFile(File file){
        updateModel();
        zapis.writeToFile(text, file.getAbsolutePath());
    }

    public void copyText(String s){
        text.copyWord(new Slovo(s));
    }

    public void pasteText(){
        if(field.getSelectedText() != null && field.getSelectedText().length() > 0) {

        }
        int ind = field.getCaretPosition();
        updateModel();
        text.pasteWord(ind);
        updateView();
        field.positionCaret(ind + text.getBuffer().length());
    }

    public void updateModel(){
        text.setText(field.getText());
    }

    public void updateView(){
        field.setText(text.getText());
    }


}
