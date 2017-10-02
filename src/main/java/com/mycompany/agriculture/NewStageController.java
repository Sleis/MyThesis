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

    private static String heigth = "100";
    private static String width = "100";

    public static void setWidth(String w) {
        NewStageController.width = w;
    }

    public static void setHeigth(String h) {
        NewStageController.heigth = h;
    }

    public static String getHeigth() {
        return heigth;
    }

    public static String getWidth() {
        return width;
    }

    @FXML
    private void handleOk(ActionEvent event) throws IOException {
        NewStageController.setHeigth(fieldHeigth.getText());
        NewStageController.setWidth(fieldWidth.getText());
        try{
        int w = Integer.parseInt(width);
        int h = Integer.parseInt(heigth);
        
        
        if (heigth.equals("") || width.equals("")) {
            labelErrorMessage.setText("Enter both values!");
        } else if (w > 200 || h > 200) {
            labelErrorMessage.setText("Maximum values are 200!");
        } else {
            ((Node) (event.getSource())).getScene().getWindow().hide();
        }
        }catch(NumberFormatException nfe){
            labelErrorMessage.setText("Please, enter integer values!");
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
