package LEHA;
/*
* developed be Zlatous 
*/
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Zapis implements I_Zapis {

    @Override
    public Text readFromFile(String fileName) {
        Text text = new Text("");
        try {
            FileReader fileReader = new FileReader(fileName);
            Scanner scanner = new Scanner(fileReader);

            while(scanner.hasNext()) {
                text.setText(text.getText() + scanner.nextLine() + "\n");
            }
            text.setText(text.getText().substring(0,text.getText().length()-2));

            fileReader.close();
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    @Override
    public void writeToFile(Text text, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(text.getText());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}