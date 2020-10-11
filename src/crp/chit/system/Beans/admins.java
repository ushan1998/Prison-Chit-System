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
public class admins {
    private String nic;
    private String name;
    private String designation;
    private String password;
    
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
    public void setDesignation(String designation){
        this.designation=designation;
    }
    public String getDesignation(){
        return this.designation;
    }
    public void setPassword(String pass){
        this.password=pass;
    }
    public String getPassword(){
        return this.password;
    }
}
