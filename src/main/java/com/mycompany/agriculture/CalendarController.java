/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.agriculture;

import static com.mycompany.agriculture.MainApp.conn;
import com.sun.javafx.scene.control.skin.DatePickerSkin;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.layout.Pane;
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
    private Pane pane;

    @FXML
    private Label comment;

    @FXML
    private Label dateLabel;

    @FXML
    private Label errorLabel;

    @FXML
    private Button backButton;

    @FXML
    private Button addButton;

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
            errorLabel.setText("Írjon valami feladatot!");
        } else if (textArea.getText().length() > 100) {
            errorLabel.setText("Legfeljebb 100 karakter!");
        } else {
            try {
                ArrayList<String> ar = new ArrayList<>();
                String com = "";
                Statement stmt = conn.createStatement();
                String ins = "insert into jobs (date,job) values ('" + HomeController.getDates() + "','" + textArea.getText() + "')";
                stmt.executeUpdate(ins);
                ResultSet rs = stmt.executeQuery("SELECT * FROM jobs");
                while (rs.next()) {
                    if (rs.getString("date").equals(HomeController.getDates().toString())) {
                        ar.add(rs.getString("job"));
                    }
                }
                for (String var : ar) {
                    com += var;
                    com += "\r";
                }
                comment.setText(com);
                textArea.clear();

            } catch (SQLException ex) {
                Logger.getLogger(CalendarController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        errorLabel.setTextFill(Color.RED);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        LocalDate dates = HomeController.getDates();
        dateLabel.setText("Dátum: " + dates);
        boolean isThere = false;
        ArrayList<String> ar = new ArrayList<>();
        String com = "";
        Statement stmt;
        try {
            stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM jobs");
            while (rs.next()) {
                if (rs.getString("date").equals(HomeController.getDates().toString())) {
                    ar.add(rs.getString("job"));
                    isThere = true;
                }
            }
            for (String var : ar) {
                com += var;
                com += "\r";
            }
            comment.setText(com);
            if (!isThere) {
                comment.setText("Mára nincs feladat.");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
        }       

    }

}
