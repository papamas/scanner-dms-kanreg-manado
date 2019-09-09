/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openkm.applet;

/**
 *
 * @author papamas
 */
public class Item
{
    private int id;
    private String description;
    private String path;
    private String fname;

    
    public Item(int id, String description, String path, String fname)
    {
        this.id = id;
        this.description = description;
        this.path = path;
        this.fname = fname;
    }
    
   
    public int getId()
    {
        return id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public String getPath()
    {
        return path;
    }
    
    public void setPath(String path)
    {
        this.path = path;
    }

    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public String getFname()
    {
        return fname;
    }
    
    public void setFname(String fname){
        
        this.fname = fname;
    }

    public String toString()
    {
        return  description ;
                
    }
}