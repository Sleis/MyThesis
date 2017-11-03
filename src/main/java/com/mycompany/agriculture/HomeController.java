package com.mycompany.agriculture;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HomeController implements Initializable {

    @FXML
    private Button editor;

    @FXML
    private Button information;

    @FXML
    private Button exit;

    @FXML
    private Button calendar;

    @FXML
    private Pane pane;

    private static LocalDate dates = LocalDate.now();

    private static String comments;

    public static void setComments(String comment) {
        HomeController.comments = comment;
    }

    public static String getComments() {
        return HomeController.comments;
    }

    public static void setDates(LocalDate date) {
        HomeController.dates = date;
    }

    public static LocalDate getDates() {
        return HomeController.dates;
    }

    @FXML
    private void handleEditor(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) editor.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Editor.fxml"));
        root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleSetting(ActionEvent event) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/NewStage.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    private void handleCalendar(ActionEvent event) throws IOException {

        Stage stage = new Stage();
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
    private void handleInformation(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) information.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Information.fxml"));
        root = loader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleExit(ActionEvent event) {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        pane.setStyle("-fx-background-image: url(\"/pictures/negy.JPG\");");
        if (dates.compareTo(LocalDate.now()) == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.setAlwaysOnTop(true);
            stage.toFront(); // not sure if necessary
            alert.setHeaderText("You have a job for today!");
            alert.getDialogPane().setExpandableContent(new ScrollPane(new TextArea("Öntözd meg a növényeket!")));
            alert.show();
            
        }
    }
}
