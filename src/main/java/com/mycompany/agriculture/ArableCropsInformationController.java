/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.agriculture;

import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
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
        ArableCrops plants;
        switch (EditorController.typeOfPlant) {
            case BÚZA:
                plants = new ArableCrops(new String[]{"minden augusztus közepéig betakarított növény"}, 12, 4, new Soils[]{Soils.CSERNOZJOM, Soils.BARNAERDŐTALAJ, Soils.RÉTITALAJ}, new PlantingAndPicking(LocalDate.of(2018, Month.OCTOBER, 15), LocalDate.of(2018, Month.OCTOBER, 25)), new String[]{"felfagyáskor hengerezés", "vegyszeres gyomírtás"}, new PlantingAndPicking(LocalDate.of(2018, Month.JULY, 1), LocalDate.of(2018, Month.JULY, 30)));
                arableCropsName.setText("Őszi búza");
                arableCropsForecrops.setText(Arrays.toString(plants.getForecrope()).substring(1, Arrays.toString(plants.getForecrope()).length() - 1));
                arableCropsCare.setText(Arrays.toString(plants.getCare()).substring(1, Arrays.toString(plants.getCare()).length() - 1));
                arableCropsPicking.setText(plants.getPicking().getMinDate().getMonth() + " " + plants.getPicking().getMinDate().getDayOfMonth() + "-" + plants.getPicking().getMaxDate().getMonth() + " " + plants.getPicking().getMaxDate().getDayOfMonth() + "között");
                arableCropsPlanting.setText(plants.getPlanting().getMinDate().getMonth() + " " + plants.getPlanting().getMinDate().getDayOfMonth() + "-" + plants.getPlanting().getMaxDate().getMonth() + " " + plants.getPlanting().getMaxDate().getDayOfMonth() + "között");
                arableCropsPlantingDepth.setText(plants.getPlantingDepth() + "cm");
                arableCropsSpacing.setText(plants.getMinRowSpacing() + "cm");
                arableCropsSoil.setText(Arrays.toString(plants.getSoil()).toLowerCase().substring(1, Arrays.toString(plants.getSoil()).length() - 1));
                break;
            case KUKORICA:
                break;
            case BURGONYA:
                break;
            case CUKORRÉPA:
                break;
            case NAPRAFORGÓ:
                break;
            case FEJESKÁPOSZTA:
                break;
            case PETREZSELYEM:
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
