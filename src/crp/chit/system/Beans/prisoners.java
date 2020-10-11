/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crp.chit.system.Beans;
/**
 *
 * @author Osura
 */
public class prisoners {
    private String nic;
    private String name;
    private String cell_no;
    private String place;
    private int relations_phone_no;
    private String email;
    private int court_id;
    
    public void setNic(String nic){
        this.nic=nic;
    }
    public String getNic(){
        return this.nic;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void setCell_no(String no){
        this.cell_no=no;
    }
    public String getCell_no(){
        return this.cell_no;
    }
    public void setPlace(String status){
        this.place=status;
    }
    public String getPlace(){
        return this.place;
    }
    public void setR_Phone(int phone){
        this.relations_phone_no = phone;
    }
    public int getR_Phone(){
        return this.relations_phone_no;
    }
    public void setCourt_id(int id){
        this.court_id=id;
    }
    public int getCourt_id(){
        return this.court_id;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
}
