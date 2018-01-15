/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.agriculture;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Map.CellType;

/**
 * FXML Controller class
 *
 * @author ivany
 */
public class InformationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label information;

    @FXML
    private void alma(MouseEvent e) {
        EditorController.typeOfPlant = CellType.ALMA;
        try {
            Stage stage;
            Parent root;
            stage = (Stage) information.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FruitsTreeInformation.fxml"));
            root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void körte(MouseEvent e) {
        EditorController.typeOfPlant = CellType.KÖRTE;
        try {
            Stage stage;
            Parent root;
            stage = (Stage) information.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FruitsTreeInformation.fxml"));
            root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void meggy(MouseEvent e) {
        EditorController.typeOfPlant = CellType.MEGGY;
        try {
            Stage stage;
            Parent root;
            stage = (Stage) information.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FruitsTreeInformation.fxml"));
            root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void cseresznye(MouseEvent e) {
        EditorController.typeOfPlant = CellType.CSERESZNYE;
        try {
            Stage stage;
            Parent root;
            stage = (Stage) information.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FruitsTreeInformation.fxml"));
            root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void szilva(MouseEvent e) {
        EditorController.typeOfPlant = CellType.SZILVA;
        try {
            Stage stage;
            Parent root;
            stage = (Stage) information.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FruitsTreeInformation.fxml"));
            root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void öszibarack(MouseEvent e) {
        EditorController.typeOfPlant = CellType.ŐSZIBARACK;
        try {
            Stage stage;
            Parent root;
            stage = (Stage) information.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FruitsTreeInformation.fxml"));
            root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void dio(MouseEvent e) {
        EditorController.typeOfPlant = CellType.DIÓ;
        try {
            Stage stage;
            Parent root;
            stage = (Stage) information.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FruitsTreeInformation.fxml"));
            root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void malna(MouseEvent e) {
        EditorController.typeOfPlant = CellType.MÁLNA;
        try {
            Stage stage;
            Parent root;
            stage = (Stage) information.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FruitsBushInformation.fxml"));
            root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void eper(MouseEvent e) {
        EditorController.typeOfPlant = CellType.EPER;
        try {
            Stage stage;
            Parent root;
            stage = (Stage) information.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FruitsBushInformation.fxml"));
            root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void szeder(MouseEvent e) {
        EditorController.typeOfPlant = CellType.SZEDER;
        try {
            Stage stage;
            Parent root;
            stage = (Stage) information.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FruitsBushInformation.fxml"));
            root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void fejeskaposzta(MouseEvent e) {
        EditorController.typeOfPlant = CellType.FEJESKÁPOSZTA;
        try {
            Stage stage;
            Parent root;
            stage = (Stage) information.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/VegetablesInformation.fxml"));
            root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void karalabe(MouseEvent e) {
        EditorController.typeOfPlant = CellType.KARALÁBÉ;
        try {
            Stage stage;
            Parent root;
            stage = (Stage) information.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/VegetablesInformation.fxml"));
            root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void uborka(MouseEvent e) {
        EditorController.typeOfPlant = CellType.UBORKA;
        try {
            Stage stage;
            Parent root;
            stage = (Stage) information.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/VegetablesInformation.fxml"));
            root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void petrezselyem(MouseEvent e) {
        EditorController.typeOfPlant = CellType.PETREZSELYEM;
        try {
            Stage stage;
            Parent root;
            stage = (Stage) information.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/VegetablesInformation.fxml"));
            root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void sargarepa(MouseEvent e) {
        EditorController.typeOfPlant = CellType.SÁRGARÉPA;
        try {
            Stage stage;
            Parent root;
            stage = (Stage) information.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/VegetablesInformation.fxml"));
            root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void retek(MouseEvent e) {
        EditorController.typeOfPlant = CellType.RETEK;
        try {
            Stage stage;
            Parent root;
            stage = (Stage) information.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/VegetablesInformation.fxml"));
            root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void paradicsom(MouseEvent e) {
        EditorController.typeOfPlant = CellType.PARADICSOM;
        try {
            Stage stage;
            Parent root;
            stage = (Stage) information.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/VegetablesInformation.fxml"));
            root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void paprika(MouseEvent e) {
        EditorController.typeOfPlant = CellType.PAPRIKA;
        try {
            Stage stage;
            Parent root;
            stage = (Stage) information.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/VegetablesInformation.fxml"));
            root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void borso(MouseEvent e) {
        EditorController.typeOfPlant = CellType.BORSÓ;
        try {
            Stage stage;
            Parent root;
            stage = (Stage) information.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/VegetablesInformation.fxml"));
            root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void vöröshagyma(MouseEvent e) {
        EditorController.typeOfPlant = CellType.VÖRÖSHAGYMA;
        try {
            Stage stage;
            Parent root;
            stage = (Stage) information.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/VegetablesInformation.fxml"));
            root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void oszibuza(MouseEvent e) {
        EditorController.typeOfPlant = CellType.BÚZA;
        try {
            Stage stage;
            Parent root;
            stage = (Stage) information.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ArableCropsInformation.fxml"));
            root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         
    @FXML
    private void kukorica(MouseEvent e) {
        EditorController.typeOfPlant = CellType.KUKORICA;
        try {
            Stage stage;
            Parent root;
            stage = (Stage) information.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ArableCropsInformation.fxml"));
            root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void burgonya(MouseEvent e) {
        EditorController.typeOfPlant = CellType.BURGONYA;
        try {
            Stage stage;
            Parent root;
            stage = (Stage) information.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ArableCropsInformation.fxml"));
            root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void cukorrepa(MouseEvent e) {
        EditorController.typeOfPlant = CellType.CUKORRÉPA;
        try {
            Stage stage;
            Parent root;
            stage = (Stage) information.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ArableCropsInformation.fxml"));
            root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void napraforgo(MouseEvent e) {
        EditorController.typeOfPlant = CellType.NAPRAFORGÓ;
        try {
            Stage stage;
            Parent root;
            stage = (Stage) information.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ArableCropsInformation.fxml"));
            root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        // TODO
    }

}
