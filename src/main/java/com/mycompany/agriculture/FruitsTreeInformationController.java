package com.mycompany.agriculture;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import model.Plants.Crowns;
import model.Plants.FruitsTree;
import model.Plants.Interval;
import model.Plants.Produce;
import model.Plants.Soils;

/**
 * FXML Controller class
 *
 * @author ivany
 */
public class FruitsTreeInformationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label fruitsTreeName;

    @FXML
    private Label fruitsTreeSoil;

    @FXML
    private Label fruitsTreePlanting;

    @FXML
    private Label fruitsTreeCrown;

    @FXML
    private Label fruitsTreeCrownArea;

    @FXML
    private Label fruitsTreeLifeTime;

    @FXML
    private Label fruitsTreeCare;

    @FXML
    private Label fruitsTreePicking;

    @FXML
    private Label fruitsTreeProduce;

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
        FruitsTree plants;
        switch (EditorController.typeOfPlant) {
            case ALMA:
                plants = new FruitsTree("almafa", Crowns.SUDARAS, new Area(6, 6), 30,
                        new Soils[]{Soils.BARNAERDŐTALAJ, Soils.CSERNOZJOM},
                        new Interval(LocalDate.of(2018, Month.SEPTEMBER, 1), LocalDate.of(2018, Month.NOVEMBER, 30)),
                        new String[]{"metszés", "öntözés"},
                        new Interval(LocalDate.of(2018, Month.MAY, 25), LocalDate.of(2018, Month.SEPTEMBER, 30)),
                        new Produce(80, 120));
                fruitsTreeName.setText("almafa");
                fruitsTreeCare.setText(Arrays.toString(plants.getCare()).substring(1, Arrays.toString(plants.getCare()).length() - 1));
                fruitsTreePicking.setText(plants.getPicking().getMinDate().format(formatter) + " " + plants.getPicking().getMinDate().getDayOfMonth()
                        + "-" + plants.getPicking().getMaxDate().format(formatter) + " " + plants.getPicking().getMaxDate().getDayOfMonth() + " között");
                fruitsTreePlanting.setText(plants.getPlanting().getMinDate().format(formatter) + " " + plants.getPlanting().getMinDate().getDayOfMonth()
                        + "-" + plants.getPlanting().getMaxDate().format(formatter) + " " + plants.getPlanting().getMaxDate().getDayOfMonth() + " között");
                fruitsTreeSoil.setText(Arrays.toString(plants.getSoil()).toLowerCase().substring(1, Arrays.toString(plants.getSoil()).length() - 1));
                fruitsTreeProduce.setText(plants.getProduce().getMin() + "-" + plants.getProduce().getMax() + "kg/fa/év");
                fruitsTreeCrown.setText(plants.getCrown().toString().toLowerCase());
                fruitsTreeCrownArea.setText(plants.getCrownArea().getHeigth() + "m*" + plants.getCrownArea().getWidth() + "m");
                fruitsTreeLifeTime.setText(plants.getLifetime() + "év");
                break;
            case KÖRTE:
                plants = new FruitsTree("körtefa", Crowns.SUDARAS, new Area(6, 3), 35,
                        new Soils[]{Soils.BARNAERDŐTALAJ, Soils.CSERNOZJOM},
                        new Interval(LocalDate.of(2018, Month.SEPTEMBER, 1), LocalDate.of(2018, Month.NOVEMBER, 30)),
                        new String[]{"metszés", "öntözés"},
                        new Interval(LocalDate.of(2018, Month.JULY, 25), LocalDate.of(2018, Month.OCTOBER, 5)),
                        new Produce(80, 120));
                fruitsTreeName.setText("körtefa");
                fruitsTreeCare.setText(Arrays.toString(plants.getCare()).substring(1, Arrays.toString(plants.getCare()).length() - 1));
                fruitsTreePicking.setText(plants.getPicking().getMinDate().format(formatter) + " " + plants.getPicking().getMinDate().getDayOfMonth()
                        + "-" + plants.getPicking().getMaxDate().format(formatter) + " " + plants.getPicking().getMaxDate().getDayOfMonth() + " között");
                fruitsTreePlanting.setText(plants.getPlanting().getMinDate().format(formatter) + " " + plants.getPlanting().getMinDate().getDayOfMonth()
                        + "-" + plants.getPlanting().getMaxDate().format(formatter) + " " + plants.getPlanting().getMaxDate().getDayOfMonth() + " között");
                fruitsTreeSoil.setText(Arrays.toString(plants.getSoil()).toLowerCase().substring(1, Arrays.toString(plants.getSoil()).length() - 1));
                fruitsTreeProduce.setText(plants.getProduce().getMin() + "-" + plants.getProduce().getMax() + "kg/fa/év");
                fruitsTreeCrown.setText(plants.getCrown().toString().toLowerCase());
                fruitsTreeCrownArea.setText(plants.getCrownArea().getHeigth() + "m*" + plants.getCrownArea().getWidth() + "m");
                fruitsTreeLifeTime.setText(plants.getLifetime() + "év");
                break;
            case ŐSZIBARACK:
                plants = new FruitsTree("őszibarackfa", Crowns.KATLAN, new Area(4, 4), 25,
                        new Soils[]{Soils.BARNAERDŐTALAJ, Soils.CSERNOZJOM},
                        new Interval(LocalDate.of(2018, Month.SEPTEMBER, 1), LocalDate.of(2018, Month.NOVEMBER, 30)),
                        new String[]{"metszés", "öntözés"},
                        new Interval(LocalDate.of(2018, Month.JULY, 20), LocalDate.of(2018, Month.SEPTEMBER, 20)),
                        new Produce(15, 30));
                fruitsTreeName.setText("őszibarackfa");
                fruitsTreeCare.setText(Arrays.toString(plants.getCare()).substring(1, Arrays.toString(plants.getCare()).length() - 1));
                fruitsTreePicking.setText(plants.getPicking().getMinDate().format(formatter) + " " + plants.getPicking().getMinDate().getDayOfMonth()
                        + "-" + plants.getPicking().getMaxDate().format(formatter) + " " + plants.getPicking().getMaxDate().getDayOfMonth() + " között");
                fruitsTreePlanting.setText(plants.getPlanting().getMinDate().format(formatter) + " " + plants.getPlanting().getMinDate().getDayOfMonth()
                        + "-" + plants.getPlanting().getMaxDate().format(formatter) + " " + plants.getPlanting().getMaxDate().getDayOfMonth() + " között");
                fruitsTreeSoil.setText(Arrays.toString(plants.getSoil()).toLowerCase().substring(1, Arrays.toString(plants.getSoil()).length() - 1));
                fruitsTreeProduce.setText(plants.getProduce().getMin() + "-" + plants.getProduce().getMax() + "kg/fa/év");
                fruitsTreeCrown.setText(plants.getCrown().toString().toLowerCase());
                fruitsTreeCrownArea.setText(plants.getCrownArea().getHeigth() + "m*" + plants.getCrownArea().getWidth() + "m");
                fruitsTreeLifeTime.setText(plants.getLifetime() + "év");
                break;
            case SZILVA:
                plants = new FruitsTree("szilvafa", Crowns.SUDARAS, new Area(6, 4), 25,
                        new Soils[]{Soils.LAZATALAJ},
                        new Interval(LocalDate.of(2018, Month.SEPTEMBER, 1), LocalDate.of(2018, Month.NOVEMBER, 30)),
                        new String[]{"metszés", "öntözés"},
                        new Interval(LocalDate.of(2018, Month.AUGUST, 15), LocalDate.of(2018, Month.SEPTEMBER, 30)),
                        new Produce(25, 80));
                fruitsTreeName.setText("szilvafa");
                fruitsTreeCare.setText(Arrays.toString(plants.getCare()).substring(1, Arrays.toString(plants.getCare()).length() - 1));
                fruitsTreePicking.setText(plants.getPicking().getMinDate().format(formatter) + " " + plants.getPicking().getMinDate().getDayOfMonth()
                        + "-" + plants.getPicking().getMaxDate().format(formatter) + " " + plants.getPicking().getMaxDate().getDayOfMonth() + " között");
                fruitsTreePlanting.setText(plants.getPlanting().getMinDate().format(formatter) + " " + plants.getPlanting().getMinDate().getDayOfMonth()
                        + "-" + plants.getPlanting().getMaxDate().format(formatter) + " " + plants.getPlanting().getMaxDate().getDayOfMonth() + " között");
                fruitsTreeSoil.setText(Arrays.toString(plants.getSoil()).toLowerCase().substring(1, Arrays.toString(plants.getSoil()).length() - 1));
                fruitsTreeProduce.setText(plants.getProduce().getMin() + "-" + plants.getProduce().getMax() + "kg/fa/év");
                fruitsTreeCrown.setText(plants.getCrown().toString().toLowerCase());
                fruitsTreeCrownArea.setText(plants.getCrownArea().getHeigth() + "m*" + plants.getCrownArea().getWidth() + "m");
                fruitsTreeLifeTime.setText(plants.getLifetime() + "év");
                break;
            case MEGGY:
                plants = new FruitsTree("meggyfa", Crowns.SUDARAS, new Area(6, 4), 30,
                        new Soils[]{Soils.BARNAERDŐTALAJ, Soils.CSERNOZJOM},
                        new Interval(LocalDate.of(2018, Month.SEPTEMBER, 1), LocalDate.of(2018, Month.NOVEMBER, 30)),
                        new String[]{"metszés", "öntözés"},
                        new Interval(LocalDate.of(2018, Month.JUNE, 15), LocalDate.of(2018, Month.AUGUST, 5)),
                        new Produce(10, 30));
                fruitsTreeName.setText("meggyfa");
                fruitsTreeCare.setText(Arrays.toString(plants.getCare()).substring(1, Arrays.toString(plants.getCare()).length() - 1));
                fruitsTreePicking.setText(plants.getPicking().getMinDate().format(formatter) + " " + plants.getPicking().getMinDate().getDayOfMonth()
                        + "-" + plants.getPicking().getMaxDate().format(formatter) + " " + plants.getPicking().getMaxDate().getDayOfMonth() + " között");
                fruitsTreePlanting.setText(plants.getPlanting().getMinDate().format(formatter) + " " + plants.getPlanting().getMinDate().getDayOfMonth()
                        + "-" + plants.getPlanting().getMaxDate().format(formatter) + " " + plants.getPlanting().getMaxDate().getDayOfMonth() + " között");
                fruitsTreeSoil.setText(Arrays.toString(plants.getSoil()).toLowerCase().substring(1, Arrays.toString(plants.getSoil()).length() - 1));
                fruitsTreeProduce.setText(plants.getProduce().getMin() + "-" + plants.getProduce().getMax() + "kg/fa/év");
                fruitsTreeCrown.setText(plants.getCrown().toString().toLowerCase());
                fruitsTreeCrownArea.setText(plants.getCrownArea().getHeigth() + "m*" + plants.getCrownArea().getWidth() + "m");
                fruitsTreeLifeTime.setText(plants.getLifetime() + "év");
                break;
            case CSERESZNYE:
                plants = new FruitsTree("cseresznyefa", Crowns.SUDARAS, new Area(6, 4), 40,
                        new Soils[]{Soils.HOMOKTALAJ},
                        new Interval(LocalDate.of(2018, Month.SEPTEMBER, 1), LocalDate.of(2018, Month.NOVEMBER, 30)),
                        new String[]{"metszés", "öntözés"},
                        new Interval(LocalDate.of(2018, Month.JUNE, 1), LocalDate.of(2018, Month.JUNE, 30)),
                        new Produce(80, 100));
                fruitsTreeName.setText("cseresznyefa");
                fruitsTreeCare.setText(Arrays.toString(plants.getCare()).substring(1, Arrays.toString(plants.getCare()).length() - 1));
                fruitsTreePicking.setText(plants.getPicking().getMinDate().format(formatter) + " " + plants.getPicking().getMinDate().getDayOfMonth()
                        + "-" + plants.getPicking().getMaxDate().format(formatter) + " " + plants.getPicking().getMaxDate().getDayOfMonth() + " között");
                fruitsTreePlanting.setText(plants.getPlanting().getMinDate().format(formatter) + " " + plants.getPlanting().getMinDate().getDayOfMonth()
                        + "-" + plants.getPlanting().getMaxDate().format(formatter) + " " + plants.getPlanting().getMaxDate().getDayOfMonth() + " között");
                fruitsTreeSoil.setText(Arrays.toString(plants.getSoil()).toLowerCase().substring(1, Arrays.toString(plants.getSoil()).length() - 1));
                fruitsTreeProduce.setText(plants.getProduce().getMin() + "-" + plants.getProduce().getMax() + "kg/fa/év");
                fruitsTreeCrown.setText(plants.getCrown().toString().toLowerCase());
                fruitsTreeCrownArea.setText(plants.getCrownArea().getHeigth() + "m*" + plants.getCrownArea().getWidth() + "m");
                fruitsTreeLifeTime.setText(plants.getLifetime() + "év");
                break;
            case DIÓ:
                plants = new FruitsTree("diófa", Crowns.SZÓRTÁLLÁSÚKOMBINÁLT, new Area(7, 7), 45,
                        new Soils[]{Soils.LAZATALAJ},
                        new Interval(LocalDate.of(2018, Month.SEPTEMBER, 1), LocalDate.of(2018, Month.NOVEMBER, 30)),
                        new String[]{"metszés", "öntözés"},
                        new Interval(LocalDate.of(2018, Month.SEPTEMBER, 25), LocalDate.of(2018, Month.OCTOBER, 10)),
                        new Produce(8, 12));
                fruitsTreeName.setText("diófa");
                fruitsTreeCare.setText(Arrays.toString(plants.getCare()).substring(1, Arrays.toString(plants.getCare()).length() - 1));
                fruitsTreePicking.setText(plants.getPicking().getMinDate().format(formatter) + " " + plants.getPicking().getMinDate().getDayOfMonth()
                        + "-" + plants.getPicking().getMaxDate().format(formatter) + " " + plants.getPicking().getMaxDate().getDayOfMonth() + " között");
                fruitsTreePlanting.setText(plants.getPlanting().getMinDate().format(formatter) + " " + plants.getPlanting().getMinDate().getDayOfMonth()
                        + "-" + plants.getPlanting().getMaxDate().format(formatter) + " " + plants.getPlanting().getMaxDate().getDayOfMonth() + " között");
                fruitsTreeSoil.setText(Arrays.toString(plants.getSoil()).toLowerCase().substring(1, Arrays.toString(plants.getSoil()).length() - 1));
                fruitsTreeProduce.setText(plants.getProduce().getMin() + "-" + plants.getProduce().getMax() + "kg dióbél/fa/év");
                fruitsTreeCrown.setText(plants.getCrown().toString().toLowerCase());
                fruitsTreeCrownArea.setText(plants.getCrownArea().getHeigth() + "m*" + plants.getCrownArea().getWidth() + "m");
                fruitsTreeLifeTime.setText(plants.getLifetime() + "év");
                break;
        }
    }

}
