package LEHA;
/*
* developed be Zlatous
*/
public interface I_Zapis {

    Text readFromFile(String fileName);

    void writeToFile(Text text, String fileName);

}
