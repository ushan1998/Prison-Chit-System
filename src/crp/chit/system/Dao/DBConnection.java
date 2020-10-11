/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crp.chit.system.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Osura
 */
public class DBConnection {
    private static String server,userName,password;
            public static Connection getConnection(){
                try {
                    //Getting the database connection by passing the url,username,password.
                    Class.forName("com.mysql.jdbc.Driver");
                    server="jdbc:mysql://localhost:3306/prison";
                    userName="root";
                    password="";
                    return DriverManager.getConnection(server,userName,password);
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                }
                return null;
            }
}
