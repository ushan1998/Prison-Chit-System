/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crp.chit.system.Dao;

import crp.chit.system.Beans.prisoners;
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
public class prisoner_dao {
    
    //Declare all the neccessary variables/objects for the class.
    private static int i =0;
    private static String sql = null;
    private static PreparedStatement pstmt;
    private static Statement stmt;
    private static Connection con;
    private static ResultSet rs;
    private static Vector prisoners,v1=null;
    
    //Method to be called to insert a new prisoner to the database.
    public static int addPrisoner(prisoners p1){
        try{
            con = DBConnection.getConnection();
            sql = "INSERT INTO prisoners (p_nic,name,cell_no,place,relations_phone_no,relations_email,court_id) VALUES (?,?,?,?,?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, p1.getNic());
            pstmt.setString(2, p1.getName());
            pstmt.setString(3, p1.getCell_no());
            pstmt.setString(4, p1.getPlace());
            pstmt.setInt(5, p1.getR_Phone());
            pstmt.setString(6, p1.getEmail());
            pstmt.setInt(7, p1.getCourt_id());
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
    //Method to be called to delete a prisoner from the database using his/her id.
    public static int deletePrisoner(int id){
        try{
            con = DBConnection.getConnection();
            sql = "DELETE FROM prisoners WHERE prisoner_id = ?";
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
    //Method to be called to update details of a prisoner using his/her id.
    public static int updatePrisoner(prisoners p1 ,int id){
        try{
            con = DBConnection.getConnection();
            sql = "UPDATE prisoners SET p_nic = ? , name =? , cell_no=? , place=? , relations_phone_no=? ,relations_email = ? , court_id=? WHERE prisoner_id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, p1.getNic());
            pstmt.setString(2, p1.getName());
            pstmt.setString(3, p1.getCell_no());
            pstmt.setString(4, p1.getPlace());
            pstmt.setInt(5, p1.getR_Phone());
            pstmt.setString(6, p1.getEmail());
            pstmt.setInt(7, p1.getCourt_id());
            pstmt.setInt(8, id);
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
    //Method to be called to serach for a specific prisoner from the database using his/her id.
    public static Vector serchPrisoner(int id){
        try{
            con = DBConnection.getConnection();
            sql = "SELECT * FROM prisoners WHERE prisoner_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            prisoners = new Vector();
            if(rs.next()){
                prisoners.addElement(rs.getInt("prisoner_id"));
                prisoners.addElement(rs.getString("p_nic"));
                prisoners.addElement(rs.getString("name"));
                prisoners.addElement(rs.getString("cell_no"));
                prisoners.addElement(rs.getString("place"));
                prisoners.addElement(rs.getInt("relations_phone_no"));
                prisoners.addElement(rs.getString("relations_email"));
                prisoners.addElement(rs.getInt("court_id"));
                return prisoners;
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
    public static Vector getPrisoners(){
        try{
            con = DBConnection.getConnection();
            String sql = "SELECT * FROM prisoners";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            prisoners = new Vector();
            while(rs.next()){
                
                v1 = new Vector();
                v1.addElement(rs.getInt("prisoner_id"));
                v1.addElement(rs.getString("p_nic"));
                v1.addElement(rs.getString("name"));
                v1.addElement(rs.getString("cell_no"));
                v1.addElement(rs.getString("place"));
                v1.addElement(rs.getInt("relations_phone_no"));
                v1.addElement(rs.getString("relations_email"));
                v1.addElement(rs.getInt("court_id"));
                prisoners.add(v1);
       
            }
            return prisoners;
            
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