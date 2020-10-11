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
public class visitors {
   
    private String nic;
    private String name;
    private String address;
    private int contact_no;
    
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
    public void setAddress(String address){
        this.address=address;
    }
    public String getAddress(){
        return this.address;
    }
    public void setContact(int contact){
        this.contact_no=contact;
    }
    public int getContact(){
        return this.contact_no;
    }
    
}
