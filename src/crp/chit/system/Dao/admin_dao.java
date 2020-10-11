/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crp.chit.system.Dao;

import crp.chit.system.Beans.admins;
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

public class admin_dao {
    
    //Declare the neccessary variable/objects for the class.
    private static int i = 0;
    private static String sql = null;
    private static PreparedStatement pstmt = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;
    private static Connection con = null;
    private static Vector admin,v1,chits=null;
    
    //Method to be called to verify admin login.
    public static Vector adminLogin(String UName){
        try{
        con = DBConnection.getConnection();
        sql = "SELECT * FROM admin WHERE nic = ?";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, UName);
        rs = pstmt.executeQuery();
        admin = new Vector();
        if(rs.next()){
            admin.addElement(rs.getInt("admin_id"));
            admin.addElement(rs.getString("nic"));
            admin.addElement(rs.getString("password"));
            return admin;
        }else{
            return null;
        }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        //Closing the resultset,preparedstatement and the connection.
        finally {
            try { if (rs == null) rs.close(); } catch (Exception e) {e.printStackTrace();};         
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {e.printStackTrace();};   
            try { if (con != null) con.close(); } catch (Exception e) {e.printStackTrace();};       
        }
        return null;
    }
    //Method for inserting a new admin to the database.
    public static int addAdmin(admins a1){
        try{
            con = DBConnection.getConnection();                                             
            sql = "INSERT INTO admin(name,nic,designation,password) VALUES (?,?,?,?)";    
            pstmt = con.prepareStatement(sql);                                              
            pstmt.setString(1, a1.getName());                                               
            pstmt.setString(2, a1.getNic());
            pstmt.setString(3, a1.getDesignation());
            pstmt.setString(4, a1.getPassword());
            i = pstmt.executeUpdate();                                                      
            return i;                                                                       

            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        //Closing the resultset,preparedstatement and the connection.
        finally {
            try { if (rs == null) rs.close(); } catch (Exception e) {e.printStackTrace();};         
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {e.printStackTrace();};   
            try { if (con != null) con.close(); } catch (Exception e) {e.printStackTrace();};       
        }
        return 0;
    }
    //Method for deleting an admin from the database using his id.
    public static int deleteAdmin(int id){
        try{
            con = DBConnection.getConnection();
            sql = "DELETE FROM admin WHERE admin_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            i = pstmt.executeUpdate();
            return i;
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        //Closing the resultset,preparedstatement and the connection.
        finally {
            try { if (rs == null) rs.close(); } catch (Exception e) {e.printStackTrace();};       
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {e.printStackTrace();};   
            try { if (con != null) con.close(); } catch (Exception e) {e.printStackTrace();};       
        }
        return 0;
    }
    //Method for updating details of an admin that's already in the database using his id.
    public static int updateAdmin(admins a1,int id){
        try{
            con = DBConnection.getConnection();
            sql = "UPDATE admin SET name = ? , nic = ? , designation = ? , password = ? WHERE admin_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, a1.getName());
            pstmt.setString(2, a1.getNic());
            pstmt.setString(3, a1.getDesignation());
            pstmt.setString(4, a1.getPassword());
            pstmt.setInt(5, id);
            i = pstmt.executeUpdate();
            return i;
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        //Closing the resultset,preparedstatement and the connection.
        finally {
            try { if (rs == null) rs.close(); } catch (Exception e) {e.printStackTrace();};       
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {e.printStackTrace();};   
            try { if (con != null) con.close(); } catch (Exception e) {e.printStackTrace();};       
        }
        return 0;
    }
    //Method for updating details of an admin that's already in the database using his id.
    public static int updateAdminWithoutPass(admins a1,int id){
        try{
            con = DBConnection.getConnection();
            sql = "UPDATE admin SET name = ? , nic = ? , designation = ? WHERE admin_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, a1.getName());
            pstmt.setString(2, a1.getNic());
            pstmt.setString(3, a1.getDesignation());
            pstmt.setInt(4, id);
            i = pstmt.executeUpdate();
            return i;
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        //Closing the resultset,preparedstatement and the connection.
        finally {
            try { if (rs == null) rs.close(); } catch (Exception e) {e.printStackTrace();};       
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {e.printStackTrace();};   
            try { if (con != null) con.close(); } catch (Exception e) {e.printStackTrace();};       
        }
        return 0;
    }
    //Method for searching for a specific admin by using his id.
    public static Vector searchAdmin(int id){
        try{
            con = DBConnection.getConnection();
            sql = "SELECT * FROM admin WHERE admin_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            admin = new Vector();
            if(rs.next()){
                admin.addElement(rs.getInt("admin_id"));
                admin.addElement(rs.getString("nic"));
                admin.addElement(rs.getString("name"));
                admin.addElement(rs.getString("designation"));
                admin.addElement(rs.getString("password"));
                return admin;
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
    //Method for getting all the admins from the database.
    public static Vector getAdmins(){
        try{
            con = DBConnection.getConnection();
            sql = "SELECT * FROM admin";        
            stmt = con.createStatement();       
            rs = stmt.executeQuery(sql);          
            admin = new Vector();          
            while(rs.next()){                       
                v1 = new Vector();
                v1.addElement(rs.getInt("admin_id"));
                v1.addElement(rs.getString("nic"));
                v1.addElement(rs.getString("name"));
                v1.addElement(rs.getString("designation"));
                v1.addElement(rs.getString("password"));
                admin.add(v1);              
            }
            if(admin.isEmpty()){
                return null;
            }else{
                return admin;
            }                       
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        //Closing the resultset,preparedstatement and the connection.
        finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {e.printStackTrace();};      
            try { if (stmt != null) stmt.close(); } catch (Exception e) {e.printStackTrace();};   
            try { if (con != null) con.close(); } catch (Exception e) {e.printStackTrace();};   
        }
        return null;
    }
    //Method to be called to get all the not approved chits from the database.
    public static Vector getChits(){
    
        try{
            con = DBConnection.getConnection();
            sql = "SELECT * FROM visits WHERE status = 'Not Approved'";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            chits = new Vector();
            while(rs.next()){
                v1 = new Vector();
                v1.addElement(rs.getInt("visit_id"));
                v1.addElement(rs.getTime("time"));
                v1.addElement(rs.getDate("date"));
                v1.addElement(rs.getString("place"));
                v1.addElement(rs.getString("status"));
                v1.addElement(rs.getString("relation_to_prisoner"));
                v1.addElement(rs.getInt("v_id"));
                v1.addElement(rs.getInt("prisoner_id"));
                chits.add(v1);
            }
            if(chits==null){
                return null;
            }else{
                return chits;   
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        //Closing the resultset,preparedstatement and the connection.
        finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {e.printStackTrace();};      
            try { if (stmt != null) stmt.close(); } catch (Exception e) {e.printStackTrace();};   
            try { if (con != null) con.close(); } catch (Exception e) {e.printStackTrace();};   
        }
        
        return null;
    }
    public static int chitApprove(int v_id, int adminId){
        try{
            con = DBConnection.getConnection();
            sql = "UPDATE visits SET status = 'Approved', admin_id = ? WHERE visit_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, adminId);
            pstmt.setInt(2, v_id);
            i = pstmt.executeUpdate();
            return i;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        //Closing the resultset,preparedstatement and the connection.
        finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {e.printStackTrace();};      
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {e.printStackTrace();};   
            try { if (con != null) con.close(); } catch (Exception e) {e.printStackTrace();};   
        }
        
        return 0;
    }
}
