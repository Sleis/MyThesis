/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.agriculture;

import com.sun.javafx.scene.control.skin.DatePickerSkin;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ivany
 */
public class CalendarController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Pane pane;

    @FXML
    private Label comment;

    @FXML
    private Label date;

    @FXML
    private Button back;

    @FXML
    private void handleBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) date.getScene().getWindow();
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 400, 250);
        DatePicker datePicker = new DatePicker(LocalDate.now());

        DatePickerSkin datePickerSkin = new DatePickerSkin(datePicker);
        Node popupContent = datePickerSkin.getPopupContent();

        popupContent.setOnMouseClicked(actionEvent -> {
            if (0 >= (LocalDate.now().compareTo(datePicker.getValue()))) {
                if (actionEvent.getButton().equals(MouseButton.PRIMARY)) {
                    if (actionEvent.getClickCount() == 2) {
                        HomeController.setDates(datePicker.getValue());
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Calendar.fxml"));
                            Parent root1 = loader.load();
                            stage.setTitle("Megjegyzések");
                            Scene scene1 = new Scene(root1);
                            stage.setScene(scene1);
                            stage.show();

                        } catch (IOException e) {
                            System.out.println(e);
                        }
                    }
                }
            }
        });

        root.setTop(popupContent);

        stage.setScene(scene);
        stage.setTitle("Calendar");
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        LocalDate dates = HomeController.getDates();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy LLLL dd");
        String formattedString = dates.format(formatter);
        date.setText(formattedString);
        comment.setText(HomeController.getComments());
        

    }

}
