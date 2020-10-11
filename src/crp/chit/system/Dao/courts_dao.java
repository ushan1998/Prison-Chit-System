/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crp.chit.system.Dao;

import crp.chit.system.Beans.courts;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Osura
 */
public class courts_dao {
    
    //Declare the neccessary variables/objects for the class.
    private static int i = 0;
    private static String sql = null;
    private static PreparedStatement pstmt = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;
    private static Connection con = null;
    private static Vector courts,v1 = null;
    
    //Method to be called to add details about a new court to the database.
    public static int addCourt(courts c1){
        
        try{
            con = DBConnection.getConnection();
            sql = "INSERT INTO courts (name,address) VALUES (?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, c1.getName());
            pstmt.setString(2, c1.getAddress());
            i = pstmt.executeUpdate();
            return i;
        
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        //Closing the resultset,preparedstatement and the connection to save memmory.
        finally {
            try { if (rs == null) rs.close(); } catch (Exception e) {e.printStackTrace();};
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {e.printStackTrace();};
            try { if (con != null) con.close(); } catch (Exception e) {e.printStackTrace();};
        }
        return 0;
    }
    //Method to be called to delete a court from the database using its id.
    public static int deleteCourt(int id){
        try{
            con = DBConnection.getConnection();
            sql = "DELETE FROM courts WHERE court_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            i = pstmt.executeUpdate();
            return i;
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        //Closing the resultset,preparedstatement and the connection to save memmory.
        finally {
            try { if (rs == null) rs.close(); } catch (Exception e) {e.printStackTrace();};
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {e.printStackTrace();};
            try { if (con != null) con.close(); } catch (Exception e) {e.printStackTrace();};
        }
        return 0;
    }
    //Method to be called to update a court from the database using its id.
    public static int updateCourt(courts c1 ,int id){
        try{
            con = DBConnection.getConnection();
            sql = "UPDATE courts SET name =? , address = ? WHERE court_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, c1.getName());
            pstmt.setString(2, c1.getAddress());
            pstmt.setInt(3, id);
            i = pstmt.executeUpdate();
            return i;
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        //Closing the resultset,preparedstatement and the connection to save memmory.
        finally {
            try { if (rs == null) rs.close(); } catch (Exception e) {e.printStackTrace();};
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {e.printStackTrace();};
            try { if (con != null) con.close(); } catch (Exception e) {e.printStackTrace();};
        }
        return 0;
    }
    //Method for getting all the courts that exist in the database.
    public static Vector getCourts(){
        try{
            con = DBConnection.getConnection();
            sql = "SELECT * FROM courts";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            courts = new Vector();
            while(rs.next()){
                v1 = new Vector();
                v1.addElement(rs.getInt("court_id"));
                v1.addElement(rs.getString("name"));
                v1.addElement(rs.getString("address"));
                courts.addElement(v1);
            }
            if(courts.isEmpty()){
                return null;
            }else{
                return courts;
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        //Closing the resultset,preparedstatement and the connection to save memmory.
        finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {e.printStackTrace();};
            try { if (stmt != null) stmt.close(); } catch (Exception e) {e.printStackTrace();};
            try { if (con != null) con.close(); } catch (Exception e) {e.printStackTrace();};
        }
        return null;
    }
    //Method to be called to get information about a court.
    public static Vector searchCourt(int id){
        try{
            con = DBConnection.getConnection();
            sql = "SELECT * FROM courts WHERE court_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            courts = new Vector();
            if(rs.next()){
                courts.addElement(rs.getInt("court_id"));
                courts.addElement(rs.getString("name"));
                courts.addElement(rs.getString("address"));
                return courts;
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        //Closing the resultset,preparedstatement and the connection.
        finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {e.printStackTrace();};      
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {e.printStackTrace();};   
            try { if (con != null) con.close(); } catch (Exception e) {e.printStackTrace();};       
        }
        return null;
    }
    //Method to be called to get all the court ids.
    public static Vector getCourtIds(){
        try{
            con = DBConnection.getConnection();
            sql = "SELECT court_id FROM courts";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            courts = new Vector();
            while(rs.next()){
                courts.addElement(rs.getInt("court_id"));
            }
            if(courts.isEmpty()){
                return null;
            }else{
                return courts;
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        //Closing the resultset,preparedstatement and the connection to save memmory.
        finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {e.printStackTrace();};
            try { if (stmt != null) stmt.close(); } catch (Exception e) {e.printStackTrace();};
            try { if (con != null) con.close(); } catch (Exception e) {e.printStackTrace();};
        }
        return null;
    }
}
