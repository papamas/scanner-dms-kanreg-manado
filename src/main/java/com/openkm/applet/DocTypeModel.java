/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openkm.applet;

/**
 *
 * @author PAKIVP
 */
public class DocTypeModel {
    
    private String id;
    private String name;
    
    
    
    public DocTypeModel(String id,String name){
        this.id=id;
        this.name=name;
    }
    
    public String getId(){
        return this.id;
    }
    
    public void SetId(String id){
        this.id = id;
    }
    
    public void SetName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
    
}
