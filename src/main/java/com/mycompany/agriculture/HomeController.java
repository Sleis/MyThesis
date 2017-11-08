package com.mycompany.agriculture;

import static com.mycompany.agriculture.EditorController.mapDrb;
import com.sun.javafx.scene.control.skin.DatePickerSkin;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.JobsDerby;

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

    @FXML
    private Label labelAlert;

    private static LocalDate dates = LocalDate.now();
    private static boolean wasAlerted = false;
    private static boolean isCalendarOpened = false;

    static JobsDerby jobDrb = new JobsDerby();

    public static void setDates(LocalDate date) {
        HomeController.dates = date;
    }

    public static LocalDate getDates() {
        return HomeController.dates;
    }

    public static void setWasAlerted(boolean bl) {
        HomeController.wasAlerted = bl;
    }

    public static boolean wasAlerted() {
        return HomeController.wasAlerted;
    }

    @FXML
    private void handleEditor(ActionEvent event) throws IOException {
        try {
            ResultSet rs = mapDrb.getSize();
            if (rs.next()) {
                Stage stage;
                Parent root;
                stage = (Stage) editor.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Editor.fxml"));
                root = loader.load();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/NewStage.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(pane.getScene().getWindow());
                stage.resizableProperty().setValue(Boolean.FALSE);
                stage.setScene(new Scene(root));
                stage.show();

            }
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleSetting(ActionEvent event) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/NewStage.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(pane.getScene().getWindow());
            stage.resizableProperty().setValue(Boolean.FALSE);
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    private void handleCalendar(ActionEvent event) throws IOException {
        if (!isCalendarOpened) {
            isCalendarOpened = true;
            Stage stage = new Stage();
            stage.initOwner(pane.getScene().getWindow());
            stage.resizableProperty().setValue(Boolean.FALSE);
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
            stage.setOnCloseRequest(close -> {
                isCalendarOpened = false;
            });
            stage.setScene(scene);
            stage.setTitle("Calendar");
            stage.show();
        }
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
        Platform.exit();
    }

    @FXML
    private void handleAlertClick() {
        labelAlert.setText("");
        HomeController.setWasAlerted(true);
        String com = "";
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.initOwner(pane.getScene().getWindow());
        stage.resizableProperty().setValue(Boolean.FALSE);
        alert.setHeaderText("You have a job for today!");
        for (String var : jobDrb.getJobs(LocalDate.now())) {
            com += var;
            com += System.getProperty("line.separator");
        }
        alert.getDialogPane().setExpandableContent(new ScrollPane(new TextArea(com)));
        alert.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        jobDrb.createDirIfNotExist();
        jobDrb.connectToDatabase();
        jobDrb.createTable();
        mapDrb.createDirIfNotExist();
        mapDrb.connectToDatabase();
        mapDrb.createMapsSizeTable();

        pane.setStyle("-fx-background-image: url(\"/pictures/negy.JPG\");");

        if (!jobDrb.getJobs(LocalDate.now()).isEmpty() && !wasAlerted) {
            labelAlert.setText("You have a notification!");

        }
    }
}
