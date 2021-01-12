package LEHA;
/*
* developed be Zlatous 
*/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {
    final TextArea field = new TextArea();

    Controller controller = new Controller(field);

    @Override
    public void start(Stage stage) throws Exception{
                
        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("Фйл");
        Menu editMenu = new Menu("Вибрать");
        Menu helpMenu = new Menu("Пимишчь");

        MenuItem newItem = new MenuItem("Новоий");
        MenuItem openFileItem = new MenuItem("Открить файл");
        MenuItem saveFileItem = new MenuItem("сохранить файл");
        MenuItem exitItem = new MenuItem("Вийти из окна");
        MenuItem copyItem = new MenuItem("Копировать");
        MenuItem pasteItem = new MenuItem("Вставить");

        addActions(stage, newItem, openFileItem, saveFileItem, exitItem, copyItem, pasteItem);

        fileMenu.getItems().addAll(newItem, openFileItem, saveFileItem, exitItem);
        editMenu.getItems().addAll(copyItem, pasteItem);

        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);
        
        BorderPane root = new BorderPane();
        root.setTop(menuBar);

        root.setCenter(field);
           
        Scene scene = new Scene(root, 550, 400);

        stage.setTitle("Super text editor v1.0");
        stage.setScene(scene);
        stage.show();
    }

    private void addActions(Stage stage, MenuItem newItem, MenuItem openFileItem, MenuItem saveFileItem, MenuItem exitItem, MenuItem copyItem, MenuItem pasteItem){
        newItem.setOnAction(actionEvent -> {
            field.clear();
            controller = new Controller(field);
        });
        openFileItem.setOnAction(actionEvent -> {
            File file = new FileChooser().showOpenDialog(stage);
            if (file != null) {
                controller = new Controller(field);
                controller.openFile(file);
            }
        });
        saveFileItem.setOnAction(actionEvent -> {
            FileChooser fileChooser = new FileChooser();

            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);

 
            File file = fileChooser.showSaveDialog(stage);

            if (file != null) {
                controller.saveFile(file);
            }
        });
        exitItem.setOnAction(actionEvent -> System.exit(0));
        copyItem.setOnAction(actionEvent -> {
            controller.copyText(field.getSelectedText());
        });
        pasteItem.setOnAction(actionEvent -> {
            controller.pasteText();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
