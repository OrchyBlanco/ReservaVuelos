/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.reservasvuelo.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 *
 * @author 2dawb
 */
public class MySqlDaoFactory {

    private static MySqlDaoFactory myInstance;
    private DataBaseConfig dbC;
    private String query = "SELECT * FROM hotel";

    private MySqlDaoFactory() {

        ResourceBundle rb = ResourceBundle.getBundle("sakila");
        dbC = new DataBaseConfig();
        dbC.setDriverClassName(rb.getString("database.driver"));
        dbC.setDatabaseUrl(rb.getString("database.url"));
        dbC.setDatabaseUser(rb.getString("database.user"));
        dbC.setDatabasePassword(rb.getString("database.password"));
        dbC.setDatabasePageSize(20);
        try {
            Class.forName(dbC.getDriverClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySqlDaoFactory.class.getName());
        }

    }

    public static synchronized MySqlDaoFactory getInstance() {

        if (myInstance == null) {
            myInstance = new MySqlDaoFactory();
        }
        return myInstance;
    }

    public Connection getConnection() throws SQLException {
        try (Connection conn = DriverManager.getConnection(dbC.getDatabaseUrl(), dbC.getDatabaseUser(), dbC.getDatabasePassword());) {
            dbC.getDatabaseUrl();
            dbC.getDatabaseUser();
            dbC.getDatabasePassword();
            return conn;
        }
    }
    
    public void closeConnection(Connection conn) throws SQLException{
        conn.close();
    }
    
    public VueloDao getVuelo() throws SQLException{
        try (Connection conn = DriverManager.getConnection(dbC.getDatabaseUrl(), dbC.getDatabaseUser(), dbC.getDatabasePassword());
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            Vuelo vuelo = (Vuelo) myInstance.getVuelo();
            return (VueloDao) vuelo;
        }       

    }
    
}