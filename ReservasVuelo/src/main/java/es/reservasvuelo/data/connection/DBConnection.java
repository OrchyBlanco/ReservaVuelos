/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.reservasvuelo.data.connection;

import com.mysql.jdbc.Driver;
import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC-Jesus
 */
public class DBConnection {
       private String url="jdbc:mysql://localhost:3306/ReservaVuelos?zeroDateTimeBehavior=convertToNull";
       private String username="2dawa";
       private String password="2dawA2!06";
       
       Connection conn =null;
       
       public void connect(){
           try {
               DriverManager.registerDriver(new Driver());
               conn=DriverManager.getConnection(url, username, password);
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
       public void close(){
           try {
               conn.close();
           } catch (Exception e) {
               e.printStackTrace();
           }
       }        
}
