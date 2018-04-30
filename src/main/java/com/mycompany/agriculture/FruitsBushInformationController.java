/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.agriculture;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Plants.Area;
import model.Plants.FruitsBush;
import model.Plants.Interval;
import model.Plants.Produce;
import model.Plants.Soils;

/**
 * FXML Controller class
 *
 * @author ivany
 */
public class FruitsBushInformationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label fruitsBushName;

    @FXML
    private Label fruitsBushSoil;

    @FXML
    private Label fruitsBushPlanting;

    @FXML
    private Label fruitsBushCultivationMethod;

    @FXML
    private Label fruitsBushArea;

    @FXML
    private Label fruitsBushLifeTime;

    @FXML
    private Label fruitsBushCare;

    @FXML
    private Label fruitsBushPicking;

    @FXML
    private Label fruitsBushProduce;

    @FXML
    private Button buttonBack;

    @FXML
    private void handleBack(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) buttonBack.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Information.fxml"));
        root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Locale locale = new Locale("hu", "HU");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM", locale);
        FruitsBush plants;
        switch (EditorController.typeOfPlant) {
            case MÁLNA:
                plants = new FruitsBush("málna", new Area(100, 50), "sövény", 10,
                        new Soils[]{Soils.BARNAERDŐTALAJ, Soils.CSERNOZJOM},
                        new Interval(LocalDate.of(2018, Month.SEPTEMBER, 1), LocalDate.of(2018, Month.NOVEMBER, 30)),
                        new String[]{"vissazvágás", "metszés", "öntözés"},
                        new Interval(LocalDate.of(2018, Month.JUNE, 25), LocalDate.of(2018, Month.JULY, 30)),
                        new Produce(1, 2));
                fruitsBushName.setText("málna");
                fruitsBushCare.setText(Arrays.toString(plants.getCare()).substring(1, Arrays.toString(plants.getCare()).length() - 1));
                fruitsBushPicking.setText(plants.getPicking().getMinDate().format(formatter) + " " + plants.getPicking().getMinDate().getDayOfMonth()
                        + "-" + plants.getPicking().getMaxDate().format(formatter) + " " + plants.getPicking().getMaxDate().getDayOfMonth() + " között");
                fruitsBushPlanting.setText(plants.getPlanting().getMinDate().format(formatter) + " " + plants.getPlanting().getMinDate().getDayOfMonth()
                        + "-" + plants.getPlanting().getMaxDate().format(formatter) + " " + plants.getPlanting().getMaxDate().getDayOfMonth() + " között");
                fruitsBushSoil.setText(Arrays.toString(plants.getSoil()).toLowerCase().substring(1, Arrays.toString(plants.getSoil()).length() - 1));
                fruitsBushProduce.setText(plants.getProduce().getMin() + "-" + plants.getProduce().getMax() + "kg/futóméter/év");
                fruitsBushCultivationMethod.setText(plants.getCultivationMethod());
                fruitsBushArea.setText(plants.getArea().getHeigth() + "cm*" + plants.getArea().getWidth() + "cm");
                fruitsBushLifeTime.setText(plants.getLifetime() + "év");
                break;
            case EPER:
                plants = new FruitsBush("eper", new Area(30, 15), "sövény", 5,
                        new Soils[]{Soils.HOMOKTALAJ, Soils.BARNAERDŐTALAJ},
                        new Interval(LocalDate.of(2018, Month.SEPTEMBER, 1), LocalDate.of(2018, Month.NOVEMBER, 30)),
                        new String[]{"öntözés"},
                        new Interval(LocalDate.of(2018, Month.MAY, 25), LocalDate.of(2018, Month.JUNE, 30)),
                        new Produce(1, 2));
                fruitsBushName.setText("eper");
                fruitsBushCare.setText(Arrays.toString(plants.getCare()).substring(1, Arrays.toString(plants.getCare()).length() - 1));
                fruitsBushPicking.setText(plants.getPicking().getMinDate().format(formatter) + " " + plants.getPicking().getMinDate().getDayOfMonth()
                        + "-" + plants.getPicking().getMaxDate().format(formatter) + " " + plants.getPicking().getMaxDate().getDayOfMonth() + " között");
                fruitsBushPlanting.setText(plants.getPlanting().getMinDate().format(formatter) + " " + plants.getPlanting().getMinDate().getDayOfMonth()
                        + "-" + plants.getPlanting().getMaxDate().format(formatter) + " " + plants.getPlanting().getMaxDate().getDayOfMonth() + " között");
                fruitsBushSoil.setText(Arrays.toString(plants.getSoil()).toLowerCase().substring(1, Arrays.toString(plants.getSoil()).length() - 1));
                fruitsBushProduce.setText(plants.getProduce().getMin() + "-" + plants.getProduce().getMax() + "kg/m²");
                fruitsBushCultivationMethod.setText(plants.getCultivationMethod());
                fruitsBushArea.setText(plants.getArea().getHeigth() + "cm*" + plants.getArea().getWidth() + "cm");
                fruitsBushLifeTime.setText(plants.getLifetime() + "év");
                break;
            case SZEDER:
                plants = new FruitsBush("szeder", new Area(30, 15), "sövény", 10,
                        new Soils[]{Soils.KÖZÉPKÖTÖTTTALAJ, Soils.BARNAERDŐTALAJ},
                        new Interval(LocalDate.of(2018, Month.SEPTEMBER, 1), LocalDate.of(2018, Month.NOVEMBER, 30)),
                        new String[]{"öntözés", "vesszővágás"},
                        new Interval(LocalDate.of(2018, Month.AUGUST, 1), LocalDate.of(2018, Month.AUGUST, 30)),
                        new Produce(3, 4));
                fruitsBushName.setText("szeder");
                fruitsBushCare.setText(Arrays.toString(plants.getCare()).substring(1, Arrays.toString(plants.getCare()).length() - 1));
                fruitsBushPicking.setText(plants.getPicking().getMinDate().format(formatter) + " " + plants.getPicking().getMinDate().getDayOfMonth()
                        + "-" + plants.getPicking().getMaxDate().format(formatter) + " " + plants.getPicking().getMaxDate().getDayOfMonth() + " között");
                fruitsBushPlanting.setText(plants.getPlanting().getMinDate().format(formatter) + " " + plants.getPlanting().getMinDate().getDayOfMonth()
                        + "-" + plants.getPlanting().getMaxDate().format(formatter) + " " + plants.getPlanting().getMaxDate().getDayOfMonth() + " között");
                fruitsBushSoil.setText(Arrays.toString(plants.getSoil()).toLowerCase().substring(1, Arrays.toString(plants.getSoil()).length() - 1));
                fruitsBushProduce.setText(plants.getProduce().getMin() + "-" + plants.getProduce().getMax() + "kg/tő/év");
                fruitsBushCultivationMethod.setText(plants.getCultivationMethod());
                fruitsBushArea.setText(plants.getArea().getHeigth() + "cm*" + plants.getArea().getWidth() + "cm");
                fruitsBushLifeTime.setText(plants.getLifetime() + "év");
                break;
        }
    }
}
