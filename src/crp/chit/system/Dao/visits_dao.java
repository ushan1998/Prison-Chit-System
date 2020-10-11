/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crp.chit.system.Dao;

import crp.chit.system.Beans.visits;
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
public class visits_dao {
    
    //Declare all the neccessary variables/objects for the class.
    private static int i =0;
    private static String sql = null;
    private static Statement stmt = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;
    private static Connection con = null;
    private static Vector visits,v1,p_display,v_display=null;
    
    //Method to be called to add a new visit to the database.
    public static int addVisit(visits v1){
        try{
            con = DBConnection.getConnection();
            sql ="INSERT INTO visits(time,date,place,relation_to_prisoner,v_id,prisoner_id) VALUES(?,?,?,?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setTime(1, v1.getTime());
            pstmt.setDate(2, v1.getDate());
            pstmt.setString(3, v1.getPlace());
            pstmt.setString(4, v1.getRelation());
            pstmt.setInt(5, v1.getV_Id());
            pstmt.setInt(6, v1.getPrisoner_id());
            i = pstmt.executeUpdate();
            return i;
        } catch (SQLException ex) {
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
    //Method to be called to delete a visit from the database.
    public static int deleteVisit(int id){
        try{
            con = DBConnection.getConnection();
            sql = "DELETE FROM visits WHERE visit_id = ?";
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
    //Method to be called to search for a specific visit.
    public static Vector searchVisit(int id){
        try{
            con = DBConnection.getConnection();
            sql = "SELECT * FROM visits WHERE visit_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                visits = new Vector();
                visits.addElement(rs.getInt("visit_id"));
                visits.addElement(rs.getTime("time"));
                visits.addElement(rs.getDate("date"));
                visits.addElement(rs.getString("place"));
                visits.addElement(rs.getString("status"));
                visits.addElement(rs.getString("relation_to_prisoner"));
                visits.addElement(rs.getInt("admin_id"));
                visits.addElement(rs.getInt("v_nic"));
                visits.addElement(rs.getInt("prisoner_id"));
                return visits;
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
    //Method for getting all the visits from the database.
    public static Vector getVisits(){
        try{
            con = DBConnection.getConnection();
            sql = "SELECT * FROM visits WHERE status = 'Approved'";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            visits = new Vector();
            while(rs.next()){
                v1 = new Vector();
                v1.addElement(rs.getInt("visit_id"));
                v1.addElement(rs.getTime("time"));
                v1.addElement(rs.getDate("date"));
                v1.addElement(rs.getString("place"));
                v1.addElement(rs.getString("status"));
                v1.addElement(rs.getString("relation_to_prisoner"));
                v1.addElement(rs.getInt("admin_id"));
                v1.addElement(rs.getInt("v_id"));
                v1.addElement(rs.getInt("prisoner_id"));
                visits.add(v1);
            }
            if(visits.isEmpty()){
                return null;
            }else{
                return visits;
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
    
    //Method for displaying the approved chits on the prison display
    public static Vector display(){
        try{
            con = DBConnection.getConnection();
            sql = "SELECT * FROM visits WHERE status = 'Approved' AND hour(now() )= hour(visits.time)";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            p_display = new Vector();
            while(rs.next()){
                v1 = new Vector();
                v1.addElement(rs.getString("place"));
                v1.addElement(rs.getString("relation_to_prisoner"));
                v1.addElement(rs.getInt("prisoner_id"));
                p_display.add(v1);
            }
            if(p_display.isEmpty()){
                return null;
            }else{
                return p_display;
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
    //Method for getting all the visits that are approved by a specific admin.
    public static Vector getVisitsByAdmin(int id){
        try{
            con = DBConnection.getConnection();
            sql = "SELECT * FROM visits WHERE status = 'Approved' AND admin_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            visits = new Vector();
            while(rs.next()){
                v1 = new Vector();
                v1.addElement(rs.getInt("visit_id"));
                v1.addElement(rs.getTime("time"));
                v1.addElement(rs.getDate("date"));
                v1.addElement(rs.getString("place"));
                v1.addElement(rs.getString("status"));
                v1.addElement(rs.getString("relation_to_prisoner"));
                v1.addElement(rs.getInt("admin_id"));
                v1.addElement(rs.getInt("v_id"));
                v1.addElement(rs.getInt("prisoner_id"));
                visits.add(v1);
            }
            if(visits.isEmpty()){
                return null;
            }else{
                return visits;
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
    //Method for getting all the visits that are about specific visitor.
    public static Vector getVisitsByVisitor(int id){
        try{
            con = DBConnection.getConnection();
            sql = "SELECT * FROM visits WHERE status = 'Approved' AND v_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            visits = new Vector();
            while(rs.next()){
                v1 = new Vector();
                v1.addElement(rs.getInt("visit_id"));
                v1.addElement(rs.getTime("time"));
                v1.addElement(rs.getDate("date"));
                v1.addElement(rs.getString("place"));
                v1.addElement(rs.getString("status"));
                v1.addElement(rs.getString("relation_to_prisoner"));
                v1.addElement(rs.getInt("admin_id"));
                v1.addElement(rs.getInt("v_id"));
                v1.addElement(rs.getInt("prisoner_id"));
                visits.add(v1);
            }
            if(visits.isEmpty()){
                return null;
            }else{
                return visits;
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
    //Method for getting all the visits that are about specific prisoner.
    public static Vector getVisitsByPrisoner(int id){
        try{
            con = DBConnection.getConnection();
            sql = "SELECT * FROM visits WHERE status = 'Approved' AND prisoner_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            visits = new Vector();
            while(rs.next()){
                v1 = new Vector();
                v1.addElement(rs.getInt("visit_id"));
                v1.addElement(rs.getTime("time"));
                v1.addElement(rs.getDate("date"));
                v1.addElement(rs.getString("place"));
                v1.addElement(rs.getString("status"));
                v1.addElement(rs.getString("relation_to_prisoner"));
                v1.addElement(rs.getInt("admin_id"));
                v1.addElement(rs.getInt("v_id"));
                v1.addElement(rs.getInt("prisoner_id"));
                visits.add(v1);
            }
            if(visits.isEmpty()){
                return null;
            }else{
                return visits;
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
}
