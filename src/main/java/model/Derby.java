/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mycompany.agriculture.HomeController;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivany
 */
public class Derby {

    private static Connection connection;
    private static Statement stmt;
    private static final String host = "jdbc:derby:" + Paths.get(System.getProperty("user.home")) + "\\Documents\\.Agriculture\\Jobs;create=true";

    public void connectToDatabase() {
        try {
            connection = DriverManager.getConnection(host, "admins", "admins");
        } catch (SQLException ex) {
            Logger.getLogger(Derby.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void createTable() {
        try {
            stmt = connection.createStatement();
            DatabaseMetaData md = connection.getMetaData();
            ResultSet rs = md.getTables(null, null, "JOBS", null);
            if (!rs.next()) {
                stmt.executeUpdate("Create table jobs (id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), date DATE  ,job varchar(100) NOT NULL)");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Statement getStatement() {
        return stmt;
    }

    public void deleteOldJobs(Statement stmt) {
        try {
            stmt.executeUpdate("DELETE FROM jobs WHERE date < '2017-11-03'");
        } catch (SQLException ex) {
            Logger.getLogger(Derby.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addNewJob(String job, LocalDate date) {
        try {
            String ins = "insert into jobs (date,job) values ('" + date + "','" + job + "')";
            stmt.executeUpdate(ins);
        } catch (SQLException ex) {
            Logger.getLogger(Derby.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<String> getJob(LocalDate date) {
        ArrayList<String> ar = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM jobs");
            while (rs.next()) {
                if (rs.getString("date").equals(HomeController.getDates().toString())) {
                    ar.add(rs.getString("job"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Derby.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ar;
    }
}
