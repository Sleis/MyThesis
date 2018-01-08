/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DB;

import com.mycompany.agriculture.HomeController;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivany
 */
public class MapDerby {

    private static Connection connection;
    private static Statement stmt;
    private static final Path P = Paths.get(System.getProperty("user.home"), "Documents", ".Agriculture");
    private static final String HOST = "jdbc:derby:" + Paths.get(System.getProperty("user.home")) + "\\Documents\\.Agriculture\\Map;create=true";

    public void connectToDatabase() {
        try {
            connection = DriverManager.getConnection(HOST, "admins1", "admins1");
        } catch (SQLException ex) {
            Logger.getLogger(JobsDerby.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void createMapsCellsTable() {
        try {
            stmt = connection.createStatement();
            DatabaseMetaData md = connection.getMetaData();
            ResultSet rs = md.getTables(null, null, "MAP", null);
            if (!rs.next()) {
                stmt.executeUpdate("Create table map (id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), x INTEGER, y INTEGER, cellsID INTEGER, cellType varchar(20))");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void createMapsSizeTable() {
        try {
            stmt = connection.createStatement();
            DatabaseMetaData md = connection.getMetaData();
            ResultSet rs = md.getTables(null, null, "SIZE", null);
            if (!rs.next()) {
                stmt.executeUpdate("Create table size  (x INTEGER, y INTEGER)");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void createDirIfNotExist() {
        try {
            if (!P.toFile().exists()) {
                P.toFile().mkdirs();
                Files.setAttribute(P, "dos:hidden", true);
            }
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Statement getStatement() {
        return stmt;
    }

    public Connection getConnection() {
        return connection;
    }

    public void addCell(int i, int j, int cellsID, String cellType) {

        try {
            stmt.executeUpdate("insert into map (x,y,cellsID,cellType) values (" + i + "," + j + "," + cellsID + ", '" + cellType + "')");
        } catch (SQLException ex) {
            Logger.getLogger(MapDerby.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addSize(int i, int j) {

        try {
            stmt.executeUpdate("insert into size (x,y) values (" + i + "," + j + ")");
        } catch (SQLException ex) {
            Logger.getLogger(MapDerby.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ResultSet getMap() throws SQLException {
        return stmt.executeQuery("SELECT * FROM map");
    }

     public ResultSet getSize() throws SQLException {
        return stmt.executeQuery("SELECT * FROM size");
    }
     
    public void deleteMap() {
        try {
            stmt.executeUpdate("DELETE FROM map");

        } catch (SQLException ex) {
            Logger.getLogger(JobsDerby.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteSize() {
        try {
            stmt.executeUpdate("DELETE FROM size");

        } catch (SQLException ex) {
            Logger.getLogger(JobsDerby.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}
