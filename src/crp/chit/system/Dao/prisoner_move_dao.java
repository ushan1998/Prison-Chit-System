/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crp.chit.system.Dao;

import crp.chit.system.Beans.prisoner_move;
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
public class prisoner_move_dao {
    
    private static int i = 0;
    private static String sql = null;
    private static ResultSet rs = null;
    private static Connection con = null;
    private static PreparedStatement pstmt = null;
    private static Statement stmt = null;
    private static Vector move,v1 = null;
    
    public static int addPrisonerMove(prisoner_move p1){
        
        try {
                con = DBConnection.getConnection();
                sql = "INSERT INTO prisoner_moved(move_from,move_to,time,date,prisoner_id) VALUES (?,?,?,?,?)";
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, p1.getM_from());
                pstmt.setString(2, p1.getM_to());
                pstmt.setTime(3, p1.getTime());
                pstmt.setDate(4, p1.getDate());
                pstmt.setInt(5, p1.getPrisoner_id());
                i = pstmt.executeUpdate();
                return i;
                
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        //Closing the resultset,preparedstatement and the connection to save memmory.
        finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {e.printStackTrace();};
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {e.printStackTrace();};
            try { if (con != null) con.close(); } catch (Exception e) {e.printStackTrace();};
        }
        return 0;
    }
    //Method to be called to delete information about prisoner movement using its id.
    public static int deletePrisonerMove(int id){
        try{
            con = DBConnection.getConnection();
            sql = "DELETE FROM prisoner_moved WHERE move_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            i = pstmt.executeUpdate();
            return i;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        //Closing the resultset,preparedstatement and the connection to save memmory.
        finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {e.printStackTrace();};
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {e.printStackTrace();};
            try { if (con != null) con.close(); } catch (Exception e) {e.printStackTrace();};
        }
        return 0;
    }
    //Method to be called to update prisoner move information.
    public static int updatePrisonerMove(prisoner_move p1, int id){      
        try{
            con = DBConnection.getConnection();
            sql = "UPDATE prisoner_moved SET move_from = ?, move_to = ? WHERE move_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, p1.getM_from());
            pstmt.setString(2, p1.getM_to());
            pstmt.setInt(3, id);
            i = pstmt.executeUpdate();
            return i;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        //Closing the resultset,preparedstatement and the connection to save memmory.
        finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {e.printStackTrace();};
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {e.printStackTrace();};
            try { if (con != null) con.close(); } catch (Exception e) {e.printStackTrace();};
        }
        return 0;
    }
    //Method to be called to get all the prisoner moving information from the table.
    public static Vector getPrisonerMove(){
        try{
            con = DBConnection.getConnection();
            sql = "SELECT * FROM prisoner_moved";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            move = new Vector();
            while(rs.next()){
                v1 = new Vector();
                v1.addElement(rs.getInt("move_id"));
                v1.addElement(rs.getString("move_from"));
                v1.addElement(rs.getString("move_to"));
                v1.addElement(rs.getTime("time"));
                v1.addElement(rs.getDate("date"));
                v1.addElement(rs.getInt("prisoner_id"));
                move.add(v1);
            }
            if(move.isEmpty()){
                return null;
            }else{
                return move;
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
     //Method to be called to get all the moving records of a specific prisoner.
    public static Vector getPrisonerMoveInfo(int id){
        try{
            con = DBConnection.getConnection();
            sql = "SELECT * FROM prisoner_moved WHERE prisoner_id = ?";
            pstmt = con.prepareCall(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            move = new Vector();
            while(rs.next()){
                v1 = new Vector();
                v1.addElement(rs.getInt("move_id"));
                v1.addElement(rs.getString("move_from"));
                v1.addElement(rs.getString("move_to"));
                v1.addElement(rs.getTime("time"));
                v1.addElement(rs.getDate("date"));
                v1.addElement(rs.getInt("prisoner_id"));
                System.out.println("came here1");
                move.add(v1);
                System.out.println("came here 2");
            }
            if(move.isEmpty()){
                return null;
            }else{
                return move;
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
