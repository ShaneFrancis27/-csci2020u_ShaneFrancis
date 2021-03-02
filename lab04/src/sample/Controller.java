package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.awt.*;
import java.time.LocalDate;

public class Controller {
    public TextField userField;
    public TextField nameField;
    public TextField phoneField;
    public DatePicker datepicker;
    @FXML  TextField passwordField;
    @FXML  TextField emailField;

    @FXML
    public void registerButtonPressed(ActionEvent actionEvent) {
        LocalDate date = datepicker.getValue();
        String Name = nameField.getText();
        String User = userField.getText();
        String Phone = phoneField.getText();
        String password = passwordField.getText();
        String email = emailField.getText();

        System.out.print(User+"\n");
        System.out.print(password+"\n");
        System.out.print(Name+"\n");
        System.out.print(email+"\n");
        System.out.print(Phone+"\n");
        System.out.print( date+"\n");
    }
}
