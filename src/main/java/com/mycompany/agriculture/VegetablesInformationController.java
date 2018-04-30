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
import model.Plants.Needs;
import model.Plants.Interval;
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
        Vegetables plants;
        switch (EditorController.typeOfPlant) {
            case FEJESKÁPOSZTA:
                plants = new Vegetables("Fejes káposzta", Needs.ALACSONY, Needs.MAGAS, Needs.KÖZEPES, new String[]{"közömbös"}, 40,
                        new Soils[]{Soils.CSERNOZJOM, Soils.BARNAERDŐTALAJ},
                        new Interval(LocalDate.of(2018, Month.APRIL, 1), LocalDate.of(2018, Month.JULY, 15)),
                        new String[]{"öntözés"}, null, new Produce(800, 1000));
                vegetablesName.setText("Fejes káposzta");
                vegetablesForecrops.setText(Arrays.toString(plants.getForecrops()).substring(1, Arrays.toString(plants.getForecrops()).length() - 1));
                vegetablesCare.setText(Arrays.toString(plants.getCare()).substring(1, Arrays.toString(plants.getCare()).length() - 1));
                vegetablesPicking.setText("korai termesztésűeknél nem teljesen kemény fejűeknél is elkezdhetjük");
                vegetablesPlanting.setText(plants.getPlanting().getMinDate().format(formatter) + " " + plants.getPlanting().getMinDate().getDayOfMonth()
                        + "-" + plants.getPlanting().getMaxDate().format(formatter) + " " + plants.getPlanting().getMaxDate().getDayOfMonth() + " között");
                vegetablesSpacing.setText(plants.getMinRowSpacing() + "cm");
                vegetablesSoil.setText(Arrays.toString(plants.getSoil()).toLowerCase().substring(1, Arrays.toString(plants.getSoil()).length() - 1));
                vegetablesHeatneed.setText(plants.getHeatNeed().toString().toLowerCase());
                vegetablesLigthneed.setText(plants.getLightNeed().toString().toLowerCase());
                vegetablesWaterneed.setText(plants.getWaterNeed().toString().toLowerCase());
                vegetablesProduce.setText(plants.getProduce().getMin() + "-" + plants.getProduce().getMax() + "db/m²");
                break;
            case PETREZSELYEM:
                plants = new Vegetables("Petrezselyem", Needs.ALACSONY, Needs.ALACSONY, Needs.ALACSONY, new String[]{"sárgarépa, pasztina, önmaguk"}, 20,
                        new Soils[]{Soils.KÖZÉPKÖTÖTTTALAJ, Soils.LAZATALAJ},
                        new Interval(LocalDate.of(2018, Month.FEBRUARY, 1), LocalDate.of(2018, Month.FEBRUARY, 28)),
                        new String[]{"öntözés", "gyomtalanítás"}, null, null);
                vegetablesName.setText("Petrezselyem");
                vegetablesForecrops.setText("ne termesszük utánuk: " + Arrays.toString(plants.getForecrops()).substring(1, Arrays.toString(plants.getForecrops()).length() - 1));
                vegetablesCare.setText(Arrays.toString(plants.getCare()).substring(1, Arrays.toString(plants.getCare()).length() - 1));
                vegetablesPicking.setText("amikor már gyökerek legalább ceruzavastagsűgúak");
                vegetablesPlanting.setText(plants.getPlanting().getMinDate().format(formatter) + " " + plants.getPlanting().getMinDate().getDayOfMonth()
                        + "-" + plants.getPlanting().getMaxDate().format(formatter) + " " + plants.getPlanting().getMaxDate().getDayOfMonth() + " között");
                vegetablesSpacing.setText(plants.getMinRowSpacing() + "cm");
                vegetablesSoil.setText(Arrays.toString(plants.getSoil()).toLowerCase().substring(1, Arrays.toString(plants.getSoil()).length() - 1));
                vegetablesHeatneed.setText(plants.getHeatNeed().toString().toLowerCase());
                vegetablesLigthneed.setText(plants.getLightNeed().toString().toLowerCase());
                vegetablesWaterneed.setText(plants.getWaterNeed().toString().toLowerCase());
                vegetablesProduce.setText("ismeretlen");
                break;
            case KARALÁBÉ:
                plants = new Vegetables("Karalábé", Needs.ALACSONY, Needs.MAGAS, Needs.MAGAS, new String[]{"burgonya", "borsó", "retek", "saláta"}, 25,
                        new Soils[]{Soils.CSERNOZJOM, Soils.BARNAERDŐTALAJ},
                        new Interval(LocalDate.of(2018, Month.JUNE, 15), LocalDate.of(2018, Month.JULY, 15)),
                        new String[]{"öntözés", "gyomtalanítás"},
                        null, new Produce(1500, 2000));
                vegetablesName.setText("Karalábé");
                vegetablesForecrops.setText(Arrays.toString(plants.getForecrops()).substring(1, Arrays.toString(plants.getForecrops()).length() - 1));
                vegetablesCare.setText(Arrays.toString(plants.getCare()).substring(1, Arrays.toString(plants.getCare()).length() - 1));
                vegetablesPicking.setText("teljesen kifejlett állapotban");
                vegetablesPlanting.setText(plants.getPlanting().getMinDate().format(formatter) + " " + plants.getPlanting().getMinDate().getDayOfMonth()
                        + "-" + plants.getPlanting().getMaxDate().format(formatter) + " " + plants.getPlanting().getMaxDate().getDayOfMonth() + " között");
                vegetablesSpacing.setText(plants.getMinRowSpacing() + "cm");
                vegetablesSoil.setText(Arrays.toString(plants.getSoil()).toLowerCase().substring(1, Arrays.toString(plants.getSoil()).length() - 1));
                vegetablesHeatneed.setText(plants.getHeatNeed().toString().toLowerCase());
                vegetablesLigthneed.setText(plants.getLightNeed().toString().toLowerCase());
                vegetablesWaterneed.setText(plants.getWaterNeed().toString().toLowerCase());
                vegetablesProduce.setText(plants.getProduce().getMin() + "-" + plants.getProduce().getMax() + "db/m²");
                break;
            case UBORKA:
                plants = new Vegetables("Uborka", Needs.MAGAS, Needs.MAGAS, Needs.MAGAS, new String[]{"rövid tenyészidejű, ősszel értékesíthető zöldségek"}, 100,
                        new Soils[]{Soils.KÖZÉPKÖTÖTTTALAJ, Soils.HOMOKTALAJ},
                        new Interval(LocalDate.of(2018, Month.APRIL, 1), LocalDate.of(2018, Month.APRIL, 5)),
                        new String[]{"öntözés", "gyomtalanítás", "fejtrágyázás", "talaj porhanyítás"},
                        new Interval(LocalDate.of(2018, Month.JUNE, 10), LocalDate.of(2018, Month.JUNE, 20)),
                        new Produce(2, 3));
                vegetablesName.setText("Uborka");
                vegetablesForecrops.setText(Arrays.toString(plants.getForecrops()).substring(1, Arrays.toString(plants.getForecrops()).length() - 1));
                vegetablesCare.setText(Arrays.toString(plants.getCare()).substring(1, Arrays.toString(plants.getCare()).length() - 1));
                vegetablesPicking.setText(plants.getPicking().getMinDate().format(formatter) + " " + plants.getPicking().getMinDate().getDayOfMonth()
                        + "-" + plants.getPicking().getMaxDate().format(formatter) + " " + plants.getPicking().getMaxDate().getDayOfMonth() + " között");
                vegetablesPlanting.setText(plants.getPlanting().getMinDate().format(formatter) + " " + plants.getPlanting().getMinDate().getDayOfMonth()
                        + "-" + plants.getPlanting().getMaxDate().format(formatter) + " " + plants.getPlanting().getMaxDate().getDayOfMonth() + " között");
                vegetablesSpacing.setText(plants.getMinRowSpacing() + "cm");
                vegetablesSoil.setText(Arrays.toString(plants.getSoil()).toLowerCase().substring(1, Arrays.toString(plants.getSoil()).length() - 1));
                vegetablesHeatneed.setText(plants.getHeatNeed().toString().toLowerCase());
                vegetablesLigthneed.setText(plants.getLightNeed().toString().toLowerCase());
                vegetablesWaterneed.setText(plants.getWaterNeed().toString().toLowerCase());
                vegetablesProduce.setText(plants.getProduce().getMin() + "-" + plants.getProduce().getMax() + "kg/m²");
                break;
            case SÁRGARÉPA:
                plants = new Vegetables("Sárgarépa", Needs.ALACSONY, Needs.KÖZEPES, Needs.ALACSONY, new String[]{"közömbös"}, 20,
                        new Soils[]{Soils.LAZATALAJ},
                        new Interval(LocalDate.of(2018, Month.FEBRUARY, 25), LocalDate.of(2018, Month.MARCH, 15)),
                        new String[]{"gyomtalanítás kapával"},
                        new Interval(LocalDate.of(2018, Month.MAY, 30), LocalDate.of(2018, Month.OCTOBER, 5)),
                        new Produce(2, 3));
                vegetablesName.setText("Sárgarépa");
                vegetablesForecrops.setText(Arrays.toString(plants.getForecrops()).substring(1, Arrays.toString(plants.getForecrops()).length() - 1));
                vegetablesCare.setText(Arrays.toString(plants.getCare()).substring(1, Arrays.toString(plants.getCare()).length() - 1));
                vegetablesPicking.setText(plants.getPicking().getMinDate().format(formatter) + " " + plants.getPicking().getMinDate().getDayOfMonth()
                        + "-" + plants.getPicking().getMaxDate().format(formatter) + " " + plants.getPicking().getMaxDate().getDayOfMonth() + " között");
                vegetablesPlanting.setText(plants.getPlanting().getMinDate().format(formatter) + " " + plants.getPlanting().getMinDate().getDayOfMonth()
                        + "-" + plants.getPlanting().getMaxDate().format(formatter) + " " + plants.getPlanting().getMaxDate().getDayOfMonth() + " között");
                vegetablesSpacing.setText(plants.getMinRowSpacing() + "cm");
                vegetablesSoil.setText(Arrays.toString(plants.getSoil()).toLowerCase().substring(1, Arrays.toString(plants.getSoil()).length() - 1));
                vegetablesHeatneed.setText(plants.getHeatNeed().toString().toLowerCase());
                vegetablesLigthneed.setText(plants.getLightNeed().toString().toLowerCase());
                vegetablesWaterneed.setText(plants.getWaterNeed().toString().toLowerCase());
                vegetablesProduce.setText(plants.getProduce().getMin() + "-" + plants.getProduce().getMax() + "kg/m²");
                break;
            case RETEK:
                plants = new Vegetables("Retek", Needs.ALACSONY, Needs.MAGAS, Needs.KÖZEPES, new String[]{"közömbös"}, 35,
                        new Soils[]{Soils.LAZATALAJ, Soils.KÖZÉPKÖTÖTTTALAJ},
                        new Interval(LocalDate.of(2018, Month.MARCH, 15), LocalDate.of(2018, Month.MARCH, 30)),
                        new String[]{"öntözés", "egy sarabolás"},
                        new Interval(LocalDate.of(2018, Month.APRIL, 15), LocalDate.of(2018, Month.APRIL, 30)),
                        null);
                vegetablesName.setText("Retek");
                vegetablesForecrops.setText(Arrays.toString(plants.getForecrops()).substring(1, Arrays.toString(plants.getForecrops()).length() - 1));
                vegetablesCare.setText(Arrays.toString(plants.getCare()).substring(1, Arrays.toString(plants.getCare()).length() - 1));
                vegetablesPicking.setText(plants.getPicking().getMinDate().format(formatter) + " " + plants.getPicking().getMinDate().getDayOfMonth()
                        + "-" + plants.getPicking().getMaxDate().format(formatter) + " " + plants.getPicking().getMaxDate().getDayOfMonth() + " között");
                vegetablesPlanting.setText(plants.getPlanting().getMinDate().format(formatter) + " " + plants.getPlanting().getMinDate().getDayOfMonth()
                        + "-" + plants.getPlanting().getMaxDate().format(formatter) + " " + plants.getPlanting().getMaxDate().getDayOfMonth() + " között");
                vegetablesSpacing.setText(plants.getMinRowSpacing() + "cm");
                vegetablesSoil.setText(Arrays.toString(plants.getSoil()).toLowerCase().substring(1, Arrays.toString(plants.getSoil()).length() - 1));
                vegetablesHeatneed.setText(plants.getHeatNeed().toString().toLowerCase());
                vegetablesLigthneed.setText(plants.getLightNeed().toString().toLowerCase());
                vegetablesWaterneed.setText(plants.getWaterNeed().toString().toLowerCase());
                vegetablesProduce.setText("ismeretlen");
                break;
            case PAPRIKA:
                plants = new Vegetables("Paprika", Needs.MAGAS, Needs.MAGAS, Needs.MAGAS, new String[]{"ne termesszük: paradicsom", "burgonya", "önmaga után"}, 30,
                        new Soils[]{Soils.BARNAERDŐTALAJ, Soils.CSERNOZJOM},
                        new Interval(LocalDate.of(2018, Month.MAY, 15), LocalDate.of(2018, Month.MAY, 16)),
                        new String[]{"trágyázás", "öntözés"},
                        new Interval(LocalDate.of(2018, Month.JUNE, 20), LocalDate.of(2018, Month.AUGUST, 1)),
                        null);
                vegetablesName.setText("Paprika");
                vegetablesForecrops.setText(Arrays.toString(plants.getForecrops()).substring(1, Arrays.toString(plants.getForecrops()).length() - 1));
                vegetablesCare.setText(Arrays.toString(plants.getCare()).substring(1, Arrays.toString(plants.getCare()).length() - 1));
                vegetablesPicking.setText(plants.getPicking().getMinDate().format(formatter) + " " + plants.getPicking().getMinDate().getDayOfMonth()
                        + "-" + plants.getPicking().getMaxDate().format(formatter) + " " + plants.getPicking().getMaxDate().getDayOfMonth() + " között");
                vegetablesPlanting.setText(plants.getPlanting().getMinDate().format(formatter) + " " + plants.getPlanting().getMinDate().getDayOfMonth()
                        + "-" + plants.getPlanting().getMaxDate().format(formatter) + " " + plants.getPlanting().getMaxDate().getDayOfMonth() + " között");
                vegetablesSpacing.setText(plants.getMinRowSpacing() + "cm");
                vegetablesSoil.setText(Arrays.toString(plants.getSoil()).toLowerCase().substring(1, Arrays.toString(plants.getSoil()).length() - 1));
                vegetablesHeatneed.setText(plants.getHeatNeed().toString().toLowerCase());
                vegetablesLigthneed.setText(plants.getLightNeed().toString().toLowerCase());
                vegetablesWaterneed.setText(plants.getWaterNeed().toString().toLowerCase());
                vegetablesProduce.setText("ismeretlen");
                break;
            case PARADICSOM:
                plants = new Vegetables("Paradicsom", Needs.KÖZEPES, Needs.MAGAS, Needs.MAGAS, new String[]{"dinnye", "uborka", "bab", "borsó", "káposztafélék"}, 65,
                        new Soils[]{Soils.BARNAERDŐTALAJ, Soils.BARNAERDŐTALAJ},
                        new Interval(LocalDate.of(2018, Month.APRIL, 20), LocalDate.of(2018, Month.APRIL, 25)),
                        new String[]{"gyomtalanítás", "öntözés", "trágyázás"},
                        new Interval(LocalDate.of(2018, Month.JULY, 15), LocalDate.of(2018, Month.AUGUST, 5)),
                        new Produce(3, 6));
                vegetablesName.setText("Paradicsom");
                vegetablesForecrops.setText(Arrays.toString(plants.getForecrops()).substring(1, Arrays.toString(plants.getForecrops()).length() - 1));
                vegetablesCare.setText(Arrays.toString(plants.getCare()).substring(1, Arrays.toString(plants.getCare()).length() - 1));
                vegetablesPicking.setText(plants.getPicking().getMinDate().format(formatter) + " " + plants.getPicking().getMinDate().getDayOfMonth()
                        + "-" + plants.getPicking().getMaxDate().format(formatter) + " " + plants.getPicking().getMaxDate().getDayOfMonth() + " között");
                vegetablesPlanting.setText(plants.getPlanting().getMinDate().format(formatter) + " " + plants.getPlanting().getMinDate().getDayOfMonth()
                        + "-" + plants.getPlanting().getMaxDate().format(formatter) + " " + plants.getPlanting().getMaxDate().getDayOfMonth() + " között");
                vegetablesSpacing.setText(plants.getMinRowSpacing() + "cm");
                vegetablesSoil.setText(Arrays.toString(plants.getSoil()).toLowerCase().substring(1, Arrays.toString(plants.getSoil()).length() - 1));
                vegetablesHeatneed.setText(plants.getHeatNeed().toString().toLowerCase());
                vegetablesLigthneed.setText(plants.getLightNeed().toString().toLowerCase());
                vegetablesWaterneed.setText(plants.getWaterNeed().toString().toLowerCase());
                vegetablesProduce.setText(plants.getProduce().getMin() + "-" + plants.getProduce().getMax() + "kg/m²");
                break;
            case VÖRÖSHAGYMA:
                plants = new Vegetables("Vöröshagyma", Needs.KÖZEPES, Needs.ALACSONY, Needs.KÖZEPES, new String[]{"trágyázott zöldségek"}, 25,
                        new Soils[]{Soils.KÖZÉPKÖTÖTTTALAJ, Soils.HOMOKTALAJ},
                        new Interval(LocalDate.of(2018, Month.MARCH, 10), LocalDate.of(2018, Month.MARCH, 20)),
                        new String[]{"gyomtalanítás", "öntözés", "kapálás", "talajtömörítés"},
                        new Interval(LocalDate.of(2018, Month.SEPTEMBER, 5), LocalDate.of(2018, Month.OCTOBER, 15)),
                        null);
                vegetablesName.setText("Vöröshagyma");
                vegetablesForecrops.setText(Arrays.toString(plants.getForecrops()).substring(1, Arrays.toString(plants.getForecrops()).length() - 1));
                vegetablesCare.setText(Arrays.toString(plants.getCare()).substring(1, Arrays.toString(plants.getCare()).length() - 1));
                vegetablesPicking.setText(plants.getPicking().getMinDate().format(formatter) + " " + plants.getPicking().getMinDate().getDayOfMonth()
                        + "-" + plants.getPicking().getMaxDate().format(formatter) + " " + plants.getPicking().getMaxDate().getDayOfMonth() + " között");
                vegetablesPlanting.setText(plants.getPlanting().getMinDate().format(formatter) + " " + plants.getPlanting().getMinDate().getDayOfMonth()
                        + "-" + plants.getPlanting().getMaxDate().format(formatter) + " " + plants.getPlanting().getMaxDate().getDayOfMonth() + " között");
                vegetablesSpacing.setText(plants.getMinRowSpacing() + "cm");
                vegetablesSoil.setText(Arrays.toString(plants.getSoil()).toLowerCase().substring(1, Arrays.toString(plants.getSoil()).length() - 1));
                vegetablesHeatneed.setText(plants.getHeatNeed().toString().toLowerCase());
                vegetablesLigthneed.setText(plants.getLightNeed().toString().toLowerCase());
                vegetablesWaterneed.setText(plants.getWaterNeed().toString().toLowerCase());
                vegetablesProduce.setText("ismeretlen");
                break;
            case BORSÓ:
                plants = new Vegetables("Borsó", Needs.ALACSONY, Needs.MAGAS, Needs.KÖZEPES, new String[]{"paprika", "uborka", "káposztafélék"}, 12,
                        new Soils[]{Soils.KÖZÉPKÖTÖTTTALAJ, Soils.HOMOKTALAJ, Soils.BARNAERDŐTALAJ, Soils.CSERNOZJOM, Soils.LAZATALAJ},
                        new Interval(LocalDate.of(2018, Month.FEBRUARY, 25), LocalDate.of(2018, Month.MARCH, 20)),
                        new String[]{"gyomtalanítás", "öntözés", "őszi mélyszántás", "tavaszi talajsimítás"},
                        new Interval(LocalDate.of(2018, Month.MAY, 15), LocalDate.of(2018, Month.JUNE, 30)),
                        new Produce(1, 2));
                vegetablesName.setText("Borsó");
                vegetablesForecrops.setText(Arrays.toString(plants.getForecrops()).substring(1, Arrays.toString(plants.getForecrops()).length() - 1));
                vegetablesCare.setText(Arrays.toString(plants.getCare()).substring(1, Arrays.toString(plants.getCare()).length() - 1));
                vegetablesPicking.setText(plants.getPicking().getMinDate().format(formatter) + " " + plants.getPicking().getMinDate().getDayOfMonth()
                        + "-" + plants.getPicking().getMaxDate().format(formatter) + " " + plants.getPicking().getMaxDate().getDayOfMonth() + " között");
                vegetablesPlanting.setText(plants.getPlanting().getMinDate().format(formatter) + " " + plants.getPlanting().getMinDate().getDayOfMonth()
                        + "-" + plants.getPlanting().getMaxDate().format(formatter) + " " + plants.getPlanting().getMaxDate().getDayOfMonth() + " között");
                vegetablesSpacing.setText(plants.getMinRowSpacing() + "cm");
                vegetablesSoil.setText(Arrays.toString(plants.getSoil()).toLowerCase().substring(1, Arrays.toString(plants.getSoil()).length() - 1));
                vegetablesHeatneed.setText(plants.getHeatNeed().toString().toLowerCase());
                vegetablesLigthneed.setText(plants.getLightNeed().toString().toLowerCase());
                vegetablesWaterneed.setText(plants.getWaterNeed().toString().toLowerCase());
                vegetablesProduce.setText(plants.getProduce().getMin() + "-" + plants.getProduce().getMax() + "kg/m²");
                break;
        }
    }

}
