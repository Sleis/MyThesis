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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    private Label test;

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

    static CellType typeOfPlant;
    static MapDerby mapDrb = new MapDerby();

    Cell[][] cells;
    TheMap maps;
    int edit;
    int IDs;

    private CellType ct = CellType.DIRT;

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
    private void búza(ActionEvent event) {
        int[] tmp = new int[2];
        tmp[0] = 1;
        tmp[1] = 1;
        maps.setArea(tmp);
        ct = CellType.BÚZA;
    }

    @FXML
    private void kukorica(ActionEvent event) {
        int[] tmp = new int[2];
        tmp[0] = 1;
        tmp[1] = 1;
        maps.setArea(tmp);
        ct = CellType.KUKORICA;
    }

    @FXML
    private void burgonya(ActionEvent event) {
        int[] tmp = new int[2];
        tmp[0] = 1;
        tmp[1] = 1;
        maps.setArea(tmp);
        ct = CellType.BURGONYA;
    }

    @FXML
    private void cukorrépa(ActionEvent event) {
        int[] tmp = new int[2];
        tmp[0] = 1;
        tmp[1] = 1;
        maps.setArea(tmp);
        ct = CellType.CUKORRÉPA;
    }

    @FXML
    private void napraforgó(ActionEvent event) {
        int[] tmp = new int[2];
        tmp[0] = 1;
        tmp[1] = 1;
        maps.setArea(tmp);
        ct = CellType.NAPRAFORGÓ;
    }

    @FXML
    private void fejeskáposzta(ActionEvent event) {
        int[] tmp = new int[2];
        tmp[0] = 1;
        tmp[1] = 1;
        maps.setArea(tmp);
        ct = CellType.FEJESKÁPOSZTA;
    }

    @FXML
    private void karalábé(ActionEvent event) {
        int[] tmp = new int[2];
        tmp[0] = 1;
        tmp[1] = 1;
        maps.setArea(tmp);
        ct = CellType.KARALÁBÉ;
    }

    @FXML
    private void uborka(ActionEvent event) {
        int[] tmp = new int[2];
        tmp[0] = 1;
        tmp[1] = 1;
        maps.setArea(tmp);
        ct = CellType.UBORKA;
    }

    @FXML
    private void petrezselyem(ActionEvent event) {
        int[] tmp = new int[2];
        tmp[0] = 1;
        tmp[1] = 1;
        maps.setArea(tmp);
        ct = CellType.PETREZSELYEM;
    }

    @FXML
    private void sárgarépa(ActionEvent event) {
        int[] tmp = new int[2];
        tmp[0] = 1;
        tmp[1] = 1;
        maps.setArea(tmp);
        ct = CellType.SÁRGARÉPA;
    }

    @FXML
    private void retek(ActionEvent event) {
        int[] tmp = new int[2];
        tmp[0] = 1;
        tmp[1] = 1;
        maps.setArea(tmp);
        ct = CellType.RETEK;
    }

    @FXML
    private void paprika(ActionEvent event) {
        int[] tmp = new int[2];
        tmp[0] = 1;
        tmp[1] = 1;
        maps.setArea(tmp);
        ct = CellType.PAPRIKA;
    }

    @FXML
    private void paradicsom(ActionEvent event) {
        int[] tmp = new int[2];
        tmp[0] = 1;
        tmp[1] = 1;
        maps.setArea(tmp);
        ct = CellType.PARADICSOM;
    }

    @FXML
    private void vöröshagyma(ActionEvent event) {
        int[] tmp = new int[2];
        tmp[0] = 1;
        tmp[1] = 1;
        maps.setArea(tmp);
        ct = CellType.VÖRÖSHAGYMA;
    }

    @FXML
    private void borsó(ActionEvent event) {
        int[] tmp = new int[2];
        tmp[0] = 1;
        tmp[1] = 1;
        maps.setArea(tmp);
        ct = CellType.BORSÓ;
    }

    @FXML
    private void alma(ActionEvent event) {
        int[] tmp = new int[2];
        tmp[0] = 3;
        tmp[1] = 3;
        maps.setArea(tmp);
        ct = CellType.ALMA;
    }

    @FXML
    private void körte(ActionEvent event) {
        int[] tmp = new int[2];
        tmp[0] = 1;
        tmp[1] = 1;
        maps.setArea(tmp);
        ct = CellType.KÖRTE;
    }

    @FXML
    private void cseresznye(ActionEvent event) {
        int[] tmp = new int[2];
        tmp[0] = 1;
        tmp[1] = 1;
        maps.setArea(tmp);
        ct = CellType.CSERESZNYE;
    }

    @FXML
    private void meggy(ActionEvent event) {
        int[] tmp = new int[2];
        tmp[0] = 1;
        tmp[1] = 1;
        maps.setArea(tmp);
        ct = CellType.MEGGY;
    }

    @FXML
    private void szilva(ActionEvent event) {
        int[] tmp = new int[2];
        tmp[0] = 1;
        tmp[1] = 1;
        maps.setArea(tmp);
        ct = CellType.SZILVA;
    }

    @FXML
    private void őszibarack(ActionEvent event) {
        int[] tmp = new int[2];
        tmp[0] = 1;
        tmp[1] = 1;
        maps.setArea(tmp);
        ct = CellType.ŐSZIBARACK;
    }

    @FXML
    private void dió(ActionEvent event) {
        int[] tmp = new int[2];
        tmp[0] = 1;
        tmp[1] = 1;
        maps.setArea(tmp);
        ct = CellType.DIÓ;
    }

    @FXML
    private void málna(ActionEvent event) {
        int[] tmp = new int[2];
        tmp[0] = 1;
        tmp[1] = 1;
        maps.setArea(tmp);
        ct = CellType.MÁLNA;
    }

    @FXML
    private void eper(ActionEvent event) {
        int[] tmp = new int[2];
        tmp[0] = 1;
        tmp[1] = 1;
        maps.setArea(tmp);
        ct = CellType.EPER;
    }

    @FXML
    private void szeder(ActionEvent event) {
        int[] tmp = new int[2];
        tmp[0] = 1;
        tmp[1] = 1;
        maps.setArea(tmp);
        ct = CellType.SZEDER;
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
        switch (edit) {
            case 0:
                if (maps.doOverlapOneAnother(x, y)) {
                    errorMessage.setText("Másikra nem lehet rakni!");
                } else if (maps.doTheAreaGoOut(x, y)) {
                    errorMessage.setText("Kimentél a területről!");
                } else {
                    switch (ct) {
                        case BÚZA:
                            maps.coloring(x, y, 1, CellType.BÚZA, IDs);
                            break;
                        case KUKORICA:
                            maps.coloring(x, y, 1, CellType.KUKORICA, IDs);
                            break;
                        case BURGONYA:
                            maps.coloring(x, y, 1, CellType.BURGONYA, IDs);
                            break;
                        case CUKORRÉPA:
                            maps.coloring(x, y, 1, CellType.CUKORRÉPA, IDs);
                            break;
                        case NAPRAFORGÓ:
                            maps.coloring(x, y, 1, CellType.NAPRAFORGÓ, IDs);
                            break;
                        case FEJESKÁPOSZTA:
                            maps.coloring(x, y, 1, CellType.FEJESKÁPOSZTA, IDs);
                            break;
                        case PETREZSELYEM:
                            maps.coloring(x, y, 1, CellType.PETREZSELYEM, IDs);
                            break;
                        case KARALÁBÉ:
                            maps.coloring(x, y, 1, CellType.KARALÁBÉ, IDs);
                            break;
                        case UBORKA:
                            maps.coloring(x, y, 1, CellType.UBORKA, IDs);
                            break;
                        case SÁRGARÉPA:
                            maps.coloring(x, y, 1, CellType.SÁRGARÉPA, IDs);
                            break;
                        case RETEK:
                            maps.coloring(x, y, 1, CellType.RETEK, IDs);
                            break;
                        case PAPRIKA:
                            maps.coloring(x, y, 1, CellType.PAPRIKA, IDs);
                            break;
                        case PARADICSOM:
                            maps.coloring(x, y, 1, CellType.PARADICSOM, IDs);
                            break;
                        case VÖRÖSHAGYMA:
                            maps.coloring(x, y, 1, CellType.VÖRÖSHAGYMA, IDs);
                            break;
                        case BORSÓ:
                            maps.coloring(x, y, 1, CellType.BORSÓ, IDs);
                            break;
                        case ALMA:
                            maps.coloring(x, y, 1, CellType.ALMA, IDs);
                            break;
                        case KÖRTE:
                            maps.coloring(x, y, 1, CellType.KÖRTE, IDs);
                            break;
                        case ŐSZIBARACK:
                            maps.coloring(x, y, 1, CellType.ŐSZIBARACK, IDs);
                            break;
                        case SZILVA:
                            maps.coloring(x, y, 1, CellType.SZILVA, IDs);
                            break;
                        case MEGGY:
                            maps.coloring(x, y, 1, CellType.MEGGY, IDs);
                            break;
                        case CSERESZNYE:
                            maps.coloring(x, y, 1, CellType.CSERESZNYE, IDs);
                            break;
                        case DIÓ:
                            maps.coloring(x, y, 1, CellType.DIÓ, IDs);
                            break;
                        case MÁLNA:
                            maps.coloring(x, y, 1, CellType.MÁLNA, IDs);
                            break;
                        case EPER:
                            maps.coloring(x, y, 1, CellType.EPER, IDs);
                            break;
                        case SZEDER:
                            maps.coloring(x, y, 1, CellType.SZEDER, IDs);
                            break;
                        default:
                            maps.coloring(x, y, 0, CellType.DIRT, IDs);
                    }
                    IDs++;
                    errorMessage.setText("");
                }
                break;
            case 1:
                try {
                    boolean dirt = false;
                    FXMLLoader fxmlLoader;
                    switch (maps.getCell()[x][y].getCelltype()) {
                        case BÚZA:
                            fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ArableCropsInformation.fxml"));
                            typeOfPlant = CellType.BÚZA;
                            break;
                        case KUKORICA:
                            fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ArableCropsInformation.fxml"));
                            typeOfPlant = CellType.KUKORICA;
                            break;
                        case BURGONYA:
                            fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ArableCropsInformation.fxml"));
                            typeOfPlant = CellType.BURGONYA;
                            break;
                        case CUKORRÉPA:
                            fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ArableCropsInformation.fxml"));
                            typeOfPlant = CellType.CUKORRÉPA;
                            break;
                        case NAPRAFORGÓ:
                            fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ArableCropsInformation.fxml"));
                            typeOfPlant = CellType.NAPRAFORGÓ;
                            break;
                        case FEJESKÁPOSZTA:
                            fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/VegetablesInformation.fxml"));
                            typeOfPlant = CellType.FEJESKÁPOSZTA;
                            break;
                        case PETREZSELYEM:
                            fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/VegetablesInformation.fxml"));
                            typeOfPlant = CellType.PETREZSELYEM;
                            break;
                        case KARALÁBÉ:
                            fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/VegetablesInformation.fxml"));
                            typeOfPlant = CellType.KARALÁBÉ;
                            break;
                        case UBORKA:
                            fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/VegetablesInformation.fxml"));
                            typeOfPlant = CellType.UBORKA;
                            break;
                        case SÁRGARÉPA:
                            fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/VegetablesInformation.fxml"));
                            typeOfPlant = CellType.SÁRGARÉPA;
                            break;
                        case RETEK:
                            fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/VegetablesInformation.fxml"));
                            typeOfPlant = CellType.RETEK;
                            break;
                        case PAPRIKA:
                            fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/VegetablesInformation.fxml"));
                            typeOfPlant = CellType.PAPRIKA;
                            break;
                        case PARADICSOM:
                            fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/VegetablesInformation.fxml"));
                            typeOfPlant = CellType.PARADICSOM;
                            break;
                        case VÖRÖSHAGYMA:
                            fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/VegetablesInformation.fxml"));
                            typeOfPlant = CellType.VÖRÖSHAGYMA;
                            break;
                        case BORSÓ:
                            fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/VegetablesInformation.fxml"));
                            typeOfPlant = CellType.BORSÓ;
                            break;
                        case ALMA:
                            fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/FruitsTreeInformation.fxml"));
                            typeOfPlant = CellType.ALMA;
                            break;
                        case KÖRTE:
                            fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/FruitsTreeInformation.fxml"));
                            typeOfPlant = CellType.KÖRTE;
                            break;
                        case ŐSZIBARACK:
                            fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/FruitsTreeInformation.fxml"));
                            typeOfPlant = CellType.ŐSZIBARACK;
                            break;
                        case SZILVA:
                            fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/FruitsTreeInformation.fxml"));
                            typeOfPlant = CellType.SZILVA;
                            break;
                        case MEGGY:
                            fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/FruitsTreeInformation.fxml"));
                            typeOfPlant = CellType.MEGGY;
                            break;
                        case CSERESZNYE:
                            fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/FruitsTreeInformation.fxml"));
                            typeOfPlant = CellType.CSERESZNYE;
                            break;
                        case DIÓ:
                            fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/FruitsTreeInformation.fxml"));
                            typeOfPlant = CellType.DIÓ;
                            break;
                        case MÁLNA:
                            fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/FruitsBushInformation.fxml"));
                            typeOfPlant = CellType.MÁLNA;
                            break;
                        case EPER:
                            fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/FruitsBushInformation.fxml"));
                            typeOfPlant = CellType.EPER;
                            break;
                        case SZEDER:
                            fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/FruitsBushInformation.fxml"));
                            typeOfPlant = CellType.SZEDER;
                            break;
                        default:
                            fxmlLoader = new FXMLLoader(getClass().getResource(""));
                            dirt = true;

                    }
                    if (!dirt) {
                        Parent root = (Parent) fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.initModality(Modality.WINDOW_MODAL);
                        stage.initOwner(pane.getScene().getWindow());
                        stage.setScene(new Scene(root));
                        stage.show();
                    }
                } catch (IOException e1) {
                    System.out.println(e1);
                }
                break;
            default:
                if (maps.getCell()[x][y].getCelltype() != CellType.DIRT) {
                    maps.checkAll(maps.getCell()[x][y].getID());
                }
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
                    case BÚZA:
                        boardGraphics.setFill(Color.YELLOWGREEN);
                        break;
                    case KUKORICA:
                        boardGraphics.setFill(Color.CORNSILK);
                        break;
                    case BURGONYA:
                        boardGraphics.setFill(Color.BURLYWOOD);
                        break;
                    case CUKORRÉPA:
                        boardGraphics.setFill(Color.CYAN);
                        break;
                    case NAPRAFORGÓ:
                        boardGraphics.setFill(Color.YELLOW);
                        break;
                    case FEJESKÁPOSZTA:
                        boardGraphics.setFill(Color.DARKSLATEGREY);
                        break;
                    case KARALÁBÉ:
                        boardGraphics.setFill(Color.DARKSEAGREEN);
                        break;
                    case UBORKA:
                        boardGraphics.setFill(Color.LIGHTGREEN);
                        break;
                    case PETREZSELYEM:
                        boardGraphics.setFill(Color.GREEN);
                        break;
                    case SÁRGARÉPA:
                        boardGraphics.setFill(Color.ORANGE);
                        break;
                    case RETEK:
                        boardGraphics.setFill(Color.CRIMSON);
                        break;
                    case PAPRIKA:
                        boardGraphics.setFill(Color.DARKKHAKI);
                        break;
                    case PARADICSOM:
                        boardGraphics.setFill(Color.TOMATO);
                        break;
                    case VÖRÖSHAGYMA:
                        boardGraphics.setFill(Color.FUCHSIA);
                        break;
                    case BORSÓ:
                        boardGraphics.setFill(Color.HOTPINK);
                        break;
                    case ALMA:
                        boardGraphics.setFill(Color.MEDIUMSLATEBLUE);
                        break;
                    case KÖRTE:
                        boardGraphics.setFill(Color.PINK);
                        break;
                    case CSERESZNYE:
                        boardGraphics.setFill(Color.SALMON);
                        break;
                    case MEGGY:
                        boardGraphics.setFill(Color.PURPLE);
                        break;
                    case ŐSZIBARACK:
                        boardGraphics.setFill(Color.BLACK);
                        break;
                    case DIÓ:
                        boardGraphics.setFill(Color.CADETBLUE);
                        break;
                    case SZILVA:
                        boardGraphics.setFill(Color.KHAKI);
                        break;
                    case MÁLNA:
                        boardGraphics.setFill(Color.VIOLET);
                        break;
                    case EPER:
                        boardGraphics.setFill(Color.OLIVE);
                        break;
                    case SZEDER:
                        boardGraphics.setFill(Color.NAVY);
                        break;
                    case DIRT:
                        boardGraphics.setFill(Color.BROWN);
                        break;
                    case MOVE:
                        boardGraphics.setFill(Color.GRAY);
                        break;
                    case ERROR:
                        boardGraphics.setFill(Color.RED);
                        break;
                }
                boardGraphics.fillRect(i * maps.getWidthRate(), j * maps.getHeigthRate(), maps.getWidthRate() - 1, maps.getHeigthRate() - 1);

            }
        }
        board.setLayoutX((1600 - board.getWidth()) / 2);
        board.setLayoutY((900 - board.getHeight()) / 2);

    }
    private GraphicsContext boardGraphics;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        mapDrb.createMapsSizeTable();
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
        maps.setHeightRate(5);
        maps.setWidthRate(5);

        maps.setArea(1, 1);

        board.setWidth(maps.getWidth() * maps.getWidthRate());
        board.setHeight(maps.getHeigth() * maps.getHeigthRate());
        try {
            ResultSet rs = mapDrb.getMap();
            while (rs.next()) {
                switch (rs.getString("cellType")) {
                    case "BÚZA":
                        cells[Integer.parseInt(rs.getString("x"))][Integer.parseInt(rs.getString("y"))].setCell(CellType.BÚZA, 1, Integer.parseInt(rs.getString("cellsID")));
                        break;
                    case "KUKORICA":
                        cells[Integer.parseInt(rs.getString("x"))][Integer.parseInt(rs.getString("y"))].setCell(CellType.KUKORICA, 1, Integer.parseInt(rs.getString("cellsID")));
                        break;
                    case "BURGONYA":
                        cells[Integer.parseInt(rs.getString("x"))][Integer.parseInt(rs.getString("y"))].setCell(CellType.BURGONYA, 1, Integer.parseInt(rs.getString("cellsID")));
                        break;
                    case "CUKORRÉPA":
                        cells[Integer.parseInt(rs.getString("x"))][Integer.parseInt(rs.getString("y"))].setCell(CellType.CUKORRÉPA, 1, Integer.parseInt(rs.getString("cellsID")));
                        break;
                    case "NAPRAFORGÓ":
                        cells[Integer.parseInt(rs.getString("x"))][Integer.parseInt(rs.getString("y"))].setCell(CellType.NAPRAFORGÓ, 1, Integer.parseInt(rs.getString("cellsID")));
                        break;
                    case "FEJESKÁPOSZTA":
                        cells[Integer.parseInt(rs.getString("x"))][Integer.parseInt(rs.getString("y"))].setCell(CellType.FEJESKÁPOSZTA, 1, Integer.parseInt(rs.getString("cellsID")));
                        break;
                    case "PETREZSELYEM":
                        cells[Integer.parseInt(rs.getString("x"))][Integer.parseInt(rs.getString("y"))].setCell(CellType.PETREZSELYEM, 1, Integer.parseInt(rs.getString("cellsID")));
                        break;
                    case "KARALÁBÉ":
                        cells[Integer.parseInt(rs.getString("x"))][Integer.parseInt(rs.getString("y"))].setCell(CellType.KARALÁBÉ, 1, Integer.parseInt(rs.getString("cellsID")));
                        break;
                    case "UBORKA":
                        cells[Integer.parseInt(rs.getString("x"))][Integer.parseInt(rs.getString("y"))].setCell(CellType.UBORKA, 1, Integer.parseInt(rs.getString("cellsID")));
                        break;
                    case "SÁRGARÉPA":
                        cells[Integer.parseInt(rs.getString("x"))][Integer.parseInt(rs.getString("y"))].setCell(CellType.SÁRGARÉPA, 1, Integer.parseInt(rs.getString("cellsID")));
                        break;
                    case "RETEK":
                        cells[Integer.parseInt(rs.getString("x"))][Integer.parseInt(rs.getString("y"))].setCell(CellType.RETEK, 1, Integer.parseInt(rs.getString("cellsID")));
                        break;
                    case "PAPRIKA":
                        cells[Integer.parseInt(rs.getString("x"))][Integer.parseInt(rs.getString("y"))].setCell(CellType.PAPRIKA, 1, Integer.parseInt(rs.getString("cellsID")));
                        break;
                    case "PARADICSOM":
                        cells[Integer.parseInt(rs.getString("x"))][Integer.parseInt(rs.getString("y"))].setCell(CellType.PARADICSOM, 1, Integer.parseInt(rs.getString("cellsID")));
                        break;
                    case "VÖRÖSHAGYMA":
                        cells[Integer.parseInt(rs.getString("x"))][Integer.parseInt(rs.getString("y"))].setCell(CellType.VÖRÖSHAGYMA, 1, Integer.parseInt(rs.getString("cellsID")));
                        break;
                    case "BORSÓ":
                        cells[Integer.parseInt(rs.getString("x"))][Integer.parseInt(rs.getString("y"))].setCell(CellType.BORSÓ, 1, Integer.parseInt(rs.getString("cellsID")));
                        break;
                    case "ALMA":
                        cells[Integer.parseInt(rs.getString("x"))][Integer.parseInt(rs.getString("y"))].setCell(CellType.ALMA, 1, Integer.parseInt(rs.getString("cellsID")));
                        break;
                    case "KÖRTE":
                        cells[Integer.parseInt(rs.getString("x"))][Integer.parseInt(rs.getString("y"))].setCell(CellType.KÖRTE, 1, Integer.parseInt(rs.getString("cellsID")));
                        break;
                    case "ŐSZIBARACK":
                        cells[Integer.parseInt(rs.getString("x"))][Integer.parseInt(rs.getString("y"))].setCell(CellType.ŐSZIBARACK, 1, Integer.parseInt(rs.getString("cellsID")));
                        break;
                    case "SZILVA":
                        cells[Integer.parseInt(rs.getString("x"))][Integer.parseInt(rs.getString("y"))].setCell(CellType.SZILVA, 1, Integer.parseInt(rs.getString("cellsID")));
                        break;
                    case "MEGGY":
                        cells[Integer.parseInt(rs.getString("x"))][Integer.parseInt(rs.getString("y"))].setCell(CellType.MEGGY, 1, Integer.parseInt(rs.getString("cellsID")));
                        break;
                    case "CSERESZNYE":
                        cells[Integer.parseInt(rs.getString("x"))][Integer.parseInt(rs.getString("y"))].setCell(CellType.CSERESZNYE, 1, Integer.parseInt(rs.getString("cellsID")));
                        break;
                    case "DIÓ":
                        cells[Integer.parseInt(rs.getString("x"))][Integer.parseInt(rs.getString("y"))].setCell(CellType.DIÓ, 1, Integer.parseInt(rs.getString("cellsID")));
                        break;
                    case "MÁLNA":
                        cells[Integer.parseInt(rs.getString("x"))][Integer.parseInt(rs.getString("y"))].setCell(CellType.MÁLNA, 1, Integer.parseInt(rs.getString("cellsID")));
                        break;
                    case "EPER":
                        cells[Integer.parseInt(rs.getString("x"))][Integer.parseInt(rs.getString("y"))].setCell(CellType.EPER, 1, Integer.parseInt(rs.getString("cellsID")));
                        break;
                    case "SZEDER":
                        cells[Integer.parseInt(rs.getString("x"))][Integer.parseInt(rs.getString("y"))].setCell(CellType.SZEDER, 1, Integer.parseInt(rs.getString("cellsID")));
                        break;
                    default:
                        cells[Integer.parseInt(rs.getString("x"))][Integer.parseInt(rs.getString("y"))].setCell(CellType.DIRT, 0, Integer.parseInt(rs.getString("cellsID")));
                        break;
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
