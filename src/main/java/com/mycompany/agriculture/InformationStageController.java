/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.agriculture;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.CellType;

/**
 * FXML Controller class
 *
 * @author ivany
 */

public class InformationStageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label infoLabel;
    
public void setInfoLabel(CellType ct) {
        infoLabel.setText(ct.name());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
