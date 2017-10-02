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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
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

    @FXML
    private final TextArea textArea = new TextArea();

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
        try {

            Stage stage = new Stage();
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, 400, 250);
            DatePicker datePicker = new DatePicker(LocalDate.now());
            datePicker.setOnAction(actionEvent -> {
                LocalDate date = datePicker.getValue();
                System.out.println("Selected date: " + date);
            });
            DatePickerSkin datePickerSkin = new DatePickerSkin(datePicker);
            Node popupContent = datePickerSkin.getPopupContent();
            root.setTop(popupContent);
            
            stage.setScene(scene);
            stage.setTitle("Calendar");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
        /*  
        // Date Pattern

        String pattern = "MM/dd/yyyy";

         

        // Create the DatePicker with a given Date

        final DatePicker datePicker = new DatePicker(LocalDate.of(2016, 1, 1));

        // Make the DatePicker editable

        datePicker.setEditable(true);

         

        // Print the new date in the TextArea

        datePicker.setOnAction(new EventHandler<ActionEvent>()

        {

            @Override

             public void handle(ActionEvent event)

             {

                 LocalDate date = datePicker.getValue();

                 writeMessage("Selected date: " + date);

             }

        });

         

        // Create the DateConverter

        FxDatePickerConverter converter = new FxDatePickerConverter(pattern);

        // Add the Converter to the DatePicker

        datePicker.setConverter(converter);

        // Set the Date in the Prompt

        datePicker.setPromptText(pattern.toLowerCase());

                 

        // Create a day cell factory

        Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>()

        {

            public DateCell call(final DatePicker datePicker)

            {

                return new DateCell()

                {

                    @Override

                    public void updateItem(LocalDate item, boolean empty)
                    {

                        // Must call super

                        super.updateItem(item, empty);

 

                        // Show Weekends in blue color

                        DayOfWeek day = DayOfWeek.from(item);

                        if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY)

                        {

                            this.setTextFill(Color.BLUE);

                        }

                         

                        // Disable all future date cells

                        if (item.isBefore(LocalDate.now()))

                        {

                            this.setDisable(true);

                        }

                    }

                };

            }

        };

 

        // Set the day cell factory to the DatePicker

        datePicker.setDayCellFactory(dayCellFactory);

                 

        // Create the Label

        Label selection = new Label("Select your Date:");

        // Create the HBox for the DatePicker

        HBox pickerBox = new HBox(selection, datePicker);

         

        // Set the preferred number of text rows

        textArea.setPrefRowCount(15);

        // Set the preferred number of text columns

        textArea.setPrefColumnCount(25);

 

        // Create the VBox

        VBox root = new VBox();        

        // Add the TreeView to the VBox

        root.getChildren().addAll(pickerBox,textArea);         

        // Set the Style of the VBox

        root.setStyle("-fx-padding: 10;" +

            "-fx-border-style: solid inside;" +

            "-fx-border-width: 2;" +

            "-fx-border-insets: 5;" +

            "-fx-border-radius: 5;" +

            "-fx-border-color: blue;");    

                 

        // Create the Scene

        Scene scene = new Scene(root);

        // Add the Scene to the Stage

        stage.setScene(scene);

        // Set the Title

        stage.setTitle("A DatePicker Control Example");

        // Display the Stage

        stage.show();

        // Set the Size of the Window to the Stage

        stage.sizeToScene();
         */
    }

    /*   private void writeMessage(String msg) {
        this.textArea.appendText(msg + "\n");

    }*/
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
    }
}
