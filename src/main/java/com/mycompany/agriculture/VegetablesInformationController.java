package com.mycompany.agriculture;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import model.Plants.Needs;
import model.Plants.PlantingAndPicking;
import model.Plants.Produce;
import model.Plants.Soils;
import model.Plants.Vegetables;

/**
 * FXML Controller class
 *
 * @author ivany
 */
public class VegetablesInformationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label vegetablesName;

    @FXML
    private Label vegetablesSoil;

    @FXML
    private Label vegetablesPlanting;

    @FXML
    private Label vegetablesForecrops;

    @FXML
    private Label vegetablesSpacing;

    @FXML
    private Label vegetablesHeatneed;

    @FXML
    private Label vegetablesLigthneed;

    @FXML
    private Label vegetablesWaterneed;

    @FXML
    private Label vegetablesCare;

    @FXML
    private Label vegetablesPicking;

    @FXML
    private Label vegetablesProduce;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Locale locale = new Locale("hu", "HU");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM", locale);
        Vegetables plants;
        switch (EditorController.typeOfPlant) {
            case FEJESKÁPOSZTA:
                plants = new Vegetables(Needs.ALACSONY, Needs.MAGAS, Needs.KÖZEPES, new String[]{"közömbös"}, 40,
                        new Soils[]{Soils.CSERNOZJOM, Soils.BARNAERDŐTALAJ},
                        new PlantingAndPicking(LocalDate.of(2018, Month.APRIL, 1), LocalDate.of(2018, Month.JULY, 15)),
                        new String[]{"öntözés"}, null, new Produce(800, 1000));
                vegetablesName.setText("Fejes káposzta");
                vegetablesForecrops.setText(Arrays.toString(plants.getForecrops()).substring(1, Arrays.toString(plants.getForecrops()).length() - 1));
                vegetablesCare.setText(Arrays.toString(plants.getCare()).substring(1, Arrays.toString(plants.getCare()).length() - 1));
                vegetablesPicking.setText("korai termesztésűeknél nem teljesen kemény fejűeknél is elkezdhetjük");
                vegetablesPlanting.setText(plants.getPlanting().getMinDate().format(formatter) + " " + plants.getPlanting().getMinDate().getDayOfMonth()
                        + "-" + plants.getPlanting().getMaxDate().format(formatter) + " " + plants.getPlanting().getMaxDate().getDayOfMonth() + " között");
                vegetablesSpacing.setText(plants.getMinRowSpacing() + "cm");
                vegetablesSoil.setText(Arrays.toString(plants.getSoil()).toLowerCase().substring(1, Arrays.toString(plants.getSoil()).length() - 1));
                vegetablesHeatneed.setText(plants.getHeatNeed().toString().toLowerCase().substring(1, plants.getHeatNeed().toString().length() - 1));
                vegetablesLigthneed.setText(plants.getLightNeed().toString().toLowerCase().substring(1, plants.getLightNeed().toString().length() - 1));
                vegetablesWaterneed.setText(plants.getWaterNeed().toString().toLowerCase().substring(1, plants.getWaterNeed().toString().length() - 1));
                vegetablesProduce.setText(plants.getProduce().getMin() + "-" + plants.getProduce().getMax() + "db/m²");
                break;
            case PETREZSELYEM:
                plants = new Vegetables(Needs.ALACSONY, Needs.ALACSONY, Needs.ALACSONY, new String[]{"sárgarépa, pasztina, önmaguk"}, 20,
                        new Soils[]{Soils.KÖZÉPKÖTÖTTTALAJ, Soils.LAZATALAJ},
                        new PlantingAndPicking(LocalDate.of(2018, Month.FEBRUARY, 1), LocalDate.of(2018, Month.FEBRUARY, 28)),
                        new String[]{"öntözés", "gyomtalanítás"}, null, null);
                vegetablesName.setText("Petrezselyem");
                vegetablesForecrops.setText("ne termesszük utánuk: " + Arrays.toString(plants.getForecrops()).substring(1, Arrays.toString(plants.getForecrops()).length() - 1));
                vegetablesCare.setText(Arrays.toString(plants.getCare()).substring(1, Arrays.toString(plants.getCare()).length() - 1));
                vegetablesPicking.setText("amikor már gyökerek legalább ceruzavastagsűgúak");
                vegetablesPlanting.setText(plants.getPlanting().getMinDate().format(formatter) + " " + plants.getPlanting().getMinDate().getDayOfMonth()
                        + "-" + plants.getPlanting().getMaxDate().format(formatter) + " " + plants.getPlanting().getMaxDate().getDayOfMonth() + " között");
                vegetablesSpacing.setText(plants.getMinRowSpacing() + "cm");
                vegetablesSoil.setText(Arrays.toString(plants.getSoil()).toLowerCase().substring(1, Arrays.toString(plants.getSoil()).length() - 1));
                vegetablesHeatneed.setText(plants.getHeatNeed().toString().toLowerCase().substring(1, plants.getHeatNeed().toString().length() - 1));
                vegetablesLigthneed.setText(plants.getLightNeed().toString().toLowerCase().substring(1, plants.getLightNeed().toString().length() - 1));
                vegetablesWaterneed.setText(plants.getWaterNeed().toString().toLowerCase().substring(1, plants.getWaterNeed().toString().length() - 1));
                vegetablesProduce.setText("ismeretlen");
                break;
            case KARALÁBÉ:
                break;
            case UBORKA:
                break;
            case SÁRGARÉPA:
                break;
            case RETEK:
                break;
            case PAPRIKA:
                break;
            case PARADICSOM:
                break;
            case VÖRÖSHAGYMA:
                break;
            case BORSÓ:
                break;
        }
    }

}
