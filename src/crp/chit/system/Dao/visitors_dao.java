/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crp.chit.system.Dao;

import crp.chit.system.Beans.visitors;
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
public class visitors_dao {
    
    //Declare all the neccessary variables/objects for the class.
    private static int i =0;
    private static String sql = null;
    private static PreparedStatement pstmt = null;
    private static Statement stmt = null;
    private static Connection con = null;
    private static ResultSet rs = null;
    private static Vector visitors,v1=null;
    
    //Method to be called to add a new visitor to the database.
    public static int addVisitor(visitors v1){
        try{
            con = DBConnection.getConnection();
            sql = "INSERT INTO visitor (v_nic,name,address,contact_no) VALUES (?,?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, v1.getNic());
            pstmt.setString(2, v1.getName());
            pstmt.setString(3, v1.getAddress());
            pstmt.setInt(4, v1.getContact());
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
    //Method to be called to delete a visitor from the database using his/her id.
    public static int deleteVisitor(int id){
        try{
            con = DBConnection.getConnection();
            sql = "DELETE FROM visitor WHERE visitor_id = ?";
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
    //Methof to be called to update a visitor using his/her id.
    public static int updateVisitor(visitors v1 ,int id){
        try{
            con = DBConnection.getConnection();
            sql = "UPDATE visitor SET name = ? , address = ? , contact_no = ? , v_nic =? WHERE visitor_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, v1.getName());
            pstmt.setString(2, v1.getAddress());
            pstmt.setInt(3, v1.getContact());
            pstmt.setString(4, v1.getNic());
            pstmt.setInt(5, id);
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
    //Method to be called to serach for a specific user from the database using his/her Nic.
    public static Vector serchVisitorByNic(String nic){
        try{
            con = DBConnection.getConnection();
            sql = "SELECT * FROM visitor WHERE v_nic = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, nic);
            rs = pstmt.executeQuery();
            if(rs.next()){
                visitors = new Vector();
                visitors.addElement(rs.getInt("visitor_id"));
                visitors.addElement(rs.getString("v_nic"));
                visitors.addElement(rs.getString("name"));
                visitors.addElement(rs.getString("address"));
                visitors.addElement(rs.getInt("contact_no"));
                return visitors;
            }
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        //Closing the resultset,preparedstatement and the connection to save memmory.
        finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {e.printStackTrace();};
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {e.printStackTrace();};
            try { if (con != null) con.close(); } catch (Exception e) {e.printStackTrace();};
        }
        return null;
    }
    //Method to be called to get all the prisoners from the database.
    public static Vector getVisitors(){
        try{
            con = DBConnection.getConnection();
            sql = "SELECT * FROM visitor";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            visitors = new Vector();
            while(rs.next()){
                v1 = new Vector();
                v1.addElement(rs.getInt("visitor_id"));
                v1.addElement(rs.getString("v_nic"));
                v1.addElement(rs.getString("name"));
                v1.addElement(rs.getString("address"));
                v1.addElement(rs.getInt("contact_no"));
                visitors.add(v1);
            }
            return visitors;
            
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
