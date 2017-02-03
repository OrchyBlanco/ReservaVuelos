/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.reservasvuelo.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author 2dawb
 */
public class DaoFactory implements ConnectionProvider {

    private static DaoFactory myInstance;
    public final static Logger LOGGER = LoggerFactory.getLogger(DaoFactory.class);
    private final DataBaseConfig DATACONFIG = new DataBaseConfig();

    private DaoFactory() {
        LOGGER.debug("Generando ResourceBundle de la base de datos...");
        ResourceBundle rb = ResourceBundle.getBundle("dataBase");
        DATACONFIG.setDriverClassName(rb.getString("database.driver"));
        DATACONFIG.setDataBaseUrl(rb.getString("database.url"));
        DATACONFIG.setDataBaseUser(rb.getString("database.user"));
        DATACONFIG.setDataBasePassword(rb.getString("database.password"));
        LOGGER.debug("Pidiendo datasource a jdbc/ReservaVuelos ... ");
        try{
            String driverClassName = rb.getString("database.driver");
            Class.forName(driverClassName);
        } catch (ClassNotFoundException ex) {
            LOGGER.error("", ex);
        }

        
    }

    public static synchronized DaoFactory getInstance() {
        if (myInstance == null) {
            myInstance = new DaoFactory();
        }
        return myInstance;
    }

    @Override
    public Connection getConnection() {
        Connection conn = null;
        LOGGER.debug("Creando conexión con la base de datos...");
        try {
            conn = DriverManager.getConnection(DATACONFIG.getDatabaseUrl(), DATACONFIG.getDatabaseUser(), DATACONFIG.getDatabasePassword());
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DaoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        LOGGER.debug("conexión: ", conn);
        return conn;
    }

    @Override
    public void closeConnection(Connection conn) {
        try {
            LOGGER.debug("Cerrando conexión...");
            conn.close();
        } catch (SQLException ex) {
            LOGGER.error("Ha ocurrido un error al cerrar la conexión a la base de datos", ex);
        }
    }
    
}