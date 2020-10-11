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
public class visits {
  
    private Time time;
    private Date date;
    private String relation_to_prisoner;
    private String place;
    private int v_id;
    private int prisoner_id;
    
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
    public void setRelation(String relation){
        this.relation_to_prisoner=relation;
    }
    public String getRelation(){
        return this.relation_to_prisoner;
    }
    public void setPlace(String place){
        this.place=place;
    }
    public String getPlace(){
        return this.place;
    }
    public void setV_Id(int v_id){
        this.v_id=v_id;
    }
    public int getV_Id(){
        return this.v_id;
    }
    public void setPrisoner_id(int id){
        this.prisoner_id=id;
    }
    public int getPrisoner_id(){
        return this.prisoner_id;
    }
}
