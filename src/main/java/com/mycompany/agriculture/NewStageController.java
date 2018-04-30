/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.agriculture;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ivany
 */
public class NewStageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField fieldWidth;

    @FXML
    private TextField fieldHeigth;

    @FXML
    private Label labelErrorMessage;

    @FXML
    private void handleOk(ActionEvent event) throws IOException {
        try {

            if (fieldWidth.getText().equals("") || fieldHeigth.getText().equals("")) {
                labelErrorMessage.setText("Írja be mindkét értéket!");
            } else if (Integer.parseInt(fieldWidth.getText()) > 180 || Integer.parseInt(fieldHeigth.getText()) > 180) {
                labelErrorMessage.setText("Maximum érték: 180!");
            }else if (Integer.parseInt(fieldWidth.getText()) < 1 || Integer.parseInt(fieldHeigth.getText()) < 1) {
                labelErrorMessage.setText("Minimum érték: 1!");
            } else {

                ((Node) (event.getSource())).getScene().getWindow().hide();
                EditorController.mapDrb.createMapsCellsTable();
                EditorController.mapDrb.deleteMap();
                EditorController.mapDrb.deleteSize();
                EditorController.mapDrb.addSize(Integer.parseInt(fieldWidth.getText()), Integer.parseInt(fieldHeigth.getText()));
            }
        } catch (NumberFormatException nfe) {
            labelErrorMessage.setText("Írjon be valós egészszámot!");
        }

    }

    @FXML
    private void handleCancel(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
    }

}
