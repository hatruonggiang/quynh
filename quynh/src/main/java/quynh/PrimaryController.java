package quynh;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class PrimaryController implements Initializable {
    @FXML
    private TextField chatField;
    @FXML
    private VBox chatBox;

    private String str;

    public void chatBot(String message) {
        if (message.contains("hello") || message.contains("hi")) {
            str = " Hello, I am Chat bot, a OOP advanced project! ";
        } else if (message.contains("how are you")) {
            str = "I'm fine, thank you, and you?";
        } else {
            str = " Sorry, I can't understand! ";
        }
        Label bot = new Label(" Bot");
        bot.getStyleClass().add("user");
        bot.setAlignment(Pos.TOP_LEFT);
        bot.setMaxWidth(chatBox.getPrefWidth());
        Label text = new Label(str);
        text.setWrapText(true);
        text.setMaxWidth(chatBox.getPrefWidth());
        text.getStyleClass().add("botText");
        text.setMinHeight(Region.USE_PREF_SIZE);
        chatBox.getChildren().addAll(bot, text);
    }

    public void send() {
        String message = chatField.getText();
        if (message.isEmpty()) {
            return;
        }
        message += " ";
        Label you = new Label("You ");
        you.getStyleClass().add("user");
        you.setAlignment(Pos.TOP_RIGHT);
        you.setMaxWidth(chatBox.getPrefWidth());
        Label text = new Label(message);
        text.setAlignment(Pos.TOP_RIGHT);
        text.setWrapText(true);
        text.setMaxWidth(chatBox.getPrefWidth());
        text.getStyleClass().add("userText");
        text.setMinHeight(Region.USE_PREF_SIZE);
        chatBox.getChildren().addAll(you, text);
        chatField.clear();

        chatBot(message);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        chatBox.setSpacing(5);
    }
}
