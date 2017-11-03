/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;

/**
 *
 * @author ivany
 */
public class Derby {

    private static Connection connection;
    private static Path p = Paths.get(System.getProperty("user.home"), "Documents", ".Agriculture");

    public void addNewJob(String job) {
        
        
    }
}
