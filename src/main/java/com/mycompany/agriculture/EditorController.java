/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.agriculture;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Map.Cell;
import model.Map.CellType;
import model.DB.MapDerby;
import model.Map.TheMap;

/**
 *
 * @author ivany
 */
public class EditorController implements Initializable {
    
    @FXML
    private Button buttonBack;
    
    @FXML
    private Button buttonReset;
    
    @FXML
    private Button buttonNew;
    
    @FXML
    private Button buttonAdd;
    
    @FXML
    private Button buttonSave;
    
    @FXML
    private Pane pane;
    
    @FXML
    private Canvas board;
    
    @FXML
    private Label errorMessage;
    
    static MapDerby mapDrb = new MapDerby();
    
    Cell[][] cells;
    TheMap maps;
    int edit;
    int IDs;
    
    @FXML
    private void handleNew(ActionEvent event) throws IOException {
        try {
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/NewStage.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage1 = new Stage();
            stage1.initModality(Modality.WINDOW_MODAL);
            stage1.initOwner(pane.getScene().getWindow());
            stage1.resizableProperty().setValue(Boolean.FALSE);
            stage1.setScene(new Scene(root1));
            stage1.show();
            
            Stage stage = (Stage) buttonBack.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Home.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    @FXML
    private void handleSave(ActionEvent event) {
        mapDrb.deleteMap();
        for (int i = 0; i < maps.getWidth(); i++) {
            for (int j = 0; j < maps.getHeigth(); j++) {
                if (maps.getCell()[i][j].getStatus() == 1) {
                    mapDrb.addCell(i, j, maps.getCell()[i][j].getID(), maps.getCell()[i][j].getCelltype().toString());
                }
            }
        }
        mapDrb.deleteSize();
        mapDrb.addSize(maps.getWidth(), maps.getHeigth());
        
    }
    
    @FXML
    private void handleBack(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) buttonBack.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Home.fxml"));
        root = loader.load();
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void handle2x2(ActionEvent event) {
        int[] tmp = new int[2];
        tmp[0] = 2;
        tmp[1] = 2;
        maps.setArea(tmp);
    }
    
    @FXML
    private void handle3x3(ActionEvent event) {
        int[] tmp = new int[2];
        tmp[0] = 3;
        tmp[1] = 3;
        maps.setArea(tmp);
    }
    
    @FXML
    private void handle3x1(ActionEvent event) {
        int[] tmp = new int[2];
        tmp[0] = 3;
        tmp[1] = 1;
        maps.setArea(tmp);
    }
    
    @FXML
    private void handle2x4(ActionEvent event) {
        int[] tmp = new int[2];
        tmp[0] = 2;
        tmp[1] = 4;
        maps.setArea(tmp);
    }
    
    @FXML
    private void handle5x2(ActionEvent event) {
        int[] tmp = new int[2];
        tmp[0] = 5;
        tmp[1] = 2;
        maps.setArea(tmp);
    }
    
    @FXML
    private void handle1x4(ActionEvent event) {
        int[] tmp = new int[2];
        tmp[0] = 1;
        tmp[1] = 4;
        maps.setArea(tmp);
    }
    
    @FXML
    private void handleReset(ActionEvent event) {
        for (int i = 0; i < maps.getWidth(); i++) {
            for (int j = 0; j < maps.getHeigth(); j++) {
                maps.getCell()[i][j].setDefault();
            }
        }
        refreshMap();
    }
    
    @FXML
    private void handleAdd(ActionEvent event) {
        edit = 0;
    }
    
    @FXML
    private void handleInformation(ActionEvent event) {
        edit = 1;
    }
    
    @FXML
    private void handleDelete(ActionEvent event) {
        edit = 2;
    }
    
    @FXML
    private void handleClick(MouseEvent e) {
        int x = (int) e.getX() / maps.getWidthRate();
        int y = (int) e.getY() / maps.getHeigthRate();
        try {
            switch (edit) {
                case 0:
                    if (maps.doOverlapOneAnother(x, y)) {
                        errorMessage.setText("You are covering another!");
                    } else if (maps.doTheAreaGoOut(x, y)) {
                        errorMessage.setText("You went out of the area!");
                    } else {
                        maps.coloring(x, y, 1, CellType.GRASS, IDs);
                        IDs++;
                        errorMessage.setText("");
                    }
                    break;
                case 1:
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/InformationStage.fxml"));
                        Parent root = (Parent) fxmlLoader.load();
                        fxmlLoader.<InformationStageController>getController().setInfoLabel(maps.getCell()[x][y].getCelltype());
                        Stage stage = new Stage();
                        stage.initModality(Modality.WINDOW_MODAL);
                        stage.initOwner(pane.getScene().getWindow());
                        stage.setScene(new Scene(root));
                        stage.show();
                    } catch (IOException e1) {
                        System.out.println(e1);
                    }
                    break;
                default:
                    if (maps.getCell()[x][y].getCelltype() != CellType.DIRT) {
                        maps.checkAll(maps.getCell()[x][y].getID());
                    }
            }
            
        } catch (ArrayIndexOutOfBoundsException aiobe) {
        }
        refreshMap();
    }
    
    @FXML
    private void handleMoved(MouseEvent e) {
        if (edit == 0) {
            maps.reset();
            int x = (int) e.getX() / maps.getWidthRate();
            int y = (int) e.getY() / maps.getHeigthRate();
            if (!maps.doTheAreaGoOut(x, y) && !maps.doOverlapOneAnother(x, y)) {
                maps.coloring(x, y, 0, CellType.MOVE);
            } else {
                maps.coloring(x, y, 0, CellType.ERROR);
            }
            refreshMap();
        }
    }
    
    @FXML
    private void handleExited(MouseEvent e) {
        for (int i = 0; i < maps.getWidth(); i++) {
            for (int j = 0; j < maps.getHeigth(); j++) {
                maps.getCell()[i][j].setDefaultIfStatusZero();
            }
        }
        refreshMap();
    }
    
    @FXML
    private void refreshMap() {
        for (int i = 0; i < maps.getWidth(); i++) {
            for (int j = 0; j < maps.getHeigth(); j++) {
                switch (maps.getCell()[i][j].getCelltype()) {
                    case DIRT:
                        boardGraphics.setFill(Color.BROWN);
                        boardGraphics.fillRect(i * maps.getWidthRate(), j * maps.getHeigthRate(), maps.getWidthRate(), maps.getHeigthRate());
                        break;
                    case GRASS:
                        boardGraphics.setFill(Color.GREEN);
                        boardGraphics.fillRect(i * maps.getWidthRate(), j * maps.getHeigthRate(), maps.getWidthRate(), maps.getHeigthRate());
                        break;
                    case MOVE:
                        boardGraphics.setFill(Color.YELLOW);
                        boardGraphics.fillRect(i * maps.getWidthRate(), j * maps.getHeigthRate(), maps.getWidthRate(), maps.getHeigthRate());
                        break;
                    case ERROR:
                        boardGraphics.setFill(Color.RED);
                        boardGraphics.fillRect(i * maps.getWidthRate(), j * maps.getHeigthRate(), maps.getWidthRate(), maps.getHeigthRate());
                        break;
                    default:
                        boardGraphics.setFill(Color.BLUE);
                        boardGraphics.fillRect(i * maps.getWidthRate(), j * maps.getHeigthRate(), maps.getWidthRate(), maps.getHeigthRate());
                        break;
                }
                
            }
        }
        board.setLayoutX((1600 - board.getWidth()) / 2);
        board.setLayoutY((900 - board.getHeight()) / 2);
        
    }
    private GraphicsContext boardGraphics;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        mapDrb.createMapsCellsTable();
        edit = 0;
        IDs = 1;
        maps = new TheMap();
        try {
            ResultSet size = mapDrb.getSize();
            size.next();
            maps.setHeigth(Integer.parseInt(size.getString("y")));
            maps.setWidth(Integer.parseInt(size.getString("x")));
        } catch (SQLException ex) {
            Logger.getLogger(EditorController.class.getName()).log(Level.SEVERE, null, ex);
        }

        cells = new Cell[maps.getWidth()][maps.getHeigth()];
        for (int i = 0; i < maps.getWidth(); i++) {
            for (int j = 0; j < maps.getHeigth(); j++) {
                cells[i][j] = new Cell(CellType.DIRT, 0, 0);
            }
        }
        // ITT KELL MÉG JAVÍTANI
        if (maps.getWidth() <= 50) {
            maps.setWidthRate(16);
        } else if (maps.getWidth() > 50 && maps.getWidth() <= 100) {
            maps.setWidthRate(8);
        } else {
            maps.setWidthRate(4);
        }
        if (maps.getHeigth() <= 50) {
            maps.setHeightRate(16);
        } else if (maps.getHeigth() > 50 && maps.getHeigth() <= 100) {
            maps.setHeightRate(8);
        } else {
            maps.setHeightRate(4);
        }
       //IDÁIG 
        maps.setArea(1, 1);
        
        board.setWidth(maps.getWidth() * maps.getWidthRate());
        board.setHeight(maps.getHeigth() * maps.getHeigthRate());
        try {
            ResultSet rs = mapDrb.getMap();
            while (rs.next()) {
                if (rs.getString("cellType").equals("GRASS")) {
                    cells[Integer.parseInt(rs.getString("x"))][Integer.parseInt(rs.getString("y"))].setCell(CellType.GRASS, 1, Integer.parseInt(rs.getString("cellsID")));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditorController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        
        maps.setCell(cells);
        pane.setStyle("-fx-background-image: url(\"/pictures/negy.JPG\");");
        boardGraphics = board.getGraphicsContext2D();
        refreshMap();
        
    }
}
