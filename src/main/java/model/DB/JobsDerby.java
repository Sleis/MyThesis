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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivany
 */
public class JobsDerby {

    private static Connection connection;
    private static Statement stmt;
    private static final Path P = Paths.get(System.getProperty("user.home"), "Documents", ".Agriculture");
    private static final String HOST = "jdbc:derby:" + Paths.get(System.getProperty("user.home")) + "\\Documents\\.Agriculture\\Jobs;create=true";

    public void connectToDatabase() {
        try {
            connection = DriverManager.getConnection(HOST, "admins", "admins");
        } catch (SQLException ex) {
            Logger.getLogger(JobsDerby.class.getName()).log(Level.SEVERE, null, ex);
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

    public void deleteOldJobs(Statement stmt) {
        try {
            stmt.executeUpdate("DELETE FROM jobs WHERE date < '2017-11-03'");
        } catch (SQLException ex) {
            Logger.getLogger(JobsDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addNewJob(String job, LocalDate date) {
        try {
            stmt.executeUpdate("insert into jobs (date,job) values ('" + date + "','" + job + "')");
        } catch (SQLException ex) {
            Logger.getLogger(JobsDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<String> getJobs(LocalDate date) {
        ArrayList<String> ar = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM jobs where date = '" + date + "'");
            while (rs.next()) {
                ar.add(rs.getString("job"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JobsDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ar;
    }

    public void deleteJobs(LocalDate date) {
        try {
            stmt.executeUpdate("DELETE FROM jobs WHERE date = '" + date + "'");
        } catch (SQLException ex) {
            Logger.getLogger(JobsDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
