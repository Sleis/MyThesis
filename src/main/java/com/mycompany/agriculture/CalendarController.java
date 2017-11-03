/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.agriculture;

import static com.mycompany.agriculture.HomeController.drb;
import com.sun.javafx.scene.control.skin.DatePickerSkin;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
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
    private Label comment;

    @FXML
    private Label dateLabel;

    @FXML
    private Label errorLabel;

    @FXML
    private Label errorLabel1;

    @FXML
    private Button backButton;

    @FXML
    private Button addButton;

    @FXML
    private Button resetButton;

    @FXML
    private TextArea textArea;

    @FXML
    private void handleBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) comment.getScene().getWindow();
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
                            stage.setTitle("Jobs");
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

    @FXML
    private void handleAdd(ActionEvent event) {
        if (textArea.getText().isEmpty()) {
            errorLabel1.setText("Type a job!");
            errorLabel1.setTextFill(Color.RED);

        } else if (textArea.getText().length() > 100) {
            errorLabel.setText("Maximum 100 charachters!");
            errorLabel.setTextFill(Color.RED);

        } else {
            drb.addNewJob(textArea.getText(), HomeController.getDates());
            textArea.clear();
            String com = "";
            for (String var : drb.getJobs(HomeController.getDates())) {
                com += var;
                com += System.getProperty("line.separator");
            }
            comment.setText(com);

        }

    }

    @FXML
    private void handleReset(ActionEvent event) {
        drb.deleteJobs(HomeController.getDates());
        comment.setText("You haven't got any jobs today.");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        // TODO
        dateLabel.setText("Date: " + HomeController.getDates());
        String com = "";
        if (drb.getJobs(HomeController.getDates()).isEmpty()) {
            comment.setText("You haven't got any jobs today.");
        } else {
            for (String var : drb.getJobs(HomeController.getDates())) {
                com += var;
                com += "\r";
            }
            comment.setText(com);
        }
    }
}
