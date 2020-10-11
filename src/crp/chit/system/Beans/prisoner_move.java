/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crp.chit.system.Beans;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Osura
 */
public class prisoner_move {
    private String m_from;
    private String m_to;
    private Time time;
    private Date date;
    private int prisoner_id;
    
    public void setM_from(String move){
        this.m_from=move;
    }
    public String getM_from(){
        return this.m_from;
    }
    public void setM_to(String to){
        this.m_to=to;
    }
    public String getM_to(){
        return this.m_to;
    }
    public void setTime(Time t){
        this.time=t;
    }
    public Time getTime(){
        return this.time;
    }
    public void setDate(Date d){
        this.date=d;
    }
    public Date getDate(){
        return this.date;
    }
    public void setPrisoner_id(int id){
        this.prisoner_id=id;
    }
    public int getPrisoner_id(){
        return this.prisoner_id;
    }
}
