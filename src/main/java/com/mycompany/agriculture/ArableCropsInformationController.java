/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.agriculture;

import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.Plants.ArableCrops;
import model.Plants.PlantingAndPicking;
import model.Plants.Soils;

/**
 * FXML Controller class
 *
 * @author ivany
 */
public class ArableCropsInformationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label arableCropsName;

    @FXML
    private Label arableCropsSoil;

    @FXML
    private Label arableCropsPlanting;

    @FXML
    private Label arableCropsForecrops;

    @FXML
    private Label arableCropsSpacing;

    @FXML
    private Label arableCropsPlantingDepth;

    @FXML
    private Label arableCropsCare;

    @FXML
    private Label arableCropsPicking;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Locale locale = new Locale("hu", "HU");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM", locale);
        ArableCrops plants;
        switch (EditorController.typeOfPlant) {
            case BÚZA:
                plants = new ArableCrops(new String[]{"minden augusztus közepéig betakarított növény"}, 12, 4,
                        new Soils[]{Soils.CSERNOZJOM, Soils.BARNAERDŐTALAJ, Soils.RÉTITALAJ}, new PlantingAndPicking(LocalDate.of(2018, Month.OCTOBER, 15),
                                LocalDate.of(2018, Month.OCTOBER, 25)), new String[]{"felfagyáskor hengerezés", "vegyszeres gyomírtás"},
                        new PlantingAndPicking(LocalDate.of(2018, Month.JULY, 1), LocalDate.of(2018, Month.JULY, 31)));
                arableCropsName.setText("Őszi búza");
                arableCropsForecrops.setText(Arrays.toString(plants.getForecrope()).substring(1, Arrays.toString(plants.getForecrope()).length() - 1));
                arableCropsCare.setText(Arrays.toString(plants.getCare()).substring(1, Arrays.toString(plants.getCare()).length() - 1));
                arableCropsPicking.setText(plants.getPicking().getMinDate().format(formatter) + " " + plants.getPicking().getMinDate().getDayOfMonth()
                        + "-" + plants.getPicking().getMaxDate().format(formatter) + " " + plants.getPicking().getMaxDate().getDayOfMonth() + " között");
                arableCropsPlanting.setText(plants.getPlanting().getMinDate().format(formatter) + " " + plants.getPlanting().getMinDate().getDayOfMonth()
                        + "-" + plants.getPlanting().getMaxDate().format(formatter) + " " + plants.getPlanting().getMaxDate().getDayOfMonth() + " között");
                arableCropsPlantingDepth.setText(plants.getPlantingDepth() + "cm");
                arableCropsSpacing.setText(plants.getMinRowSpacing() + "cm");
                arableCropsSoil.setText(Arrays.toString(plants.getSoil()).toLowerCase().substring(1, Arrays.toString(plants.getSoil()).length() - 1));
                break;
            case KUKORICA:
                plants = new ArableCrops(new String[]{"közömbös"}, 70, 5,
                        new Soils[]{Soils.CSERNOZJOM, Soils.BARNAERDŐTALAJ, Soils.RÉTITALAJ, Soils.ÖNTÉSÉSLEJTŐHORDALÉKTALAJ}, new PlantingAndPicking(LocalDate.of(2018, Month.APRIL, 15),
                                LocalDate.of(2018, Month.MAY, 15)), new String[]{"vegyszeres gyomírtás"},
                        new PlantingAndPicking(LocalDate.of(2018, Month.AUGUST, 31), LocalDate.of(2018, Month.OCTOBER, 31)));
                arableCropsName.setText("Kukorica");
                arableCropsForecrops.setText(Arrays.toString(plants.getForecrope()).substring(1, Arrays.toString(plants.getForecrope()).length() - 1));
                arableCropsCare.setText(Arrays.toString(plants.getCare()).substring(1, Arrays.toString(plants.getCare()).length() - 1));
                arableCropsPicking.setText(plants.getPicking().getMinDate().format(formatter) + " " + plants.getPicking().getMinDate().getDayOfMonth()
                        + "-" + plants.getPicking().getMaxDate().format(formatter) + " " + plants.getPicking().getMaxDate().getDayOfMonth() + " között");
                arableCropsPlanting.setText(plants.getPlanting().getMinDate().format(formatter) + " " + plants.getPlanting().getMinDate().getDayOfMonth()
                        + "-" + plants.getPlanting().getMaxDate().format(formatter) + " " + plants.getPlanting().getMaxDate().getDayOfMonth() + " között");
                arableCropsPlantingDepth.setText(plants.getPlantingDepth() + "cm");
                arableCropsSpacing.setText(plants.getMinRowSpacing() + "cm");
                arableCropsSoil.setText(Arrays.toString(plants.getSoil()).toLowerCase().substring(1, Arrays.toString(plants.getSoil()).length() - 1));
                break;
            case BURGONYA:
                plants = new ArableCrops(new String[]{"kalászosok", "fehérmustár", "olajretek"}, 70, 2,
                        new Soils[]{Soils.LAZATALAJ, Soils.KÖZÉPKÖTÖTTTALAJ}, new PlantingAndPicking(LocalDate.of(2018, Month.APRIL, 5),
                                LocalDate.of(2018, Month.APRIL, 25)), new String[]{"vegyszeres gyomírtás"},
                        new PlantingAndPicking(LocalDate.of(2018, Month.MAY, 15), LocalDate.of(2018, Month.JUNE, 30)));
                arableCropsName.setText("Burgonya");
                arableCropsForecrops.setText(Arrays.toString(plants.getForecrope()).substring(1, Arrays.toString(plants.getForecrope()).length() - 1));
                arableCropsCare.setText(Arrays.toString(plants.getCare()).substring(1, Arrays.toString(plants.getCare()).length() - 1));
                arableCropsPicking.setText(plants.getPicking().getMinDate().format(formatter) + " " + plants.getPicking().getMinDate().getDayOfMonth()
                        + "-" + plants.getPicking().getMaxDate().format(formatter) + " " + plants.getPicking().getMaxDate().getDayOfMonth() + " között");
                arableCropsPlanting.setText(plants.getPlanting().getMinDate().format(formatter) + " " + plants.getPlanting().getMinDate().getDayOfMonth()
                        + "-" + plants.getPlanting().getMaxDate().format(formatter) + " " + plants.getPlanting().getMaxDate().getDayOfMonth() + " között");
                arableCropsPlantingDepth.setText(plants.getPlantingDepth() + "cm");
                arableCropsSpacing.setText(plants.getMinRowSpacing() + "cm");
                arableCropsSoil.setText(Arrays.toString(plants.getSoil()).toLowerCase().substring(1, Arrays.toString(plants.getSoil()).length() - 1));
                break;
            case CUKORRÉPA:
                plants = new ArableCrops(new String[]{"kalászosok", "rostlen", "silókukorica"}, 45, 2,
                        new Soils[]{Soils.KÖZÉPKÖTÖTTTALAJ}, new PlantingAndPicking(LocalDate.of(2018, Month.MARCH, 15),
                                LocalDate.of(2018, Month.APRIL, 10)), new String[]{"vegyszeres gyomírtás"},
                        new PlantingAndPicking(LocalDate.of(2018, Month.SEPTEMBER, 1), LocalDate.of(2018, Month.SEPTEMBER, 10)));
                arableCropsName.setText("Cukorrépa");
                arableCropsForecrops.setText(Arrays.toString(plants.getForecrope()).substring(1, Arrays.toString(plants.getForecrope()).length() - 1));
                arableCropsCare.setText(Arrays.toString(plants.getCare()).substring(1, Arrays.toString(plants.getCare()).length() - 1));
                arableCropsPicking.setText(plants.getPicking().getMinDate().format(formatter) + " " + plants.getPicking().getMinDate().getDayOfMonth()
                        + "-" + plants.getPicking().getMaxDate().format(formatter) + " " + plants.getPicking().getMaxDate().getDayOfMonth() + " között");
                arableCropsPlanting.setText(plants.getPlanting().getMinDate().format(formatter) + " " + plants.getPlanting().getMinDate().getDayOfMonth()
                        + "-" + plants.getPlanting().getMaxDate().format(formatter) + " " + plants.getPlanting().getMaxDate().getDayOfMonth() + " között");
                arableCropsPlantingDepth.setText(plants.getPlantingDepth() + "cm");
                arableCropsSpacing.setText(plants.getMinRowSpacing() + "cm");
                arableCropsSoil.setText(Arrays.toString(plants.getSoil()).toLowerCase().substring(1, Arrays.toString(plants.getSoil()).length() - 1));
                break;
            case NAPRAFORGÓ:
                plants = new ArableCrops(new String[]{"őszi kalászosok", "tavaszi kalászosok"}, 70, 5,
                        new Soils[]{Soils.KÖZÉPKÖTÖTTTALAJ, Soils.LAZATALAJ}, new PlantingAndPicking(LocalDate.of(2018, Month.APRIL, 10),
                                LocalDate.of(2018, Month.APRIL, 25)), new String[]{"vegyszeres gyomírtás"}, null);
                arableCropsName.setText("Napraforgó");
                arableCropsForecrops.setText(Arrays.toString(plants.getForecrope()).substring(1, Arrays.toString(plants.getForecrope()).length() - 1));
                arableCropsCare.setText(Arrays.toString(plants.getCare()).substring(1, Arrays.toString(plants.getCare()).length() - 1));
                arableCropsPicking.setText("Amikor a kaszat nedvességtartalma 15-18 %-os, a tányér színe rozsdabarna és a szélén lévő pikkelylevelek erősen töredeznek.");
                arableCropsPlanting.setText(plants.getPlanting().getMinDate().format(formatter) + " " + plants.getPlanting().getMinDate().getDayOfMonth() + "-" + plants.getPlanting().getMaxDate().format(formatter) + " " + plants.getPlanting().getMaxDate().getDayOfMonth() + " között");
                arableCropsPlantingDepth.setText(plants.getPlantingDepth() + "cm");
                arableCropsSpacing.setText(plants.getMinRowSpacing() + "cm");
                arableCropsSoil.setText(Arrays.toString(plants.getSoil()).toLowerCase().substring(1, Arrays.toString(plants.getSoil()).length() - 1));
                break;
            case ALMA:
                break;
            case KÖRTE:
                break;
            case ŐSZIBARACK:
                break;
            case SZILVA:
                break;
            case MEGGY:
                break;
            case CSERESZNYE:
                break;
            case DIÓ:
                break;
            case MÁLNA:
                break;
            case EPER:
                break;
            case SZEDER:
                break;
        }
    }

}
