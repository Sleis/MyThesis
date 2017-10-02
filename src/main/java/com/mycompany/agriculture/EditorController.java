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
import javafx.stage.Stage;
import model.Cell;
import model.CellType;
import model.TheMap;

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
    private Pane pane;

    @FXML
    private Canvas board;

    @FXML
    private Label errorMessage;

    Cell[][] cells;
    TheMap maps;
    int edit;
    int IDs;

    @FXML
    private void handleNew(ActionEvent event) throws IOException {
        try {
            Stage stage = (Stage) buttonBack.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Home.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/NewStage.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(root1));
            stage1.show();

        } catch (IOException e) {
            System.out.println(e);
        }
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
    private void handle2x2(ActionEvent event) throws IOException {
        int[] tmp = new int[2];
        tmp[0] = 2;
        tmp[1] = 2;
        maps.setArea(tmp);
    }

    @FXML
    private void handle3x3(ActionEvent event) throws IOException {
        int[] tmp = new int[2];
        tmp[0] = 3;
        tmp[1] = 3;
        maps.setArea(tmp);
    }

    @FXML
    private void handle3x1(ActionEvent event) throws IOException {
        int[] tmp = new int[2];
        tmp[0] = 3;
        tmp[1] = 1;
        maps.setArea(tmp);
    }

    @FXML
    private void handle2x4(ActionEvent event) throws IOException {
        int[] tmp = new int[2];
        tmp[0] = 2;
        tmp[1] = 4;
        maps.setArea(tmp);
    }

    @FXML
    private void handle5x2(ActionEvent event) throws IOException {
        int[] tmp = new int[2];
        tmp[0] = 5;
        tmp[1] = 2;
        maps.setArea(tmp);
    }

    @FXML
    private void handle1x4(ActionEvent event) throws IOException {
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
    private void handleAdd(ActionEvent event) throws IOException {
        edit = 0;
    }

    @FXML
    private void handleInformation(ActionEvent event) throws IOException {
        edit = 1;
    }

    @FXML
    private void handleDelete(ActionEvent event) throws IOException {
        edit = 2;
    }

    @FXML
    private void handleClick(MouseEvent e) {
        int x = (int) e.getX() / maps.getRate();
        int y = (int) e.getY() / maps.getRate();
        try {
            switch (edit) {
                case 0:
                    if (!maps.doTheAreaGoOut(x, y) && !maps.doOverlapOneAnother(x, y)) {
                        maps.coloring(x, y, 1, CellType.GRASS, IDs);
                        IDs++;
                    } else {
                        errorMessage.setText("Kimentél a területről!");
                    }
                    break;
                case 1:
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/InformationStage.fxml"));
                        Parent root = (Parent) fxmlLoader.load();
                        Stage stage = new Stage();
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
            int x = (int) e.getX() / maps.getRate();
            int y = (int) e.getY() / maps.getRate();
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
                        boardGraphics.fillRect(i * maps.getRate(), j * maps.getRate(), maps.getRate(), maps.getRate());
                        break;
                    case GRASS:
                        boardGraphics.setFill(Color.GREEN);
                        boardGraphics.fillRect(i * maps.getRate(), j * maps.getRate(), maps.getRate(), maps.getRate());
                        break;
                    case MOVE:
                        boardGraphics.setFill(Color.YELLOW);
                        boardGraphics.fillRect(i * maps.getRate(), j * maps.getRate(), maps.getRate(), maps.getRate());
                        break;
                    case ERROR:
                        boardGraphics.setFill(Color.RED);
                        boardGraphics.fillRect(i * maps.getRate(), j * maps.getRate(), maps.getRate(), maps.getRate());
                        break;
                    default:
                        boardGraphics.setFill(Color.BLUE);
                        boardGraphics.fillRect(i * maps.getRate(), j * maps.getRate(), maps.getRate(), maps.getRate());
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
        edit = 0;
        IDs = 1;
        maps = new TheMap();
        maps.setHeigth(Integer.parseInt(NewStageController.getHeigth()));
        maps.setWidth(Integer.parseInt(NewStageController.getWidth()));
        cells = new Cell[maps.getWidth()][maps.getHeigth()];

        if (maps.getWidth() <= 50) {
            maps.setRate(16);
        } else if (maps.getWidth() > 50 && maps.getWidth() <= 100) {
            maps.setRate(8);
        } else {
            maps.setRate(4);
        }

        maps.setArea(1, 1);

        board.setWidth(maps.getWidth() * maps.getRate());
        board.setHeight(maps.getHeigth() * maps.getRate());
        for (int i = 0; i < maps.getWidth(); i++) {
            for (int j = 0; j < maps.getHeigth(); j++) {
                cells[i][j] = new Cell(CellType.DIRT, 0, 0);
            }
        }
        maps.setCell(cells);
        pane.setStyle("-fx-background-image: url(\"/pictures/negy.JPG\");");
        boardGraphics = board.getGraphicsContext2D();
        refreshMap();

    }
}
