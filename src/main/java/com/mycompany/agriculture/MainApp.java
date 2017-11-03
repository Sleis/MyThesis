package com.mycompany.agriculture;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    static Connection conn;
    static Path p = Paths.get(System.getProperty("user.home"), "Documents", ".Agriculture");

    @Override
    public void start(Stage stage) throws Exception {
        if (!p.toFile().exists()) {
            Path dir = Paths.get(System.getProperty("user.home"), "Documents", ".Agriculture");
            dir.toFile().mkdirs();
            Files.setAttribute(dir, "dos:hidden", true);
        }
        String tmp = System.getProperty("user.home");
        String host = "jdbc:derby:" + tmp + "\\Documents\\.Agriculture\\Jobs;create=true";

        try {
            conn = DriverManager.getConnection(host, "admins", "admins");
            Statement stmt = conn.createStatement();

            DatabaseMetaData md = conn.getMetaData();
            ResultSet rs = md.getTables(null, null, "JOBS", null);

            if (!rs.next()) {
                stmt.executeUpdate("Create table jobs (id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), date DATE  ,job varchar(100) NOT NULL)");
            }

            stmt.executeUpdate("DELETE FROM jobs WHERE date < '2017-11-03'");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Home.fxml"));
        Scene scene = new Scene(root);

        scene.getStylesheets()
                .add("/styles/Styles.css");
        stage.setTitle(
                "JavaFX and Maven");
        stage.setScene(scene);

        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
